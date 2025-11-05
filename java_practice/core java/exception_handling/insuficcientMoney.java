package exception_handling;

public class insuficcientMoney extends Exception{
    // public insuficcientMoney(String msg)
    // { 
    //     super(msg);  
    // }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Low Balance";
    }
}