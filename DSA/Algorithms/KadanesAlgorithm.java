package Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Sub-Array sum is : "+maxSumArraySum(a));
    }

    public static int maxSumArraySum(int[] a)
    {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int sI = 0;
        int eI = 0;
        for(int i = 0;i<a.length;i++)
        {
            if(sum==0) sI = i;
            sum +=a[i];
            if(sum>max)
            {
                max = sum;
                eI =  i;
            }
            if(sum<0) sum = 0;
        }
        for(int i= sI;i<eI+1;i++)
        {
            System.out.print(a[i]+" ");
        }
        return max;
    }
    
}
