package my.controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import my.model.Person;

public class PersonSleepy {
    
    Person person = Person.getInstance();
    GmailFunctions gmailFunctions;

    public PersonSleepy () {
        gmailFunctions = new GmailFunctions();
    }

    private void checkInactivity() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - person.getLastActivityTime();

        if (elapsedTime >= person.getINACTIVITY_TIMEOUT()) {
            System.out.println("El empleado está inactivo durante " + (person.getINACTIVITY_TIMEOUT() / 1000) + " segundos.");
            try {
                gmailFunctions.sendEmail();
            } catch (AddressException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
    }

    public void TickTackTimer () {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkInactivity();
            }
        }, 0, 1000);
    }

}
