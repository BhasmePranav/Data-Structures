public class FloydWarshallAlgorithm {
    

    public static void main(String[] args) {
        
        int n =  4;
        int[][] matrix = new int[4][4];
        for(int i = 0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j] = -1;
            }
        }
        // matrix[0][1] = 2;
        // matrix[1][0] = 1;
        // matrix[1][2] = 3;
        // matrix[3][0] = 3;
        // matrix[3][1] = 5;
        // matrix[3][2] = 4;

        matrix[0][1] = 1;
        matrix[1][2] = -1;
        matrix[2][3] = -1;
        matrix[3][0] = -1;

        for(int[] a : matrix)
        {
            for(int x : a)
            {
                System.out.print(x + "  ");
            
            }
            System.out.println();
        }

        floydWarshallSolver(matrix, n);
        System.out.println("solveddd-----------------");
        for(int[] a : matrix)
        {
            for(int x : a)
            {
                System.out.print(x + "  ");
            
            }
            System.out.println();
        }

        

    }

    public static void floydWarshallSolver(int[][] matrix, int n)
    {
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(matrix[i][j] == -1)  matrix[i][j] = 100000000;

                if(i == j)  matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != 100000000 && matrix[k][j] != 100000000) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        for(int i = 0;i<n;i++)
        {
            if(matrix[i][i] < 0)
            {
                System.out.println("\n\n\n------There is negative cycle in this graph ");
            }
        }

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(matrix[i][j] == 1e9) matrix[i][j] = -1;
            }
        }

        

    }
}
