package DSA.Stacks;
import java.util.*;
public class PrefixToPostfix {
    
    public static void main(String[] args) {
        
        String prefix = "*-A/BC-/AKL";
        String sol = converter(prefix);

        System.out.println("prefix : "+prefix);
        System.out.println("Postfix : "+sol);
    }

    
    public static String converter(String s)
    {
        Stack<String> st = new Stack();
        for(int i = s.length()-1;i>=0;i--)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                st.push(String.valueOf(s.charAt(i)));
            }
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();

                String temp = op1+op2+String.valueOf(s.charAt(i));
                st.push(temp);
            }
        }
        return st.pop();

    }
}
