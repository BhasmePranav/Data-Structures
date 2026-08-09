public class LowerAndUpperBound {
    
    public static void main(String[] args) {
        
        /* from below given array we have to find lower and upper bound for x */
        //int[] arr = {3,5,8,15,19};
        int[] arr = {1,2,2,3};
        int x = 2;
        //int x = 9;
        System.out.println(lowerBound(arr, x));
        System.out.println(upperBound(arr, x));
    }

    /*lower bound means greater or equal number than x  with smallest index  */
    public static int lowerBound(int[] arr, int x)
    {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int lb  = n;                    //for storing lower bound index of x
        while(l < r)
        {
            int mid = (l+r)/2;

            /* here we are using greater than or equal to becz even if we get mid equal to target there 
             * might be possibility to ahve same number prior to that also
             */
            if(arr[mid] >= x)
            {
                r = mid;
                lb = Math.min(lb,mid);
            }
            else l = mid+1;
            
            
        }
        return lb;
    }

    //upper bound measn finding only. greater element from given x with smllest index
    public static int upperBound(int[] arr, int x)
    {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int ub = -1;                //innitially upper bund is -1


        /* if mid > x then we will go to left side of the array and same time we update the uper bound as mid
         * bcz mid ia greatee than x and it might be upper bound bcz there is chances that all other previous elements
         * are smaller than x
         */
        while(l < r)
        {
            int mid = (l+r)/2;
            if(arr[mid] > x)
            {
                r = mid;
                ub = Math.max(ub,mid);          //updateing upper bound

            }
            else l = mid+1;
        }
        System.out.println("upper Bound : "+ub);
        return ub;
    }
}
