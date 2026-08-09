package Sortings;

public class HeapSort {

    public static void main(String[] args)
    {
        int[] a = {81,89,9,11,14,76,54,22};
        System.out.println("Before Sorting Array is : ");
        for(int x : a)
        {
            System.out.print(x+" ");
        }

        heapifyUp(a, a.length, 3);
        buildHeap(a, a.length-1);                   //We can call this method in heapSort() method  also
        System.out.println("\n\nAfter Building Heap : ");
        for(int x : a)
        {
            System.out.print(x+" ");
        }

        heapSort(a, a.length-1);
        System.out.println("\n\nAfter Sorting Array is : ");
        for(int x : a)
        {
            System.out.print(x+" ");
        }
        
    }


    //Method for building heap from given array
    public static void buildHeap(int[] a , int length)              
    {
        int n = (length-1)/2;               //leaf node of given tree starts from (length/2)+1 to last index of node from tree
       for(int j = n;j>=0;j--)
       {
        heapifyUp(a, length, j);            //so we are heapifying only elements which are parent 
       }

    }

    //Mehtod heapifyUp to creating max heap
    //This method will crate max heap from the array index which is passed as i
    public static void heapifyUp(int[] a , int length , int i )
    {
        int largest = i;                                    //Declaring largest as passed index
        int leftChild = (2*i)+1;                            //finding left child formula
        int rightChild = (2*i)+2;                           //finding Right child formula

        if(leftChild<length && a[largest]<a[leftChild])        //If leftChild index is small than lenght and value at leftchild index is greater than at index largest then leftchild indexwill be set as largest
        {
            largest = leftChild;
        }
        if(rightChild<length && a[largest]<a[rightChild])          //Same reason as line 51 just for rightChildIndex
        {
            largest = rightChild;
        }
        if(largest != i)                                        //if passed index is not largest then it will swap with largest elemnt
        {
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;

            heapifyUp(a, length, largest);
        }

    }

    //Method for Sorting elements in heap sort
    public static void heapSort(int[] a , int length)           //MaxHeap is created by using buildHeap Method
    {
        buildHeap(a, a.length-1);
        for(int i=length; i>=0;i--)                             //Root element is max so it will swap with lasrt element
        {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            length--;
            heapifyUp(a, i, 0);                     //again calling heapify method with reducing length
            //in this above heapify method we reducing length because after swapping largest element is at last position
            //We are using i as length and i is also decrementing so we can pass i as length
        }
        
    }

}
