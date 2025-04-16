package Sortings;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ar = { 2, 13, 456, 43, 78, 9743, 23 };
        int i = 0;
        int j = 0;
        System.out.println("Unsorted : ");

        for(int x : ar)
        {
            System.out.print(x+ " ");

        }

        for (i = 0; i < ar.length - 1; i++)             //used length-1 otherwise gives error null pointer exception at if condition at ar[j+1]line number 22
        {
            for (j = 0; j < ar.length - 1; j++)            //2 loops  loop j for checking andd swapping and loop i will run for array length-1 times
            {
                int temp;
                if(ar[j]>ar[j+1])
                {
                    temp = ar[j];               //Swapping element
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
        System.out.println("\nSorted : ");
        for(int x : ar)
        {
            System.out.print(+x+ " ");

        }
    }

}
