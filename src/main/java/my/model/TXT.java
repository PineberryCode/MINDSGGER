package my.model;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TXT {

    protected static LocalDate currentDate = LocalDate.now();
    protected static LocalDateTime currentDateTime;
    protected static boolean state = false;

    protected static File yourFile;

    protected static String pref = ".txt";
    protected static String nameFile = "friday"+pref;
    protected static String __dirname__ = System.getProperty("user.dir");
    protected static String path = __dirname__+"/src/main/resources/privado/".concat(nameFile);
}
