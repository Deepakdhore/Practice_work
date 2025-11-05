package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        
        
        try {
            System.out.println("server is waitnig");
            ServerSocket ss=new ServerSocket(9806);
            Socket soc=ss.accept();
            System.out.println("connection estalished");

            BufferedReader bf=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str=bf.readLine();

            PrintWriter pw=new PrintWriter(soc.getOutputStream(),true);
            pw.println("Server says ="+str);
            System.out.println("sent the recieved string fomr clint");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
