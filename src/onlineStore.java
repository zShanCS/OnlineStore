
package assisgnment1;

import java.io.Serializable;


public class OnlineStore extends Store implements Serializable{
 static String webAddress="www.oop_mart_assignment1.com";
  static String  ID="ON1";
    public OnlineStore(){}
    
   
    public  static void getStoreDetails(){
         System.out.println("Store ID \t       ;;   On1");
         System.out.println("Store Name        ;;   OO PMart");
         System.out.println("WebSite --        ;;   "+webAddress);
    }
}
