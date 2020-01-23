
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Matteo Galiazzo
 */

/*
SFOGHI PERSONALI E RIFLESSIONI SUL PROGRAMMA
ho appena scoperto che devo gestire il codice di noleggio e che ogni volta che
riapro il prorgramma devo
-riempire gli arraylist con noleggi veicoli e clienti
-cercare il numero massimo di noleggio a cui sono arrivato e metterlo dentro rentalCode
voglio uccidermi
*/

public class RentalManager implements Serializable {
    // 3 ArrayList che tengono clienti veicoli e noleggi attivi
    private ArrayList<Customer> customers;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Rental> rentals;
    
    private String customersFileName = "customersData.dat";
    private String vehiclesFileName = "vehiclesData.dat";
    private String rentalsFileName = "rentalsData.dat";
    
    private int rentalCode;
    private String rentalCodeFileName = "rentalCodes.dat";
    
    public RentalManager() throws IOException {
        // TODO: inserire il codice di noleggio massimo precedente
        this.rentalCode = 1;
        customers = new ArrayList<>();
        vehicles = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    
    /**
     * metodo che aggiunge un nuovo noleggio, e che prima verifica se sono gia'
     * presenti la macchina e il cliente nel registro
     * poi boh mette data di inizio e fine e da un codice al noleggio
     * (DEVO SALVARE IL NUMERO DI NOLEGGIO A CUI SONO ARRIVATO SU UN FILE DAT)
     */
    public void addRent(Customer newCustomer, Vehicle newVehicle, Date startDate, Date endDate) {
        boolean customerAlreadyRegistered = false;
        boolean vehicleAlreadyRegistered = false;
        //verifica che la macchina o il cliente non siano gia' presenti nel registro
        for (Customer item : customers)
            if (item.getTaxCode().equals(newCustomer.getTaxCode())) {
                customerAlreadyRegistered = true;
                break;
            }
        for (Vehicle value : vehicles)
            if (value.getLicensePlate().equals(newVehicle.getLicensePlate())) {
                vehicleAlreadyRegistered = true;
                break;
            }
        // aggiunta di macchina o cliente al registro (DEGLI INDAGATI XDXDXD)
        if (!customerAlreadyRegistered) customers.add(newCustomer);
        if (!vehicleAlreadyRegistered) vehicles.add(newVehicle);
        // aggiunta del noleggio: dati del cliente e un riferimento al veicolo
        // incrementa il numero di noleggio a cui sono arrivato e poi lo mette come numero di noleggio
        rentals.add(new Rental(rentalCode, newVehicle, newCustomer, startDate, endDate));
        rentalCode++;
    }
    
    // metodo che rimuove una macchina dal noleggio
    public void removeRent(int returningRentalCode) {
        for (int i = 0; i < rentals.size(); i++)
            if (rentals.get(i).getRentalCode() == returningRentalCode) {
                rentals.remove(i);
                break;
            }
    }
    
    // metodo che ritorna un noleggio a un certo indice per visualizzarlo nel main
    public Rental getRentalAt(int i) {
        return rentals.get(i);
    }
    
    // metodo che stampa i noleggi attivi
    public void printRentals(){
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
    public void removeVeichle(int vehicleID) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVeichleID() == vehicleID) {
                vehicles.remove(i);
                break;
            }
        }
    }
    
    public void printVehicles(){
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
    public void printCustomers(){
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
    
    // metodo per scrivere i file dat con i dati
    public void writeDataFiles() throws IOException {
        // write rentals
        ObjectOutputStream rentalsFile = new ObjectOutputStream(new FileOutputStream(rentalsFileName));
        for (Rental rental : rentals) {
            rentalsFile.writeObject(rental);
        }
        rentalsFile.close();
        // write customers
        ObjectOutputStream customerFile = new ObjectOutputStream(new FileOutputStream(customersFileName));
        for (Customer value : customers) {
            customerFile.writeObject(value);
        }
        customerFile.close();
        // write vehicles
        ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream(vehiclesFileName));
        for (Vehicle value : vehicles) {
            vehiclesFile.writeObject(value);
        }
        vehiclesFile.close();
        // write rentalCode
        ObjectOutputStream rentalCodeFile = new ObjectOutputStream(new FileOutputStream(rentalCodeFileName));
        rentalCodeFile.write(rentalCode);
        rentalCodeFile.close();
    }
    
    // metodo per leggere i file dat salvati
    public void readDataFiles() throws IOException, ClassNotFoundException {
        // read rentals list
        ObjectInputStream rentalData = new ObjectInputStream(new FileInputStream(rentalsFileName));
        while (rentalData.available() != 0) {
            rentals.add((Rental) rentalData.readObject());
        }
        rentalData.close();
        // read customers list
        ObjectInputStream customerData = new ObjectInputStream(new FileInputStream(customersFileName));
        while (customerData.available() != 0) {
            customers.add((Customer) customerData.readObject());
        }
        customerData.close();
        // read vehicles list
        ObjectInputStream vehicleData = new ObjectInputStream(new FileInputStream(vehiclesFileName));
        while (vehicleData.available() != 0) {
            vehicles.add((Vehicle) vehicleData.readObject());
        }
        vehicleData.close();
        // read rentalCode
        ObjectInputStream rentalCodeData = new ObjectInputStream(new FileInputStream(rentalCodeFileName));
        this.rentalCode = rentalCodeData.read();
        rentalCodeData.close();
    }
}
