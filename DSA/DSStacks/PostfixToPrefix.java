package DSA.Stacks;

import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        
        String postfix = "ABC/-AK/L-*";
        String sol = converter(postfix);

        System.out.println("PostFix : "+postfix);
        System.out.println("Prefix : "+sol);
    }

    public static String converter(String postfix)
    {
        Stack<String> st = new Stack();

        for(char x : postfix.toCharArray())
        {
            if(Character.isLetterOrDigit(x))
            {
                st.push(String.valueOf(x));
            }
            else
            {
                String op2 = st.pop();
                String op1 = st.pop();
                String temp = String.valueOf(x)+op1+op2;
                st.push(temp);
            }
        }


        return st.pop();
    }
    
}
