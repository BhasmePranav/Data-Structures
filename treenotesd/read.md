# Boundary Traversal of Tree

```java
/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> sol = new ArrayList<>();

        if (isLeaf(root)) {
            sol.add(root.data);
            return sol;
        }

        sol.add(root.data);

        leftBoundary(root.left, sol);
        leaves(root, sol);

        List<Integer> rightBoundary = new ArrayList<>();
        rightBoundary(root.right, sol, rightBoundary);
        Collections.reverse(rightBoundary);
        sol.addAll(rightBoundary);

        return sol;
    }

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public static void leftBoundary(Node root, ArrayList<Integer> sol) {
        Node curr = root;

        while (curr != null) {
            if (!isLeaf(curr)) {
                sol.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void leaves(Node root, ArrayList<Integer> sol) {
        if (root == null) return;

        if (isLeaf(root)) {
            sol.add(root.data);
        }

        leaves(root.left, sol);
        leaves(root.right, sol);
    }

    public static void rightBoundary(Node root, ArrayList<Integer> sol, List<Integer> rightBoundary) {
        Node curr = root;

        while (curr != null) {
            if (!isLeaf(curr)) {
                rightBoundary.add(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }
}
```

This solution prints the boundary traversal of a tree, following:
- root node
- left boundary
- leaf nodes
- right boundary in reverse order
