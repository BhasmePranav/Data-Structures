# Kruskal's Algorithm

## Disjoint Set (Union-Find) - Must Know Before Kruskal
- Kruskal picks the smallest edge first.
- Before choosing any edge, we must check whether its endpoints are already connected.
- If both endpoints are in the same set, the edge creates a cycle.
- If both endpoints are in different sets, the edge is safe to add.
- Disjoint Set is used to keep track of connected components.
- It helps us answer: "Are u and v already connected?"
- This check is needed because MST must never contain a cycle.
- Union-Find gives almost constant time checks for connectivity.
- It is the most important helper for Kruskal's algorithm.
- It stores a parent array and a size array.
- `getParent(node)` finds the root parent of a node.
- `unionBySize(u, v)` merges two sets by size.
- This keeps the tree balanced and makes operations fast.
- Why we need it:
  - To avoid cycles in MST
  - To connect different components only
  - To keep the total cost minimum
  - To process edges efficiently
- How to use it:
  - Sort edges by weight
  - Take the smallest edge
  - Check `ds.getParent(u) != ds.getParent(v)`
  - If different, include edge and call `unionBySize(u, v)`
  - If same, skip the edge
- Important points:
  - MST always uses `V - 1` edges
  - Graph should be weighted and undirected
  - A cycle is not allowed in an MST
  - Kruskal is greedy and works because smallest safe edge always helps
- Code:

```java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DisjointSet ds = new DisjointSet(V);
        int maxLen = 0;
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int w = a[2];

            if (ds.getParent(u) != ds.getParent(v)) {
                maxLen += w;
                ds.unionBySize(u, v);
            }
        }
        return maxLen;
    }
}

class DisjointSet {
    int[] parents;
    int[] size;

    public DisjointSet(int v) {
        parents = new int[v + 1];
        size = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int getParent(int node) {
        if (node == parents[node]) return node;
        else return parents[node] = getParent(parents[node]);
    }

    public void unionBySize(int u, int v) {
        int ult_u = getParent(u);
        int ult_v = getParent(v);

        if (ult_u == ult_v) return;

        if (size[ult_u] < size[ult_v]) {
            parents[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parents[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}
```

## Kruskal's Algorithm
- Goal:
  - Find the Minimum Spanning Tree (MST)
  - Connect all vertices with minimum total cost
- Core idea:
  - Sort edges by weight
  - Pick the smallest edge that does not create a cycle
  - Keep adding valid edges until all vertices are connected
- Why this works:
  - Greedy choice is safe for MST problems
  - Smallest edge connecting different components is important
  - Cycle check is done using Disjoint Set
- When to use:
  - Weighted undirected graph
  - Minimum cost to connect all nodes
  - Road, cable, router, and network design problems
- Step-by-step:
  - Sort all edges by weight
  - Create a Disjoint Set for all vertices
  - Check each edge from smallest to largest
  - If endpoints are in different sets, include the edge
  - Union the two sets
  - Stop when `V - 1` edges are selected
- Minimal logic:
  - Sort edges
  - Check if edge connects two different sets
  - Add if safe
  - Union sets
  - Repeat until MST is formed
- Time complexity:
  - Sorting edges: `O(E log E)`
  - DSU operations: almost `O(E α(V))`
  - Total: `O(E log E)`
- Space complexity:
  - `O(V + E)`
- Key points:
  - Kruskal is edge-based
  - Prim is vertex-based
  - Kruskal is best when edges are directly available
  - It is efficient and easy to implement with Disjoint Set

## Java code for Kruskal's Algorithm
```java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DisjointSet ds = new DisjointSet(V);
        int maxLen = 0;
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int w = a[2];

            if (ds.getParent(u) != ds.getParent(v)) {
                maxLen += w;
                ds.unionBySize(u, v);
            }
        }
        return maxLen;
    }
}

class DisjointSet {
    int[] parents;
    int[] size;

    public DisjointSet(int v) {
        parents = new int[v + 1];
        size = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int getParent(int node) {
        if (node == parents[node]) return node;
        else return parents[node] = getParent(parents[node]);
    }

    public void unionBySize(int u, int v) {
        int ult_u = getParent(u);
        int ult_v = getParent(v);

        if (ult_u == ult_v) return;

        if (size[ult_u] < size[ult_v]) {
            parents[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parents[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}
```
