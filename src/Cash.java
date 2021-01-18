
package assisgnment1;

import java.util.Scanner;

public class Cash extends Payment{
     private Double Total;
     private Double Paid;
   private Double ReturnAble;
    
    public Cash(Double p,Double toP){
        Paid=p;
        Total=toP;
    }

    public static boolean Pay(Double toPay){
           Scanner in=new Scanner(System.in);
    
System.out.println("enter Paid amount;  ");
try{Double paid=in.nextDouble();
 

   Cash c = new Cash(paid,toPay); 
        if (paid>=toPay){
        System.out.println("\nCashPayment Cleared via Cash........ ");
        c.setReturnAble((Double) c.getPaid() - c.getTotal());
    System.out.println("Please return  "+c.getReturnAble());
    c.Status="Cleared";
return true;
        }
        else{
             System.out.println("\nCashPayment NOT Cleared........Amount paid is less then due ");
        c.Status="Amount less then due";
        }
}
catch(Exception e){
 System.out.println("something might be wrong with your input. Dont do it again. I might crash. kidding. I wont.");}
        return false;
    } 
  
    @Override
    public void getPaymentDetails(){
        
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public Double getPaid() {
        return Paid;
    }

    public void setPaid(Double Paid) {
        this.Paid = Paid;
    }

    public Double getReturnAble() {
        return ReturnAble;
    }

    public void setReturnAble(Double ReturnAble) {
        this.ReturnAble = ReturnAble;
    }
}
