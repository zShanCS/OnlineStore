
package assisgnment1;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class Receipt implements Serializable{
    private DefaultTableModel tm;
    private Integer ID;
    private Integer Quantity;
    private Double Total;
    private String method;
    private String dateTime;
    private String ShipTo;   
    private String Store;
    public static HashMap<Integer,Receipt>allReceipts = new HashMap<Integer,Receipt>();
    
    public Receipt(Order o){
        this.tm=makeTableModel(o);
        this.ID=o.getOrderID();
        this.method = o.getMethod();
        this.Total = o.getTotal();
        this.dateTime= o.getDateTime();
        this.ShipTo = o.getShipTo();
        this.Quantity= o.getQuantity();
        this.Store=o.getStore();
    }
    public static Receipt makeReceipt(Order o){
    Receipt r = new Receipt(o);
    allReceipts.put(r.ID,r);
    return r;
    }
     public static DefaultTableModel makeTableModel(Order o){
        String [][] data = {};
        String[] q = {"ID","           NAME         ","PRICE","Q","Q * P"}; 
    DefaultTableModel history = new DefaultTableModel(data,q){ @Override public boolean isCellEditable(int row,int column){return false;}};
      HashMap<String,Integer>item=o.getOrderDetail();
       for (Map.Entry m: item.entrySet()){
           String iID= m.getKey().toString();
           String y =m.getValue().toString();
           Integer Q = Integer.parseInt(y);
           Items itm=Items.getItm(iID);
           String n =Items.getName(iID);
           String p = Double.toString(itm.getPrice(iID));
           String pq=Double.toString(itm.getPrice(iID)*Q);
           Object [] w ={iID,n,p,y,pq};
           history.addRow(w);          
       }
    return history;
    }

    public DefaultTableModel getTm() {
        return tm;
    }

    public Integer getID() {
        return ID;
    }
    public Receipt getReceipt(Integer ID) {
      return  allReceipts.get(ID);
    }
 
    public Integer getQuantity() {
        return Quantity;
    }
    
    public String getStore() {
        return Store;
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

    public String getShipTo() {
        return ShipTo;
    }

    public static HashMap<Integer,Receipt> getAllReceipts() {
        return allReceipts;
    }
}
