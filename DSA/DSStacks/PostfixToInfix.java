package DSA.Stacks;

import java.util.Stack;

public class PostfixToInfix {
    
    public static void main(String[] args) {
        
        String postfix = "ab*c+";
        String sol = converter(postfix);

        System.out.println("postfix is : "+postfix);
        System.out.println("infix is : "+sol);
    }

    public static String converter(String postfix)
    {
        Stack<String> st = new Stack();
        for(char x : postfix.toCharArray())
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
        return st.pop();
    }

    public static int getPrecedence(char x)
    {
        if(x == '+' || x == '-')    return 1;
        else if(x == '*' || x == '/')    return 2;
        else if(x == '^')   return 3;
        else return 0;
    }
}
