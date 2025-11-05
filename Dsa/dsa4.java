import java.util.Scanner;

public class dsa4 {
    /*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5. */


 public static void main(String[] args) {
    //if divisible not by 2|3|5
    //
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the nth number");
    
    int n =sc.nextInt();
    if(n<=1)
    {
        System.out.println(1);
    }
    else{
        int count=2;
    int i=2;
    System.out.println(1);
    while(count<=n)
    {
        if(i%2==0 || i%3==0 || i%5==0 )
        {
            count++;
            System.out.println(i);
        }
        

        i++;
    }
    }
    
 }
}
