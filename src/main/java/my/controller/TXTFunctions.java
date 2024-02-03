package my.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import my.model.TXT;

public class TXTFunctions extends TXT {

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

    public long sizeFile () {
        File file = new File(path);

        long size = file.length();
        
        return size;
    }

}
