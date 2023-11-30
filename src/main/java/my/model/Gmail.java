package my.model;

import java.io.File;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import my.key.Param;

@Getter
@Setter
public class Gmail extends Param {

    public Gmail () {
        properties = new Properties();
    }

    @Setter(AccessLevel.NONE)
    private String path = System.getProperty("user.dir") + "/src/main/resources/privado/friday.txt";

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public final String emailFrom = "projectsbygithub@gmail.com";
    
    private String emailTo;
    private String subject;
    private String content;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public Properties properties;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public Session session;
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public MimeMessage mimeMessage;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public File myFile = new File(path);

    public String getPasswordApp () {
        return passwordGMAILApp; // this the name of variable that contain the app password (gmail)
    }
}
