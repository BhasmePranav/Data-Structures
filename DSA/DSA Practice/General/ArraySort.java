package Practice.General;

import java.util.Arrays;
import java.util.*;

public class ArraySort {
    public static void main(String[] args) {
        int[] num = {3 ,2 , 1 , 2,1,3,2,1};
        Map<Integer , Integer> hm = new HashMap<>();
        for(int x : num)
        {
            hm.put(x, (int)Arrays.stream(num).filter(e->e==x).count());
        }
        System.out.println(hm.isEmpty());  
    }
}
