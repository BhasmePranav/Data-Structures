# Floyd-Warshall Algorithm

## Core concept
- It finds shortest paths between all pairs of vertices.
- It uses dynamic programming over an intermediate vertex `via`.
- We keep improving paths by trying every possible middle node.

## When to use
- Use when you need shortest paths for all pairs.
- Best for dense graphs and small-to-medium `V`.
- Good when graph is not too large but all-pairs distances are needed.

## Why we need it
- Dijkstra works from one source.
- Bellman-Ford also works from one source.
- Floyd-Warshall gives all distances in one shot.
- It is useful when we need distances between every pair of nodes.

## Benefits
- Finds shortest path for every pair.
- Works with positive and negative weights (except negative cycles).
- Simple triple-loop logic.

## Types of questions
- All-pairs shortest path.
- Graph distance matrix updates.
- Detect negative cycle in graph.
- Shortest path between every node pair in a small graph.

## Important tips
- Time complexity: O(V^3)
- Space complexity: O(V^2)
- It is best for graphs with `V` around 100 or less.
- If there is a negative cycle, shortest path is undefined.
- The matrix `dist` is usually the adjacency matrix with `INF` for no direct edge.

```java
class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here

        int n = dist.length;
        int INF = 100000000;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Skip impossible paths: if either route is INF, no valid path exists through this intermediate node.
                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }
}
```

## Minimal logic
- Try every intermediate node.
- If path via `via` is valid, update the shortest route.
- Keep taking the minimum of direct and indirect paths.
