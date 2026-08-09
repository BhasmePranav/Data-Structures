package Practice.TreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node
{
    int data;
    Node left , right;

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class IterativeTraversals {

    static int idx = -1;
    public static void main(String[] args) {
        int[] nodes  = {7,9,11 ,2,-1,-1,-1,17,-1,3,-1,-1,22,19,-1,-1,15,-1,-1};
        Node root = buildTree(nodes);
        System.out.println("Root is : "+root.data);
        System.out.println("PreOrder is : ");
        preorderTraversalInterative(root);
        System.out.println();
        System.out.println("Post Order is : using 2 stacks ");
        postOrderTraversalIterativeTwoStacks(root);
        // System.out.println("Post Order is : using 1 stacks ");
        // postOrderTraversalIterativeOneStacks(root);
        System.out.println("\nInOrder is : ");
        inOrderTraversalIterative(root);
        System.out.println("\nLevel Order is : ");
        levelOrderTraversal(root);
        System.out.println("\nLevel Order traversal in List : ");
        System.out.print(levelOrderTraversalToList(root));
        System.out.println("\nLevel Order traversal in triangle format : ");
        levelOrderTraversalTriangleFormat(root);
        System.out.println("\nTotal Nodes in Tree : "+countOfNodes(root));
        
    }

    public static Node buildTree(int[] nodes)
    {
        idx++;
        if(nodes[idx]==-1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void preorderTraversalInterative(Node root)
    {
       Stack<Node> st = new Stack<>();
       if(root==null) return;
       st.push(root);
       while(!st.isEmpty())
       {
        Node curr = st.pop();
        System.out.print(curr.data+"  ");
        if(curr.right!=null) st.push(curr.right);
        if(curr.left!=null) st.push(curr.left);
       }
    }

    public static void postOrderTraversalIterativeTwoStacks(Node root)
    {
        //Using 2 stacks
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if(root==null) return;
        st1.push(root);
        while(!st1.isEmpty())
        {
            root = st1.pop();
            st2.push(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while(!st2.isEmpty())
        {
            System.out.print(st2.pop().data+"  ");
        }
    }

    public static void postOrderTraversalIterativeOneStacks(Node root)
    {
        if(root==null) return;
        Stack<Node> st1 = new Stack<>();
    }



    public static void inOrderTraversalIterative(Node root)
    {
        Stack<Node> st = new Stack<>();
        while(true)
        {
            if(root != null)
            {
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()) break;
                root = st.pop();
                System.out.print(root.data + "  ");
                root = root.right;
            }
        }
    }

    public static void levelOrderTraversal(Node root)
    {
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data+"  ");
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
        }
    }
    
    public static  List<List<Integer>> levelOrderTraversalToList(Node root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int level = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0;i<level;i++)
            {
                Node temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                inner.add(temp.data);
            }
            result.add(inner);
        }
        return result;
    }

    public static void levelOrderTraversalTriangleFormat(Node root)
    {
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if(temp==null)
            {
                if(q.isEmpty()) break;
                else{
                    System.out.println();
                    q.offer(null);
                    
                }
            }
            else
            {
                System.out.print(temp.data+"  ");
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
    }

    public static int countOfNodes(Node root)
    {
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.offer(root);
        while(!q.isEmpty())
        {
            int len = q.size();
            
            for(int i = 0;i<len;i++)
            {
                Node temp = q.poll();
                if(temp.left!=null) 
                {   count++;
                    q.offer(temp.left);
                }
                if(temp.right!=null) 
                {
                    count++;
                    q.offer(temp.right);
                }
            }
        }
        return count;
    }

    public static Node findPath(Node root , int val ,List<Integer> l)
    {
        if(root==null) return null;
        l.add(root.data);
        if(root.data == val) return root;
        Node left = findPath(root.left, val, l);
        Node right = findPath(root.right, val, l);
        return root;

    }
}





