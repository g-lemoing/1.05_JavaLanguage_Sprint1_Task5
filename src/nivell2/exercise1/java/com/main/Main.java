package nivell2.exercise1.java.com.main;

import nivell2.exercise1.java.com.modules.ArbreArxius;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    final static String CONFIG_PATH = "resources" + File.separator + "config.properties";

    public static void main (String[]args){
        Properties properties = new Properties();
        String outputFile = "";
        String inputDir = "";

        try{
            properties.load(new FileInputStream(CONFIG_PATH));
            outputFile = properties.getProperty("OUTPUT_FILE");
            inputDir = properties.getProperty("INPUT_DIRECTORY");
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

        String dir = inputDir.isEmpty()? "." + File.separator : inputDir;
        try{
            if(ArbreArxius.checkDir(dir)){
                List<String> contents;
                contents = ArbreArxius.listFiles(new File(dir), new ArrayList<>(), 0);
                ArbreArxius.writeToTextFile(outputFile, contents);
                System.out.println("El contingut del directori " + dir + " i dels seus subdirectoris "
                        + "s'ha desat al fitxer " + outputFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
