package Practice.BSTPractice;

import java.util.ArrayList;
import java.util.*;

public class BST {

    public static void main(String[] args) {
    int nodes[] = {56 , 77 , 88 , 11 , 44 , 22 ,7 , 6 , 90 , 67 };  
    Node root = null;
    for (int i : nodes)
    {
        root = buildBST(root , i);
    }
    System.out.println("Root : "+root.data);
    System.out.println("Pre Order Traversal : "+preOrderTraversal(root));
    System.out.println("Post Order Traversal : "+postOrderTraversal(root));
    System.out.println("In Order Traversal : "+inOrderTraversal(root));

    }

    public static Node buildBST(Node root , int val)
    {
        if(root==null)
        {
            root = new Node(val);
            return root;
        }
        if(val<root.data)  root.left = buildBST(root.left, val);
        if(val>root.data)  root.right = buildBST(root.right, val);
        return root;
    }

    public static List<Integer> postOrderTraversal(Node root)
    {
        List<Integer> postOrder = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if(root==null) return null;
        s1.push(root);
        while(!s1.isEmpty())
        {
            root = s1.pop();
            s2.push(root);

            if(root.left!=null) s1.push(root.left);
            if(root.right!=null) s1.push(root.right);
        }
        while(!s2.isEmpty())
        {
            postOrder.add(s2.pop().data);
        }
        return postOrder;  
    }

    public static List<Integer> preOrderTraversal(Node root)
    {
        if(root==null) return null;
        List<Integer> preOrder = new ArrayList<>();
        Stack<Node> st = new Stack();
        st.push(root);
        while(!st.isEmpty())
        {
            root = st.pop();
            preOrder.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
        }
        
        return preOrder;  
    }

    public static List<Integer> inOrderTraversal(Node root)
    {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> st = new Stack();
        if(root==null) return null;
        while(true)
        {
            if(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            else
            {
                if(st.isEmpty())
                {
                    break;
                }
                else
                {
                    root = st.pop();
                    inOrder.add(root.data);
                    root = root.right;
                }
            }
        }
        return inOrder;  
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
    }
}




