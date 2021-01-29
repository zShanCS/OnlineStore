//this deals with all features of card.
//this stores an offline set of card info and uses that for payment

package assisgnment1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;


public class Card extends Payment implements Serializable{
    private  final String AccNum;
  private  final  String Pin;
  private Double Balance;
  private  final  String AccHolderName;
     public static HashMap<String,Card> allCards = new HashMap<String,Card>();
  // a few cards were initialized for testing and demonstration in our test class under method DATA()  
    

    
    public Card(String num,String pin,String name,Double balance){
        AccNum=num;Pin=pin;AccHolderName=name;Balance=balance;
    }
    public static void newCard(String num,String pin,String name,Double balance){
      Card c = new  Card(num, pin, name,balance);
      allCards.put(num,c);
    }
    public static boolean validate(String num,String pin){
        if (allCards.containsKey(num)){
       Card c = allCards.get(num);
       return pin.equals(c.Pin);
        }
        return false;
    }
     public static Double getBalance(String num){
       Card c = allCards.get(num);
       return c.Balance;
    }
       public static void updateBalance(String num,Double charged){
       Card c = allCards.get(num);
       c.Balance-=charged;
    }  
     public static void setStatus(String num,String s){
       Card c = allCards.get(num);
       c.Status=s;
    } 
     public static String getStatus(String num){
       Card c = allCards.get(num);
      return c.Status;
    } 
    public static boolean Pay(Double toPay){  
         Scanner in=new Scanner(System.in); 
         System.out.print("PLEASE ENTER THE CREDIT CARD NUMBER   ");
         String num=in.next();
         System.out.print("ENTER PIN                            ");
        String pin =in.next();
          if (validate(num,pin)){
              Double currentBalance = getBalance(num);
            if (currentBalance>=toPay){
                updateBalance(num,toPay);
                
                setStatus(num,"Cleared");
                System.out.println("\n.............PayMent Status  =  "+getStatus(num)+" via Card");
                System.out.println("\n-------------Remaining Balance; "+getBalance(num)+"\n");

                return true;

            } 
            else {
                 setStatus(num,"Balance Not Enough");
                System.out.println("..................................Failure.... ");
                 System.out.println(".............PayMent Status  =  "+getStatus(num)); 
                 return false;
            }
          }
          else {
               System.out.println("......................Wrong Credentials....................... ");
               
          }
          return false;
    } 
    
    @Override
    public void getPaymentDetails(){        
    }
}
