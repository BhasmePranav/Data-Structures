import java.util.*;


/* in this approach we are using topolgical sort to find shortest distaance between source node to each element */
public class ShortestPathInDAG
{
	public static void main(String[] args) {
		
		int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    	int n = 6;

		//Creating adjecancy list
    	List<List<Combo>> l = new ArrayList<>();
		for(int i = 0;i<n;i++)
		{
			l.add(new ArrayList());
		}
		for(int i = 0;i<edges.length;i++)
		{
			int a = edges[i][0];
			int b = edges[i][1];
			int c = edges[i][2];

			l.get(a).add(new Combo(b,c));
		}

		//Stack and visited array for topological sort
		Stack<Integer> st = new Stack();
		boolean[] visited = new boolean[n];
		topoSort(l, 0, visited, st);
		

		//array forstoring distance of source node to each node
		int[] distance = new int[n];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[st.peek()] = 0;
		while(!st.isEmpty())
		{
			Integer x = st.pop();
			for(Combo Combo : l.get(x))				//traversing all neighbouring elemnt
			{
				int ele = Combo.ele;
				int weight = Combo.weight;
				if(distance[x] + weight < distance[ele])					//if weight of edge and weight to last nondeis less than current node weight then update it
				{
					distance[ele] = distance[x] + weight;
				}
			}
		}
		for(int a : distance)
		{
			System.out.print(a+"  ");
		}
	}

	public static void topoSort(List<List<Combo>> l , int i, boolean visited[], Stack<Integer> st)
	{
		visited[i] = true;
		for(Combo x : l.get(i))
		{
			int ele = x.ele;
			//int weight = x.weight;

			if(visited[ele] == false)
			{
				topoSort(l, ele, visited, st);
			}
		}
		st.push(i);
	}
}


class Combo
{
	int ele;
	int weight; 	

	public Combo(int ele, int weight)
	{
		this.ele = ele;
		this.weight = weight;
	}
}