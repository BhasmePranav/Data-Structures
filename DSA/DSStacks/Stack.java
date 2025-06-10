package DSStacks;

public class Stack {

    class Node                  //Stack in form of LinkedList so created node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public Node head;

    public boolean isEmpty()            //checking stck is empty or not 
    {
        return head == null;
     }
    
        
    public void push(int data)              //Adding element to stack
    {
        Node newNode = new Node(data);
        newNode.data = data;
        if(isEmpty())
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;            //Adding element at top
            head = newNode;
        
        }
    }

    public int pop()                        //removing element from stack
    {
        if(isEmpty())
        {
            return -1;
        }
        int top = head.data;
        head = head.next;                       //Removign element from top
        return top;
    }

    public int peek()                           //returning top element only
    {
        if(isEmpty())
        {
            return -1;
        }
        else
            return head.data;
    }
    


    public static void  main(String[] args)
    {
        Stack sc = new Stack();
        sc.push(11);
        sc.push(22);
        sc.push(33);
        sc.push(55);
        sc.push(44);
        System.out.println("Deleted element is : "+sc.pop());

        

        while(!sc.isEmpty())
        {
            System.out.println(sc.peek());
            sc.pop();

        }

    }
    
}
