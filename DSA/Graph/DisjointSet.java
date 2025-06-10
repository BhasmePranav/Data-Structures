import java.util.*;

public class DisjointSet {
    
    public static void main(String[] args) {
        
        DisjointSetImpl ds = new DisjointSetImpl(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        //ds.unionByRank(null, null);
        
        /*Before joining nodes 3 and 7  it will give answer both nodes not belong to same parent*/
        System.out.println("\n\nBefore joining node between : 3 & 4");
        if(ds.findUltParent(1) == ds.findUltParent(6))  System.out.println("YESSSSSSSSSS");
        else System.out.println("NOOooooooooo");

        ds.unionByRank(3,4);

        /*After joining nodes 3 and 4  it will give answer both nodes belong to same parent*/
        System.out.println("After joining node between : 3 & 4");
        if(ds.findUltParent(3) == ds.findUltParent(7))  System.out.println("YESSSSSSSSSS");
        else System.out.println("NOOooooooooo");

    }
}

class DisjointSetImpl
{
    List<Integer> rank = new ArrayList();
    List<Integer> parents = new ArrayList();

    /*Initializing rank and parent List */
    public DisjointSetImpl(int v)
    {
        for(int i = 0;i<=v;i++)
        {
            rank.add(0);                        //rank wiill be 0 for all
            parents.add(i);                     //each  node will be its own parent
        }
    }



    /*Connecting noded accoring to their ranks
     * if ultimate parents of both nodea re same no need to do anything so return
     * else connect node with small rank to the node with greater rank
     * if both having equal rank then conect anyone to anyont but update rank of connected element
     * (for eg. 4 connect to 3 then rank of 3 willl be increased)
     */
    public void unionByRank(Integer x, Integer y)
    {
        Integer ult_parentX = findUltParent(x);
        Integer ult_parentY = findUltParent(y);

        if(ult_parentX == ult_parentY)  return;
        if(rank.get(ult_parentX) > rank.get(ult_parentY))
        {
            parents.set(ult_parentY , ult_parentX);
        }
        else if(rank.get(ult_parentX) < rank.get(ult_parentY))
        {
            parents.set(ult_parentX, ult_parentY);
        }
        else 
        {
            int rankX = rank.get(x);
            parents.set(y,x);
            rank.set(x,rankX+1);
        }
    }

    /*going and checking parent of parent untill node and its won [arent is not same */
    public Integer findUltParent(Integer x)
    {
        if(parents.get(x) == x) return x;
        Integer node = findUltParent(parents.get(x));
        parents.set(x,node);
        return parents.get(node);
    }
}