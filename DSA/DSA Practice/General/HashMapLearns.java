package Practice.General;

import java.util.HashMap;
import java.util.Map;

public class HashMapLearns {

    public static void main(String[] args) {
        Map<Integer , Integer> hm = new HashMap();
        int[] ar = {3,-3,1,1,1};
        int k = 3;
        int sum = 0;
        int count = 0;
        hm.put(0,1);
        for(int x : ar)
        {
            sum = sum+x;
            int rem = sum-k;
            if(hm.containsKey(rem))
            {
                count = count+hm.get(rem);
            }
            if(hm.containsKey(sum))
            {
                hm.put(sum , hm.get(sum)+1);
            }
            else hm.put(sum , 1);
        }
        System.out.println(count);
    }
    
}
