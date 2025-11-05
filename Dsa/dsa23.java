import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.HandlerBase;

public class dsa23 {
    /*
     * Given an array of strings strs, 
     * group the anagrams together. 
     * You can return the answer in any order.
    An Anagram is a word or phrase formed by 
    rearranging the letters of a different word or phrase, 
    typically using all the original letters exactly once.
    Input: strs = ["eat","tea","tan","ate","nat","bat"] Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Input: strs = [""] Output: [[""]]
     */
    public static void main(String[] args) {
        
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        
        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
        int[] index=new int[strs.length];
       
        int sum=0;
        int i=0;
        for (String s : strs) {
            char[] arr=s.toCharArray();
            for (char ch : arr) {
              sum+=((int)ch);
            }
           index[i]=sum;
           i++;
           sum=0;
        }

        int x=0;
        for(int j=0;j<index.length;j++)
        {
           if(map.containsKey(index[j]))
           {
                map.get(index[j]).add(strs[j]);
           }
            
            
        }
        
       for (ArrayList<String> s : map.values()) {
        System.out.println(s);
       }
       
    }
}
