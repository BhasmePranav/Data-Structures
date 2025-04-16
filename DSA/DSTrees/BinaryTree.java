package DSTrees;
import java.util.*;

class Node
{
    int data;
    Node left , right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree
{
    static int idx = -1;
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5 ,-1,-1 ,3,-1 ,6,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(root.data);
        System.out.println("PreOrder Traversal is : ");
        preOrder(root);
        System.out.println("\nInOrder Traversal is : ");
        inOrder(root);
        System.out.println("\nPostOrder Traversal is : ");
        postOrder(root);
        System.out.println("\nLevel Order Traversal is : ");
        levelOrder(root);
        System.out.println("Count of nodes is : "+countNodes(root));
        System.out.println("Height of tree is : "+height(root));
        System.out.println("Diameter of tree is : "+diameter(root));
    }



    public static Node buildTree(int[] nodes)
    {        
        idx++;
        if(nodes[idx]==-1) return null;

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right =buildTree(nodes);

        return newNode;
    }


    public static void preOrder(Node root)
    {
        if(root == null) return;

        System.out.print(root.data+ "  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root)
    {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+"  ");
        inOrder(root.right);
    }

    public static void postOrder(Node root)
    {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +"  ");
    }

    public static void levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        if(root==null) return;
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node currentNode = q.remove();
            if(currentNode==null)
            {
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                System.out.print(currentNode.data+"  ");
                if(currentNode.left != null) q.add(currentNode.left);
                if(currentNode.right!= null) q.add(currentNode.right);
            }
        }
    }

    public static int countNodes(Node root)
    {
        if(root==null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes+1;
    }

    public static int height(Node root)
    {
        if(root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight , rightHeight)+1;
    }

    public static int diameter(Node root)
    {
        if(root==null) return 0;
        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int diamToRoot = height(root.left) + height(root.right)+1;
        return Math.max(diamToRoot , Math.max(leftDiam , rightDiam));
    }

    
}

