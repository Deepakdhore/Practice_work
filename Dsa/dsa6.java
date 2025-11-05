import java.util.LinkedList;
import java.util.Scanner;

import org.w3c.dom.NodeList;

public class dsa6 {
    /* Given the head of a sorted linked list,
     delete all nodes that have duplicate numbers,
      leaving only distinct numbers from the original list.
       Return the linked list sorted as well.  
    Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5]*/
    
    public static class Node {
        int data;
        Node next;
    }
    public static void main(String[] args) {
       //LinkedList<Integer> list=new LinkedList<>();
       Scanner sc =new Scanner(System.in);
       System.out.println("enter the no of elements");
       int n=sc.nextInt();
       System.out.println("enter the list elements");
       Node head=new Node();
       Node temp=head;
       for(int i=0;i<n;i++)
       {
            temp.data=sc.nextInt();
            temp.next=new Node();
            temp=temp.next;
       } 
       temp=null;

       Node res=removeDuplicates(head);
       System.out.println();
       while(res!=null)
       {
        System.out.print(res.data);
        res=res.next;
       }
    
    }

    public static Node removeDuplicates(Node head)
    {
       Node temp1=head;
       Node temp2=head.next;

       while(temp2!=null) {
         if(temp1.data==temp2.data)
         {
            if(temp2.next!=null &&temp2.data!=temp2.next.data)
            {
               temp1
            }
         }
       }
    }
}
