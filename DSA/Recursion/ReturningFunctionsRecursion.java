public class ReturningFunctionsRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.print("Original Array : ");
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
        reverseArray(arr, 0, arr.length-1);
        System.out.print("\nReversed Array : ");
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Pallindrome String : " +checkPalindromeRecursion("Pranav", 0, "Pranav".length()-1));
    }



    public static int[] reverseArray(int[] arr , int start , int end)
    {
        if(start>=end) return arr;
        int temp = arr[start];
        arr[start]  = arr[end];
        arr[end] = temp;
        return reverseArray(arr, start+1, end-1);
    }

    public static boolean checkPalindromeRecursion(String s , int x , int y)
    {
        if(x>=y) return true;
        if(s.charAt(x)!=s.charAt(y)) return false;
        return checkPalindromeRecursion(s, x+1, y-1);
    }
}
