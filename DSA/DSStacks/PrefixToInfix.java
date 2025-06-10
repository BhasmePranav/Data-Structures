package DSA.Stacks;

import java.util.Stack;

public class PrefixToInfix {
    
    public static void main(String[] args) {
        
        String prefix = "*-A/BC-/AKL";
        String sol = converter(prefix);

        System.out.println("Prefix : "+prefix);
        System.out.println("infix : "+sol);
        
    }

    public static String converter(String prefix)
    {
        prefix = new StringBuilder(prefix).reverse().toString();
        System.out.println(prefix);
        Stack<String> st = new Stack();

        for(char x : prefix.toCharArray())
        {
            if(Character.isLetterOrDigit(x))
            {
                st.push(String.valueOf(x));
                continue;
            }
            else
            {
                String o1 = st.pop();
                String o2 = st.pop();

                String temp = "("+o2+String.valueOf(x)+o1+")";
                st.push(temp);
            }
        }
        String sol = st.pop();
        sol = new StringBuilder(sol).reverse().toString();
        sol = sol.replace("(", "#").replace(")", "(").replace("#", ")");
        return sol;
    }
}
