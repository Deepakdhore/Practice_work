public class dsa26 {
    /*
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     *  which has the largest sum and return its sum.
        A subarray is a contiguous part of an array.
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4] 
        Output: 6 Explanation: The contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */

     public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};

        int max=0;
        int currMax=0;
        int sum = 
        for(int i=0;i<nums.length;i++)
        {
            System.out.println("numss: "+nums[i]);
            if(currMax+nums[i]<0)
            {
                if(max<currMax)
                max=currMax;
                System.out.println("currmax: "+currMax);
                System.out.println("max: "+max);
                currMax=0;

            }
            else{
                currMax+=nums[i];
                System.out.println("currMax: "+currMax);
                if(max<currMax)
                max=currMax;
                System.out.println("max: "+max);
            }
        }

        System.out.println(max);
     }
}
