import java.util.*;

public class KrushkalsAlgorithm {
    
    public static void main(String[] args) {
        
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 6}, {4, 2, 2}};
        List<Pair> l = new ArrayList();
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            l.add(new Pair(w,u,v));
        }
        int mstWeight = 0;
        
        DisjointSetForKrushkals ds = new DisjointSetForKrushkals(V);
        Collections.sort(l);

        for(Pair p : l)
        {
            int w = p.w;
            int u = p.u;
            int v = p.v;

            if(ds.findParent(u) != ds.findParent(v))
            {
                mstWeight += w;
                ds.unionByRank(u, v);

            }
        }
        System.out.println("\n\n"+mstWeight);

    }

}

class Pair implements Comparable<Pair>
{
    int w;
    int u;
    int v;

    public Pair(int w, int u, int v)
    {
        this.w  = w;
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(Pair p1)
    {
        return this.w - p1.w;
    }
}

class DisjointSetForKrushkals
{
    int[] rank;
    int[] parents;

    public DisjointSetForKrushkals(int v)
    {
        rank = new int[v];
        parents = new int[v];

        for(int i = 0;i<v;i++)
        {
            rank[i] = 0;
            parents[i] = i;
        }
    }

    public void unionByRank(int u, int v)
    {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v)  return;
        if(rank[ulp_v] < rank[ulp_u])
        {
            parents[ulp_v] = ulp_u;
        }
        else if(rank[ulp_v] > rank[ulp_u])
        {
            parents[ulp_u] = ulp_v;
        }
        else
        {
            parents[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public int findParent(int x)
    {
        if(x == parents[x])  return x;
        return parents[x] = findParent(parents[x]);
    }
}