
/**
 * @author Matteo Galiazzo
 */
public class Customer extends Person {
    
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
        return "Customer{\n" + "taxCode=" + taxCode + ",\n phoneNumber=" + phoneNumber + "\n}";
    }
    
}
