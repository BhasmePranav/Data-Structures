package DSQueues;

public class LinearQueue {


    class Node                          //Queue as linnked list so used node
    {
        int data;
        Node next;

        public Node()
        {

        }
        public Node(int data , Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    Node front;                  
    Node rear;

    public boolean isEmpty()                    //checking queue is empty or not
    {
        return front == null;
    }

    public void enqueue(int data)               //adding element at front
    {
        Node newNode = new Node();
        newNode.data = data;
        if(front == null)
        {
            front = rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue()                    //deleting element from rear end
    {
        if(isEmpty())
        {
            System.out.println("Queue is already Empty");
        }
        int del = front.data;
        front = front.next;
        return del; 
    }

    public int peek()                       //returning font element
    {
        if(isEmpty())
        {
            System.out.println("Queue is already Empty"); 
        }
        return front.data; 
    }


    public static void main(String[] args)
    {
            LinearQueue lq = new LinearQueue();
            lq.enqueue(11);
            lq.enqueue(22);
            lq.enqueue(33);
            lq.enqueue(44);
            System.out.println("Deleted element is : "+lq.dequeue());
            // System.out.println(lq.front.data);
            // System.out.println(lq.rear.data);
            lq.enqueue(55);
            lq.dequeue();
            
            
            while(!lq.isEmpty())
            {
                System.out.println(lq.peek());
                lq.dequeue();
            }
            

    }
    
}
