package my.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class myTXT {
    
    //To better the path (dinamic)
    static String pref = ".txt";
    static String nameFile = "friday"+pref;
    static String __dirname__ = System.getProperty("user.dir");
    static String path = __dirname__+"/src/main/java/my/file/privado/".concat(nameFile);

    public static void createFile () throws IOException {
        File yourFile = new File(path);
        try (PrintWriter out = new PrintWriter(yourFile)) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile (String word) throws IOException {
        File yourFile = new File(path);
        try (FileWriter fw = new FileWriter(yourFile, true)){
            fw.append(word);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
