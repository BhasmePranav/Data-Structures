package Sortings;

public class MergeSort {

    public static void main(String[] args)
    {
        int a[] = {12,1343,543,87,15,99,768};
        int end = a.length-1;

        System.out.println("Unsorted Array : ");
        for(int x : a)
        {
            System.out.print(x+" ");

        }
        divide(a, 0, end);
        System.out.println("\nSorted Array : ");
        for(int x : a)
        {
            System.out.print(x+" ");

        }
    }

    public static void divide(int[] a , int beg , int end)               //Divide method
    {
        if(beg>=end)                                    //if we get single element then we will stop recursion
        {
            return;
        }
        int mid = beg + (end-beg)/2;                          //If array is big both start end end value will be INT_MAX it will give integer range error(GO out of range of integer in java compiler)
        divide(a, beg, mid);                                //Dividing array recursively
        divide(a, mid+1, end);
        conqure(a, beg, mid, end);
    }

    public static void conqure(int[] a , int beg , int mid , int end)               //again joining array in sorted way
    {
        int[] merged = new int[end-beg+1];                              //New Array with size of subarrays we will join in each pass
        int idx1 = beg;                                             //Index for traversing array at left of mid so from beg to mid
        int idx2 = mid+1;                                           //Index for traversing array at right of mid so from mid+1 to end
        int x = 0;
        while(idx1<=mid && idx2 <=end)
        {
            if(a[idx1]<=a[idx2])
            {
                merged[x] = a[idx1];
                x++;
                idx1++;
            }
            else
            {
                merged[x] = a[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1 <= mid)                                  //If right array is completely traveresed then remaining element from left array will be added to merged array
        {
            merged[x] = a[idx1];
            x++;
            idx1++;

        }
        while(idx2<=end)
        {
            merged[x] = a[idx2];
            x++;
            idx2++;

        }
        int i = 0;
        int j = 0 ;
        for(i = 0 , j = beg; i<merged.length;i++ , j++)                     //Setting eleemtn of sorte array to again to original array
        {
            a[j] = merged[i];
        }
    }
   
    
}
