import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUndirectedGraph {
    
    public static void main(String[] args) {
        
        //int[][] edges = {{1, 3},{0, 2, 4},{1, 5},{0, 4},{1, 3, 5},{2, 4}};
        int[][] edges = {{1, 2}, {0}, {0, 3}, {2}};
        int n = edges.length;
        /*Creating adjecancy List */
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList());
        }

        for(int i = 0;i<n;i++)
        {
            for(int x : edges[i])
            {
                adj.get(i).add(x);

            }
        }
        System.out.println("Detected cycle by BFS : "+cycleInUndirectedGraphUsingBFS(adj, n));
        boolean[] visited = new boolean[n];
        System.out.println("Detected cycle by DFS : "+cycleInUndirectedGraphUsingDFS(adj,visited,0,-1));

    }

    /*Detecting cycle using BFS */
    public static boolean cycleInUndirectedGraphUsingBFS(List<List<Integer>> adj, int len)
    {
        Queue<Node> q = new LinkedList<>();                    //for storing neighbour node
        q.offer(new Node(0,-1));                        //start element parent is -1
        
        boolean[] visited = new boolean[len];
        Arrays.fill(visited,false);
        visited[0] = true;

        //until all elements being visited or or loop detected
        while(!q.isEmpty())
        {
            Node n = q.poll();
            int ele = n.ele;
            int par = n.parent;
            

            for(int it : adj.get(ele))                  //checking all neighbour of partcular element
            {
                if(visited[it] == false)            //if nont visited then add to q as pair of (node and current ele as parent)
                {
                    q.offer(new Node(it,ele));
                    visited[it] = true;             // mark as visited
                }
                else if(par != it)  return true;        //if its already visited and parent is not same to neigbor then loop detected

            }
        }
        return false;
    }



    /* Detecting cycle using DFS : here we are passing node and its parent in recursive call */
    public static boolean cycleInUndirectedGraphUsingDFS(List<List<Integer>> adj, boolean[] visited, int node, int parent)
    {
        visited[node] = true;                   //marking curret node as visited
        /* here we are also traversing all neigbour element by loop but we are giving recursive call 
         * after each element if it is not visited so it is going till the depth of that perticular node
         */
        for(int ele : adj.get(node))             
        {
            if(visited[ele] == false)
            {
                //in this recursive call we are neighbour element as next node and current element as parent
                if(cycleInUndirectedGraphUsingDFS(adj, visited, ele, node)) return true;        //if recurcive call return true then loop is detected
            }
            else if(ele != parent)  return true;
        }
        return false;
    }
}


class Node
{
    int ele;
    int parent;
    public Node(int ele, int parent)
    {
        this.ele = ele;
        this.parent = parent;
    }
}
