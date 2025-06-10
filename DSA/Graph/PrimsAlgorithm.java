import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    
    public static void main(String[] args) {
        int[][] edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        int v = 5;

        //creating arraylist storing destination node  nd its weight
        List<List<PrimsNode>> l = new ArrayList();
        for(int i  = 0;i<v;i++)
        {
            l.add(new ArrayList());
        }

        for(int[] a : edges)
        {
            int x = a[0];
            int y = a[1];
            int z = a[2];

            l.get(x).add(new PrimsNode(z, y));
            l.get(y).add(new PrimsNode(z, x));
        }

        /* using pq bcz it wil give node  with smallest et first and at initall we will place starting node and weight is 0 */
        PriorityQueue<PrimsNode> pq = new PriorityQueue<>((a,b)->(a.wt-b.wt));
        pq.offer(new PrimsNode(0, 0));
        int sum  = 0;
        int[] visited = new int[v];


        /* ltraverse till pq becomes empty and then chek si current node is visitd or not is visited then skip this itr
         * else mark that node as visitd and add edge weight to ttoal sum
         */
        while(!pq.isEmpty())
        {

            PrimsNode p = pq.poll();
            int ele = p.ele;
            int w = p.wt;
            if(visited[ele] == 1)   continue;
            visited[ele] = 1;
            sum = sum + w;

            /*traverse al the neighbouring element if that node is not visited then we add that node weight and element in pq */
            for(PrimsNode x : l.get(ele))
            {
                int wt = x.wt;
                int node = x.ele;

                if(visited[node] == 0)
                {
                    pq.offer(new PrimsNode(wt, node));
                }
            
            }
        }

        System.out.println("value of weight if edges inn MST : "+ sum);


    }
}

class PrimsNode
{
    int wt;
    int ele; 
    public PrimsNode(int wt, int ele)
    {
        this.wt = wt;
        this.ele = ele;
    }
}

