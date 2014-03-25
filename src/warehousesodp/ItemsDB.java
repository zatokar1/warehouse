/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}
