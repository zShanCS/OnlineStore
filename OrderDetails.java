
package assisgnment1;
import java.io.Serializable;
import java.util.HashMap;

public class OrderDetails implements Serializable{
    Integer Num=0;//num of items
    Integer Quantity=0;//total quantity of all items

    public  HashMap<String,Integer> items = new HashMap<String,Integer>();

public void newItem(String iID,Integer iQ){ 
    if (!items.containsKey(iID)){
        this.items.put(iID, iQ);
    }
    else { 
        Integer x = items.get(iID);
        Integer c = x+iQ;
        this.items.put(iID,c);}
   if (!hasItem(iID)) {Num++; }
    
    Quantity+=iQ; Items.Qbought(iID, iQ);
     }
public void removeItem(String iID){
    if (hasItem(iID)){
        int q =items.get(iID);
        Items.Qbought(iID, -q);
    Quantity-=q;
    this.items.remove(iID);  
    Num--;}
}
