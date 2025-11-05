import java.util.HashMap;
import java.util.*;
public class dsa8 {
    /*Given an integer array nums where every element appears three times except for one, 
    which appears exactly once. Find the single element and return it.

    You must implement a solution with a linear runtime complexity and 
    use only constant extra space.
    Example 1:
    Input: nums = [2,2,3,2]
    Output: 3
    Example 2:
    Input: nums = [0,1,0,1,0,1,99]
    Output: 99 */
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();

        Scanner sc=new Scanner(System.in);
        int n=4;
        int nums[]=new int[n];
        System.out.println("enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }

        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i, 0)+1);
        }

        for(int i:nums)
        {
            if(map.get(i)==1)
            {
                System.out.println("Single elemnt is "+i);
            }
        }

        



    }
}
