package my;

import static my.controller.TXTFunctions.createFile;
import static my.controller.TXTFunctions.writeFile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import my.controller.PersonSleepy;
import my.model.Person;

public class App implements NativeKeyListener {

    Person person;
    public App () {
        person = Person.getInstance();
        PersonSleepy personSleepy = new PersonSleepy();
        personSleepy.TickTackTimer();
    }

    public static void main (String[] args) throws IOException {
        
        createFile();

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new App());
        
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        int keyCode = nativeEvent.getKeyCode();
        String keyString = nativeEvent.getKeyText(keyCode);
        //System.out.println("Tecla pulsada (Código VK): " + keyCode);
        //System.out.println("Letra: "+keyString);

        try {
            writeFile(keyString);
            person.setLastActivityTime(System.currentTimeMillis());
        } catch (IOException e) {e.printStackTrace();}
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}

}