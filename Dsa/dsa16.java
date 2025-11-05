import java.util.ArrayList;
import java.util.HashMap;

public class dsa16 {
    /*you are given a list of time intervals, 
    where each interval represents a scheduled meeting. 
    Each interval [start, end] denotes a meeting that starts at start time and ends at end time. 
    All times are non-negative integers.

    Your task is to determine if a person can attend all meetings given these intervals. 
    A person cannot attend two meetings if they overlap.
    Input:
    An array (or List) of Interval objects. Each Interval object has two properties: start and end. 
    Example: intervals = [[0, 30], [5, 10], [15, 20]]
    Output:
    Return true if the person can attend all meetings, false otherwise. */
    //Input: intervals = [[7, 10], [2, 4]] Output: true Explanation: Meeting [7, 10] and [2, 4] do not overlap
    public static void main(String[] args) {
        int[][] intervals={{7, 10}, {2, 4}};

        //start form small starting hrss
        //if the end hrs is a key/ stat point then go to it/
        //next if no start hrs found then go to next key or start pont

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int[] i : intervals) {
            map.put(i[0],i[1]);
        }
        ArrayList<Integer> list=new ArrayList<>();
        int endhrs=0;
        for(int start:map.keySet())
        {
            endhrs=map.get(start);

            if(map.containsKey(map.get(start))&&!list.contains(start))
            {
                int temp=start;
                list.add(temp);
                while(map.containsKey(map.get(temp))){
                    
                    temp=map.get(temp);
                    list.add(temp);
                }

            }else{
                list.add(start);
            }



        }

        int maxHrs=0;
        int count=0;
        for(int j:list){
            if(map.get(j)>maxHrs)
            {
                System.out.println(j+"-"+map.get(j)+" -> ");
                maxHrs=map.get(j);
                count++;
            }
        }
        if(count==intervals.length)
        {
            System.out.println("True\nTotal of "+count+" can be attended");
        }
        else
        {
          System.out.println("false\nTotal of "+count+" can be attended");
        }
    }
}
