import java.io.Serializable;

/**
 * @author Matteo Galiazzo
 */
public class Customer extends Person implements Serializable {
    
    private String taxCode;
    private String phoneNumber;
    
    public Customer(String taxCode, String phoneNumber, String name, String surname, Gender gender, int age) {
        super(name, surname, gender, age);
        this.taxCode = taxCode;
        this.phoneNumber = phoneNumber;
    }
    
    public String getTaxCode() {
        return taxCode;
    }
    
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return "CLIENTE\n"+"nome:\t"+getName()+"\ncognome:\t"+getSurname()+"\nsesso:\t"+getGender()+"\neta'\t"+getAge()+"\nnumero di telefono:\t"+phoneNumber+"\ncodice fiscale:\t"+taxCode;
    }
    
}
