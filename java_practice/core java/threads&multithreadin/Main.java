import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main{
    /**
     * @param args
     */


     static class countter{
        static int count=0;
       // ReentrantLock
        public static synchronized void count(){
            
            for(int i=0;i<10000;i++)
            count++;
        }
     }
    public static void main(String[] args) {
       //int count;
      
    //   A objA= new A(){
    //     public void run(){
    //         System.out.println("thread of class a running");
    //     }
    //   };

    //   B objB=new B(){
    //     public void run(){
    //         System.out.println("thread of class b runnnig");
    //     }
    //   };

    //   C objC=new C(){
    //     public void run(){
    //         System.out.println("therad of class c runnnig");
    //     }
    //   };
    //   try {
            
    //         objB.start();
    //         objB.join();  

    //         objA.start();
    //         objA.join();  // Wait for A to finish

    //         objC.start();
    //         objC.join();  // Wait for C to finish
        
    //   } catch (Exception e) {
    //     // TODO: handle exception

    //     System.out.println(e+"an Excetions occured My lord pls check it once");
    //   }

       Runnable r1=()->{
           countter.count();
           System.out.println("thread t1 running count= "+countter.count);
       };
        Runnable r2=()->{
            countter.count();;
            System.out.println("thread t2 running count= "+countter.count);
       };
        Runnable r3=()->{
            countter.count();
            System.out.println("thread t3 running count= "+countter.count);
       };

       Thread t1=new Thread(r1);
       Thread t2=new Thread(r2);
       Thread t3=new Thread(r3);
       Thread t4=new Thread(new Runnable() {
            public void run(){
                countter.count();
                System.out.println("thread t4 runnning count= "+countter.count);
            }
       });
       try{
            t1.start();
            //t1.join();
            //Thread.sleep(1000);
            
            t2.start();
            //t2.join();
            //Thread.sleep(1000);
            
            t3.start();
            //t3.join();
            //Thread.sleep(1000);

            t4.start();
            Thread.sleep(1000);
       }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
       catch(Exception e)
        {
                System.out.println(e);  
        }
       
       
       //Thread.yield();

    }
}