package nivell1.exercise5.java.com.main;

import nivell1.exercise5.java.com.modules.Customer;
import nivell1.exercise5.java.com.modules.Utilities;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String OUTPUT_FILE = "TestFolder" + File.separator +
                "Exercise5" + File.separator + "customer.ser";

        Customer customer = new Customer("Joan", 25, "Barcelona");
        System.out.println("Instanciem un client: " + customer);
        System.out.println("Serialitzem l'objecte al fitxer " + OUTPUT_FILE);
        Utilities.serializar(customer, OUTPUT_FILE);
        System.out.println("Deserialitzem el fitxer " + OUTPUT_FILE + " en un objecte: "
                + Utilities.deserializar(OUTPUT_FILE));
    }
}
