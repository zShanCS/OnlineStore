

package assisgnment1;

import java.io.Serializable;
import java.util.HashMap;


public class Employee implements Serializable{

    private String ID;
    private String Password;
    private String Name;
    private String PhNo;
    private String Address;
    private boolean isAdmin = false;
    public static HashMap<String,Employee> allEmployee = new HashMap<String,Employee>();
    public static HashMap<String,Employee> allAdmin = new HashMap<String,Employee>();
     HashMap<Integer,Receipt>myReceipts = new HashMap<Integer,Receipt>();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
     public void setAddress(String add) {
        this.Address = add;
    }

    public String getPhNo() {
        return PhNo;
    }

    public void setPhNo(String PhNo) {
        this.PhNo = PhNo;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public static HashMap<String,Employee> getAllEmployee() {
        return allEmployee;
    }

    public static HashMap<String,Employee> getAllAdmin() {
        return allAdmin;
    }

    public static void setAllAdmin(HashMap<String,Employee> aAllAdmin) {
        allAdmin = aAllAdmin;
    }

    public Employee(String id,String pass,String name,String phno,String add){
        ID=id;Password=pass;Name=name;PhNo=phno;Address=add;
    }
       public static void newAdmin(String id,String pass,String name,String phno,String add){
        Employee e = new Employee(id,pass,name,phno,add);
        e.setIsAdmin(true);
        getAllAdmin().put(id,e);
    }   
 
    public static void newEmp(String id,String pass,String name,String phno,String add){
        Employee e = new Employee(id,pass,name,phno,add);
        getAllEmployee().put(id,e);
    }   
      public static boolean loginE(String id,String p){
       if (getAllEmployee().containsKey(id)){
       Employee c = getAllEmployee().get(id);
       if( p.equals(c.getPassword()))
       {
          // System.out.println("---------------WellCome Back Mr/Ms "+c.getNameE()); 
           return true;}      
       } 
       return false;
 }
      public static boolean existE(String id){
      return  getAllEmployee().containsKey(id);
      }
      public static boolean existA(String id){
      return  getAllAdmin().containsKey(id);
      }
    public static boolean loginA(String id,String p){
       if (getAllAdmin().containsKey(id)){
       Employee c = getAllAdmin().get(id);
       if( p.equals(c.getPassword()))
       {
          // System.out.println("---------------WellCome Back  Mr/Ms "+c.getNameE());
           return true;}      
       } 
       return false;
 }
      public String getPassword() {
        return Password;
    }
  public static String getNameE(String id) {
  Employee e = getAllEmployee().get(id);      return e.getName();
    }
   public static void deleteE(String id) {
  allEmployee.remove(id);      
    }
  public static String getPhoneE(String id) {
  Employee e = getAllEmployee().get(id);      return e.getPhNo();
    }
 public static String getAddressE(String id) {
  Employee e = getAllEmployee().get(id);      return e.Address;
    }
  public static Employee getEmployeeE(String id) {
  Employee e = getAllEmployee().get(id);      return e;
    } 
  public static String getNameA(String id) {
  Employee e = getAllAdmin().get(id);      return e.getName();
    }
  public static String getPasswordA(String id) {
  Employee e = getAllAdmin().get(id);      return e.getPassword();
    }
   public static void setPasswordA(String id,String newP) {
  Employee e = getAllAdmin().get(id);       e.Password=newP;
    }
   public static void setNameA(String id,String newA) {
  Employee e = getAllAdmin().get(id);       e.Name=newA;
    }
   public static void setAddressA(String id,String newA) {
  Employee e = getAllAdmin().get(id);       e.Address=newA;
    }
   public static void setPhoneA(String id,String newA) {
  Employee e = getAllAdmin().get(id);       e.PhNo=newA;
    }
   public static void deleteA(String id) {
  allAdmin.remove(id);      
    }
  public static String getPhoneA(String id) {
  Employee e = getAllAdmin().get(id);      return e.getPhNo();
    }
 public static String getAddressA(String id) {
  Employee e = getAllAdmin().get(id);      return e.Address;
    }
  public static Employee getEmployeeA(String id) {
  Employee e = getAllAdmin().get(id);      return e;
    }
    public String getAddress() {
        return Address;
    }
      



}
