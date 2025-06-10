package Concepts;

public class Recursion {

    public static int count = 0;
    public static int count1 = 0;

    public static void main(String[] args) {
        int z = 0;
        int start = 1;
        int end = 5;
        System.out.println("Using 2 vairables : ");
        print();
        System.out.println("\nUsing 1 vairables : ");
        counter(z);
        System.out.println("\nPrinting 1 to 5 using backTracking : ");
        backtrack(start , end);

    }


    
    public static void print()
    {   
        if(count<3)
        {
            System.out.println("Its One count : "+ count++);
            print();
            System.out.println("Its two count1 : "+ count1++);
        }
    }

    public static void counter(int n)
    {
        if(n>3 || n<0)
        {
            return;
        }
        System.out.println("1 print : "+n);
        n++;
        counter(n);
        System.out.println("2 print : "+n);
        n++;
        counter(n);
    }
        
    public static void backtrack(int start , int end)
    {
        if(end<start) return;
        backtrack(start, end-1);
        System.out.println(end);
    }
}


