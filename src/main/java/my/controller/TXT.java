package my.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TXT {
    
    static private LocalDate currentDate = LocalDate.now();
    static public LocalDateTime currentDateTime;
    static public boolean state = false;

    static File yourFile;

    static String pref = ".txt";
    static String nameFile = "friday"+pref;
    static String __dirname__ = System.getProperty("user.dir");
    static String path = __dirname__+"/src/main/resources/privado/".concat(nameFile);

    public static void createFile () throws IOException {
        yourFile = new File(path);
        writeFile("\n"+currentDate+": ");
        state = true;
    }

    public static void writeFile (String words) throws IOException {
        try (FileWriter fw = new FileWriter(yourFile, true)) {
            fw.append(""+words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private long sizeFile () {
        File file = new File(path);

        long size = file.length();
        //System.out.println("The file size is " + size + " bytes");
        return size;
    }

    public void validateSizeOfTheFile () {
        long size = sizeFile();
        if (size >= 1024) {
            //Enviar Archivo, luego eliminar.
        }
    }

}
