package Sortings;

public class SelectionSort {

    public static void main(String[] args)
    {
        int[] a = {12, 3, 456, 43, 78, 9743, 23};
        int i = 0;
        int j = 0;

        System.out.print("Unsorted Array : ");
        for(int x : a)
        {
            System.out.print(x+" ");
        }

        for(i=0;i<a.length-1;i++)
        {
            int min = i;
            for(j = i+1;j<a.length;j++)
            {
                if(a[min]>a[j])
                {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        System.out.print("\nSorted Array : ");
        for(int x : a)
        {
            System.out.print(x+" ");
        }
    }
    
}
