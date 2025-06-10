
public class BasicRecursion {
    static int sum = 0;
    public static void main(String[] args) {
        printNum(1);
        System.out.println();
        printNumBackTrack(5);
        System.out.println();
        printNumRevBackTrack(1);
        sumOfNnumbr(1);
        System.out.println("\nSum is : "+sum);
        System.out.println("Sum of Number by recursive returning fuction : "+sumOfNumberReturning(10));
        System.out.println("Factorial by returning method is : "+factorialReturning(5));
        
        
    }
    public static void printNum(int x)
    {
        if(x>5) return ;
        System.out.print(x+" ");
        printNum(++x);
    }

    public static void printNumBackTrack(int n)
    {
        if(n<1) return ;
        printNumBackTrack(n-1);
        System.out.print(n+" ");
    }

    public static void printNumRevBackTrack(int n)
    {
        if(n>5) return;
        printNumRevBackTrack(n+1);
        System.out.print(n+" ");
    }

    public static void sumOfNnumbr(int x)
    {
        if(x>5) return;
        sum = sum+x;
        sumOfNnumbr(x+1);
    }

    public static int sumOfNumberReturning(int x)
    {
        if(x==0) return 0;
        return x + sumOfNumberReturning(x-1);
    }

    public static int factorialReturning(int x)
    {
        if(x==1) return 1;
        return x * factorialReturning(x-1);

    }
}
