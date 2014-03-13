/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class TheHandler {
    DB db=new DB();
  public void logIn(String name, char[] pwd) throws ClassNotFoundException{
      db.setUsrAndPwd(name, pwd);
  } 
  public void add(String name, String address, String contact, String other) throws ClassNotFoundException{
      db.add(name, address, contact, other);
  }
}
