
import java.util.*;
public class InfixToPostfix {
    
    public static void main(String[] args) {
        
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String sol = converter(infix);
        System.out.println("\n\nInfix is : "+infix);
        System.out.println("Postfix is : "+sol);
        System.out.println("\n\n");
    }

    public static String converter(String infix)
    {
        StringBuilder sol = new StringBuilder();
        Stack<Character> st = new Stack();
        for(char x : infix.toCharArray())
        {
            if(Character.isLetterOrDigit(x))    sol.append(x);
            else
            {
                if(x == '(')
                {
                    st.push(x);
                    continue;
                }
                if(x == ')')
                {
                    while(st.peek() != '(')
                    {
                        sol.append(st.pop());
                    }
                    st.pop();
                    continue;
                }
                while(!st.isEmpty() && st.peek() != '('  && getPrecedence(x) <= getPrecedence(st.peek()))
                {
                    sol.append(st.pop());
                }
                st.push(x);
            }
        }
        while(!st.isEmpty())    sol.append(st.pop());
        return new String(sol);
    }

    public static int getPrecedence(char x)
    {
        if(x == '+' || x == '-')    return 1;
        else if(x == '*' || x == '/')    return 2;
        else if(x == '^')   return 3;
        else return 0;
    }
}
