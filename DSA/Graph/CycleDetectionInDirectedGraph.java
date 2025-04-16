import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraph {
    
    public static void main(String[] args) {
        
        int n = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Directed graph with cycle
        // adj.get(1).add(2);
        // adj.get(2).add(3);
        // adj.get(3).add(4);
        // adj.get(3).add(7);
        // adj.get(4).add(5);
        // adj.get(5).add(6);
        // adj.get(7).add(5);
        // adj.get(8).add(9);
        // adj.get(9).add(10);
        // adj.get(10).add(8);

        //Second example with not cycle
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(8);
        adj.get(8).add(9);
        adj.get(9).add(10);

        System.out.println(adj);
        int[] visited = new int[n];                 //for storing visted array
        int[] path = new int[n];                        //for storing visited path bcz in directed we can visit same element but it can/cant be cycle
        boolean sol = false;
        /* checking for companants graph case */
        
        for(int i = 0;i<n;i++)
        {
            if(cycleDetectionDirectedGrapgDFS(adj,i,visited,path)) 
            {
                sol = true;
                break;
            }
            sol = false;
        }
        System.out.println("Is cycle in directed graph : "+ sol);
        /*
         * Note : for finding cycle in directed cyclic graph using BFS we will try to apply kah'n algo, 
         * it is only applicable on Directed acyclic graph if it fails means there is cycle.
         */


    }

    /*Cycle Detection using DFS */
    public static boolean cycleDetectionDirectedGrapgDFS(ArrayList<ArrayList<Integer>> adj, int i, int visited[] ,int[] path)
    {
        visited[i] = 1;                 //will mark current node as visited and path is also visited
        path[i] = 1;
        for(Integer a : adj.get(i))                 //try all neighbour elements
        {
            if(path[a] == 0)                //if neighbout element is not visited in path then we will visited that path
            {
                if(cycleDetectionDirectedGrapgDFS(adj, a, visited, path))   return true;
            }
            else if(path[a] == 1)   return true;                //if that neighbout node is visited  in path then we will   return true as cucle present
        }
        path[i] = 0;            // when we return we try diff path as node has multilple neughbout weo so is element is giving cycle here we will remove path visited to false.
        return false;
    }
}
