import java.util.*;

public class DFS {
    
    public static void main(String[] args) {
        
        int v = 7;

        int[][] edges = {{0,1},{2,3},{1,3},{1,4},{2,4},{5,6}};
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0;i<v;i++)
        {
            adj.add(new ArrayList());
        }

        /*Creating adjecency List(graph edge lsit) */
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int t = edges[i][1];
            adj.get(u).add(t);
            adj.get(t).add(u);
        }

        boolean[] visited  = new boolean[v];
        Arrays.fill(visited, false);
        List<Integer> sol = new ArrayList();
        
        /* In loop we are checking for each node bcz given graph may has componant so if it is not visited 
         * then we will call dfs for that
         */
        for(int i = 0;i<v;i++)
        {
            if(visited[i] == false)
            {
                dfs(adj, visited, sol, i);
            }
        }
        System.out.println(sol);
        
    }

    
    public static void dfs(List<List<Integer>> adj, boolean[] visited, List<Integer> sol, int node)
    {
        visited[node] = true;                       //marking the current element as visited
        sol.add(node);                              //adding to dfs list
        for(Integer x : adj.get(node))              //taking its first connected element if it is not visited then calling dfs for that node
        {
            if(visited[x]  == false)
            {
                dfs(adj,visited,sol,x);
            }
        }
    }


}
