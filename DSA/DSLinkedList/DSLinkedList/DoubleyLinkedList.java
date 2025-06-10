package DSLinkedList;

public class DoubleyLinkedList {

    class Node
    {
        Node prevNode;
        int data;
        Node nextNode;
        
        public Node(int data) {
            this.data = data;
        }

        public Node(Node prevNode, int data, Node nextNode) {
            this.prevNode = prevNode;
            this.data = data;
            this.nextNode = nextNode;
        }

    }
    

    Node head = null;
    Node tail = null;

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            newNode.data =data;
            head = newNode;
            tail = newNode;
            newNode.prevNode = null;
            newNode.nextNode = null;
        }
        else
        {
            newNode.data = data;
            newNode.nextNode = head;
            newNode.prevNode = null;
            head.prevNode = newNode;
            head = newNode;
        }
    }
    
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            newNode.data = data;
            newNode.nextNode = null;
            newNode.prevNode = null;
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.data = data;
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            newNode.nextNode = null;
            tail = newNode;

        }
    }

    public void addAtPosition(int pos , int data)
    {
        Node newNode = new Node(data);
        Node current = head;
        Node temp = head.nextNode;
        
        if(head == null)
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
            head.prevNode = null;
            head.nextNode = null;
        }
        else if(pos == 1)
        {
            newNode.data = data;
            head.prevNode = newNode;
            newNode.nextNode = head;
            newNode.prevNode = null;
            head = newNode;
        }
    
        else
        {
            for(int i = 0 ; i<=pos-2; i++)
            {
                if(i == pos-2)
                {
                    newNode.data = data;
                    newNode.nextNode = current.nextNode;
                    newNode.prevNode = current;
                    temp.prevNode = newNode;
                    current.nextNode = newNode;
                }
                current = current.nextNode;
                temp = temp.nextNode;
            }
        }

    }

    public void deleteFirst()
    {
        if(head == null)
        {
            System.out.println("Linked list is empty");
        }
        else
        {
            head = head.nextNode;
            head.prevNode = null;
        }
    }

    public void deleteLast()
    {
        if(head == null)
        {
            System.out.println("Linked list is empty");
        }
        else
        {
            tail = tail.prevNode;
            tail.nextNode = null;
        }
    
    }


    public void printList()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.nextNode;
        }
    }


    public static void main(String args[])
    {
        DoubleyLinkedList dll = new DoubleyLinkedList();
        dll.addFirst(77);
        dll.addFirst(11);
        dll.addFirst(766);
        dll.addLast(89);
        dll.addLast(3456);
        dll.addAtPosition(3, 6789);
        dll.printList();
       System.out.println();
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteLast();
       dll.printList();
    }
    
}
