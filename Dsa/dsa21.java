public class dsa21 {
    /*
     * Given a signed 32-bit integer x,
     *  return x with its digits reversed. 
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], 
     * then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    Example 1:

    Input: x = 123
    Output: 321
    
    Example 2:
    Input: x = -123
    Output: -321
    
    Example 3:
    Input: x = 120
    Output: 21
     */
    public static void main(String[] args) {
        int input=321;
        System.out.println(find_reverse(input));
        
    }

    public static int find_reverse(int input){
        int temp=0;
        int rev=0;
        int x=10;
        int flag=0;
        if(input<-231||input>231-1)
        {
            System.out.println(" limit exceeded ");
            return 0;
        }
        if(input<0)
        {
            input*=-1;
            flag=1;
        }
        while(input>0)
        {
            temp=input%10;
            rev=rev*x+temp;
            input=input/10;

        }
        if (flag==1) {
            //System.out.println(rev*-1);
            return rev*-1;
        }
        else
        {
            return rev;
        }
       // System.out.println(rev);
    }
}
