package Sortings;


public class QuickSort {

    public static int partition(int[] a , int low , int high)                   //PArtition method to sort arrays
    {
        int pivot = a[high];                                                //Assigning last element as pivot
        int i = low-1;                                                      //To create place for elemtn lower than pivot
        int j = 0;

        for(j = low;j<high;j++)                                             //Traversing array 
        {
            if(a[j]<pivot)                                                 // This condition will swap element until loop gets finished ahd when conditon issatisfying
            {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;                                                                //it willl place pivot to accurate position
        int temp = a[i];
        a[i] = pivot;
        a[high] = temp;
        for(int x : a)
        {
            System.out.print(x+ " ");

        }
         return i;                                                               //Returning index of pivot
    }
    public static void quickSort(int[] a , int low , int high)                  //Method for Sorting arrays which got after partition
    {
        if(low<=high)
        {
            int pivIndex = partition(a, low, high);                             //from partition return index of pivote
            System.out.println("Index : "+pivIndex+ " Pivote is : "+a[pivIndex]);
            quickSort(a, low, pivIndex-1);                                     //recursive quick sort by using pivot index
            quickSort(a, pivIndex+1, high);
        }
    }

    public static void main(String[] args)
    {
        int[] a = {7,6,2,3,9,12,8};
        int len = a.length;

        System.out.println("\nUnsorted Array :  ");
        for(int x : a)
        {
            System.out.print(x+ " ");

        }

        quickSort(a, 0, len-1);
        System.out.println("\nSorted Array :  \n");
        for(int x : a)
        {
            System.out.print(x+ " ");

        }

        // for(int x : a)
        // {
        //     System.out.print(x+ " ");

        // }

    }
    
}
