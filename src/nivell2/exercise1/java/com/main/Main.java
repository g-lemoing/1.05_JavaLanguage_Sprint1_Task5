package nivell2.exercise1.java.com.main;

import nivell1.exercise3.java.com.modules.ArbreArxius;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    final static String CONFIG_PATH = "resources" + File.separator + "config.properties";

    public static void main (String[]args){
        Properties properties = new Properties();
        String OUTPUT_FILE = "";
        String INPUT_DIRECTORY = "";
        try{
            properties.load(new FileInputStream(CONFIG_PATH));
            OUTPUT_FILE = properties.getProperty("OUTPUT_FILE");
            INPUT_DIRECTORY = properties.getProperty("INPUT_DIRECTORY");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        Console c = System.console();
        if (c == null){
            System.err.println("Console not available");
            System.exit(1);
        }
        String dir = INPUT_DIRECTORY.isEmpty()? "." + File.separator : INPUT_DIRECTORY;
        ArbreArxius.listFiles(Paths.get(dir), new ArrayList<>(), OUTPUT_FILE);
        System.out.println("El contingut del directori " + dir + " i dels seus subdirectoris "
        + "s'ha desat al fitxer " + OUTPUT_FILE);
    }
}
