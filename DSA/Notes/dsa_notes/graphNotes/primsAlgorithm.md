# Prim's Algorithm

## Core concept
- Prim's algorithm builds the Minimum Spanning Tree (MST).
- Start from any node and keep adding the cheapest edge to a new node.
- It always picks the minimum-weight edge connecting the tree to the remaining graph.

## When to use
- Use for MST in a weighted undirected graph.
- Works best when edge weights are non-negative.

## Why used
- We need the cheapest network connection covering all vertices.
- It is greedy and efficient for graph connectivity problems.

## Benefits
- Fast for dense graphs with priority queue.
- Gives minimum total cost to connect all nodes.
- Easy to implement with adjacency list and PQ.

## Types of questions
- Minimum cost to connect all cities.
- Minimum spanning tree problems.
- Network wiring / cable / road cost minimization.

## Java code
```java
class Solution {
    int prims(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});

        int mstCost = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int wt = cur[0];
            int node = cur[1];

            if (visited[node]) continue;
            visited[node] = true;
            mstCost += wt;

            for (int[] nxt : adj.get(node)) {
                int nei = nxt[0];
                int edgeWt = nxt[1];

                if (!visited[nei]) {
                    pq.add(new int[]{edgeWt, nei});
                }
            }
        }

        return mstCost;
    }
}
```

## Minimal logic
- Pick the smallest edge from the current tree.
- Add that node.
- Repeat until all nodes are included.
