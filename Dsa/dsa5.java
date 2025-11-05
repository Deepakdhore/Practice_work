import java.util.Scanner;
import java.util.*;
public class dsa5 {
        /*Given the head of a singly linked list, return true if it is a palindrome  or false otherwise.
        Input: head = [1,2,2,1] 
        Output: true 
        Input: head = [1,2]
        Output: false */

    public static class Node {
        int data;
        Node next;
        
    }
    public static void main(String[] args) {
    
        //fill ll
        //get the mid
        //check other half
        Node head=new Node();
        Node node=head;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of linked list");
        int n=sc.nextInt();
        System.out.println("enter the liked list elemnets");
        for(int i=0;i<n;i++)
        {
            node.data=sc.nextInt();
            node.next=new Node();
            node=node.next;
        }
        node=null;

        checkPali(head);
    }

    public static void checkPali(Node head){
        Node node=new Node();
        node=head;

        ArrayList<Integer> list =new ArrayList<>();
        //ArrayList<Integer> rlist =new ArrayList<>(); 
        while (node!=null) {
           // System.out.print(node.data);
            list.add(node.data);
            node=node.next;
        }

        list.remove(list.size()-1);

       

        if(list.equals(list.reversed()))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }


    }
    
}
