package DSTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

import javax.naming.LimitExceededException;

public class BinaryTreeIterative {

    static int idx = -1;
    public static void main(String[] args) {
        int[] nodes = {7,9,11 ,2,-1,-1,-1,17,-1,3,-1,-1,22,19,-1,-1,15,-1,-1};
        
        Node root = BuildTree(nodes);
        System.out.println("root is : "+root.data);
        System.out.println("root is from Iterative : "+root.data);
        System.out.println("In order : "+inorder(root));
        System.out.println("Pre order : "+preorder(root));
        System.out.println("Post order : "+postorder(root));
        List<Integer> l = new ArrayList<>();
        System.out.println("Element exist : "+findPath(root, 19,l)+"\nPath from root to Node 2 is : "+l);   
        System.out.println("LCA of 9 and 19 is  : "+findLCA(root, 9, 19).data);
        System.out.println("LCA of 2 and 3 is  : "+findLCA(root, 2, 3).data);
    }

    public static Node BuildTree(int[] nodes)
    {
        idx++;
        if(nodes[idx]==-1) return null;
        Node root = new Node(nodes[idx]);
        root.left = BuildTree(nodes);
        root.right = BuildTree(nodes);
        return root;
    }

    // public static Node BuildTreeIterative(int[] nodes)
    // {
    //     if(nodes[0]==-1 || nodes.length==0) return null;
    //     int i = 1;
    //     Queue<Node> q = new LinkedList<>();
    //     Node root = new Node(nodes[0]);
    //     q.offer(root);
    //     while(!q.isEmpty() && i<nodes.length)
    //     {
    //         Node curr = q.poll();
    //         if(nodes[i]!=-1)
    //         {
    //             curr.left = new Node(nodes[i]);
    //             q.offer(curr.left);
    //         }
    //         i++;
    //         if(nodes[i]!=-1)
    //         {
    //             curr.right = new Node(nodes[i]);
    //             q.offer(curr.right);
    //         }
    //         i++;
    //     }
    //     return root;
    // }

    public static List<Integer> inorder(Node root)
    {
        List<Integer> l = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        while(true)
        {
            if(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            else{
                if(s.isEmpty()) break;
                else
                {
                    root = s.pop();
                    l.add(root.data);
                    root = root.right;
                }
            }
        }
        return l;
    }

    public static List<Integer> preorder(Node root)
    {
        List<Integer> pre = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty())
        {
            root = s.pop();
            pre.add(root.data);
            if(root.right!=null)    s.push(root.right);
            if(root.left!=null)     s.push(root.left);
        }
        return pre;
    }

    public static List<Integer> postorder(Node root)
    {
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            Node curr = stack1.pop();
            stack2.push(curr);
            if(curr.left!=null) stack1.push(curr.left);
            if(curr.right!=null) stack1.push(curr.right);
        }
        while(!stack2.isEmpty()) l.add(stack2.pop().data);
        return l;
    }   

    public static boolean findPath(Node root ,int target , List<Integer> l )
    {
        if(root==null) return false;
        l.add(root.data);
        if(root.data==target) return true;
        if(findPath(root.left, target, l) || findPath(root.right, target, l))
        {
            return true;
        }
        System.out.println("Path from root to node is : "+l);
        l.remove(l.size()-1);
        return false;
    }

    public static Node findLCA(Node root , int p , int q)
    {
        if(root==null || root.data==p || root.data==q) return root;
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        else return root;
    }
}


class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

