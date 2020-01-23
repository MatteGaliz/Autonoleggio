
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Matteo Galiazzo
 */
public class Rental implements Serializable {
    
    private int rentalCode;
    private Vehicle vehicle;
    private Customer customer;
    private Date startDate;
    private Date endDate;
    
    public Rental(int rentalCode, Vehicle vehicle, Customer customer, Date startDate, Date endDate) {
        this.rentalCode = rentalCode;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public int getRentalCode() {
        return rentalCode;
    }
    
    public void setRentalCode(int rentalCode) {
        this.rentalCode = rentalCode;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return "RentalManager{\n" + "rentalCode=" + rentalCode + ",\n vehicle=" + vehicle + ",\n customer=" + customer + ",\n startDate=" + new SimpleDateFormat("dd/mm/yy").format(startDate) + ",\n endDate=" + new SimpleDateFormat("dd/mm/yy").format(endDate) + "\n}";
    }
    
}
