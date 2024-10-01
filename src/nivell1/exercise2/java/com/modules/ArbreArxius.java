package nivell1.exercise2.java.com.modules;

import java.io.IOException;
import java.nio.file.*;

public class ArbreArxius {

    public static void listFiles(Path relDir){

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(relDir)){
            System.out.println("Aquest és el contingut del directori: " + relDir);
            for(Path elem: stream){
                if(Files.isDirectory(elem)){
                    String line = " D - " +
                            elem.getFileName() + ", modificat el " + Files.getLastModifiedTime(elem);
                    System.out.println(line);
                    listFiles(elem);
                }
                else{
                    String line = " F - " +
                            elem.getFileName()+ ", modificat el " + Files.getLastModifiedTime(elem);
                    System.out.println(line);
                }
            }
        }
        catch (IOException | DirectoryIteratorException ex){
            System.err.println(ex.getMessage());
        }
    }

}
