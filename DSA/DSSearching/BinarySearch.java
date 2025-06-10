package DSSearching;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a[] = {12,22,34,46,56,67,79,89,99,123,234,789};
        System.out.println("Enter the element which you want to find : ");
        int target = sc.nextInt();
        int high = a.length-1;
        int result = binarySearch(a, 0,high, target);
        
        if(result==-1)
            System.out.println("Element "+target+" not present in th array .");
        else
            System.out.println("Element "+target+" is found at index : "+result);

        sc.close();
    }

    public static int binarySearch(int[] a , int low , int high , int target)
    {
        if(low<=high)
        {
            int mid = (low+high)/2;
            if(target==a[mid])
            {
                return mid;
            }
            if(target > a[mid])
            {
                return binarySearch(a, mid+1, high, target);
            }
            else if(target < a[mid])
            {
                return binarySearch(a, low, mid-1, target);
            }
            
        }
        return-1;
    }
 
}
