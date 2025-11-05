package demo;

import java.util.ArrayList;

public class Demo{
    public static void main(String[] args)
    {
        System.out.println("hello world");
        int[] arr={1,2,3,4,5};
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr)
        {
            list.add(i);
            System.out.println(i);
        }
        
        for (int i : list) {
            System.out.println(i);
        }
    }
}

