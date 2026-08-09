package Practice.General;

import java.util.Scanner;

public class SwapVowels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter String : ");
        // String s = sc.nextLine();
        String s = "meetings";
        String vowels = "aeiou";
        String sol = "";
        for(int i = 0;i<s.length()-1;i++)
        {
            char x = s.charAt(i);
            char z = s.charAt(i+1);
            if(!vowels.contains(String.valueOf(x))) sol = sol+x;
            if(vowels.contains(String.valueOf(x)))
            {
                if(vowels.contains(String.valueOf(z)))
                {
                    if(x==z)
                    {
                        int indX = vowels.indexOf(x);
                        int indz = vowels.indexOf(z);
                        sol = sol+vowels.charAt(vowels.indexOf(x)+1)+vowels.charAt(vowels.indexOf(x)+2);
                        i++;
                    }
                }
                else
                {
                    sol = sol+vowels.charAt(vowels.indexOf(x)+1);
                }
            }
        }
        if(vowels.contains(String.valueOf(s.charAt(s.length()-1))))
        {
            sol = sol+vowels.charAt(vowels.indexOf(s.charAt(s.length()-1))+1);
        }
        System.out.println(sol);
    }
    
}
