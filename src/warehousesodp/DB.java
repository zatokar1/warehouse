/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;


import java.sql.Connection;
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
        finally{try {
                prodsQuery.close();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }}
        return name;
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
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{try {
                prodsQuery.close();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
    
    public void remove(String name) throws ClassNotFoundException{
        Statement stmt = null;
        Connection con = dbc.connect();
        String query = "delete from suppliers where name = "+name;
            try { 
            stmt = con.createStatement();        
              
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
             if (stmt != null) {  
    try {  
     stmt.close();  
    } catch (SQLException e) {  
     Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
    }  
   }  
   if (con != null) {  
    try {  
     con.close();  
    } catch (SQLException e) {  
     Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e); 
    }  
   }            
    }}
    
    public Supplier getSupplier(String name) throws ClassNotFoundException, SQLException{
        Supplier result=null;
        Statement stmt = null;
        String query = "select name, contact, adress, other from warehouseDB.suppliers";
    try {
        Connection con = dbc.connect();
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            String newName = rs.getString("name");
            if (newName.equals(name)){
            String adress = rs.getString("adress");
            String contact = rs.getString("contact");
            String other = rs.getString("other");
            result = new Supplier(newName, adress, contact, other);
            }
        }
    } catch (SQLException e ) {
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        return(result);
    }
    
    public void updateSupplier(String name, String newName, String adress, String contact, String other) throws ClassNotFoundException, SQLException{ 
        Supplier supplier = getSupplier(name);
        if (supplier != null){
        try {
          
            prodsQuery = dbc.connect().prepareStatement("UPDATE supplier SET name = ?,adress = ?,contact = ?,other = ? WHERE name = '"+name+"'");
            prodsQuery.setString(1, name);
            prodsQuery.setString(2, adress);
            prodsQuery.setString(3, contact);
            prodsQuery.setString(4, other);
            prodsQuery.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{try {
                prodsQuery.close();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
}
}