package nivell1.exercise2.java.com.main;

import nivell1.exercise2.java.com.modules.ArbreArxius;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main (String[]args) {
        Console c = System.console();
        String dir = "";
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
//        String dir = c.readLine("Indica el directori relatiu del qual vols llistar-ne el contingut,\nprem directament Intro per llistar el directori actual: \n");
//        dir = dir.isEmpty()? "." + File.separator : dir;
        try{
            if(ArbreArxius.checkDir(dir)){
                System.out.println("El directori " + dir + " té el contingut següent:");
                ArbreArxius.listFiles(new File(dir), 1);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
