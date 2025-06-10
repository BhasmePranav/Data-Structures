import java.util.ArrayList;
import java.util.List;

public class MergeSortRecursion {
    public static void main(String[] args) {
        int[] arr = {66,44,22,99,44};
        divideArray(arr, 0, arr.length-1);
        System.out.println("Sorted is : ");
        for(int s  : arr)
        {
            System.out.print(s+" ");
        }

    }
    
    public static void divideArray(int[] arr  , int low , int high)
    {
        if(low==high) 
        {
            
            return ;
        }
        
        int mid = (low+high)/2;
        divideArray(arr, low, mid);
        divideArray(arr, mid+1, high);
        joinArray(arr , low , mid , high);
    }

    private static void joinArray(int[] arr, int low, int mid, int high) 
    {
        int left  = low;
        int right = mid+1;
        int x = 0;
        int[] merged = new int[high-low+1];
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                merged[x] = arr[left];
                left++;
            }
            else
            {
                merged[x] = arr[right];
                right++;
            }
            x++;
        }
        while(left<=mid)
        {
            merged[x] = arr[left];
            left++;
            x++;
        }
        while(right<=high)
        {
            merged[x] = arr[right];
            right++;
            x++;
        }
        int i = 0;
        int j= 0;
        for(i = 0,j=low;i<merged.length;i++,j++)
        {
            arr[j] = merged[i];
        }
        System.out.println("Array A is : ");
        for(int a : arr)
        {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}

    