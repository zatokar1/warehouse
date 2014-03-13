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
public class DB {

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
                }
                ;
                break;
                // case "officeworker":new OfficeWorker().setVisible(true);
                //  break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
                return "Error.";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public void add(String name, String address, String contact, String other) throws ClassNotFoundException {
        try {
            prodsQuery = dbc.connect().prepareStatement("INSERT INTO suppliers (name, address, contact, other)"
                    + "VALUES (?,?,?,?)");
            prodsQuery.setString(1, name);
            prodsQuery.setString(2, address);
            prodsQuery.setString(3, contact);
            prodsQuery.setString(4, other);
            prodsQuery.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
