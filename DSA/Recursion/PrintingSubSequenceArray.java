import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintingSubSequenceArray {


    public static void main(String[] args) {
        int arr[] = {2,5,2,1,2};
        List<Integer> l = new ArrayList<>();
        printSubSequnce(0, arr.length, l, arr);
        System.out.println("Subsequence with sum 5 : ");
        printSubSequnceEqualSum(0 , 5 , l , arr , 5 , 0);
        System.out.println("Only one subSequnce with target sum is  : ");
        printOneSubSequenceEqualToTarget(0, 4, l, arr, 6, 0);
        System.out.println(countOfSubSequence(0, 4, arr, 6, 0));
    }

    public static void printSubSequnce(int i , int n , List<Integer> l , int[] arr)
    {
        if(i>=n)
        {
            System.out.println(l);
            return;
        }
        printSubSequnce(i+1, n, l, arr);
        l.add(arr[i]);
        printSubSequnce(i+1 , n , l , arr);
        l.remove(l.size()-1); 
    }

    public static void printSubSequnceEqualSum(int i , int n , List<Integer> l  , int[] arr , int target , int sum)
    {
        if(i>=n)
        {
            if(sum==target) 
            {
                System.out.println(l);
            }
            return;
        }
        sum = sum+arr[i];
        l.add(arr[i]);
        printSubSequnceEqualSum(i+1, n, l, arr , target , sum);
        l.remove(l.size()-1);
        sum = sum-arr[i];
        printSubSequnceEqualSum(i+1, n, l, arr, target, sum);
    }

    public static boolean printOneSubSequenceEqualToTarget(int i , int n, List<Integer> l ,int[] arr , int target , int sum)
    {
        if(i>=n)
        {
            if(target==sum)
            {
                System.out.println(l);
                return true;
            }
            else return false;
        }
        l.add(arr[i]);
        sum = sum+arr[i];
        if(printOneSubSequenceEqualToTarget(i+1, n, l, arr, target, sum)==true) return true;
        sum = sum-arr[i];
        l.remove(l.size()-1);
        if(printOneSubSequenceEqualToTarget(i+1, n, l, arr, target, sum)==true) return true;
        return false;
    }

    public static int countOfSubSequence(int i , int n, int[] arr , int target , int sum)
    {
        if(i>=n)
        {
            if(target==sum) return 1;
            else return 0;
        }
        sum = sum+arr[i];
        int l = countOfSubSequence(i+1, n, arr, target, sum);
        sum = sum-arr[i];
        int r  = countOfSubSequence(i+1, n, arr, target, sum);
        return l+r;
    }
}