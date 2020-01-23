import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/*
TODO:
salvare clienti
togliere clienti
salvare auto
togliere auto
salvare noleggi
togliere noleggi
mostrare clienti
mostrare auto
mostrare noleggi
 */

/**
 * @author Matteo Galiazzo
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException{
        RentalManager rentalManager = null;
        try {
            rentalManager = new RentalManager();
            rentalManager.readDataFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        rentalManager.addRent(new Customer("taxCode", "phoneNumber", "name", "surname", Gender.MALE, 18), new Vehicle(1, "AA000AA", "manufacturer", "model", (short) 5, true), new Date(), new Date());
        rentalManager.addRent(new Customer("taxCode1", "phoneNumber1", "name1", "surname1", Gender.MALE, 19), new Vehicle(2, "AA001AA", "manufacturer1", "model1", (short) 5, true), new Date(), new Date());
        System.out.println(rentalManager.getRentalAt(0));
        System.out.println(rentalManager.getRentalAt(1));
        */
        Scanner scan = new Scanner(System.in);
        
        boolean active = true;
        int mainSelection, secondSelection;
        
        String customerName;
        String customerSurname;
        String g;
        Gender gender;
    
        System.out.println("---SOFTWARE DI GESTIONE DELL' AUTONOLEGGIO---");
        while (active) {
            System.out.println("\nseleziona l'azione da compiere");
            System.out.println("\n1. sezione noleggi");
            System.out.println("2. sezione clienti");
            System.out.println("3. sezione autovetture");
            System.out.println("4. Esci dal programma");
            mainSelection = scan.nextInt();
            switch (mainSelection) {
                case 1:
                    System.out.println("sezione noleggi");
                    System.out.println("1. mostra noleggi attivi");
                    System.out.println("2. inserisci nuovo noleggio");
                    System.out.println("3. rimuovi noleggio");
                    System.out.println("4. torna indietro");
                    secondSelection = scan.nextInt();
                    switch (secondSelection) {
                        case 1:
                            rentalManager.printRentals();
                            break;
                        case 2:
                            // customer fill ( name surname gender age taxcode phonenumber )
                            System.out.println("inserisci il nome del cliente");
                            customerName = scan.nextLine();
                            System.out.println("inserisci il cognome del cliente");
                            customerSurname = scan.nextLine();
                            System.out.println("inserisci il sesso (m/f)");
                            g = scan.nextLine();
                            if (g.equals("m")||g.equals("M"))
                                gender = Gender.MALE;
                            else
                                gender = Gender.FEMALE;
                            System.out.println("inserisci il numero di telefono");
                            // vehicle fill
                            // rentStartDate
                            // rentEndDate
                            //rentalManager.addRent();
                            break;
                        case 3:
                            //rentalManager.removeRent();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("sezione clienti");
                    System.out.println("1. mostra elenco clienti");
                    System.out.println("2. inserisci nuovo cliente");
                    System.out.println("3. rimuovi cliente");
                    System.out.println("4. torna indietro");
                    secondSelection = scan.nextInt();
                    switch (secondSelection){
                        case 1:
                            //rentalManager.printCustomers();
                            break;
                        case 2:
                            //rentalManager.addCustomer();
                            break;
                        case 3:
                            //rentalManager.removeCustomer();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("sezione autovetture");
                    System.out.println("1. mostra elenco autovetture");
                    System.out.println("2. inserisci nuova autovettura");
                    System.out.println("3. rimuovi autovettura");
                    System.out.println("4. torna indietro");
                    secondSelection = scan.nextInt();
                    switch (secondSelection){
                        case 1:
                            //rentalManager.printRentals();
                            break;
                        case 2:
                            //rentalManager.addVeichle();
                            break;
                        case 3:
                            //rentalManager.removeVeichle();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    try {
                        System.out.println("salvataggio dei dati in corso");
                        rentalManager.writeDataFiles();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(500);
                    System.out.println("0%");
                    Thread.sleep(250);
                    System.out.println("20%");
                    Thread.sleep(300);
                    System.out.println("50%");
                    Thread.sleep(500);
                    System.out.println("80%");
                    Thread.sleep(500);
                    System.out.println("100%");
                    Thread.sleep(200);
                    System.out.println("Dati salvati correttamente");
                    Thread.sleep(1000);
                    active = false;
                    break;
                default:
                    break;
            }
        }
    }
}
