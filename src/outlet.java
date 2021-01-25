
package assisgnment1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Outlet extends Store implements Serializable{
   
    private String Branch;
    private static String currentBranch;
   private static HashMap<String,Outlet>allOutlet = new HashMap<String,Outlet>();
public Outlet(String code,String branch){
    ID=code;Branch=branch;
}
    public static void newOutlet(String outletCode,String branch){
Outlet cust = new Outlet(outletCode,branch);
        getAllOutlet().put(outletCode,cust);
 }
     public static void listOutlets(){
for(Map.Entry m: getAllOutlet().entrySet() ){
    String o = m.getKey().toString();
    Outlet out = getAllOutlet().get(o);
    System.out.print(" Outlet Code; "+out.ID);
    System.out.println(" Store Name --> OOPMart, "+out.getBranch());
}
 } 
      public static boolean currentOutlet(String thisOut){
          if (getAllOutlet().containsKey(thisOut))
          { setCurrentBranch(thisOut); return true;} else { System.out.println("Wrong Input... Try Again... ");}
          return false;
      }
  
    public static void getStoreDetails(String id){
        Outlet o = getAllOutlet().get(id);
        System.out.print("      \t  Store Name  --     "+o.Name);
        System.out.println("    \t      Branch --      "+o.getBranch());
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public static String getCurrentBranch() {
        return currentBranch;
    }

    public static void setCurrentBranch(String aCurrentBranch) {
        currentBranch = aCurrentBranch;
    }

    public static HashMap<String,Outlet> getAllOutlet() {
        return allOutlet;
    }

    public static void setAllOutlet(HashMap<String,Outlet> aAllOutlet) {
        allOutlet = aAllOutlet;
    }
}
