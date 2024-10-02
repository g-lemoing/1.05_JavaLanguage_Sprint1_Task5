package nivell1.exercise1.java.com.main;

import nivell1.exercise1.java.com.modules.ArbreArxius;

import java.io.Console;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){
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

        try{
            ArbreArxius.listFiles(dir);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
