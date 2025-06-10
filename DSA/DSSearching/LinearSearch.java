package DSSearching;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args)
    {   
        Scanner sc = new Scanner(System.in);
        int[] a = {123,45,76,345,87,98,345,2};
        System.out.print("Enter element which u want to find : ");
        int target = sc.nextInt();
        int result = linearSearch(a, target);
        if(result==-1)
        {
            System.out.println("Element "+target+" is not present in the array . ");
        }
        else
        {
            System.out.println("Element "+target+" is found at index "+result);
        }
        sc.close();
    }

    //Linear search method
    public static int linearSearch(int[] a , int target)
    {
        int i = 0;
        for(i=0;i<a.length;i++)
        {
            if(a[i]==target)
            {
                return i;
            }
        }
        return -1;
    }


    
}
