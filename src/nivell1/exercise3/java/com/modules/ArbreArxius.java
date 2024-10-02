package nivell1.exercise3.java.com.modules;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArbreArxius {
    public static boolean checkDir(String relDir) throws FileNotFoundException {
        File dir = new File(relDir);
        if(!dir.isDirectory()){
            throw new FileNotFoundException("El directori no existeix.");
        }
        return true;
    }

    public static List<String> listFiles(File dir, ArrayList<String> list, int level){
        File[] files = dir.listFiles();
        if(files != null){
            Arrays.sort(files);
            for(File file: files){
                if (file.isDirectory()){
                    String line = buildLine(file.getName(), "D", getUpdateTime(file), level);
                    list.add(line);
                    listFiles(file, list,level + 1);
                }
                else {
                    String line = buildLine(file.getName(), "F", getUpdateTime(file), level);
                    list.add(line);
                }
            }
        }
        return list;
    }

    public static String buildLine (String fileName, String type, String updateTime, int level){
        return " ".repeat(level) + type + " - " + fileName + ", modificat el " + updateTime;
    }

    public static String getUpdateTime(File file){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(file.lastModified());
    }

    public static void writeToTextFile(String outfile, List<String> list) {
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
