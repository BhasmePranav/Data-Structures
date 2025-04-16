public class QuickSortRecursion {

    public static void main(String[] args) {
        int[] arr = { 66, 44, 22, 99, 44 };
        System.out.println("Original Array : ");
        for(int x : arr)
        {
        System.out.print(x+" ");
        }
        System.out.println();
        quickSortLogicCode(arr, 0, arr.length - 1);
        System.out.println("Sorted Array : ");
        for(int x : arr)
        {
        System.out.print(x+" ");
        }
    }

    public static void quickSortLogicCode(int[] arr, int low, int high) 
    {
        if(low<high)
        {
            int left = low;
            int right= high;
            int pivot = arr[low];
            while(left<=right)
            {
                while(arr[left]<=pivot && left<=high)    left++;
                while(arr[right]>pivot && right>=low)   right--;
                if(left<=right)
                {
                    int temp = arr[left];
                    arr[left]  =arr[right];
                    arr[right] = temp;
                }
            }
            int temp = arr[right];
            arr[right] = pivot;
            arr[low] = temp;

            quickSortLogicCode(arr, low, right-1);
            quickSortLogicCode(arr, right+1, high);
        }
        

    }
    
}
