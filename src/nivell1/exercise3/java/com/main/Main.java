package nivell1.exercise3.java.com.main;

import nivell1.exercise3.java.com.modules.ArbreArxius;

import java.io.Console;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main (String[]args){
        final String OUTPUT_FILE = "TestFolder" + File.separator +
                "Exercise3" + File.separator + "directories_contents.txt";
        Console c = System.console();
        if (c == null){
            System.err.println("Console not available");
            System.exit(1);
        }
        String dir = c.readLine("Indica el directori relatiu del qual vols llistar-ne el contingut,\nprem directament Intro per llistar el directori actual: \n");
        dir = dir.isEmpty()? "." + File.separator : dir;
        ArbreArxius.listFiles(Paths.get(dir), new ArrayList<>(), OUTPUT_FILE);
        System.out.println("El contingut del directori " + dir + " i dels seus subdirectoris "
        + "s'ha desat al fitxer " + OUTPUT_FILE);
    }
}
