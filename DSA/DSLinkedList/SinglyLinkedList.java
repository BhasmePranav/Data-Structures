    package DSLinkedList;

public class SinglyLinkedList {


    class Node          //Inner class for creating new node
    {
        int data;
        Node next;

        public Node(int data)       //Constructor to creating new node ,,gets called when new node is created
        {
            this.data = data;
        }

        public Node() {
        }
    }
    

    Node head = null;
    Node tail = null;

    public void addFirst(int data)             //adding elemtn to first position of LL
    {
        Node newNode = new Node(data);         //New Node creation ; will call constructor of node class
        if(head==null)                         //check list is empty or not
        {
            head = newNode;                    //if ll is empty new node will be head and tail
            head.next = null;
            tail = newNode;
            tail.next = null;

        }
        else
        {
            newNode.data = data;            //alrady present list then new node will be head
            newNode.next = head;
            head = newNode;
            tail = newNode.next;
        }
    }

    public void addlast(int data)           //adding element to the last
    {
        Node newNode = new Node(data);         //checking head is empty or not
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;

        }
    }
    public int lengthOfList()
    {
        int length = 0;
        Node current = head;
        while(current!=null)
        {
            length++;
            current=current.next;
        }
        //System.out.println("length is : "+length);
        return length;

    }
    public void addAtPosition(int position , int data)      //method for adding node at given position
    {
        Node newNode = new Node(data);
        Node currentNode = head; 
        
        if(head == null)            //empty list check
        {
            head = newNode;
            tail = newNode;

        }
        else if(position == 1)          //adding at position 1
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            for(int i=0;i<=position-2;i++)          
            {
                if(i==position-2)
                {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;


                }
                currentNode = currentNode.next;
            }
        }
    }

    public void deleteFirst()           //first element delete
    {
        if(head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            head = head.next;
        }

    }

    public void deleteLast()            //deleting  last element
    {
        Node secondLastNode = head;
        Node lastNode = head.next;

        if(head == null)                //condition if head is null
        {
            System.out.println("List is empty");
        }
        else if(head.next == null)          //if only one element in linked list
        {
           head = null;
        }
        else
        {
            while(lastNode.next!=null)             //deleting last element by traversing through list
            {
                lastNode = lastNode.next;
                secondLastNode = secondLastNode.next;

            }
            secondLastNode.next = null;
            tail = secondLastNode;
        }
    }

    public void deleteAtPosition(int position)
    {
        Node temp = head;
        Node temp2 = temp.next;
        int length = lengthOfList();

        if(position>length)
        {
            System.out.println("Invalid");
        }
        else if(head==null)
        {
            System.out.println("List is empty");
        }
        else if(head.next == null)
        {
            head = null;
            System.out.println("List become Empty");
        }
        else 
        {
            
            for(int i = 0;i<position-1;i++)
            {
                    if(i == position-2)
                    {
                    temp.next = temp2.next;
                    }
                    temp = temp.next;
                    temp2 = temp2.next;
            }
        }
    }
    
    
    public void printList()                        //print all members method
    {
        Node tempNode = head;                   //temporary node to traversre through complete list
        while(tempNode!=null)                   //traverse through all  nodes until getting null element
        {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
            
        }
    }


        public static void main(String[] args) {

            SinglyLinkedList ll =new SinglyLinkedList();
        
                ll.addFirst(4);
                ll.addFirst(45);
                ll.addlast(89);
                ll.addlast(77);
                
                //System.out.println();
                ll.addAtPosition(3, 99);
                ll.printList();
                ll.deleteFirst();
                ll.deleteLast();
                System.out.println();
                ll.deleteAtPosition(4);
                ll.printList();
                //ll.lengthOfList();

        
    }
    
}

