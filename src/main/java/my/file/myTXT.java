package my.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class myTXT {
    
    static private LocalDate currentDate;
    static public LocalDateTime currentDateTime;
    static private boolean state = false;
    static private boolean isJustOpened() {return state;}

    static File yourFile;

    static String pref = ".txt";
    static String nameFile = "friday"+pref;
    static String __dirname__ = System.getProperty("user.dir");
    static String path = __dirname__+"/src/main/resources/privado/".concat(nameFile);

    public static void createFile () throws IOException {
        yourFile = new File(path);
        state = true;
    }

    public static void writeFile (String words) throws IOException {
        try (FileWriter fw = new FileWriter(yourFile, true)) {
            if (isJustOpened()) {
                fw.append(currentDate.now()+"--> ");
                state = false;
            }
            fw.append(""+words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
