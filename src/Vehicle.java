import java.io.Serializable;

/**
 * @author Matteo Galiazzo
 */
public class Vehicle implements Serializable {
    private String licensePlate;
    private String manufacturer;
    private String model;
    private short seats;
    private boolean booked;
    
    public Vehicle(String licensePlate, String manifacturer, String model, short seats, boolean booked) {
        this.licensePlate = licensePlate;
        this.manufacturer = manifacturer;
        this.model = model;
        this.seats = seats;
        this.booked = booked;
    }
    
    public Vehicle(String licensePlate, String manufacturer, String model, short seats) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.seats = seats;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getManifacturer() {
        return manufacturer;
    }
    
    public void setManifacturer(String manifacturer) {
        this.manufacturer = manifacturer;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getSeats() {
        return seats;
    }
    
    public void setSeats(short seats) {
        this.seats = seats;
    }
    
    public boolean isBooked() {
        return booked;
    }
    
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    @Override
    public String toString() {
        return "Vehicle{\n" + "licensePlate=" + licensePlate + ",\n manifacturer=" + manufacturer + ",\n model=" + model + ",\n seats=" + seats + ",\n booked=" + booked + "\n}";
    }
    
    
}
