package nivell1.exercise2.java.com.main;

import nivell1.exercise2.java.com.modules.ArbreArxius;

import java.io.Console;
import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main (String[]args){
        Console c = System.console();
        if (c == null){
            System.err.println("Console not available");
            System.exit(1);
        }
        String dir = c.readLine("Indica el directori relatiu del qual vols llistar-ne el contingut,\nprem directament Intro per llistar el directori actual: \n");
        dir = dir.isEmpty()? "." + File.separator : dir;
        ArbreArxius.listFiles(Paths.get(dir));
    }
}
