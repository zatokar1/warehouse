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
    DBConnect dbc=new DBConnect();
  public void logIn(String name, char[] pwd) throws ClassNotFoundException{
      dbc.setUsrAndPwd(name, pwd);
  }  
}
