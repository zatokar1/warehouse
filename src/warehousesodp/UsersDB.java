/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import warehousesodp.GUI.Login;
import warehousesodp.GUI.OfficeWorkerGUI;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class UsersDB {
     String name, pwd;
    Statement s = null;
    ResultSet rs = null;
    String m = null;
    PreparedStatement prodsQuery;
    DBConnect dbc = new DBConnect();
     public void setUsrAndPwd(String name, char[] pwd) throws ClassNotFoundException {
        try {
            this.name = name;
            this.pwd = new String(pwd);
            String username = this.logIn();
            switch (username) {
                case "office": {
                    new OfficeWorkerGUI().setVisible(true);
                };
                break;
                // case "officeworker":new OfficeWorker().setVisible(true);
                //  break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String logIn() throws SQLException {
        try {
            prodsQuery = dbc.connect().prepareStatement("SELECT * FROM users where username"
                    + "=? AND password=?");
            prodsQuery.setString(1, name);
            prodsQuery.setString(2, pwd);
            rs = prodsQuery.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username or password.");
                new Login().setVisible(true);
                prodsQuery.close();
                return "Error.";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prodsQuery.close();
            } catch (SQLException ex) {
                Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return name;
    }

}
