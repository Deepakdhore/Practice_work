import java.util.HashMap;
import java.util.HashSet;

public class dsa17 {

    /*
     * Given an integer array nums and an integer k,
     *  return true if there are two distinct indices i and j in the array such that 
     * nums[i] == nums[j] and abs(i - j) <= k.
        Example 1:
        Input: nums = [1,2,3,1], k = 3
        Output: true
        Example 2:
        Input: nums = [1,0,1,1], k = 1
        Output: true
        Example 3:
        Input: nums = [1,2,3,1,2,3], k = 2
        Output: false
     */
    public static void main(String[] args) {
        //sliding window size k
        int[] nums={1,2,3,1,2,3};
        HashMap<Integer,Integer> map=new HashMap<>();
        int k=2;
        int flag=0;
        for(int i=0;i<nums.length;i++)
        {
            
            for(int j=i;j<=k;j++){
                System.out.println(nums[j]);
                if(map.containsKey(nums[j]))
                {
                    System.out.println("True");
                    flag=1;
                    break;
                }
                map.put(nums[j],map.getOrDefault(nums[j],1)+1);
                
            }
            
            map.clear();
            if(flag==1)
            break;
        }
        if(flag==0)
        System.out.println("False");
    }
    
}
