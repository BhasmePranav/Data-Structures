
import java.util.Arrays;

public class ShortestJobFirst {

    public static void main(String[] args) {
        
        //time taken for each job to complete that job
        int[] times = {4,3,7,1,2};
        System.out.println(solver(times));
    }

    public static int solver(int[] times)
    {   
        int n = times.length;
        int waiting  = 0;
        int sol = 0;

        //Sorting given array bcz SFJ algorithm always perform shortest job first
        Arrays.sort(times);


        /* waitting is time each task need to wait until its time to perform that task
         * firstly when first task is performed witing time ws 0 then  second task is performed that
         * task need to wsit until first task gets completed in same way for all tha ttask.
         */
        for(int i = 0;i<n;i++)
        {
            System.out.println(waiting);
            sol = sol + waiting;
            waiting += times[i];
        }
        System.out.println(sol);
        return 0;
    }
    
}
