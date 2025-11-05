package Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Iter {
    public static void main(String[] args) {
       List<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it= list.iterator();

        // for (Integer integer : list) {
        //     if(integer%2==0)
        //     list.remove(list.indexOf(integer));
        // }

        while(it.hasNext())
        {
            if(it.next()%2==0)
            it.remove();;
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
        

    }
}       
