import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class dsa20 {
    /*
     * Given an integer array nums,
     * return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k,
     * and nums[i] + nums[j] + nums[k] == 0.
     * Input: nums = [-1, 0, 1, 2, -1, -4]
     * Output: [[-1, -1, 2], [-1, 0, 1]]
     */

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        // -3012
        Arraylist<ArrayList<Integer>> list = new Arraylist<ArrayList<Integer>>();
        int start = 0;
        int end = nums.length-1;
        int temp = start + 1;

        int first = 0;
        int second = 0;
        int third = 0;
        while (start < end) {
            first = nums[start];
            second = nums[end];
            if (nums[temp] + (nums[start] + nums[end]) == 0) {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(first);
                tempList.add(second);
                tempList.add(third);
                list.add(tempList);
                start++;
                temp++;
            } else {

                if (nums[start] + nums[end] < 0) {
                    temp = end-1;
                    if (nums[temp] + (nums[start] + nums[end]) == 0) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(first);
                        tempList.add(second);
                        tempList.add(third);
                        list.add(tempList);
                        start++;
                        temp++;
                    }
                    else
                    {
                        start++;
                        
                    }
                } else {

                    temp = start + 1;
                    if (nums[temp] + (nums[start] + nums[end]) == 0) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(first);
                        tempList.add(second);
                        tempList.add(third);
                        list.add(tempList);
                        start++;
                        temp++;
                    }
                    else{
                        end--;
                    }
                }

            }


        }

        System.out.println(list);
    }
}
