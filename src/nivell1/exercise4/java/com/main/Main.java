package nivell1.exercise4.java.com.main;

import nivell1.exercise4.java.com.modules.ArbreArxius;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[]args) throws IOException {
        final String OUTPUT_FILE = "TestFolder" + File.separator +
                "Exercise4" + File.separator + "directories_contents.txt";
        String dir = "";

        Console c = System.console();
        if (c == null){
            System.err.println("Console not available");
            System.exit(1);
        }
        if (args.length > 0){
            dir = args[0];
        }
        else{
            System.out.println("Ha d'entrar un nom de directori.");
            System.exit(1);
        }

        dir = dir.isEmpty()? "." + File.separator : dir;
        try{
            if(ArbreArxius.checkDir(dir)){
                List<String> contents;
                contents = ArbreArxius.listFiles(new File(dir), new ArrayList<>(), 0);
                ArbreArxius.writeToTextFile(OUTPUT_FILE, contents);
                System.out.println("El contingut del directori " + dir + " i dels seus subdirectoris "
                        + "s'ha desat al fitxer " + OUTPUT_FILE);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ara llegirem del fitxer acabat de crear " + OUTPUT_FILE +" i mostrarem el seu contingut per consola:");
        ArbreArxius.readFromTextFile(OUTPUT_FILE);
    }
}
