import java.util.HashMap;
import java.util.HashSet;

public class dsa18 {
    /*
    Given a string s, 
    find the length of the longest substring without repeating characters.
    Input: s = "abcabcbb" 
    Output: 3 

    */

    public static void main(String[] args) {
        HashMap<Character,Integer> map=new HashMap<>();
        String s="abcabcdb";
        int max=0;
        int currmax=0;
        for (char ch: s.toCharArray()) {
            if(map.containsKey(ch)){
                //System.out.println("repeating is "+ch);
                max=Math.max(currmax, max);
                currmax=1;
                map.clear();
                map.put(ch, 1);
            }
            else{
                map.put(ch, 1);
                currmax++;
                //System.out.println("count incresed by "+currmax );
            }

        }

        System.out.println("the max subarry is = "+max);
    }
    
}
