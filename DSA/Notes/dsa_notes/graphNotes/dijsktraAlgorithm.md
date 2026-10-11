# Dijkstra Algorithm

## Important notes
- Dijkstra finds shortest path in a weighted graph with non-negative edges.
- It uses a priority queue to always pick the smallest known distance.
- Relax edges when a shorter path is found: dist[v] = min(dist[v], dist[u] + wt).
- If edge weights are negative, Dijkstra fails; use Bellman-Ford instead.

## Core idea
- Keep the shortest distance seen so far.
- Visit the nearest node first.
- Update neighbors only if a better path is found.

## Java code
```java
class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int wt = a[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int wt = temp[0];
            int node = temp[1];

            // This check avoids stale entries.
            // Old distances that are no longer the best should not be processed.
            // It keeps the algorithm correct when a node is updated multiple times.
            if (wt > dist[node]) continue;

            for (Pair p : adj.get(node)) {
                int currWt = p.wt;
                int currNode = p.v;

                // This is the main logic of the code.
                // Relax the edge only if a shorter path is found.
                if (dist[currNode] > currWt + wt) {
                    dist[currNode] = currWt + wt;
                    pq.offer(new int[]{dist[currNode], currNode});
                }
            }
        }

        ArrayList<Integer> sol = new ArrayList<>();
        for (int a : dist) {
            sol.add(a);
        }
        return sol;
    }
}

class Pair {
    int v;
    int wt;

    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
```

## Minimal logic
- Pick the node with smallest distance.
- Try all neighbors.
- Update if new path is cheaper.
- Repeat until all nodes are processed.
