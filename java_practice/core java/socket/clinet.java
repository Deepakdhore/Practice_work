package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clinet {
    public static void main(String[] args) {
        
        try {
            System.out.println("clinet started");
            Socket soc=new Socket("localhost",9806);
            
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
           
            System.out.println("Enter a string");
            String input=bf.readLine();
           
            PrintWriter pw=new PrintWriter(soc.getOutputStream(),true); 
            pw.println(input);

            BufferedReader inbf=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(inbf.readLine());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
