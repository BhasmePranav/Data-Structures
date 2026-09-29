# Iterative Traversals of Binary Tree

## 1) Inorder Traversal of Binary Tree: Iterative Approach

This is the standard iterative inorder traversal for a binary tree.

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                sol.add(node.val);
                node = node.right;
            }
        }
        return sol;
    }
}
```

### How it works
- Push nodes along the left path onto the stack.
- When you reach `null`, pop the top node, add its value to the result, and move to its right subtree.
- Repeat until the stack is empty and the current node is `null`.

This follows the inorder order:
- left subtree → node → right subtree

### Complexity
- Time: `O(n)`
- Space: `O(h)` where `h` is the height of the tree (worst-case `O(n)` for a skewed tree)

---

## 2) Preorder Traversal of Binary Tree: Iterative Approach

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();

        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(node);

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (temp == null) break;
            sol.add(temp.val);
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
        }
        return sol;
    }
}
```

### How it works
- Visit the current node first.
- Push the right child first, then the left child onto the stack so the left subtree is processed first.
- Pop the stack to process nodes in preorder order.

This follows the preorder order:
- node → left subtree → right subtree

### Complexity
- Time: `O(n)`
- Space: `O(h)` where `h` is the height of the tree (worst-case `O(n)` for a skewed tree)

---

## 3) Postorder Traversal of Binary Tree: Iterative Approach (Using 2 Stacks)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode node = root;
        st.push(node);

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (temp == null) break;
            st2.push(temp);

            if (temp.left != null) st.push(temp.left);
            if (temp.right != null) st.push(temp.right);
        }

        while (!st2.isEmpty()) {
            l.add(st2.pop().val);
        }
        return l;
    }
}
```

### How it works
- Push the root into the first stack.
- Pop a node from the first stack and push it into the second stack.
- Push left and right children of the popped node into the first stack.
- At the end, the second stack contains nodes in reverse postorder, so popping from it gives postorder traversal.

This follows the postorder order:
- left subtree → right subtree → node

### Complexity
- Time: `O(n)`
- Space: `O(n)`
