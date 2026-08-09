

 

public class BubbleSort { 

 

 

//TC : O(n^2) : comparing each element with its adjacent element for n times. 

public static void main(String[] args) { 

// TODO Auto-generated method stub 

 

int[] arr = {11,55,22,88,6579,564,88,22,3,7}; 

int[] arr1 = {11,55,22,88,3,7}; 

System.out.println("Before Sorting : "); 

for(int a : arr) 

{ 

System.out.print(a+"  "); 

} 

System.out.println(); 

bubbleSortMethod(arr); 

System.out.println("After Sorting : "); 

for(int a : arr) 

{ 

System.out.print(a+"  "); 

} 

 

} 

 

/* Simple comparison sorting technique 

* Comparing each element with its next adjacent element 

* in first iteration it will sort few elements after that few elements 

* in worstcase it may need to soft element till end of the iteration */ 

public static void bubbleSortMethod(int[] nums) 

{ 

int n = nums.length; 

for(int i = 0;i<n;i++) 

{ 

/*Running this loop for n-1 time bcz we are comparing with next element  

* when we are at n-1 element and comparing n+1 element will exceed array index klimit 

* any will get arrayIndexOutOfBoundException  

* and after sorting n-1 elements , last remaining element will be automatically in sorted order 

*/ 

for(int j = 0;j<n-1;j++) 

{ 

if(nums[j] > nums[j+1]) 

{ 

//swapping numbers if current number is greater than immediate next element 

int temp = nums[j]; 

nums[j] = nums[j+1]; 

nums[j+1] = temp; 

} 

} 


} 

 

}
}

