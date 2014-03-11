/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp;

import warehousesodp.GUI.Login;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class WarehouseSODP {
static DBConnect dbc=new DBConnect();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 new Login().setVisible(true);
    }
}
