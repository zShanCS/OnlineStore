
package assisgnment1;
import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable{
    public static Integer serial=0;
    protected Integer orderID;
    OrderDetails od;
    protected Double Total;
    protected String method;
    protected String dateTime;
    protected String ShipTo="-";  
    private String Store;   
    public Order(){
    this.orderID=++serial;
      Total = 0.0;
    }
public static Order newOrder(){
    Order o = new Order();
OrderDetails ods= new OrderDetails();
Assignment1.serials.put("Order",serial);
    o.od=ods;
    return o;
}
public void addNewItem(String iID,Integer iQ){
    this.od.newItem(iID,iQ);
    Total +=(Items.getPrice(iID))*iQ;
}
public void removeOrder(String iID){
   if(this.hasI(iID)){
    int iQ=this.getQ(iID); this.od.removeItem(iID);
    Total -=(Items.getPrice(iID))*iQ;
   }
}
public boolean hasI(String iID){return this.od.hasItem(iID);}
public int getQ(String iID){return this.od.getItemQ(iID);}
public void setShipTo(String ship){this.ShipTo=ship;}
public HashMap getOrderDetail(){return this.od.getItems();}
public Integer getNum(){return this.od.getNum();}
public Integer getQuantity(){return this.od.getQuantity();}
public void clear(){ this.od.clear();}

    public Integer getOrderID() {
        return orderID;
    }

    public Double getTotal() {
        return Total;
    }

    public String getMethod() {
        return method;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getShipTo() {
        return ShipTo;
    }

    public String getStore() {
        return Store;
    }

    public void setStore(String Store) {
        this.Store = Store;
    }

}
