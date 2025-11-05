package exception_handling;

import java.util.Scanner;

public class Bank {
    static int balance = 5000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Welecome to the bank-----\n  Enter the value to withdraw\n");

        int money = sc.nextInt();

        withdraw(money);
    }

    public static void withdraw(int money)
    {
        try {
            if(money<balance)
            throw new insuficcientMoney();
            
        } catch(insuficcientMoney e) {
            System.out.println(e.getMessage());
        }
    }

}
