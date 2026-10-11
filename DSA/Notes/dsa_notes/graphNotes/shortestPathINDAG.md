# Shortest Path in DAG

## Topological Sort: key idea
- For every edge u -> v, u must come before v.
- Works only for DAGs.
- Used when ordering tasks/dependencies.

## Why not Dijkstra / BFS / DFS?
- Dijkstra: shortest path with weights, uses priority queue.
- BFS: shortest path in unweighted graphs only.
- DFS: graph traversal, not dependency ordering.
- Topological Sort is best when the graph is a DAG and we need valid dependency order.

## Why Dijkstra works for shortest path and Topological Sort works here
- Dijkstra works because it repeatedly picks the smallest known distance node and relaxes outgoing edges.
- This is valid when all edge weights are non-negative.
- It does not depend on graph order; it uses a priority queue to always choose the next best path.
- Topological Sort works here because the graph is a DAG, so there is a natural order where every node appears after its dependencies.
- In a DAG, once a node is processed in topo order, all its predecessors have already been handled.
- So we can relax edges directly in that order and compute shortest paths in O(V + E).
- Dijkstra is more general, but Topological Sort is faster for DAGs because it avoids priority queue operations.

## Shortest path in DAG using Topological Sort
```java
class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int wt = a[2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topoSort(adj, visited, st, i);
            }
        }

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (dis[node] == Integer.MAX_VALUE)
                continue;

            for (Pair p : adj.get(node)) {
                int v = p.v;
                int wt = p.wt;
                if (dis[v] > dis[node] + wt) {
                    dis[v] = dis[node] + wt;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = -1;
            }
        }

        ArrayList<Integer> sol = new ArrayList<>();
        for (int num : dis) {
            sol.add(num);
        }
        return sol;
    }

    public static void topoSort(List<List<Pair>> adj, int[] visited, Stack<Integer> st, int node) {
        visited[node] = 1;

        for (Pair p : adj.get(node)) {
            int v = p.v;
            if (visited[v] == 0) {
                topoSort(adj, visited, st, v);
            }
        }
        st.push(node);
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

## How it works
- Build adjacency list with weighted edges.
- DFS to create a topological order using a stack.
- Process nodes in reverse topological order.
- Relax edges using shortest path formula: dist[v] = min(dist[v], dist[u] + wt).
- If a node is unreachable, mark it as -1.

## Why it works
- In a DAG, all predecessors of a node are processed before it in topological order.
- So once we reach a node, the shortest path to it is already finalized.
- Time complexity: O(V + E)

## Example
- 0 -> 1 (2)
- 0 -> 2 (5)
- 1 -> 3 (4)
- 2 -> 3 (1)

Topological order: 0, 1, 2, 3

Distances:
- dist[0] = 0
- dist[1] = 2
- dist[2] = 5
- dist[3] = min(2 + 4, 5 + 1) = 6

## Final point
- Topological Sort is the right tool for dependency-based ordering and shortest path in DAG.
- Dijkstra is for general weighted shortest path, but DAG + topo order is faster and simpler.
