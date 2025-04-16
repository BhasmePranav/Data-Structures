package Sortings;

public class InsertionSort {

    public static void main(String[] args)
    {
        int[] a = {12, 3, 456, 43, 78, 9743, 23};
        
        System.out.println("Unsorted : ");
        for(int x : a)
        {
            System.out.print(x+ " ");
        }
        
        int i = 0 , j = 0;
        for(i = 1 ; i < a.length;i++)
        {
            int temp = a[i];
            j = i-1;
            while(j>=0 && a[j]>temp)
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
        
        
        
        
        System.out.println("\nSorted : ");
        for(int x : a)
        {
            System.out.print(x+ " ");
        }

    }
    
}
