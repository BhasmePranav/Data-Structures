

public class CountingSort {

    public static void main(String[] args) {
        
        int[] arr = {22,55,2,11,77,88,99,4,4,44,11,22};
        int n = arr.length;
        System.out.println("unsortted Array : ");
        for(int a : arr)
        {
            System.out.print(a+"  ");
        }
        int max = 0;

        //finding max to make hash array of that size so can store ech element occurace
        for(int a : arr)
        {
            max = Math.max(a,max);
        }
        int[] counts = new int[max+1];
        
        //counting the occurance of each element
        for(int a : arr)
        {
            counts[a]++;
        }
    

        //Adding all element on original array forhoe many occurance of there 
        //if 1 is occurs thrice then we will add 1 in array 3 Times
        int x = 0;
        for(int i = 0;i<counts.length;i++)
        {
            while(counts[i] > 0)
            {
                arr[x] = i;
                x++;
                counts[i]--;
            }
        }

        System.out.println("\nSorted Array : ");
        for(int a : arr)
        {
            System.out.print(a+"  ");
        }

    }


    
}
