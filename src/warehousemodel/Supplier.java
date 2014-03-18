package warehousemodel;

/**
 *
 * @author Lukas
 */
public class Supplier {
    
    public String name;
    public String contact;
    public String adress;
    public String other;
    
    public Supplier(String name, String contact, String adress, String other){
        this.name = name;
        this.contact = contact;
        this.adress = adress;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
}
