import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    
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

        boolean[] visited = new boolean[n];                     //to mark visited elements
        Stack<Integer> st = new Stack<>();                      //to store all elements for topo sort 

        /* checking if graph is componant graph */
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == false) 
            {
                dfs(adj,i,visited,st);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!st.isEmpty())
        {
            topo.add(st.pop());
        }
        System.out.println(topo);
    }

    /* this is topological sort code it wont work if graph has cycle
     * int this algo we will add element to stack after completing the operation;
     * here we are not using stack for recursion call we are using global declared stack to store topo sort elements
     */
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> st)
    {
        visited[i] = true;
        for(int a : adj.get(i))
        {
            if(visited[a] == false)
            {
                dfs(adj,a,visited,st);
            }
        }
        st.push(i);
    }
}
