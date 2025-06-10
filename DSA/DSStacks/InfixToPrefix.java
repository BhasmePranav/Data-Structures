package DSA.Stacks;
import java.util.*;



public class InfixToPrefix {

    public static void main(String[] args) {
        
        String  infix = "a+b*(c^d-e)^(f+g*h)-i";
        String sol = converter(infix);

        System.out.println("\n\n Infix is  : "+infix);
        System.out.println("Prefix is  : "+sol);

    }

    public static String converter(String infix)
    {
        /*Approach to convert infix to prefix is reverse given infix operation swap the opening closing brackets 
         * take operator in stack under specific condition and then reverse the final string    */
        
        Stack<Character> st = new Stack();
        StringBuffer sol = new StringBuffer();

        //reversing given infix String and swapping brackets
        infix = new StringBuilder(infix).reverse().toString();
        infix = infix.replace("(", "#").replace(")", "(").replace("#" , ")");
        System.out.println(infix);
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
                else if(x == ')')
                {
                    while(st.peek() != '(')
                    {
                        sol.append(st.pop());
                    }
                    st.pop();
                    continue;
                }
                else
                {
                    while(!st.isEmpty() && st.peek() != '(' && getPrecedence(x) < getPrecedence(st.peek()))
                    {
                        sol.append(st.pop());
                    }
                }
                
                st.push(x);
            }
            
        }
        while(!st.isEmpty())    sol.append(st.pop());
        return sol.reverse().toString();

    }

    public static int getPrecedence(char x)
    {
        if(x == '+' || x == '-')    return 1;
        else if(x == '*' || x == '/')    return 2;
        else if(x == '^')   return 3;
        else return 0;
    }
    
}
