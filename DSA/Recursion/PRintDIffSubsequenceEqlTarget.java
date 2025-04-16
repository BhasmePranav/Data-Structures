import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRintDIffSubsequenceEqlTarget {
    public static void main(String[] args) {
        int[] ar  = {2,3,4,1,4,1,2,1,1};
        Arrays.sort(ar);
        List<List<Integer>> sol = new ArrayList();
        combis(ar , 0 , 7 , new ArrayList() , sol);
        System.out.println(sol.size());
        //System.out.println(sol);
    }

    public static void combis(int[] arr , int i , int target ,  List<Integer> l  , List<List<Integer>> sol )
    {
        
        if(i==arr.length)
        {
            if(target==0)
            {
                System.out.println(l);
                sol.add(new ArrayList<>(l));
            }
            return;
        }
        if(arr[i]<=target)
        {
            l.add(arr[i]);
            combis(arr , i+1 , target-arr[i] , l , sol);
            l.remove(l.size()-1);
        }
        i=i+1;
        while(i<arr.length-1 && arr[i]==arr[i-2]) i++;
        combis(arr, i+1, target, l, sol);

    }
}
