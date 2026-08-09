public class FloorAndCeil {
    
    public static void main(String[] args) {
        
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = arr.length;
        int x = 5;

        System.out.println("floor is : "+floor(arr,x));
        System.out.println("Ceil is : "+ceil(arr,x));
    }

    //floor means largest value which is smaller than x
    public static int floor(int[] arr, int x)
    {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int floor = -1;
        int floorId = -1;

        while(l < r)
        {
            int mid = (l+r)/2;
            if(arr[mid] <= x)
            {
                floor = arr[mid];
                floorId = mid;
                l = mid+1;
            }
            else r = mid;
        }
        System.out.println(floorId);
        return floor;
    }

    
    //ceil means smallest value which is greater than x
    public static int ceil(int[]arr, int x)
    {
        int n = arr.length;
        int l = 0;
        int r  = n-1;
        int ceil = 100;
        while(l < r)
        {
            int mid = (l+r)/2;
            if(arr[mid] >= x)
            {
                r = mid;
                ceil = Math.min(ceil,arr[mid]);
            }
            else l = mid+1;
        }
        return ceil;
    }
}
