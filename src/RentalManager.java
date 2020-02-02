
import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * @author Matteo Galiazzo
 */
public class RentalManager implements Serializable {
    
    private ArrayList<Customer> customers;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Rental> rentals;
    private ArrayList<Rental> removedRentals;
    
    private String customersFileName = "customersData.dat";
    private String vehiclesFileName = "vehiclesData.dat";
    private String rentalsFileName = "rentalsData.dat";
    private String removedRentalsFileName = "removedRentals.dat";
    
    private int rentalCode;
    private String rentalCodeFileName = "rentalCodes.dat";
    
    public RentalManager() {
        this.rentalCode = 1;
        customers = new ArrayList<>();
        vehicles = new ArrayList<>();
        rentals = new ArrayList<>();
        removedRentals = new ArrayList<>();
    }
    
    public void addRent(Customer newCustomer, Vehicle newVehicle, LocalDate startDate, LocalDate endDate) {
        boolean customerAlreadyRegistered = false;
        boolean vehicleAlreadyRegistered = false;
        //verifica che la macchina o il cliente non siano gia' presenti nel registro
        for (Customer item : customers) {
            if (item.getTaxCode().equals(newCustomer.getTaxCode())) {
                customerAlreadyRegistered = true;
                break;
            }
        }
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(newVehicle.getLicensePlate())) {
                vehicleAlreadyRegistered = true;
                break;
            }
        }
        // aggiunta di macchina o cliente al registro (DEGLI INDAGATI XDXDXD)
        if (!customerAlreadyRegistered) {
            customers.add(newCustomer);
        }
        if (!vehicleAlreadyRegistered) {
            vehicles.add(newVehicle);
        }
        // aggiunta del noleggio: dati del cliente e un riferimento al veicolo
        // incrementa il numero di noleggio a cui sono arrivato e poi lo mette come numero di noleggio
        rentals.add(new Rental(rentalCode, newVehicle, newCustomer, startDate, endDate));
        rentalCode++;
    }
    
    // metodo che rimuove una macchina dal noleggio e la segna come non prenotata
    // aggiunge anche il noleggio al file di noleggi rientrati/rimossi
    public void removeRent(int returningRentalCode) {
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i).getRentalCode() == returningRentalCode) {
                rentals.get(i).getVehicle().setBooked(false);
                removedRentals.add(rentals.get(i));
                rentals.remove(i);
                break;
            }
        }
    }
    
    // metodo che ritorna un noleggio a un certo indice per visualizzarlo nel main
    public Rental getRentalAt(int i) {
        return rentals.get(i);
    }
    
    // metodo che stampa i noleggi attivi
    public void printRentals() {
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
    
    // metodo che aggiunge un veicolo al registro
    public void addVeichle(Vehicle v) {
        vehicles.add(v);
    }
    
    // metodo che ritorna un veicolo a un certo indice per visualizzarlo nel main
    public Vehicle getVehicleAt(int i) {
        return vehicles.get(i);
    }
    
    // metodo che rimuove un veicolo
    public void removeVeichle(String licensePlate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
                vehicles.remove(i);
                break;
            }
        }
    }
    
    // metodo che stampa i veicoli
    public void printVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    
    // aggiunge un cliente al registro
    public void addCustomer(Customer c) {
        customers.add(c);
    }
    
    // ritorna al main un cliente a un certo indice
    public Customer getCustomerAt(int i) {
        return customers.get(i);
    }
    
    // rimuove un cliente
    public void removeCustomer(String taxCode) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getTaxCode().equals(taxCode)) {
                customers.remove(i);
                break;
            }
        }
    }
    
    // metodo per stampare i clienti
    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    
    // write rentals
    public void writeRentalsFile() throws IOException {
        new File(rentalsFileName);
        ObjectOutputStream rentalsFile = new ObjectOutputStream(new FileOutputStream(rentalsFileName));
        rentalsFile.writeObject(rentals);
        rentalsFile.flush();
        rentalsFile.close();
    }
    
    public void writeCustomersFile() throws IOException {
        new File(customersFileName);
        ObjectOutputStream customerFile = new ObjectOutputStream(new FileOutputStream(customersFileName));
        customerFile.writeObject(customers);
        customerFile.flush();
        customerFile.close();
    }
    
    public void writeVehiclesFile() throws IOException {
        new File(vehiclesFileName);
        ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream(vehiclesFileName));
        vehiclesFile.writeObject(vehicles);
        vehiclesFile.flush();
        vehiclesFile.close();
    }
    
    public void writeRemovedRentals() throws IOException {
        new File(removedRentalsFileName);
        ObjectOutputStream removedRentalsFile = new ObjectOutputStream(new FileOutputStream(removedRentalsFileName));
        removedRentalsFile.writeObject(removedRentals);
        removedRentalsFile.flush();
        removedRentalsFile.close();
    }
    
    public void writeRentalCodeFile() throws IOException {
        new File(rentalCodeFileName);
        ObjectOutputStream rentalCodeFile = new ObjectOutputStream(new FileOutputStream(rentalCodeFileName));
        rentalCodeFile.write(rentalCode);
        rentalCodeFile.flush();
        rentalCodeFile.close();
    }
    
    // controlla se il file esiste e in caso contrario li crea
    public int checkFiles() throws IOException {
        File f = new File(rentalsFileName);
        File f1 = new File(customersFileName);
        File f2 = new File(vehiclesFileName);
        File f3 = new File(rentalCodeFileName);
        if (!f.exists()) {
            f.createNewFile();
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            return 0;
        } else {
            return 1;
        }
    }
    
    public void importRentalsData() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream rentalData = new ObjectInputStream(new FileInputStream(rentalsFileName));
            rentals = ((ArrayList<Rental>) rentalData.readObject());
        } catch (EOFException e) {
        }
    }
    
    public void importCustomersData() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream customerData = new ObjectInputStream(new FileInputStream(customersFileName));
            customers = ((ArrayList<Customer>) customerData.readObject());
            customerData.close();
        } catch (EOFException e) {
        }
    }
    
    public void importVehiclesData() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream vehicleData = new ObjectInputStream(new FileInputStream(vehiclesFileName));
            vehicles = ((ArrayList<Vehicle>) vehicleData.readObject());
            vehicleData.close();
        } catch (EOFException e) {
        }
    }
    
    public void importRemovedRentalsData() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream rentalData = new ObjectInputStream(new FileInputStream(removedRentalsFileName));
            removedRentals = ((ArrayList<Rental>) rentalData.readObject());
        } catch (EOFException e) {
        }
    }
    
    public void importRentalCodeData() throws IOException {
        try {
            ObjectInputStream rentalCodeData = new ObjectInputStream(new FileInputStream(rentalCodeFileName));
            this.rentalCode = rentalCodeData.read();
            rentalCodeData.close();
        } catch (EOFException e) {
        }
    }
    
    public void showRemovedRents() {
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
    
    public void showAllAvailableVehicles(){
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isBooked()) {
                System.out.println(vehicle);
            }
        }
    }
    
    public boolean vehicleCanBeBooked(String licensePlateToCheck){
        for (Vehicle vechile : vehicles){
            if (vechile.getLicensePlate().equals(licensePlateToCheck)){
                return false;
            }
        }
        return true;
    }
}
