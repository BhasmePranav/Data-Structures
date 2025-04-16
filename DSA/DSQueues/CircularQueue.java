package DSQueues;

public class CircularQueue {

    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    public boolean isEmpty()
    {
        return front == null;
    }
    public void enqueue(int data)
    {
        Node newNode = new Node(data);
        newNode.data = data;
        if(isEmpty())
        {
            front = newNode;
            rear = newNode;
            rear.next = front;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    public int dequeue()
    {
        int del = front.data;
        if(isEmpty())
        {
            System.out.println("Queue is already empty from dequeue.");
        }
        front = front.next;
        rear.next = front;

        return del;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is already empty from Peek.");
        }
        return front.data;
    }
    

    public static void main(String args[])
    {
        CircularQueue cq = new CircularQueue();

        cq.enqueue(11);
        cq.enqueue(22);
        cq.enqueue(33);
        cq.enqueue(44);
        System.out.println("Deleteed Element is : "+cq.dequeue());
        cq.enqueue(55);


        // System.out.println(cq.front.data);
        // System.out.println(cq.rear.data);
        // System.out.println(cq.rear.next.data);


        Node current = cq.front;
        do{
            System.out.println(current.data);
            current = current.next;

        }while(current!=cq.front);

        
    }
    
}
