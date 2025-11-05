import java.util.Scanner;

public class dsa3 {
    /*Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.
Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true. */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String[] str1={"ab","c"};
        String[] str2={"a","bc"};

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
       
        for(String s:str1)
        {
            sb1.append(s);
        }

        for(String s1:str2)
        {
            sb2.append(s1);
        }

        if(sb1.toString().equals(sb2.toString()))
        {
            System.out.println("truq they are equal");
        }
        else{
            System.out.println("false");;
        }


    }
}
