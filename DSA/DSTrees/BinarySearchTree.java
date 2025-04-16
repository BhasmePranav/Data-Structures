package DSTrees;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    static List<Integer> inorder = new ArrayList<>();
    public static void main(String[] args) {
        int nodes[] = { 11, 17, 19, 7, 9, 22, 15, 2 };
        Node root = null;
        for (int x : nodes) {
            root = insertNode(root, x);
        }
        inOrderTraversal(root);
        System.out.println("Root is : " + root.data);
        System.out.println("Inorder data is : " + inorder);
        System.out.println("Ceil for key 18 is : " + ceilOfKey(root, 18));
        System.out.println("Floor for key 18 is : " + floorOfKey(root, 18));
        System.out.println("Element 18 present or Not in tree : " + searchElementInBST(root, 18));
        System.out.println("Element 22 present or Not in tree : " + searchElementInBST(root, 22));
        insertGivenNode(root, 99);
        insertGivenNode(root, -15);
        insertGivenNode(root, 17);
        inorder.clear();
        inOrderTraversal(root);
        System.out.println("Inorder after adding 99  , -15 and 17 element in tree is : " + inorder);
        deleteGivenNode(root, 7);
        inorder.clear();
        inOrderTraversal(root);
        System.out.println("Inorder After deleting Node 7 is : "+inorder);
        System.out.println("Is Valid BST : "+validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertNode(root.left, data);
        if (data > root.data)
            root.right = insertNode(root.right, data);
        return root;
    }

    public static int ceilOfKey(Node root, int key) {
        int ceil = 0;
        while (root != null) {
            System.out.println(ceil);
            if (root.data == key) {
                ceil = root.data;
                break;
            }
            if (root.data < key) {
                ceil = root.data;
                root = root.right;
            } else if (root.data > key) {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static int floorOfKey(Node root, int key) {
        int floor = 0;
        while (root != null) {
            if (root.data == key)
                floor = root.data;
            else if (root.data < key) {
                floor = root.data;
                root = root.right;
            } else if (root.data > key) {
                root = root.left;
            }
        }
        return floor;
    }

    public static boolean searchElementInBST(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (root.data < key) {
            return searchElementInBST(root.right, key);
        } else {
            return searchElementInBST(root.left, key);
        }
    }

    public static Node insertGivenNode(Node root, int target) {
        if (root == null) {
            root = new Node(target);
            return root;
        } else {
            while (true) 
            {
                if (root.data > target) 
                {
                    if (root.left == null) 
                    {
                        root.left = new Node(target);
                        break;
                    } 
                    else    root = root.left;
                }
                else
                {
                    if(root.right==null)
                    {
                        root.right = new Node(target);
                        break;
                    }
                    else root = root.right;
                }
            }
        }
        return root;
    }

    //DeleteNode method code
    public static Node deleteGivenNode(Node root , int data)
    {
        if(root==null) return null;
        if(root.data == data) return deleteHelper(root);
        while(root!=null)
        {
            if(root.data<data)
            {
                if(root.right!=null && root.right.data==data)
                {
                    root.right = deleteHelper(root.right);
                }
                else root = root.right;
            }
            else
            {
                if(root.left!=null && root.left.data == data) 
                {
                    root.left = deleteHelper(root.left);
                }   
                else root = root.left;
            }
        }
        return root;
    }

    //Connecting link between root and deleted element left child 
    public static Node deleteHelper(Node root)
    {
        if(root.left==null) return root.right;          //if delete elements left is null then right child will conennct to root
        if(root.right==null) return root.left;          //If roots right child is null then roots left child gets connected to root
        
        //Root has both childs left and right so below logic
        Node rightTree = root.right;                                //roots right child is stored
        Node leftMostRight = leftMostRight(root.left);                //find the largest element in root's left subtree , we find here most right lement bcz right has greater value than root in BST
        leftMostRight.right = rightTree;                        //lefts most right elemnts right is set as rightTree
        return root.left;                                   //return roots left to connect with root
    }

    //recursion to find roots most right child
    public static Node leftMostRight(Node root)
    {
        if(root.right==null) return root;
        return leftMostRight(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        inorder.add(root.data);
        inOrderTraversal(root.right);
    }

    public static boolean validateBST(Node root  , int min , int max)
    {
        if(root==null) return true;
        if(root.data>=min && root.data<=max)
        {
            boolean left = validateBST(root.left, min, root.data);
            boolean right = validateBST(root.right, root.data, max);
            return left && right;
        }
        return false;
    }

}

