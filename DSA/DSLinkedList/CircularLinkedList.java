package DSLinkedList;

public class CircularLinkedList {
    
    Node head = null;
    Node tail = null;

    class Node                                      //creating new node
    {
        int data;
        Node next;

        public Node(int data)                       //constructor
        {
            this.data = data;
        }

        public Node(int data , Node next)
        {
            this.data = data;
            this.next = next;
        }
        public Node()
        {

        }
    }
    //Inserting elemnt at first method
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)                                //If list is empty
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
            
        }
        else
        {
            newNode.data = data;
            newNode.next = head;
            head = newNode;
            tail.next = head;                          //In cll tail again point to first element


        }
    }

    //Inserting elemnt at last method
    public void addLast(int data)
    {
        Node newNode = new Node();
        if(head==null)
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else
        {
            newNode.data = data;
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        }
    }

    //Inserting at specific location method
    public void addAtPosition(int pos,int data)
    {
        Node newNode = new Node();
        if(pos<1)
        {
            System.out.println("Invalid Position , Enter valid position.");
        }
        if(head == null)
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
        }
        else
        {
            Node temp = head;
            int i = 1;
            while(i<pos)
            {
                if(i+1==pos)
                {
                    newNode.data = data;
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
                i++;
                temp = temp.next;
            }
           

        }
    }

    //Deleting first node method
    public void deleteFirst()
    {
        if(head==null)
        {
            System.out.println("Linked list is empty");

        }
        else if(head == tail)
        {
            head = null;
            tail = null;
            System.out.println("Linked list became empty");
        }
        else
        {
           head = head.next;
           tail.next = head;
        }

    }

    //Deleting last node method
    public void deleteLast()
    {
        if(head==null)
        {
            System.out.println("Linked list is empty");
        }
        else if(head == tail)                                       //if single element in the list then head and tail get null and list will be empty 
        {
            head = null;
            tail = null;
            System.out.println("Linked list became empty");
        }
        else
        {
            Node temp = head;
            while(temp.next!=tail)                                  //Traversing cll until second last element
            {
                temp = temp.next;
            }
            temp.next = tail.next;
            tail = temp;
            tail.next = head;
        }
    }

    public void deleteAtPosition(int pos)
    {
        if(pos<1)
        {
            System.out.println("Invalid position entered , enter valid position");

        }
        else if(head == null)
        {
            head = null;
            tail = null;
            System.out.println("Linked List became empty");
        }
        else
        {
            Node current = head;
            Node currNext = current.next;
            int i = 1;
            while(i<pos)
            {
                if(i+1==pos)                                    //Traversed till one position before so i can add at given position
                {
                    current.next = currNext.next;
                    
                }
                i++;
                current = current.next;
                currNext = currNext.next;
            }
        }
    }

    
    //Print Method
    public void printList()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            Node temp = head;
            do{                                                 //Traversing list until again reach to head.
                System.out.println(temp.data);                  //if i use for loop then in first iteration condition gets failed
                temp = temp.next;                               //thats why use DO-WHILE() loop
            }while(temp!=head);                                            
            // System.out.println("\n"+head.data);
            // System.out.println(tail.next.data);
            // System.out.println(tail.data);
        }
    }

    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();
        System.out.println("Circular Linked List : ");
        cll.addFirst(10);
        cll.addFirst(20);
        cll.addFirst(30);
        cll.addLast(40);
        cll.addLast(50);
        cll.deleteFirst();
        cll.deleteLast();
        cll.addAtPosition(3, 45);
        cll.deleteAtPosition(3);
        cll.printList();
        
        

        


        
    }
    
}
