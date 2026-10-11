# N-Queens Problem

## Approach 1: Backtracking with Board and Safe Check

This approach places one queen in each column and checks whether the chosen position is safe from attacks.

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solver(board, sol, 0, n);
        return sol;
    }

    public static void solver(char[][] board, List<List<String>> sol, int col, int n) {
        if (col == n) {
            List<String> temp = construct(board, n);
            sol.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row, n)) {
                board[row][col] = 'Q';
                solver(board, sol, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int col, int row, int n) {
        int i = row;
        int j = col;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        i = row;
        j = col;
        while (j >= 0) {
            if (board[i][j] == 'Q') return false;
            j--;
        }

        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }

    public static List<String> construct(char[][] board, int n) {
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(board[i][j]);
            }
            sol.add(s.toString());
        }
        return sol;
    }
}
```

## Explanation

- We fill the board with '.' to represent empty cells.
- We place queens column by column.
- At each step, we check whether the current row and column are safe.
- We move diagonally and vertically to detect any queen already attacking the new position.
- When all columns are filled, we store the current board configuration as a valid solution.

## Time Complexity

- Worst-case: O(n!)
- This is because each column can try up to n rows, and backtracking explores many combinations.

## Space Complexity

- O(n^2) for the board + recursion stack

---

## Approach 2: Backtracking with 3 Arrays for Tracking Conflicts

This approach uses three boolean-like arrays to track occupied rows and diagonals instead of checking all positions manually each time.

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> sol = new ArrayList();

        char[][] board = new char[n][n];
        for(char[] x : board)   Arrays.fill(x, '.');
        int[] left = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        Arrays.fill(left,0);
        Arrays.fill(upperDiagonal,0);
        Arrays.fill(lowerDiagonal,0);

        solver(board,sol,left,upperDiagonal,lowerDiagonal,0,n);
        return sol;
    }

    public static void solver(char[][] board, List<List<String>> sol, int[] left, int[] upperDiagonal, int[] lowerDiagonal, int col, int n)
    {
        if(col == n)
        {
            List<String> temp = construct(board, n);
            sol.add(temp);
            return;
        }

        for(int row = 0;row<n;row++)
        {
            if(left[row] != 1 && lowerDiagonal[col+row] != 1 && upperDiagonal[n-1+col-row] != 1)
            {
                board[row][col] = 'Q';
                left[row] = 1;
                lowerDiagonal[col + row] = 1;
                upperDiagonal[n-1+col-row] = 1;
                solver(board,sol,left,upperDiagonal,lowerDiagonal,col+1,n);
                board[row][col] = '.';
                left[row] = 0;
                lowerDiagonal[col + row] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }

    public static List<String> construct(char[][] board, int n)
    {
        List<String> sol = new ArrayList();
        for(int i = 0;i<n;i++)
        {
            String s = "";
            for(int j = 0;j<n;j++)
            {
                s = s + board[i][j];
            }
            sol.add(s);
        }
        return sol;
    }
}
```

### How this works

- `left[row]` checks whether a row is already occupied.
- `lowerDiagonal[col + row]` checks the anti-diagonal.
- `upperDiagonal[n - 1 + col - row]` checks the main diagonal.
- If all three are free, we place a queen and continue recursively.
- After backtracking, we reset all three arrays so the next branch can explore safely.

### Time Complexity

- O(n!) in the worst case, similar to Approach 1.

### Space Complexity

- O(n^2) for the board + O(n) for the tracking arrays.



