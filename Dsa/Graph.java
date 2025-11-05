import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Graph{

    /*There are a total of numCourses courses you have to take, 
    labeled from 0 to numCourses - 1. 
    You are given an array prerequisites where 
    prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], 
    indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses.
     Otherwise, return false.
    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0. So it is possible.
    Example 2:
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible. */


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] arr = { { 1, 0 }, { 0, 2 }, { 2, 1 },{5,6},{6,7},{4,5} };
        
        for (int[] a : arr) {
            System.out.println(a[0] + "" + a[1]);
            map.put(a[0], a[1]);
        }

        HashSet<Integer> path=new HashSet<>();
        Boolean[] list=new Boolean[arr.length];
        for(int i:map.keySet()){
            list[i]=canComplete(i,path,map);
        }

        for(int i:list){
            
        }
    }
    static Boolean canComplete(int i,HashSet<Integer> path, HashMap<Integer, Integer> map){
        if(path.contains(i)){
            System.out.println("cyle found for value "+i);
            return false;
        }
        path.add(i);
        if(map.containsKey(i))
        {
            return canComplete(map.get(i), path, map);
        }
        else{
            return true;
        }
        
        
    }
}