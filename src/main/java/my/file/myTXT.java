package my.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class myTXT {
    
    public static void createFile () throws IOException {
        //To better the path (dinamic)
        String nameFile = "friday";
        String a = System.getProperty("user.name");
        String path = "/home/"+System.getProperty("user.name")+"/Documentos/Project Files/"
                        +"keylogger/default/src/main/java/my/file/privado/".concat(nameFile);
        File yourFile = new File(path.concat(".txt"));

        try (PrintWriter exit = new PrintWriter(yourFile)) {
            System.out.println(yourFile.getCanonicalPath());
            System.out.println(yourFile.getAbsolutePath());
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
