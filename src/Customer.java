//handle all activites related to customer and saving thier data
package assisgnment1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.Serializable;

public class Customer implements Serializable{
private String ID,Name,Email,Address;
private String pass;
boolean isOnline=false;
String store;
Order o;
public static HashMap<String,Customer>allCustomer = new HashMap<String,Customer>();

 HashMap<Integer,Receipt>myReceipts = new HashMap<Integer,Receipt>();

 public Customer(String id){
    ID=id;
}
  public String getName() {
        return Name;
    }
    public String getEmail() {
        return Email;
    }
 public String getAddress() { return Address;   }
 public String getPass() {
        return pass;
    }
 public boolean isOnline() {
        return isOnline;
    }
public static HashMap<String,Customer> getAllCustomer() {
        return allCustomer;
    }
 public static String newOffCust(){
    int c;String ID;
    for (c=0;true;c++){
          ID = Integer.toString(c);
         if (!Customer.exist(ID)){break;}
 }
 Customer cust = new Customer(ID);
        getAllCustomer().put(ID,cust);
 cust.o=Order.newOrder();
 return ID;
 }
  public static void newOnCust(String ID,String p,String name,String email,String add){
Customer cust = new Customer(ID);
cust.isOnline=true;
cust.pass=p;cust.Name=name;cust.Email=email;cust.Address=add;
getAllCustomer().put(ID,cust);
 cust.o=Order.newOrder();
 cust.o.setShipTo(cust.getAddress());
 }
 public static boolean login(String id,String p){
       if (getAllCustomer().containsKey(id)){
       Customer c = getAllCustomer().get(id);
       if (c.isOnline){
       return p.equals(c.getPass());
        }}
        return false;
 }
public static void addItem(String custID, String iID,Integer iQ){
    if (Items.Qallowed(iID, iQ)){
    Customer c = getAllCustomer().get(custID);
    if (iQ!=0){
    c.o.addNewItem(iID,iQ);
     }}
    else {System.out.println("Out of Stock.........");}
}
public static void removeItem(String custID, String iID){
    
    Customer c = getAllCustomer().get(custID);
    c.o.removeOrder(iID);
 //   System.out.println(".........Item removed from the Order List..............");
    }
public static Double getTotal(String custID){
    
    Customer c = getAllCustomer().get(custID);
    return c.getTotal();
}
public static void getBill(String custID){

Customer c = getAllCustomer().get(custID);  
System.out.println("\n---------------------------------------------RECIET---------------------------------------------------------\n");
 System.out.println("---------------------------------CUSTOMER ID --- "+  c.ID+"    -----------------------------------------------");
 System.out.println("                   Item ID   \t Name  \t\t\t Item Price    \t      Quantity\t\t Total Price\n");
 HashMap<String,Integer>item=c.o.getOrderDetail();
  for (Map.Entry m: item.entrySet()){
  String iID= m.getKey().toString();
 String y = m.getValue().toString();
  int Q=Integer.parseInt(y);

   Items itm=Items.getItm(iID);
System.out.println("                   "+iID+" \t \t " +itm.getName(iID)+ "\t\t "+itm.getPrice(iID)+"   \t     " +Q+"\t\t"+(itm.getPrice(iID)*Q));
  } 
  System.out.println("\n\t\tTOTAL Items:  "+c.o.getNum()+"              QUANTITY OF ITEMS  "+c.o.getQuantity());
  System.out.println("\t\t-------------------------       TOTAL:"+c.getTotal()+"        ------------------------\n");
  Pay(custID, c.getTotal());
  if (c.o.getTotal()==0){getAllDetails(c);}
  
  
}
public static void  getAllDetails(Customer c){

if (c.isOnline){
    System.out.println("\t\tCustomer Name; "+c.getName());
   System.out.println("\t\tCustomer Email; "+c.getEmail());
    
    System.out.printf("\nThe items you bought will be Shipped to %s \n\n Thank you.\n\n",c.getAddress());
    OnlineStore.getStoreDetails();
}

else {System.out.printf("--You have shopped at Store ID;  %s \n", Outlet.getCurrentBranch());Outlet.getStoreDetails(Outlet.getCurrentBranch());}
System.out.println("\n--------------------------------------------------------------------------------------------------------- ");
}
public static void Pay(String custID,Double pay){
    Scanner in=new Scanner(System.in);
    Customer c = getAllCustomer().get(custID);  
    System.out.println("\n----------------------------PLEASE CHOOSE A PAYMENT METHOD---------------------------- ");
    if (!c.isOnline()) //if cstomer is at outlet then getType is true
    {System.out.println("ENTER 1- use card , 2- Online, 3-Cash");}
    else {System.out.println("ENTER 1- use card , 2- Online");}
    String choice = in.next();
    if (choice.equals("1"))
    {
        if ( !Card.Pay(c.o.Total) ){  
            Pay(custID,pay);  
        } else {
            Receipt r = Receipt.makeReceipt(c.o);
        c.myReceipts.put(r.getID(),r);
        c.o.clear();
        c.o.Total=0.0;}
    }
    else  if (choice.equals("2"))
    {
         if ( !OnlinePayment.Pay(c.o.Total) ){  
            Pay(custID,pay);  
        }  else { Receipt r = Receipt.makeReceipt(c.o);
        c.myReceipts.put(r.getID(),r);
        c.o.clear();
        c.o.Total=0.0;}
    }
    else if (choice.equals("3"))
    {
         if (!c.isOnline){
       if ( !Cash.Pay(c.o.Total) ){  
            Pay(custID,pay);  
        }
       else { Receipt r = Receipt.makeReceipt(c.o);
        c.myReceipts.put(r.getID(),r);
        c.o.clear();
        c.o.Total=0.0;}
         }
         else { System.out.println("Invalid Choice"); Pay(custID,pay);}
    }
    else {
            System.out.println("Invalid Choice"); Pay(custID,pay);
    }
    
}
public static Customer getCust(String custID){ return getAllCustomer().get(custID);}
 public static boolean exist(String id){ return getAllCustomer().containsKey(id);  }
    public Double getTotal() {       return o.getTotal();   }
     public void clearTotal() {  this.o.Total=0.0;   }
   public static String getName(String id) {
            Customer e = allCustomer.get(id);      return e.Name;
    }
   public static String getAddress(String id) {
            Customer e = allCustomer.get(id);      return e.Address;
    }
   public static String getEmail(String id) {
            Customer e = allCustomer.get(id);      return e.Email;
    }
    public static void delete(String id) {
            allCustomer.remove(id);      
    }
}//end customer
