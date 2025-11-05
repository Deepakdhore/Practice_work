package exception_handling;

import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        System.out.println("lets do exception Handling");
        try {
            int sum=10/0;
            System.out.println(sum);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("exception occured = "+e);
            e.printStackTrace();

        }
    }
}
