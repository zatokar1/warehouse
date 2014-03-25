/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;


import java.sql.SQLException;
import warehousemodel.Supplier;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class TheHandler {
    SuppliersDB db=new SuppliersDB();
    UsersDB udb=new UsersDB();
    public Supplier supplier=null;
  public void logIn(String name, char[] pwd) throws ClassNotFoundException{
      udb.setUsrAndPwd(name, pwd);
  } 
  public void add(String name, String address, String contact, String other) throws ClassNotFoundException{
      db.add(name, address, contact, other);
  }
  
  public void remove(String name) throws ClassNotFoundException, SQLException{
      db.remove(name);
      System.out.println(name);
  }
  
  public Supplier get(String name) throws ClassNotFoundException,SQLException{
      Supplier result = db.getSupplier(name);
      supplier = result;
      return(result);
  }
  
  public void updateSupplier(String name, String newName, String adress, String contact, String other) throws ClassNotFoundException,SQLException{
      db.updateSupplier(name, newName, adress, contact, other);
  }
}