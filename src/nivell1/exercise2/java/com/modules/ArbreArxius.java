package nivell1.exercise2.java.com.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ArbreArxius {

    public static boolean checkDir(String relDir) throws FileNotFoundException {
        File dir = new File(relDir);
        if(!dir.isDirectory()){
            throw new FileNotFoundException("El directori no existeix.");
        }
        return true;
    }
    public static void listFiles(File dir, int level){
        File[] files = dir.listFiles();
        if(files != null){
            Arrays.sort(files);
            for(File file: files){
                if (file.isDirectory()){
                    String line = buildLine(file.getName(), "D", getUpdateTime(file), level);
                    System.out.println(line);
                    listFiles(file, level + 1);
                }
                else {
                    String line = buildLine(file.getName(), "F", getUpdateTime(file), level);
                    System.out.println(line);
                }
            }
        }
    }

    public static String buildLine (String fileName, String type, String updateTime, int level){
        return " ".repeat(level) + type + " - " + fileName + ", modificat el " + updateTime;
    }

    public static String getUpdateTime(File file){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(file.lastModified());
    }
}
