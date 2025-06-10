import java.util.ArrayList;
import java.util.List;

public class PrintPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("First Approch using one ds for checking which elelemt is pickedup : ");
        permuts(arr, new ArrayList<>(), new ArrayList<>());
        System.out.println("Second Approch By swapping : ");
        permutesBySwapping(0, 0, arr);
    }

    //Approch 1 using extra List to store permutations
    public static void permuts(int[] arr , List<Integer> l , List<Integer> marker) 
    {
        if(l.size()==arr.length)
        {
            System.out.println(l);
            return;
        }
        for(int i = 0;i<arr.length;i++)
        {
            if(!marker.contains(i)) 
            {
                l.add(arr[i]);
                marker.add(i);
                permuts(arr, l, marker);
                marker.remove(marker.size()-1);
                l.remove(l.size()-1);
            }
        }
    }

    //Approach 2 using swapping
    public static void permutesBySwapping(int i , int z , int[] arr)
    {
        if(i==arr.length)
        {
            for(int x : arr)
            {
                System.out.print(x+"  ");
            }
            System.out.println();
            return;
        }
        for(int j = i;j<arr.length;j++)
        {
            int temp = arr[z];
            arr[z] = arr[j];
            arr[j] = temp;
            permutesBySwapping(i+1, z+1, arr);
            temp = arr[z];
            arr[z] = arr[j];;
            arr[j] = temp;
        }
    }
}
