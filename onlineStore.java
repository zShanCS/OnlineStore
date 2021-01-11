//new class to make an online store in which all objects can be created

package assisgnment1;

import java.io.Serializable;


public class OnlineStore extends Store implements Serializable{
 //serialziable so I can convert each object into s string form for saving on file
 static String webAddress="www.oop_mart_assignment1.com";
  static String  ID="ON1";
    public OnlineStore(){}
    
   
    public  static void getStoreDetails(){
         System.out.println("Store ID \t       ;;   On1");
         System.out.println("Store Name        ;;   OO PMart");
         System.out.println("WebSite --        ;;   "+webAddress);
    }
}
