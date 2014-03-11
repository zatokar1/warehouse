/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import warehousesodp.GUI.OfficeWorkerGUI;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import warehousesodp.GUI.Login;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class DBConnect {

    String name, pwd;

    public String connect() throws ClassNotFoundException {
        
        // register the driver 
        Class.forName("org.sqlite.JDBC");

        // now we set up a set of fairly basic string variables to use in the body of the code proper
        final String sTempDb = "warehouseDB.sqlite";
        final String sJdbc = "jdbc:sqlite";
        final String sDbUrl = sJdbc + ":" + sTempDb;
        final Statement s;
        final ResultSet rs;
        final String m;
        // which will produce a legitimate Url for SqlLite JDBC :
        // jdbc:sqlite:warehouseDB.sqlite
        try {
            // create a database connection
            Connection conn = DriverManager.getConnection(sDbUrl);
            PreparedStatement prodsQuery = conn.prepareStatement("SELECT * FROM users where username"
                    + "=? AND password=?");
            prodsQuery.setString(1, name);
            prodsQuery.setString(2, pwd);
            rs = prodsQuery.executeQuery();
            if (!rs.next()) {
               JOptionPane.showMessageDialog(null, "Wrong username or password.");
               new Login().setVisible(true);  
               return "Error.";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }

    public void setUsrAndPwd(String name, char[] pwd) throws ClassNotFoundException {
        this.name = name;
        this.pwd = new String(pwd);
        String username=this.connect();
        switch (username) {
            case "office": {
                new OfficeWorkerGUI().setVisible(true);
             };
            break;
          // case "officeworker":new OfficeWorker().setVisible(true);
             //  break;
        }
               
    }
}
