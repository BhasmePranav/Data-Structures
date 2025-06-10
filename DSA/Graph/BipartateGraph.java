import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BipartateGraph
{
    public static void main(String[] args) {
        
        //int[][] edges = {{},{2},{1,3,6},{2,4},{3,7,5},{4,6},{2,5},{4,8},{7}};                  //Odd cycle graph
        int[][] edges = {{},{2, 8},{1, 3},{2, 4},{3, 5},{4, 6},{5, 7}, {6, 8},{7, 1}};                // Even Cycle graph
        
        int n = edges.length;
        int[] visited = new int[n+1];
        Arrays.fill(visited,-1);
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0;i<=n;i++)
        {
            l.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++)
        {
            for(int a : edges[i])
            {
                l.get(i).add(a);
            }
        }
        System.out.println(l);
        boolean sol = false;

        /* running loop to check every node it is visited bcz graph can be componants */
        for(int i = 0;i<n+1;i++)
        {
            if(visited[i] == -1)
            {
                // at starting we can pass any color from bcz we dont have any condition
                sol = dfs(l,i,0,visited);       //in case of componants if any of the calll return false it will return false
                if(sol == false)    break;
            }
        }
        System.out.println("Bipartet graph : "+sol);
    
    } 
    
    public static boolean dfs(List<List<Integer>> l, int i, int color, int[] visited)
    {
        visited[i] = color;         //marking current elemebt as given color

        /* if neighbour is not colored then we will pass anothre color in that recursion call with next element but
         * if neighbout elemnt is already visited and its color is same as current color the n it will return false bcz here bipartate is not possible
         * 
         * for passing color we are using formula 1 - color bcz we are using 2 color 0 and 1 os if current cuuretn is 0 then 1-0 will pass 1 and 
         * curent is 1 then 1-1 pass 0.
         */
        for(int a : l.get(i))
        {
            if(visited[a] == -1)       
            {
                if(dfs(l,a,1-color,visited) == false)  return false;
            }
            else if(visited[a] == color)    return false;
        }
        return true;
    }
}

