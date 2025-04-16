public class MultipleRecursionCalls {
    public static void main(String[] args) {
        System.out.println(printFibbo(7));
    }

    public static int printFibbo(int n)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return printFibbo(n-1)+printFibbo(n-2);
    }
}
