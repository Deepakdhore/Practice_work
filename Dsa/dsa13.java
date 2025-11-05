public class dsa13 {

    /*Given an array of integers nums sorted in non-decreasing order,
     find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity  
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4] 
    */

    public static void main(String[] args) {
        
        int[] arr={5,7,7,8,8,8,8,8,10};
        int target=8;
        int first=0;
        int last=arr.length-1;

       while(first<last){
        
        if(arr[first]!=target)
        first++;
      
        if(arr[last]!=target)
        last--;
        
        if(arr[first]==target && arr[last]==target)
        break;
       
       }

       if(arr[first]!=target)
       System.out.println(-1+" "+-1);
       else{
        System.out.println(first+" "+last);
       }

    }
    
}
