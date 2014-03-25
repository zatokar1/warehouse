/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousemodel;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class Item {
     private String name;
    private int quantity;
    private String loc;
   
    public Item(String name, int quantity, String loc){
        this.name = name;
        this.quantity = quantity;
        this.loc = loc;
    }
 
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
 
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
 
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }
 
    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }
}
