import java.util.Scanner;
import java.util.*;

public class dsa2 {

    static ArrayList<ArrayList<Integer>> lists =new ArrayList<>();
    public static void main(String[] args) {
        /*Given a number num, check if any permutation of its digits forms a prime number whose sum of digits is also a prime.
         If such a number exists, return it; otherwise, return 0.
Example:
Input: 431
Possible Prime Permutations: 431, 413, 341
Digit Sums:
431 → 4+3+1 = 8 (not prime)
413 → 4+1+3 = 8 (not prime)
341 → 3+4+1 = 8 (not prime)
Output: 0 (No valid prime permutation with a prime digit sum) */


        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number");
        int num=sc.nextInt();
        int single=0;
        ArrayList<Integer> list =new ArrayList<>();
        while(num!=0)
        {
            single=num%10;
            if(isPrime(single))
            list.add(single);
            num=num/10;
        }
        int sum=0;
        System.out.println("total prime nubers are ");
        for(int i:list)
        {
            System.out.print(i+" ");
            sum=sum+i;
        }

        if(isPrime(sum))
        System.out.println("\nSUM is also prime="+sum);
        else
        System.out.println("\nSum is not prime="+sum);
        


    }

    public static Boolean isPrime(int n)
    {
        if(n<=2)
        return true;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            return false;
        }
        
        return true;
    }
    /*431256
     * 0+4 0+3 0+1 0+2 0+5 0+6
     *  4+3
     * 
     */
    
    public void permutations(ArrayList<Integer> list,int sum,ArrayList<Integer> currList) 
    {
      
        for(int i=0;i<list.size();i++)
        {
            sum=sum+list.get(i);
            currList.add(list.get(i));
            
            if(isPrime(sum))
            lists.add(currList);
            
            
            permutations(list, sum, currList)
        } 

        return;
    }

    //recursion permutation
    






    public int ifSumPrime(ArrayList<Integer> list)
    {
        Collections.sort(list);
        int sum=0;
        for(int i:list)
        {
            sum+=i;
        }

        for(int i=0;i<list.size();i++)
        {
            if(isPrime(sum))
            {
                System.out.println(sum+" is prime");
                    for (int j : list) 
                    {
                        System.out.println(j);
                    }
                    break;
            
            }
            else
            sum-=list.get(i);

        }
        

        return sum;
    }

    
}
