import java.util.ArrayList;
import java.util.HashMap;

public class dsa15 {
    /*
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi]
     * indicates that you must take course bi first if you want to take course ai.
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * Example 1:
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0,
     * and to take course 0 you should also have finished course 1. So it is
     * impossible.
     */

    public static void main(String[] args) {
        // add to hashMap
        // Check each keys;
        // check if a key is a value;
        // if a key is a value check its value and repeate step 3 until not a key,
        // else store
        // return all stored keys;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] arr = { {1,0} };

        for (int[] a : arr) {
            System.out.println(a[0] + "" + a[1]);
            map.put(a[0], a[1]);
        }


        int value = 500;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        
        for (int i : list.reversed()) {
            System.out.print(i + " ");
        }

        System.err.println();

        ArrayList<Integer> seenList = new ArrayList<>();

        ArrayList<Integer> canBeCompleted=new ArrayList<>();


        for (int i : list) {
            System.out.println(i);
            value = i;
            if (map.containsKey(value)) {
                while (map.containsKey(value)) {

                    seenList.add(value);
                     //System.out.println("we are checking " + value );
                     //System.out.println("the value of " + value + " is " + map.get(value));
                    value = map.get(value);
                    if(canBeCompleted.contains(value))
                    {
                        System.out.println("the course "+i+" can beb");
                        break;
                    }
                    if (seenList.contains(value)) {
                        System.out.println("the course "+i+" Cannot be possible since " + value + " is present");
                        seenList.clear();
                        break;
                    }
                    if(map.get(value)==null)
                    {
                        System.out.println("the Course "+i+" can be completed as");
                        canBeCompleted.add(i);
                          for (int j : seenList) {
                            System.out.print(j + "->");
                          }
                          System.out.println(value);
                          seenList.clear();
                        break;
                    }
                }
            }

        }

      
    }
}
