package nivell1.exercise1.java.com.modules;

import java.io.IOException;
import java.nio.file.*;

public class ArbreArxius {

    public static void listFiles(String relDir) throws IOException, DirectoryIteratorException{
        Path dir = Paths.get(relDir);
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            System.out.println("El directori " + relDir + " conté els elements següents:");
            for(Path file: stream){
                System.out.println(file.getFileName());
            }
        }
        catch (IOException | DirectoryIteratorException ex){
            System.err.println(ex.getMessage());
        }
    }
}
