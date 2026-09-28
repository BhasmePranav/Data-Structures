import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    static int count= 0;
    public static void main(String[] args) {
        int n = 5;
        List<List<String>> sol = new ArrayList<>();
        char[][] c = new char[n][n];
        for(int i = 0;i<c.length;i++)
        {
            for(int j = 0;j<c[i].length;j++)
            {
                c[i][j]='-';
            }
        }
        System.out.println("Solution By First Approach : ");
        setQueensApproach_1(0 , c , sol);     
        System.out.println(sol);                                        //Passed 0 for column c for chess board created of n*n size and sol to store list
        System.out.println("Count of Solutions Approach 1: "+sol.size());  
        System.out.println("Solution Second Approach : ");         
        List<List<String>> ans = new ArrayList<>();
        char[] rows = new char[n];
        char[] upperDiagonal = new char[2*n-1];
        char[] lowerDiagonal = new char[2*n-1];
        Arrays.fill(rows , '-');
        Arrays.fill(upperDiagonal , '-');
        Arrays.fill(lowerDiagonal , '-');
        
        setQueensApproach_2(0, c, rows , upperDiagonal , lowerDiagonal , ans , n , count);
        System.out.println("COunt : "+count);

        System.out.println(ans);
        System.out.println("Count of Solutions Approch 2: "+ans.size());  

                   
    }

    // Approach 1 - Backtracking using a board and diagonal checks
    public static List<List<String>> solveNQueensApproach_1(int n) {
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
            sol.add(construct(board, n));
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
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }

    //Approach 1
    public static void setQueensApproach_1(int col , char[][] arr, List<List<String>> sol)
    {
        if(col==arr.length)
        {
            List<String> temp =  new ArrayList<>();
            for(int i = 0;i<arr.length;i++)
            {
                String s = new String(arr[i]);
                temp.add(s);
            }
            //System.out.println(temp);
            sol.add(temp);
            return;
        }
        for(int row = 0 ; row < arr.length; row ++ )
        {
            if(isValid(arr , row , col))
            {
                arr[row][col] = 'Q';
                setQueensApproach_1(col+1, arr, sol);
                arr[row][col] = '-';
            }
        }
    }
    public static boolean isValid(char[][] arr , int row , int col)
    {
        int ogRow = row;
        int ogCol = col;
        while(ogRow>=0 && ogCol>=0)
        {
            if(arr[ogRow][ogCol]=='Q') return false;
            ogRow--;
            ogCol--;
        }
        ogRow = row;
        ogCol = col;

        while(ogCol>=0)
        {
            if(arr[row][ogCol]=='Q') return false;
            ogCol--;
        }
        ogRow = row;
        ogCol = col;
        while(ogCol>=0 && ogRow<arr.length)
        {
            if(arr[ogRow][ogCol]=='Q') return false;
            ogRow++;
            ogCol--;
        }
        return true;
    }



    //Approach 2
    private static void setQueensApproach_2(int col, char[][] arr, char[] rows, char[] upperDiagonal, char[] lowerDiagonal,List<List<String>> ans , int n , int count) 
    {
        if(col==arr.length)
        {
            List<String> temp = new ArrayList();
            for(int i = 0;i<arr.length;i++)
            {
                String s = new String(arr[i]);
                temp.add(s);
            }
            ans.add(temp);
           // System.out.println(temp);
           count++;
            return;
        }
        for(int row = 0;row<arr.length;row++)
        {
            if(rows[row]=='-' && upperDiagonal[n-1+col-row]=='-' && lowerDiagonal[row+col]=='-')
            {
                arr[row][col] = 'Q';
                arr[row][col] = 'Q';
                rows[row] = 'Q';
                upperDiagonal[(n-1)+(col-row)] = 'Q';
                lowerDiagonal[row+col] = 'Q';
                setQueensApproach_2(col+1, arr, rows, upperDiagonal, lowerDiagonal, ans , n , count);
                arr[row][col] = '-';
                rows[row] = '-';
                upperDiagonal[(n-1)+(col-row)] = '-';
                lowerDiagonal[row+col] = '-';
            }
        }
    }
}

