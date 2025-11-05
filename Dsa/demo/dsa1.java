package demo;
import java.util.*;
/*A sandwich is two pieces of bread with something in between. Return the

string that is between the first and last appearance of "bread" in the given

string, or return the empty string " " if there are not two pieces of bread.

Ex: sandwich("breadjambread") → "jam" sandwich("xxbreadyy") → " " */
public class dsa1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the sandwich string");
        String test=sc.nextLine(); 
        //String test="breadjambreadjambread";
        breadjambred(test);
        //System.out.println(res);
    }

    static void breadjambred(String test)
    {
        String[] sarr=test.split("bread");
        //if startswith bread and ends with bread
        if(test.startsWith("bread") && test.endsWith("bread"))
        {
            for(String s: sarr)
            {
                System.out.println(s);
            }
        }
        if(test.startsWith("bread") && !test.endsWith("bread"))
        {
            for(int i=0;i<sarr.length-1;i++)
            {
                System.out.println(sarr[i]);
            }
        }
        if(!test.startsWith("bread") && test.endsWith("bread"))
        {
            for(int i=1;i<sarr.length;i++)
            {
                System.out.println(sarr[i]);
            }
        }

     
    }
            
}
