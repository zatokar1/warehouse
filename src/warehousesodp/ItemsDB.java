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

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class ItemsDB {
    String name, pwd;
    Statement s = null;
    ResultSet rs = null;
    String m = null;
    PreparedStatement prodsQuery;
    DBConnect dbc = new DBConnect();
    
    public ResultSet getItemsRS(){
        try {
            prodsQuery = dbc.connect().prepareStatement("SELECT * FROM items");
            rs = prodsQuery.executeQuery();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
}
