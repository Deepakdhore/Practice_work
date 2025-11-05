import java.util.HashSet;

public class dsa14 {

    /*
     * Given an unsorted array of integers nums, 
     * return the length of the longest consecutive elements sequence.
        You must write an algorithm that runs in O(n) time.
 
    Example 1:Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
    Therefore its length is 4.

    Example 2:Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
     */

     public static void main(String[] args) {
     //find least
     //find max 
     //compare max
        HashSet<Integer> set=new HashSet<>();
        
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        
        int count=0;
        int max=0;
        for (int i : nums) {
            set.add(i);
        }

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1))
            continue;
            else{
                count=1;
                int j=i;
                int temp=nums[j];
                while(set.contains(temp+1))
                {
                    count++;
                    temp+=1;
                }

                max=Math.max(max,count);
                count=0;
            }
        }

        System.out.println("max consecutive= "+max);

     }
    
}
