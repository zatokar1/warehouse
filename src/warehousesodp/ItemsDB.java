/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import warehousemodel.Item;
import warehousemodel.Supplier;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class ItemsDB {
    Item item;
    String name, pwd;
    Statement s = null;
    ResultSet rs = null;
    String m = null;
    PreparedStatement prodsQuery;
    DBConnect dbc = new DBConnect();

    public ResultSet getItemsRS() {
        try {
            prodsQuery = dbc.connect().prepareStatement("SELECT * FROM items");
            rs = prodsQuery.executeQuery();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
 public Item getItem(String name) {
        try {
            Statement st = dbc.connect().createStatement();
            String sql = ("SELECT * FROM orders WHERE name=" + "'"+name+"'");
            ResultSet rs = st.executeQuery(sql);
            item = null;
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                String location = rs.getString("location");
                item = new Item(name, quantity, location);
            }
            rs.close();
            st.close();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return item;
    }
    public void order(String name, int quantity, String location) throws ClassNotFoundException {
        try {

            prodsQuery = dbc.connect().prepareStatement("INSERT INTO 'items' (name, quantity, location)"
                    + "VALUES (?,?,?);");
            prodsQuery.setString(1, name);
            prodsQuery.setInt(2, quantity);
            prodsQuery.setString(3, location);
            prodsQuery.executeUpdate();
            prodsQuery.close();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(new Date());
            prodsQuery = dbc.connect().prepareStatement("INSERT INTO 'orders' (name, quantity, date)"
                    + "VALUES (?,?,?);");
            prodsQuery.setString(1, name);
            prodsQuery.setInt(2, quantity);
            prodsQuery.setString(3, strDate);
            prodsQuery.executeUpdate();
            prodsQuery.close();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prodsQuery.close();
            } catch (SQLException ex) {
                Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
