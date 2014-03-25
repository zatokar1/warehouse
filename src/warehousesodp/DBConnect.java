/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class DBConnect {

    public Connection connect() throws ClassNotFoundException {
        try {
            // register the driver 
            Class.forName("org.sqlite.JDBC");
            // now we set up a set of fairly basic string variables to use in the body of the code proper
            final String sTempDb = "warehouseDB.sqlite";
            final String sJdbc = "jdbc:sqlite";
            final String sDbUrl = sJdbc + ":" + sTempDb;
            // which will produce a legitimate Url for SqlLite JDBC :
            // jdbc:sqlite:warehouseDB.sqlite
            // create a database connection
            Connection conn = DriverManager.getConnection(sDbUrl);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}