import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> sol = new ArrayList<>();
        paliPartition(s , 0 , new ArrayList<>() , sol);
        System.out.println(sol);
    }

    private static void paliPartition(String s, int i, List<String> l, List<List<String>> sol) {
        if(i==s.length())
        {
            sol.add(new ArrayList<>(l));
            return;
        }
        for(int j = i;j<s.length();j++)
        {
            String sub = s.substring(i, j+1);
            System.out.println(l);
            if(isPallindrome(sub))
            {
                l.add(sub);
                System.out.println(l);
                paliPartition(sub, i+1, l, sol);
                l.remove(l.size()-1);
            }
        }
    }

    private static boolean isPallindrome(String a)
    {
        String x = new StringBuilder(a).reverse().toString();
        return x.equals(a);
    }
}
