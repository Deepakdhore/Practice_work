import java.util.ArrayList;
import java.util.HashMap;

public class dsa22 {
    /*
     * Given an integer array nums and an integer k,
     *  return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, 
    not the kth distinct element.
    You must solve it without sorting the entire array.
    
    Input: nums = [3,2,1,5,6,4], k = 2 
    Output: 5
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
     */
    public static void main(String[] args) {

        int[] input={3,2,3,1,2,4,5,5,6};
        int k=4;
        ArrayList<Integer> list =new ArrayList<>();

        for (int i : input) {
            list.add(i);
        }
        int max=0;

        for(int i=0;i<k;i++)
        {
            max=0;
            for(int j:list)
            {
                if(j>max)
                max=j;
            }
            list.remove(list.indexOf(max));
        }

        System.out.println("the "+k+"th number is= "+max);
        
    }
}
