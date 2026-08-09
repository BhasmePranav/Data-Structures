


public class InsertAndDeletionHeap {

    public static void main(String[] args) {
        
        Heap h = new Heap();
        h.insertNode(23);
        h.insertNode(34);
        h.insertNode(45);
        h.insertNode(65);
        h.insertNode(11);
        h.insertNode(2);
        h.printHeap();
        h.deleteRootNode();
        h.printHeap();
    }
}

class Heap
{
    int[] arr = new int[100];
    int size = 0;

    /* here we are inserting nodes in heap considering as  max heap */
    public void insertNode(int val)
    {
        size = size+1;
        int index = size;
        arr[index] = val;

        while(index > 1)
        {
            int parent = index/2;

            if(arr[parent] < arr[index])
            {
                int x = arr[parent];
                arr[parent] = arr[index];
                arr[index] = x;
            }
            else return;
            index = parent;
        }
    }


    //Wrong code neeed to correct. : update once corrected
    
    public void deleteRootNode()
    {
        if(size == 0)
        {
            System.out.println("Empty Heap");
            return;
        }

        arr[1] = arr[size];
        size--;
        int index = 1;

        while(index < size)
        {
            int left = 2*index;
            int right = 2*index + 1;

            if(left <= size && arr[left] > arr[index])
            {
                int x = arr[left];
                arr[left] = arr[index];
                arr[index] = x;
                index = left;
            }
            else if(right <= size && arr[right] > arr[index])
            {
                int x = arr[right];
                arr[right] = arr[index];
                arr[index] = x;
                index = right;
            }
            else return;
        }
    }

    public void printHeap()
    {
        for(int i = 1;i<=size;i++)
        {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}
