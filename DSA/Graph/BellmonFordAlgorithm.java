import java.util.Arrays;

public class BellmonFordAlgorithm {
    
    public static void main(String[] args) {
        

        //without negative cycle exmple
        int[][] edges = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        
        //with negative cycle exmple
        //int[][] edges = {{0, 1, 1},{1, 2, 2},{2, 3, 3},{3, 1, -7},{4, 5, 1},{0, 4, 4}};
        int n = 6;

        //storing distance from source to each node
        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e8);

        distance[0] = 0;                        //distance of source to source is 0

        /* we will perform opration fo relaxation of edge for n-1 times bcz we havr value of source node so in each iteratin it will update one more value
         * so that we dont need nth iteration ot update nth node we will update it in n-1 th iteratiom
         */
        for(int i = 0;i<n-1;i++)
        {
            for(int[] a : edges)
            {
                int u = a[0];
                int v = a[1];
                int w = a[2];

                if(distance[u] != 1e8)                          //if current u is already defined then we can use it to define distance to another node
                {
                    if(distance[u] + w < distance[v])              //if current node dit + its weight to destination is less tha distance at destination then it will update it
                    {
                        distance[v] = distance[u] + w;
                    }
                }
            }
        }

        /* ideally after n-1 th iteration we have to get our shortest distance of source to each node 
         * but even after n-1 th iteration value of distance array is reduing it means there is cycle to detect that we will traverse
         * compelte edges array and relax them one more time. if value decreases then we find out that there ie neg cycle
         */
        boolean flag = false;
        for(int[] a : edges)
        {
            int u = a[0];
            int v = a[1];
            int w = a[2];

            if(distance[u] + w < distance[v])
            {
                distance[v] = distance[u] + w;
                flag = true;
                break;
            }
        }

        for(int a : distance)
        {
            System.out.print(a+"  ");
        }
        if(flag) System.out.println("\nNegative cycle present .  ");
    }
}
