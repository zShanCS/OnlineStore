//class for online payments records and data


package assisgnment1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
public class OnlinePayment extends Payment implements Serializable{
   
 private  final String  MediumUsed;   //JazzCash or EasyPaisa etc 
private   final String   AccNum;
 private   final String   Name;
private final  String Pin; 
    private Double Balance;

   public static HashMap<String,OnlinePayment> JazzCash = new HashMap<String,OnlinePayment>();
   public static HashMap<String,OnlinePayment> EasyPaisa = new HashMap<String,OnlinePayment>();

  // a few Online MicroFinancings were initialized for testing and demonstration in our test class under method DATA()    
   public OnlinePayment(String acc,String pin,String name,Double balance,String mdm){
        AccNum=acc;Pin=pin;Name=name;Balance=balance;MediumUsed=mdm;
    }
   
    public static void newJazzCash(String num,String pin,String name,Double balance){
     OnlinePayment c = new  OnlinePayment(num, pin, name,balance,"JazzCash");
      JazzCash.put(num,c);
    }
    public static void newEasyPaisa(String num,String pin,String name,Double balance){
     OnlinePayment c = new  OnlinePayment(num, pin, name,balance,"EasyPaisa");
      EasyPaisa.put(num,c);
    }
    public static boolean validateJ(String num,String pin){
        if (JazzCash.containsKey(num)){
       OnlinePayment c = JazzCash.get(num);
       return pin.equals(c.Pin);
        }
        return false;
    }
       public static boolean validateE(String num,String pin){
        if (EasyPaisa.containsKey(num)){
       OnlinePayment c = EasyPaisa.get(num);
       return pin.equals(c.Pin);
        }
        return false;
    }
     public static Double getBalanceJ(String num){
       OnlinePayment c = JazzCash.get(num);
       return c.Balance;
    }
      public static Double getBalanceE(String num){
       OnlinePayment c = EasyPaisa.get(num);
       return c.Balance;
    }
       public static void updateBalanceJ(String num,Double charged){
       OnlinePayment c = JazzCash.get(num);
       c.Balance-=charged;
    } 
        public static void updateBalanceE(String num,Double charged){
       OnlinePayment c = EasyPaisa.get(num);
       c.Balance-=charged;
    }  
     public static void setStatusJ(String num,String s){
       OnlinePayment c = JazzCash.get(num);
       c.Status=s;
    } 
     public static void setStatusE(String num,String s){
       OnlinePayment c = EasyPaisa.get(num);
       c.Status=s;
    } 
     public static String getStatusJ(String num){
       OnlinePayment c = JazzCash.get(num);
      return c.Status;
    } 
      public static String getStatusE(String num){
       OnlinePayment c = EasyPaisa.get(num);
      return c.Status;
    } 
    public static boolean Pay(Double toPay){
         Scanner in=new Scanner(System.in); 
         System.out.print("\nENTER 1-JazzCash, 2-EasyPaisa   ");
         int method = in.nextInt();
         if (method==1){ if(PayJ(toPay))return true;}
         else if (method==2){ if(PayE(toPay))return true;}
         else {System.out.print("Inavlid Input..........  ");}
        return false;
    } 
    @Override
    public void getPaymentDetails(){
        
    }
    public static boolean PayJ(Double toPay){
        Scanner in=new Scanner(System.in); 
          System.out.print("\nPLEASE ENTER THE JAZZCASH ACC NUMBER   ");
         String num=in.next();
         System.out.print("ENTER PIN           ");
        String pin =in.next();
          if (validateJ(num,pin)){
              Double currentBalance = getBalanceJ(num);
            if (currentBalance>=toPay){
                updateBalanceJ(num,toPay);
                
                setStatusJ(num,"Cleared");
                System.out.println("\n.............PayMent Status  =  "+getStatusJ(num)+" VIA jAZZcASH");
                  System.out.println("Remaining Balance;   "+getBalanceJ(num)+"\n");
return true;
            } 
            else {
                 setStatusJ(num,"Balance Not Enough");
                System.out.println("Failure.... ");
                 System.out.println(".............PayMent Status  =  "+getStatusJ(num));
                 return false;
            }
          }
          else {
               System.out.println("......................Wrong Credentials....................... ");
               Pay(toPay);
          }
          return false;
    }
     public static boolean PayE(Double toPay){
        Scanner in=new Scanner(System.in); 
   System.out.printf("\nPLEASE ENTER THE EASYPAISA ACC NUMBER   ");
   String num=in.next();
   System.out.printf("ENTER PIN                                 ");
        String pin =in.next();
          if (validateE(num,pin)){
              Double currentBalance = getBalanceE(num);
            if (currentBalance>=toPay){
                updateBalanceE(num,toPay);
                setStatusE(num,"Cleared");
                System.out.println("\n.............PayMent Status  =  "+getStatusE(num));
                  System.out.println("Remaining Balance;   "+getBalanceE(num)+"\n");
return true;
            } 
            else {
                 setStatusE(num,"Balance Not Enough");
                System.out.println("Failure.... ");
                 System.out.println(".............PayMent Status  =  "+getStatusE(num)+" VIA EASYPAISA.");
                 return false;
            }
          }
          else {
               System.out.println("......................Wrong Credentials....................... ");
               Pay(toPay);
          }
          return false;
    }
}
