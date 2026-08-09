public class QuickSort {
    
    public static void main(String[] args) {
        
        int[] arr = {243,5,3,34,635,14,3,4};
        int n = arr.length;

        quickSort(arr,0,n-1);
        for(int a : arr)
        {
            System.out.println(a);
        }

    }

    public static void quickSort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int pivot = getPivot(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int getPivot(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j)
        {
            while(i <= high-1 && arr[i] <= pivot)
        {
            i++;
        }

        while(j >= low+1 && arr[j] > pivot)
        {
            j--;
        }

        if(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


}
