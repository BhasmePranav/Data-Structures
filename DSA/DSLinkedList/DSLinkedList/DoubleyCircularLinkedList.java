package DSLinkedList;

public class DoubleyCircularLinkedList {

    Node head;
    Node tail;


    class Node
    {
        Node prev;
        int data;
        Node next;

        public Node()
        {

        }
        public Node(Node prev , int data , Node next)
        {
                this.prev = prev;
                this.data = data;
                this.next = next;
        }
    }

    //Insert element at first method
    public void addFirst(int data)
    {
        Node newNode = new Node();
        if(head==null)
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.next = head;
            tail.prev  = head;
            head.prev = tail;
        }
        else
        {
            newNode.data = data;
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            newNode.prev = tail;
            tail.next = head;

        }
    }

    //Inserting element at last method
    public void addLast(int data)
    {
        Node newNode  = new Node();
        if(head == null)
        {
            newNode.data = data;
            head = newNode;
            tail = newNode;
            tail.next = head;
            head.prev = tail;

        }
        else
        {
            newNode.data = data;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void addAtPosition(int pos , int data)
    {
        Node newNode = new Node();
        if(pos<1)
        {
            System.out.println("Invalid position , please enter valid position . ");

        }
        else
        {
           
            newNode.data = data;
            
            int i = 1;
            Node temp = head;
            while(i+1 != pos)
            {
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            newNode.prev = temp;
            temp.next = newNode;
            
        }
    }
    
    
    //Deleting first element method
    public void deleteFirst()
    {
        if(head == null) 
        {
            System.out.println("This list is empty . ");
        }
        else if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail.next = head.next;
            head = head.next;
            head.prev = tail;

        }
    }

    //Deleting last element method
    public void deleteLast()
    {
        if(head == null)
        {
            System.out.println("Linked List is empty . ");

        }
        else if(head == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail.prev.next = tail.next;
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }

    }

    public void deleteAtPositon(int pos)
    {
        if(pos<0)
        {
            System.out.println("Invalid Position , Enter Valid Position .");

        }
        else
        {
            int i = 1;
            Node temp = head;
            while(i+1 != pos)
            {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
            temp.next.next.prev = temp;


        }
    }


    
    

    

    //printing list method
    public void printList()
    {
        Node temp = head;
        do
        {
            System.out.println(temp.data);
            temp = temp.next;

        }while(temp!=head);
    }


    public static void main(String[] argss)
    {
        DoubleyCircularLinkedList dcll = new DoubleyCircularLinkedList();
        dcll.addFirst(20);
        dcll.addFirst(30);
        dcll.addLast(40);
        dcll.addLast(50);
        dcll.printList();
        System.out.println("\n");
        
        dcll.addAtPosition(3, 55);
        dcll.addAtPosition(5, 77);
        System.out.println("\n");
        dcll.printList();
        
        dcll.deleteFirst();
        dcll.deleteLast();
        System.out.println("\n");
        dcll.printList();
        
        dcll.deleteAtPositon(4);
        dcll.deleteAtPositon(1);
        System.out.println("\n");
        dcll.printList();

        

    }
    
}
