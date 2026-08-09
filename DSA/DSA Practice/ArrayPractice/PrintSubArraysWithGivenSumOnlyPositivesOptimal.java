package Practice.ArrayPractice;

public class PrintSubArraysWithGivenSumOnlyPositivesOptimal {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,3,3,4,2,1};
        SubArrayWithGivenSum(arr , 18);
    }

    public static void SubArrayWithGivenSum(int[] arr , int k)
    {
        int sum = 0;
        int left = 0;
        int right  = 0;
        int len = 0;
        while(right<arr.length)
        {
            sum = sum+arr[right];
            right++;
            if(sum==k)
            {
                len = Math.max(len , right-left);
                for(int i= left;i<right;i++)
                {
                    System.out.print(arr[i]+"  ");
                }
                System.out.println();
            }
            while(sum>k)
            {
                sum = sum-arr[left];
                left++;
            }
        }
        System.out.println(len);
    }
    
}
