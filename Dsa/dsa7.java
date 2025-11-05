import java.util.Scanner;

public class dsa7 {

    /*
    Given an integer array nums, move all 0's to the end of it 
    while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:
    Input: nums = [0]
    Output: [0] 
    */
    public static void main(String[] args) {
        
        int[] nums=new int[5];
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the numbers");
        for(int i=0;i<5;i++)
        {
            nums[i]=sc.nextInt();
        }

        //if zer0 move left
        //move all all to right;

        for(int i=0;i<5;i++)
        {
            if(nums[i]==0)
            {
                for(int j=i;j<4;j++)
                {
                    nums[j]=nums[j+1];
                }
                nums[4]=0;
            }
        }

        for(int i:nums)
        {
            System.out.print(i);
        }
    }
}
