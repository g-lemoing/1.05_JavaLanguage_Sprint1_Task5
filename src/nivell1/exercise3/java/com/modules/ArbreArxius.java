package nivell1.exercise3.java.com.modules;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ArbreArxius {

    public static void listFiles(Path relDir, ArrayList<String> list, String outfile){

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(relDir)){
            list.add("Aquest és el contingut del directori: " + relDir);
            for(Path elem: stream){
                if(Files.isDirectory(elem)){
                    String line = " D - " +
                          elem.getFileName() + ", modificat el " + Files.getLastModifiedTime(elem);
                    list.add(line);
                    listFiles(elem, list, outfile);
                }
                else{
                    String line = " F - " +
                            elem.getFileName()+ ", modificat el " + Files.getLastModifiedTime(elem);
                    list.add(line);
                }
            }
            writeToTextFile(outfile, list);
        }
        catch (IOException | DirectoryIteratorException ex){
            System.err.println(ex.getMessage());
        }
    }

    public static void writeToTextFile(String outfile, ArrayList<String> list) throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outfile))){
            for(String line : list){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
