package nivell1.exercise5.java.com.modules;

import java.io.*;

public class Utilities {
    public static void serializar(Object object, String outFile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
        oos.writeObject(object);
        oos.close();
    }
    public static Customer deserializar(String inFile) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inFile));
        return (Customer) ois.readObject();
    }
}
