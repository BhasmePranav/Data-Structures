import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {

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
        adj.get(8).add(10);
        adj.get(9).add(10);

        /* indegree of element is incoming edges at particular node */
        int[] indegree  = new int[n];                       //for storing indegree of element
        for(int i = 0;i<adj.size();i++)
        {
            for(int a : adj.get(i))
            {
                indegree[a]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoByKahns = new ArrayList<>();              //solution storing list
        for(int i = 1;i<n;i++)
        {
            if(indegree[i] == 0)    q.offer(i);                     //storing node in queue which has indegree 0
        }
        
        /* we are popping the top element and checking all neighbouring elements and reducing indegree of each neighbour element by 1
         * if indegree becomes 0 then we add that element to queue and again performing same ops untils q gets empty
         */
        while(!q.isEmpty())
        {
            Integer x = q.poll();
            topoByKahns.add(x);                     //adding each popped element in resultant list
            for(int a : adj.get(x))
            {
                indegree[a]--;
                if(indegree[a] == 0)    q.offer(a);
            }
        }
        if(topoByKahns.size() != n-1)                   //if number of elements in resultant list is equal to number of nodes then there no cycle.else there is cycle
        {
            System.out.println("Failed...Here is cycle . at 8->9->10!!!!!");
        }
        System.out.println(topoByKahns);

        
    }
    
}
