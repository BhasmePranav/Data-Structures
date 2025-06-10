


/* in these code we have to find shortest disctance betwween source to each node where
 weight of each edge is 1. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceInUndirectedGraph {
    
    public static void main(String[] args) {
       
       int nodes = 9;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int n = edge.length;
       
       
       /* creating adjecncy list of  graph*/
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0;i<n;i++)  l.add(new ArrayList<>());
        for(int[] a : edge)
        {
            l.get(a[0]).add(a[1]);
            l.get(a[1]).add(a[0]);
        }
        int[] a = shortestDistacneSourceToNode(l, 0, nodes);
        for(int x : a)
        {
            System.out.print(x+"  ");
        }

    }

    /* s is source */
    public static int[] shortestDistacneSourceToNode(List<List<Integer>> l, int s, int n)
    {
    
        int[] distance = new int[n];                            //storing distance of source to each node
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();                  //to traverse all nodes
        q.offer(s);
        distance[s] = 0;            //distance of source to source is 0
        
        //traversing all nodes of graph through queue
        while(!q.isEmpty())
        {
            Integer x  = q.poll();
            for(int a : l.get(x))                   //checking all neighbour nodes
            {
                if(distance[a] > distance[x] + 1)                   //if distance of neighbour node is greater than 1 + distance of current node then we will update it
                {
                    distance[a] = 1 + distance[x];              //updating distance
                    q.offer(a);                             //adding ele to q
                }
            }
        }


        return distance;
    }
}
