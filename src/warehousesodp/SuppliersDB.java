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
import warehousemodel.Supplier;
import warehousesodp.GUI.Login;
import warehousesodp.GUI.OfficeWorkerGUI;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class SuppliersDB {

    String name, pwd;
    Statement s = null;
    ResultSet rs = null;
    String m = null;
    PreparedStatement prodsQuery;
    DBConnect dbc = new DBConnect();

   
public ResultSet getRS(){
        try {
            prodsQuery = dbc.connect().prepareStatement("SELECT * FROM suppliers");
            rs = prodsQuery.executeQuery();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SuppliersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
    
    public void add(String name, String address, String contact, String other) throws ClassNotFoundException {
        try {

            prodsQuery = dbc.connect().prepareStatement("INSERT INTO 'suppliers' (name, address, contact, other)"
                    + "VALUES (?,?,?,?);");
            prodsQuery.setString(1, name);
            prodsQuery.setString(2, address);
            prodsQuery.setString(3, contact);
            prodsQuery.setString(4, other);
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

    public void remove(String name) throws ClassNotFoundException {
        try {
            prodsQuery = dbc.connect().prepareStatement("DELETE FROM suppliers WHERE name=?");
            prodsQuery.setString(1, name);
            prodsQuery.executeUpdate();
            System.out.println("removed");
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

    public Supplier getSupplier(String name) throws ClassNotFoundException, SQLException {
        Statement st = dbc.connect().createStatement();
        String sql = ("SELECT * FROM suppliers WHERE name=" + "'"+name+"'");
        ResultSet rs = st.executeQuery(sql);
        Supplier supplier = null;
        if (rs.next()) {

            String address = rs.getString("address");
            String contact = rs.getString("contact");
            String other = rs.getString("other");
            supplier = new Supplier(name, address, contact, other);
        }
        rs.close();
        st.close();
        return supplier;
    }

    public void updateSupplier(String name, String newName, String address, String contact, String other) throws ClassNotFoundException, SQLException {
        
        
                System.out.println("Chystam sa updatnut suppliera: old name: "+name+" new name: "+newName+" address: "+address+" contact "+contact+" other: "+other);
                prodsQuery = dbc.connect().prepareStatement("UPDATE suppliers SET name = ?,address = ?,contact = ?,other = ? WHERE name = ?");
                prodsQuery.setString(1, newName);
                prodsQuery.setString(2, address);
                prodsQuery.setString(3, contact);
                prodsQuery.setString(4, other);
                prodsQuery.setString(5, name);
                prodsQuery.executeUpdate();
                prodsQuery.close();
            
    }
}