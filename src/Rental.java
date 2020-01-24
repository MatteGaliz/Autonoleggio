
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Matteo Galiazzo
 */
public class Rental implements Serializable {

    private int rentalCode;
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(int rentalCode, Vehicle vehicle, Customer customer, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RentalManager{\n" + "rentalCode=" + rentalCode + ",\n vehicle=" + vehicle + ",\n customer=" + customer + ",\n startDate=" + startDate + ",\n endDate=" + endDate + "\n}";
    }

}
