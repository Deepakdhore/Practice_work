package Lists.itrable.comperable;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Cricketer> players= Arrays.asList(
        new Cricketer(1,"Virat Kholi",215),
        new Cricketer(2,"khel rahul",300),
        new Cricketer(3,"Shubh_Mangil",200),
        new Cricketer(4,"Rahul Dravid",220),
        new Cricketer(5,"Anna mallai",250),
        new Cricketer(6,"MS Dhoni",150),
        new Cricketer(7,"James",155),
        new Cricketer(8,"Tony Stark",0),
        new Cricketer(9,"Monkey D Luffy ",100),
        new Cricketer(10,"Uzumanki Naruto",251)
        );
        
        Collections.sort(players);

       for (Cricketer cricketer : players) {
        System.out.println(cricketer.toString());
        Comparator
       }
    }
    
}
