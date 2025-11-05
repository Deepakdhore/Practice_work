import java.util.ArrayList;
import java.util.HashMap;

public class dsa11 {
    /*Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.
 
Example 1:Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:Input: nums = [1]
Output: [[1]] */

    public static void main(String[] args) {
        //for each elment swap to to each otther element 
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
       

      

        ArrayList<Integer> tempList=new ArrayList<>();
        //int len=3;
        HashMap<Integer,Boolean> used=new HashMap<>();
        for(int i:list){
            used.put(i,false);
        }
        System.out.println("entering backtracking");
        backTrack(list,tempList,used);
    }

    static void backTrack(ArrayList<Integer> list,ArrayList<Integer> tempList,HashMap<Integer,Boolean> used){
        
        if(tempList.size()==list.size())
        {
            System.out.println(tempList);
            return;
        }

        for(int i=0;i<list.size();i++)
        {
            if(used.get(list.get(i)))
            continue;
    
            used.put(list.get(i),true);

            tempList.add(list.get(i));
            backTrack(list, tempList, used);

            tempList.remove(list.get(i));
            used.put(list.get(i), false);

        }

        return;
    }
}
