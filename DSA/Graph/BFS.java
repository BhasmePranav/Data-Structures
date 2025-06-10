import java.util.*;

public class BFS {
    
    public static void main(String[] args) {
        
        int v = 7;
        int[][] edges = {{0,1},{2,3},{1,3},{1,4},{2,4},{5,6}};
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        List<Integer> bfsTraversal = new ArrayList<>();
        createAdjecancyList(v, edges, adj);

        /*running loop and callling bfs multiple times bcz if complete graph is not conencted then it will be
         * another bfs call
         */
        for(int i = 0;i<v;i++)
        {
            if(visited[i] == false)
            {
                bfs(adj,visited, i, bfsTraversal);
            }
        }
        System.out.println(bfsTraversal);

    }

    /*creating adjecancy list according to given edges */
    public static void createAdjecancyList(int v, int[][] edges, List<List<Integer>> adj)
    {
        for(int i = 0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        /*as it is undirected graph we will add edges both ways */
        for(int i = 0;i<edges.length;i++)
        {
            int x = edges[i][0];
            int y = edges[i][1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }
    }

    /*bfs traversal
     * taking one Queue data structure to store currently visited nodes and if node is already visited then we will ont add
     * that node in queue if it is not visited then will add tht node to queue and mark it as visited
     */
    public static void bfs(List<List<Integer>> adj, boolean[] visited, int node, List<Integer> bfsTraversal)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty())
        {
            int x = q.poll();
            bfsTraversal.add(x);
            for(Integer a : adj.get(node))
            {
                if(visited[a] == false)
                {
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
    }

}
