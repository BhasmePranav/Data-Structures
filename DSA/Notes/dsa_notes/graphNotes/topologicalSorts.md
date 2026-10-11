# Topological Sort

## Quick Comparison: DFS vs BFS for Topological Sort

| Aspect | DFS Topological Sort | BFS Topological Sort (Kahn's Algorithm) |
|---|---|---|
| Main idea | Use recursion + stack | Use indegree + queue |
| Structure used | Stack | Queue |
| Best for | Understanding dependencies recursively | Iterative, queue-based processing |
| Works when | Graph is a DAG | Graph is a DAG |
| Detecting cycle | Indirectly, by no valid order | If all nodes are not processed |
| Time complexity | O(V + E) | O(V + E) |
| Space complexity | O(V) | O(V) |


In simple words: if an edge is u-v, then u should be before v.

## Why Topological Sort is used

It is used to order tasks or dependencies so that every task is completed before the tasks that depend on it.

Examples:
- Course prerequisites
- Build systems
- Project scheduling
- Dependency resolution

## Condition for Topological Sort

Topological sort is only possible for a Directed Acyclic Graph (DAG).

A DAG is a directed graph with no directed cycle.

If a cycle exists, then no valid ordering exists because a task would have to appear before itself.

## Why it works only on DAGs

Suppose there is a directed cycle:

A -> B -> C -> A

If topological sorting were possible, then:
- A must come before B
- B must come before C
- C must come before A

This gives:
- A < B < C < A

This is impossible. So a cycle prevents any valid ordering.

That is why Topological Sort works only on DAGs.

## Intuition

In a DAG, there is at least one node with no incoming edges (indegree = 0). This node can be placed first because no other task must come before it.

After removing it, the remaining graph is still a DAG, and the same idea repeats.

This is the key reason the process always works for DAGs.

## Algorithm 1: DFS based Topological Sort

### Idea
- Perform DFS on each vertex.
- Before returning from the DFS call, push the current vertex to a stack.
- At the end, pop from the stack to get the topological order.

### Why it works

If there is an edge u -> v, then DFS from u visits v before finishing u. So u is pushed to the stack after all its descendants. When the stack is popped, u appears before v only if the graph is acyclic.

### Example

Graph:
- 1 -> 2
- 1 -> 3
- 2 -> 4
- 3 -> 4

One valid topological order is:
- 1, 2, 3, 4

### Code idea

```java
public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, st);
        }
    }

    st.push(node);
}
```

## Algorithm 2: Kahn's Algorithm (Using Indegree)

### Idea
- Compute indegree of each node.
- Push all nodes with indegree 0 into a queue.
- Repeatedly remove a node and reduce indegree of its neighbors.
- If all nodes are processed, the order is valid.

### Steps
1. Count indegree for every vertex.
2. Add all zero-indegree vertices to a queue.
3. Pop one vertex from queue and print it.
4. For each neighbor of that vertex, decrease its indegree.
5. If a neighbor becomes zero, push it to queue.
6. Repeat until queue is empty.

### Example

Graph:
- 5 -> 2
- 5 -> 0
- 4 -> 0
- 2 -> 3
- 3 -> 1

One valid topological order could be:
- 4, 5, 2, 0, 3, 1

## Important note about cycles

If the graph contains a cycle, Kahn's algorithm will not process all vertices because no node will reach indegree 0.

Similarly, DFS-based topological sort will detect a back edge in a cycle and cannot produce a valid ordering.

So, topological sorting is only valid for DAGs.

## Time Complexity

For both DFS and Kahn's algorithm:
- O(V + E)

Where:
- V = number of vertices
- E = number of edges

## Summary

- Topological sort prints vertices in an order where every edge u -> v means u appears before v.
- It works only for DAGs.
- A cycle makes topological sorting impossible.
- It is useful for dependency ordering and scheduling.

## Final statement

Topological Sort is not for arbitrary graphs; it is specifically for directed acyclic graphs (DAGs), because only in a DAG can a consistent ordering of dependencies exist without violating precedence rules.

## Topological Sort using DFS traversal

A DFS-based topological sort uses recursion and a stack. While traversing the graph, we push the node into the stack after visiting all its neighbors. At the end, popping from the stack gives the topological order.

This works because in a DAG, all dependencies of a node are processed before the node itself is added to the stack.

```java
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> sol = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            adj.get(a[0]).add(a[1]);
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(sol, adj, st, visited, i);
            }
        }

        while (!st.isEmpty()) {
            sol.add(st.pop());
        }
        return sol;
    }

    public static void dfs(ArrayList<Integer> sol, List<List<Integer>> adj, Stack<Integer> st, int[] visited, int node) {
        visited[node] = 1;

        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(sol, adj, st, visited, it);
            }
        }
        st.push(node);
    }
}
```

### Explanation of the code

- Build adjacency list from the directed edges.
- Traverse every vertex using DFS.
- Mark vertices as visited.
- After exploring all neighbors of a node, push the node onto the stack.
- Finally, pop from the stack to produce the topological ordering.

### Example

If the edges are:
- 0 -> 1
- 0 -> 2
- 1 -> 3
- 2 -> 3

Then one valid topological order is:
- 0, 1, 2, 3

This order ensures that every edge u -> v has u before v.

### Important note

This DFS-based method is valid only for DAGs. If the graph contains a cycle, the ordering will not be valid because a cycle would force a node to appear before itself.

## Topological Sort using BFS traversal (Kahn's Algorithm)

BFS-based topological sort uses the concept of indegree. The indegree of a node is the number of incoming edges to it.

A node with indegree 0 has no dependency and can be processed first. We repeatedly remove such nodes and reduce indegree of their neighbors.

This is also known as Kahn's Algorithm.

```java
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> sol = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            adj.get(a[0]).add(a[1]);
            indegree[a[1]]++;
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sol.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return sol;
    }
}
```

### Explanation of the code

- Create an adjacency list for the directed graph.
- Compute indegree of each vertex.
- Push all nodes with indegree 0 into the queue.
- Remove a node from the queue and add it to the answer.
- Decrease indegree of its neighbors.
- If any neighbor's indegree becomes 0, add it to the queue.
- Continue until all nodes are processed.

### Why this works

If an edge is u -> v, then u must appear before v. In Kahn's algorithm, v becomes available only when all its incoming edges are processed. So, we process vertices in order of dependency completion.

### Example

For the edges:
- 0 -> 1
- 0 -> 2
- 1 -> 3
- 2 -> 3

The indegrees are:
- indegree[0] = 0
- indegree[1] = 1
- indegree[2] = 1
- indegree[3] = 2

The queue starts with: 0

After processing 0, we reduce indegrees of 1 and 2 to 0, so queue becomes: 1, 2

Then process 1 and 2, and finally 3.

One valid order is:
- 0, 1, 2, 3

### Important note

If the graph has a cycle, not all vertices will ever reach indegree 0. Therefore, the queue will not process all nodes, which tells us the graph is not a DAG and topological sort is not possible.

### Complexity

- Time Complexity: O(V + E)
- Space Complexity: O(V)

This BFS approach is efficient and widely used for topological sorting of DAGs.

### Quick rule

- Use Topological Sort for dependency ordering.
- Use Dijkstra for shortest path.
- Use BFS/DFS for traversal and reachability.

### Important difference

- Topological Sort cares about dependency order.
- Dijkstra cares about minimum cost from a source.
- BFS cares about level order / shortest path in unweighted graphs.
- DFS cares about exploration and recursion.

This is why topological sort is the correct choice for dependency-based problems and not Dijkstra or general traversal.