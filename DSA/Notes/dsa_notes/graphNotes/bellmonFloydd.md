# Bellman-Ford Algorithm

## Core concept
- Relax all edges again and again.
- Each pass improves distances step by step.
- After V-1 passes, shortest paths are final.

## Why used
- Works even when edge weights are negative.
- Best for shortest path where Dijkstra cannot be used.

## Benefits
- Handles negative edges.
- Detects negative cycles.
- Easy to understand and implement.

## Types of questions
- Shortest path with negative weights.
- Detect cycle with negative total weight.
- Distance update in graph constraints.

```java
class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        // code here
        ArrayList<Integer> sol = new ArrayList<>();
        int inf = 100000000;
        int[] dist = new int[V];
        Arrays.fill(dist, inf);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] a : edges) {
                int u = a[0];
                int v = a[1];
                int wt = a[2];

                // Relax edge: improve distance if a shorter path is found.
                if (dist[u] != inf && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int wt = a[2];

            // Negative cycle check: if any edge can still improve, cycle exists.
            if (dist[u] != inf && dist[u] + wt < dist[v]) {
                return new ArrayList<>(Arrays.asList(-1));
            }
        }

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
