
package assisgnment1;
import java.util.HashMap;
import java.util.Scanner;
public class Assignment1 {
 public static  HashMap<String,HashMap>data = new HashMap<String,HashMap>();
 public static  HashMap<String,Integer>serials = new HashMap<String,Integer>();
    public static void main( String[] args) {
     StoreGUI.main(args);
 /*data();
   while(true){
if(choices()==0)            
     break;       
   }     
  System.out.println(Items.getAllItems());*/
    }//END MAIN
 public static HashMap DATA(){return data;}
  public static void data() {

Items.addItem("900","iPad Mini       ",125000.0,50);
Items.addItem("901","Fancy Dog Collar",50.0,6);
Items.addItem("902","Smart  OLED     ",45367.0,27);
Items.addItem("903","NIKON D3500     ",61500.0,22);  
Items.addItem("904","DANY Smart TV Device",7000.0,159);
Items.addItem("905","Jabra Elite 75T EarBuds",179000.0,100);
Items.addItem("906","Philips WakeUp Light",18000.0,12);
Items.addItem("907","HP Pocket Photo Printer",20000.0,69);
Items.addItem("908","Samsung T7 Touch SSD",89000.0,50);
Items.addItem("909","Bose Portable Home Spealer",300000.0,66);
Items.addItem("911","SteelSeries Arctics1 Gaming Headset",199999.9,25);
Items.addItem("910","Samsung Galaxy S20 Ultra",197999.9,50);
Customer.newOnCust("1","1234","Mehreen Tahir","mtahir.bscs19seecs","Islamabad, Pakistan");
Customer.newOnCust("2","1234","Zeeshan Ahmad","mahmad.bscs19seecs","Islamabad, Pakistan");
Card.newCard("1","1234","Hina Dutt",999999996699.0);
Card.newCard("2","1234","Hina Dutt",999999996699.0);
Employee.newEmp("2","1234","Zeeshan Ahmad","03046998005","Taxila Museum, Taxila,Pakistan");
Employee.newEmp("3","1234","Hadi Malik","911","Million Dollar House,Islamabad");
Employee.newEmp("1","1234","Dawood Wasif","420","Taj Mahal, Aagra, India");
Employee.newEmp("4","1234","Hina Dutt","773743368","PM House, Islamabad, Pakistan");
Employee.newAdmin("1","1234","Mehreen Tahir The Admin","9000","lahore");
Employee.newAdmin("2","1234","Zeeshan The Admin","9000","lahore");
OnlinePayment.newJazzCash("1","1234","I am JazzCash",999990000.0);
OnlinePayment.newEasyPaisa("1","1234","I am EasyPaisa",99991000.0);
Outlet.newOutlet("111","RawalPindi");
Outlet.newOutlet("222","Islamabad");
Outlet.newOutlet("333","Karachi");
Store online_store = new OnlineStore();
  }
public static int choices(){
    Scanner in=new Scanner(System.in);
  System.out.println("SELECT ONE OF THESE OPTIONS.....................   ");
  System.out.println("enter   1   For Online Shopping,\nenter   2   if you are an employee at checkout point   ");
  System.out.print("enter   3   for Admin privilidges,\nenter       anything else to exit the App  \n");        
    String choice = in.next();
    if(choice.equals("2"))  //CHECOUT MENU
    {    offline();    choices(); }   
    
    //ONINE
    else if (choice.equals("1")) 
    {        online(); choices();  }
    else if (choice.equals("3"))  
    {        admin(); choices();  }
    else {System.out.println("-----------------THANYOU FOR USING OOPMART----------------------------------");}
    return 0;
}
public static void offline(){
     String ID,pass;
     Scanner in=new Scanner(System.in);
      System.out.println("Wecome to Outlet CheckOut");     
   selectOutlet();
   System.out.println("");   
   System.out.println("------YOU WILL NEED TO SIGN IN USING YOUR EMPLOYEE ACCOUNT---- ");
      System.out.print("Enter YOUR LOGIN ID            ");
    ID=in.next();
      System.out.print("Enter Password                 ");
pass=in.next();
     if( Employee.loginE(ID, pass)  ) {      
         System.out.println("Enter 1 to Start Taking Orders,    enter 0 to Logout");
   String   choice = in.next();
      if (choice.equals("1"))  {        New();       }
    else  if(choice.equals("2"))  {        offline();       }
     }
     
     else {
         System.out.println("Wrong Credentials...... Try Again");
         offline();
     }


}
public static void admin(){
     String ID,pass;
     Scanner in=new Scanner(System.in);
      System.out.println("--------------------------Wecome to Administration -------------------");
      System.out.println("------YOU WILL NEED TO SIGN IN ---- ");
      System.out.println("Enter ID or \"exit\" to Leave");
    ID=in.next();
      
if (ID.equals("exit")){}
   else { 
    System.out.println("Enter Password");
pass=in.next();
if( Employee.loginA(ID, pass)  )
        {     
                adminChoices();
        }
     else {
         System.out.println("Wrong Credentials...... Try Again");
         admin();
     }
} 
}
public static void adminChoices(){
    Scanner in=new Scanner(System.in);
       System.out.println("1- addItems, (When youre done) 2-ListAll Items 3- Edit Details 4- to Logout ");
        String   choice = in.next();
        if(choice.equals("1")){    addItem();    adminChoices();     } 
        else if (choice.equals("2")){   
                  Items.listItems();adminChoices();
        }
        else if(choice.equals("3")){   
                  Items.editItems();adminChoices();
        }
        else if(choice.equals("4")){   
                        System.out.println("------------------Logout ScccessFull---------------------------");
                        admin();       }
         else {System.out.println("Wrong Input..... Try Again");    adminChoices();    }
}
public static void online(){
    String ID,pass;
     Scanner in=new Scanner(System.in);
System.out.println("\n--------------------------------YOU WILL NEED TO SIGN IN -----\nEnter    \"EXIT\"    instead to ID to leave, OR Enter    0    to make new account ");
              System.out.printf("Enter your Login ID please     ");
    ID=in.next();
    if ((!ID.equals("EXIT")) && (!ID.equals("exit")) ){
        if (ID.equals("0")){newOn();}
        else{ System.out.printf("Enter Password                  ");
      pass=in.next();
     if( Customer.login(ID, pass)  ){
           System.out.println("Welcome Mr/Ms "+Customer.getName(ID)); 
           onChoice(ID);
     }
     else {
         System.out.println("Wrong Credentials...... Try Again"); online();
     }}
    }
}
public static void New(){
     Scanner in=new Scanner(System.in);
    String ID; int Q;
 System.out.println("\nEnter a unique customer(Not That It Matter because this Code Is kinda Outdated since a GUI was Built upon this) ID (use NIC etc number) or \"EXIT\" to leave");
ID=in.next();
if ((!ID.equals("EXIT")) && (!ID.equals("exit")) ){
    String IDq= Customer.newOffCust();
     makeOrder(IDq);
} 
}
public static void makeOrder(String custID){
    Customer c = Customer.getCust(custID);
System.out.println("ENTER ID of the Item to add it to Cart, 0 to Complete Order, \"list\" to see all items- \"R\" to remove an item");
           Scanner in=new Scanner(System.in);
            String ID; int Q;
            ID = in.next();
         if (!ID.equals("0"))
         {
             if (ID.equals("R"))
             {
                  System.out.println("Input ID of the Item you want to remove...");
               String  rID = in.next();
                 Customer.removeItem(custID,rID);
                 makeOrder(custID);            
             }
             else if (ID.equals("list"))
             {
                  Items.listItems();
                  makeOrder(custID);
             }
             else if (Items.exist(ID))
             {
                 System.out.print("Input Quantiy  ");
                 Q = in.nextInt();
                 if (Q>0){
                  Customer.addItem(custID,ID,Q);
                      makeOrder(custID);}else {System.out.println("quantity cant be zero or less "); makeOrder(custID);}
             }
            else{
                 System.out.println("Invalid ID. Items does Not Exist "); 
                  makeOrder(custID); 
                }           
         }
    else{
             Double t = Customer.getTotal(custID);
          if (!c.isOnline) //true if customer at outlet
              {
                  if (t==0.0) { New(); }
                     else {
                     Customer.getBill(custID);
                          New();
                         }
               }
          else {
              if (t==0.0) {System.out.println("No Items added................");}
              else {Customer.getBill(custID);}
                }
         }
}
public static void onChoice(String ID){
     Scanner in=new Scanner(System.in);
    System.out.println("ENTER   1   to  Add Items to the Cart , 2- Logout");
    int choice = in.nextInt();
    if(choice==1) //CHECOUT MENU
    {
     makeOrder(ID); onChoice(ID);
     }
    else if (choice==2){
         System.out.println("Logout Sucess......................");
        online();
    }
  
}
public static void addItem(){
     System.out.println("............ENTER ID of the Item------0 to Complete.................");
           Scanner in=new Scanner(System.in);
            String ID; 
            ID = in.nextLine();
         if (!ID.equals("0"))
         {
       try{   System.out.printf("ENTER Name of the Item     ");
         String  name=in.nextLine();
            System.out.printf("ENTER Price of the Item    ");
         String  p=in.next(); 
         Double price=Double.parseDouble(p);
           if (price>0.0){
            System.out.printf("ENTER Quantity of the Item   ");
          Integer quantity=in.nextInt();
           Items.addItem(ID,name,price,quantity);
           System.out.println("----------------Item Added--------------------------");
           }
           else {
               System.out.println("-----NO NO NO BOY.NEGATIVE PRICE HAH??? WE DONT DO THAT HERE......");
              }
       }
       catch(Exception e){ System.out.println("LOOKS LIKE YOU ENTERED SOMETHING WRONG..... TRY AGAIN");}
           
             
       
           addItem();
         }
            
}
public static void selectOutlet(){ 
     Scanner in=new Scanner(System.in);
    System.out.println("Select an Outlet/Branch that you work in currently (enter its ID)...");
     Outlet.listOutlets();
     String thisOut=in.next();
    if( Outlet.currentOutlet(thisOut)){} else {selectOutlet();}}
public static void newOn(){
     Scanner in=new Scanner(System.in);
System.out.println("\nwelcome to new customer registration");
System.out.printf("enter id              ");
String id = in.next();
if (!Customer.exist(id)){ if ((!id.equals("exit"))&&(!id.equals("0"))){
System.out.printf("enter password        ");
String p = in.next();p = in.next();  
System.out.printf("enter name            ");
String n = in.nextLine();n = in.next(); 
System.out.printf("enter email           ");
String e = in.next(); e = in.next();
System.out.printf("enter address         ");
String a = in.next(); a = in.next();
Customer.newOnCust(id,p,n,e,a);
System.out.println("\n    ------------------------------ADDED-------------------------");
online();}else{System.out.println("\n -------------------------------------------exit and 0 are reserved so can not be used         ");
 online();}
}
else //if customer id is already stored then
{
System.out.println("\n ------------------User ID already exists. Try using a more unique ID\n");
newOn();
}
}
} //END OF CASS
