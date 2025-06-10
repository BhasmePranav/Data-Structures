package PatternPrinting.Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

//QUESTION : Print nth row  of Pascal's Triangle in Java from given n
public class PrintParticularLine {
    
    public static void main(String[] args) {

        int n = 7;
        List row = new ArrayList<>();
        int num = 1;
        for(int i = 0;i<n;i++)
        {
            if(i==0 || i==n-1) row.add(1);
            else
            {
                num = num*(n-i)/(i);
                row.add(num);
            }
        }
        System.out.println(row);
    }
}
