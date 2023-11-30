package my.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    public static volatile Person THE_ONE;

    private Person(){}

    protected long INACTIVITY_TIMEOUT = 1 * 3600 * 1000;
    protected long lastActivityTime = System.currentTimeMillis();

    public static Person getInstance () {
        if (THE_ONE == null) {
            synchronized (Person.class) {
                if (THE_ONE == null) {
                    THE_ONE = new Person();
                }
            }
        }
        return THE_ONE;
    }
}
