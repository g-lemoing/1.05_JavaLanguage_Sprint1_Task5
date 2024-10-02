package nivell1.exercise1.java.com.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ArbreArxius {

    public static void listFiles(String relDir) throws FileNotFoundException {
        File dir = new File(relDir);
        if(!dir.isDirectory()){
            throw new FileNotFoundException("El directori no existeix.");
        }
        String[] files = dir.list();
        if(files != null){
            Arrays.sort(files);
            for(String file : files){
                System.out.println(file);
            }
        }
        else{
            System.out.println("El directori " + relDir + "està buit.");
        }

    }
}
