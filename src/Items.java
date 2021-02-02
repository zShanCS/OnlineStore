package assisgnment1;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//holds all items data 
public class Items implements Serializable{
  private  String ID;
    private String Name;
    private Double Price;
    private Integer Quantity;
    public static HashMap<String,Items> allItems = new HashMap<String,Items>();
 public Items(String id,String n ,Double p, Integer q){
ID=id;Name=n;Price=p;Quantity=q;
 }
 
   public static void listItems(){
       System.out.printf("ID        Name           Price       Quantity\n");
for(Map.Entry m: getAllItems().entrySet() ){
    String id = m.getKey().toString();
    Items item = getAllItems().get(id);
    System.out.printf("%s    %s           %.1f       %d \n",id,item.getName(),item.getPrice(),item.getQuantity());
    
}
   }
    public static void editItems() {
Scanner in = new Scanner(System.in);
System.out.println("Enter ID of item you wanna change or 0 to leave");
String id = in.next();
if (!id.equals("0")){
if (Items.exist(id)) { editChoice(id); }
else {System.out.println("Wrong Input........... ");}
 }
 }
public static void editChoice(String id){
     Items i = allItems.get(id);
     Scanner in = new Scanner(System.in);
    System.out.println("1- Edit Name, 2-Edit Price, 3- Edit Qantity");
String choice = in.next();
if (choice.equals("1")){
    System.out.println("Enter New Name");String name = in.next(); i.setName(name);editItems();}
else if (choice.equals("2")){
    System.out.println("Enter New Price");
    Double price = in.nextDouble(); 
    if (price>0.0){
    i.setPrice(price);editItems();}
    else{
               System.out.println("-----NO NO NO BOY.NEGATIVE PRICE HAH??? WE DONT DO THAT HERE......");
              editItems(); }
}
else if (choice.equals("4")){
    System.out.println("Enter New Quantity");Integer Q = in.nextInt(); i.setQuantity(Q);editItems();}
else {    System.out.println("Invalid Choice");  editChoice(id); }
}
    
 public static void addItem(String i,String n,Double p,Integer q) {
     Items x = new Items(i,n,p,q);
        getAllItems().put(i,x);
 }
 public static Items getItm(String id){
     Items i = getAllItems().get(id);
     return i;
 }
 public static boolean Qallowed(String id,Integer Q){
     Items i = getAllItems().get(id);
      if ( (Q>0) && (i.getQuantity()>=Q)) {return true;}
     return false;
 }
  public static void Qbought(String id,Integer Q){
     Items i = getAllItems().get(id);
    i.Quantity-=Q;
     
 }
 public static String getName(String id){
     Items i = getAllItems().get(id);
     return i.getName();
 }
  public static Integer getQuantity(String id){
     Items i = getAllItems().get(id);
     return i.getQuantity();
 }
 public static Double getPrice(String id){
     Items i = getAllItems().get(id);
     return i.getPrice();
 }
 public static void setQuantity(String id,Integer newQ){
     Items i = getAllItems().get(id);
     i.setQuantity(newQ);
 }
  public static void delete(String id){
     getAllItems().remove(id);
 }
 public static boolean exist(String id){
  return getAllItems().containsKey(id);  
 }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public static HashMap<String,Items> getAllItems() {
        return allItems;
    }

    public static void setAllItems(HashMap<String,Items> aAllItems) {
        allItems = aAllItems;
    }
}
