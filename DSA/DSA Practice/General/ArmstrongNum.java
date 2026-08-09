package Practice.General;

import java.util.Scanner;

public class ArmstrongNum {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num  : ");
        int x = sc.nextInt();
        System.out.println("num is : "+x);
        int powSum = 0;
        int len = 0;
        int temp = x;
        int og = x;
        while(temp>0)
        {
            len++;
            temp = temp/10;
        }
        while(x>0)
        {
            int rem = x%10;
            powSum = (int) (powSum + Math.pow(rem , len));
            x = x/10;
        }
        if(og==powSum)
            System.out.println(og+" is an armstrong number");
        else
            System.out.println("Not armstrong");
    }
    
}
