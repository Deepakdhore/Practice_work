import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class dsa24 {
    /*
     * Given an integer array nums, 
     * return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array 
    by deleting some or no elements without changing the order of the remaining elements. 
    For example, [3,6,2,7] is a subsequence of [0,3,1,6,2,2,7].

Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing subsequence is [2,3,7,101].
Input: nums = [0,1,0,3,2,3] Output: 4 Explanation: The longest increasing subsequence is [0,1,2,3].
Input: nums = [7,7,7,7,7,7,7] Output: 1 Explanation: The longest increasing subsequence is [7].
     */

     public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,dsa18};
        HashMap<Integer,Integer> map =new HashMap<>();

        //find big seies,
        //build along wiht it
        //get the series

        HashSet<Integer> set =new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<Integer> currList =new ArrayList<>();
        int index=0;
        for (int i : nums) {
            map.put(i, index);
            index++;
        }

        Arrays.sort(nums);
        int max=0;
        int currMax=0;
        int start=0;

        for(int i:nums)
        {
            System.out.print(i);
        }
        System.out.println();
        for(int i=0;i<nums.length;i++)
        {
            start=nums[i];
            currList.add(nums[i]);
            currMax=1;

           for(int j=i+1;j<nums.length;j++)
           {
             if(map.get(nums[j])>map.get(start))
             {
                currMax++;
                currList.add(nums[j]);
                System.out.print(nums[j]);
                start=nums[j];
             }
            }
                System.out.println(currMax);
            for(int f:currList)
            {
                System.out.print(f);
            }

           
            if(currMax>max)
            {
                list.clear();
                list.addAll(currList);
            }
            currList.clear();
            currMax=0;
            System.out.println();
        }

        for(int i:list)
        {

            System.out.println(i);
        }
     }
}
