import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijsktraAlgorithm
{
	public static void main(String[] args) {
		
		int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    	int n = 6;

		//Creating adjecnacy list
		List<List<DJNode>> l = new ArrayList<>();
		for(int i=0;i<n;i++)	l.add(new ArrayList<>());
		for(int i = 0;i<edges.length;i++)
		{
			int a = edges[i][0];
			int b = edges[i][1];
			int c = edges[i][2];

			l.get(a).add(new DJNode(c, b));
		}

		/* using PQ here bcz it will give node with minimum distance first so greedily w will get shortest distance only
		 * if we use queue unnecessary iterations will be addded here
		 */
		PriorityQueue<DJNode> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
		int[] distance = new int[n];
		Arrays.fill(distance,(int)1e9);
		pq.offer(new DJNode(0, 0));				// we start from 0
		distance[0] = 0;				//distance form 0 to 0 is o

		while(!pq.isEmpty())
		{
			DJNode dn = pq.poll();
			int dist = dn.dist;
			int ele = dn.ele;

			for(DJNode neighbour : l.get(ele))						//traversing alll neighbout
			{
				/* if distance to neighbout + distance to reach at current node is less than distance at neighbour node
				 * we will update distance array for neighbout node also add it to pq
				 */
				if(neighbour.dist + dist < distance[neighbour.ele])				
				{
					distance[neighbour.ele] = neighbour.dist + dist;
					pq.offer(new DJNode(distance[neighbour.ele], neighbour.ele));

				}
			}
		}

		for(int a : distance)
		{
			System.out.print(a+"  ");
		}


	}
}


class DJNode
{
	Integer dist;
	Integer ele;

	public DJNode(Integer dist, Integer ele)
	{
		this.dist = dist;
		this.ele = ele;

	}
}