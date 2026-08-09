package Practice.TreePractice;

import java.util.ArrayList;
import java.util.List;

public class RecursionPractice {
    public static void example(int n) {
        if (n <= 0) {
            return;  // Base case
        }
        System.out.println("1 print = " + n);
        example(n - 1);  // First recursive call
        System.out.println("2 print = " + n);
        example(n - 1);  // Second recursive call
    }

    public static int sum(int x)
    {
        if(x<1) return x;
        else 
        {
            return x+sum(x-1);
        }
    }

    public static int factorial(int x)
    {
        if(x==1) return x;
        else
        {
            return x * factorial(x-1);
        }
    }

    public static List<Integer> fibbo(int start , int end , int x , List<Integer> list)
    {
        list.add(end);
        if(start+end>x) return list;
        int n = start +end;
        start = end;
        end = n;
        return fibbo(start , end , x , list);
    }

    public static void main(String[] args) {
        int sum = 0;
        List<Integer> fibboS = new ArrayList<>();
        fibboS.add(0);

        example(3);
        System.out.println("\nSum is : "+sum(5));
        System.out.println("\nFactorial is : "+factorial(5));
        System.out.println("\nFibonacci sereis till 50 is : "+fibbo(0,1,50,fibboS));
    }
}
