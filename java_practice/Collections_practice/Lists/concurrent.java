package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class concurrent {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        
        for (Integer i : list) {
            if(i%2==0)
            list.add(list.indexOf(i), 0);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }
    
}
