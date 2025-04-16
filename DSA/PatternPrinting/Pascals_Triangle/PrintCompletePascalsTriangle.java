package PatternPrinting.Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

//QUESTION : Print complete pascals triangle till given row
public class PrintCompletePascalsTriangle {

    static List<List<Integer>> res = new ArrayList();
    public static void main(String[] args) {
        
        int n = 7;
        createPascalesTriangle(n);
        for(List x : res)
        {
            System.out.println(x);
        }
    }

    private static void createPascalesTriangle(int n) {
        int x = 1;
        while(x<=n)
        {
            List<Integer> temp = new ArrayList();
            int sol = 1;
            for(int i = 0;i<x;i++)
            {
                if(i==0 || i==x-1) temp.add(1);
                else
                {
                    sol = sol*(x-i)/(i);
                    temp.add(sol);
                }
                
            }
            res.add(temp);
            x++;
        }
        

    }
    
    
}
