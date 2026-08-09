package Practice.TreePractice;

public class LongesPalindromeByIterative {
    
    static int max = 0;
    static String sol = "";

    public static void main(String[] args) {
        String s = "qspranavvanarppqt";
        System.out.println("\n"+longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        String sol = "";
        int max = 0;
        for(int i = 0;i<s.length();i++)
        {
            for(int j = i+1;j<s.length();j++)
            {
                String temp = s.substring(i , j+1);
                if(isPal(temp) && temp.length()>max)
                {
                    max = temp.length();
                    sol = temp;
                }
            }
        }
        System.out.print(sol);
        return max;
        
    }
    public static boolean isPal(String s)
    {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
}
