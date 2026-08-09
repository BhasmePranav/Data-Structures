package Practice.ArrayPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PRintSubArrays {

    public static void main(String[] args) {
        int[] arr= new int[]{-5, -3, -2, -8, -1, 2, 4, -6,15};
        System.out.println("\nBrute-Force Approach  with TC O(n^3): ");
        printAllSubarrays(arr);
        System.out.println("\nBrute-Force Approach  with TC O(n^2): ");
        printSubsBruteSecond(arr);
        System.out.println("\nBetter Approach using hashing : ");
        printSubsBetter(arr , 4);
    }

    //Brute-Force Approach with TC O(n^3)
    public static void  printAllSubarrays(int[] arr){
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = i;j<arr.length;j++)
            {
               for(int k = i;k<=j;k++)
               {
                    System.out.print(arr[k]+" ");
               }
               System.out.println();
            }
        }
    }

    //Brute-Force Approach with TC O(n^2)
    public static void printSubsBruteSecond(int[] arr)
    {
        int sum = 0;
        int maxLen = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum = 0;
            for(int j = i;j<arr.length;j++)
            {
                sum = sum+arr[j];
                System.out.println(sum);
                if(sum==7) maxLen = Math.max(maxLen , j-i+1);           //finding subArray with sum 7
            }
        }
        System.out.println("Maximum length is : " + (maxLen));
    }


    //Better Approach using Hashing            (Optimal approach for Array containing positive and negative elements)
    public static void printSubsBetter(int[] arr , int k)
    {
        HashMap<Integer , Integer> hm = new HashMap<>();        //Used for hashing sum and index where it occured
        int sum = 0;
        int len = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum = sum+arr[i];
            int rem = sum-k;                    //Calculate remaining sum using reverse maths
            if(sum==k) 
            {
                len =  i+1;
            }
            else if(hm.containsKey(rem))        //if map contains remaining sum it means  we found a subarray of length 'len'
            {
                len = Math.max(len , i-hm.get(rem));        //calculate length from max of len and index of rem and current index
                int[] solArr = Arrays.copyOfRange(arr, hm.get(rem)+1, i+1);
                for(int x: solArr)
                {
                    System.out.print(x+" ");     //Print the solution array
                }
                System.out.println();
            }
            hm.put(sum , i);
        }
        System.out.println("Length is : "+len);
    }
}
