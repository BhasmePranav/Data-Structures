package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;


/* Generate all strings of given length without consecutive 1s */
public class GenerateBinaryStrings {

    public static void main(String[] args) {
        int k = 4;

        List<String> sol = new ArrayList();
        solver(k,-1,"",sol);
        System.out.println("\n\n"+sol);
    }

    public static void solver(int k , int last, String sol, List<String> l)
    {
        if(k == 0)
        {
            l.add(sol);
            return;
        }
        sol = sol + "0";
        solver(k-1,0,sol,l);
        sol = sol.substring(0,sol.length()-1);
        if(last != 1)
        {
            sol = sol + "1";
            solver(k-1,1,sol,l);
        }   
        
        return ;

    }
    
}
