package Practice.BSTPractice;

import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        data = this.data;
    }
}

public class InsertDeleteNodeFromBST {
    public static void main(String[] args) {
        int nodes[] = {77,34,12,78,99,101,56,85};
        Node root = null;
        for(int x : nodes)
        {
            root = buildBST(root , x);
        }
        List<Integer> inorder = new ArrayList<>();
        inorderTrav(root, inorder);
        System.out.println(inorder);
        insertGivenNode(root, 91);
        inorder.clear();
        inorderTrav(root, inorder);
        System.out.println("After Adding 91 : "+inorder);
        inorder.clear();
        deleteNode(root,99);
        deleteNode(root,34);
        inorderTrav(root, inorder);
        System.out.println("After Deleting 99 : "+inorder);
    }

    public static Node buildBST(Node root , int data)
    {
        if(root==null) return new Node(data);
        if(data<root.data) root.left = buildBST(root.left, data);
        if(data>root.data) root.right = buildBST(root.right, data);
        return root;
    }

    public static Node insertGivenNode(Node root , int data)
    {
        if(root==null) return new Node(data);
        while(true)
        {
            if(root.data<data)
            {
                if(root.right!=null) root = root.right;
                else
                {
                    root.right = new Node(data);
                    break;
                }
            }
            else
            {
                if(root.left!=null) root = root.left;
                else
                {
                    root.left = new Node(data);
                    break;
                }
            }
        }
        return root;
    }
    
    public static Node deleteNode(Node root , int data)
    {
        if(root==null) return null;
        if(root.data==data) return deleteHelper(root);
        while(root!=null)
        {
            if(root.data<data)
            {
                if(root.right!=null && root.right.data==data)
                {
                    root.right =  deleteHelper(root.right);
                }
                else root = root.right;
            }
            else
            {
                if(root.left!=null && root.left.data==data)
                {
                    root.left =  deleteHelper(root.left);
                }
                else root = root.left;
            }
        }
        return root;
    }

    public static Node deleteHelper(Node root)
    {
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        Node leftTree = root.left;
        Node rightTreeSmallest = rightSmall(root.right);
        rightTreeSmallest.left=leftTree;
        return root.right;
    }
    public static Node rightSmall(Node root)
    {
        if(root.left==null) return root;
        return rightSmall(root.left);
    }

    public static void inorderTrav(Node root , List<Integer>inorder)
    {
        if(root==null) return ;
        inorderTrav(root.left , inorder);
        inorder.add(root.data);
        inorderTrav(root.right , inorder);
    }
}