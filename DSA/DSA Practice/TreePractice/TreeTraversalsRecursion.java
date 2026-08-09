package Practice.TreePractice;

import java.util.ArrayList;
import java.util.List;

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

public class TreeTraversalsRecursion {

    static int idx = -1;
    public static void main(String[] args) {
        int[] nodes = {7,9,11 ,2,-1,-1,-1,17,-1,3,-1,-1,22,19,-1,-1,15,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(root.data);
        System.out.println("PreOrder is : " );
        preorderTraversal(root);
        System.out.println("\nPostOrder is : ");
        postOrderTraversal(root);
        System.out.println("\nInOrder is : ");
        inOrderTraversal(root);
        System.out.println("\nCount of Nodes is : "+countOfNodes(root));
        System.out.println("\nSum of All Nodes is : "+sumOfAllNodes(root));
        int maxi = 0;
        System.out.println("\nMaximum sum of Nodes is : "+maximumPathSum(root , maxi));
        List<Integer> path = new ArrayList<>();
        findPath(root, 17, path);
        System.out.println("Path betwee root to node 19 is : "+path);
    }

    private static void findPath(Node root, int i, List<Integer> path) {
    }

    public static Node buildTree(int[] nodes)
    {
        idx++;
        if(nodes[idx] == -1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void preorderTraversal(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+"  ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
    }

    public static void postOrderTraversal(Node root)
    {
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+"  ");
    }

    public static void inOrderTraversal(Node root)
    {
        if(root==null) return ;
        inOrderTraversal(root.left);
        System.out.print(root.data+"  ");
        inOrderTraversal(root.right);
    }

    public static int countOfNodes(Node root)
    {
        if(root==null) return 0;
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount+rightCount+1;
    }

    public static int sumOfAllNodes(Node root)
    {
        if(root==null) return 0;
        int sum = root.data;
        int leftSum = sumOfAllNodes(root.left);
        int rightSum = sumOfAllNodes(root.right);
        return sum+leftSum+rightSum;    
    }

    public static int maximumPathSum(Node root , int maxi)
    {
        if(root==null) return 0;
        int leftSum = maximumPathSum(root.left, maxi);
        int rightSum = maximumPathSum(root.right, maxi);
        maxi = Math.max(maxi , leftSum+rightSum+root.data);             //Here we are updateding maximum path sum value according to each node subtree
        //System.out.println(maxi);               //Maximum sum is 77 is gets rpinted when we executes this line
        return root.data+Math.max(leftSum , rightSum);          // returning maximum path
    }
    

    
 
   

    
}


