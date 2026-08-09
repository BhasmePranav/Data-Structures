package Practice.ArrayPractice;

import java.util.HashMap;
import java.util.Map;

public class LongestArraySumToZero {
    
    public static void main(String[] args) {
        int[] a = {9, -3, 3, -1, 6, -5};
        subArraySumToZero(a);
    }

    private static void subArraySumToZero(int[] a) {
        int max = 0;
        int sum = 0;
        Map<Integer , Integer> hm = new HashMap<>();
        for(int i = 0;i<a.length;i++)
        {
            sum = sum+a[i];
            if(sum==0)
            {
                max = i+1;
            }
            if(hm.containsKey(sum))
            {
                max = Math.max(max , i-hm.get(sum));
            }
            else    hm.put(sum , i);
        }
        System.out.println(max);
    }
}
