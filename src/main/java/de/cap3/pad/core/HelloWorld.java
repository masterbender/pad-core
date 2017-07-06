package de.cap3.pad.core;

import javax.faces.bean.ManagedBean;
import java.util.logging.Logger;

@ManagedBean
public class HelloWorld {

    private String firstName = "Johnny";
    private String lastName = "Doe";

    final static Logger logger = Logger.getLogger(HelloWorld.class.toString());

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        logger.info("Sending greeting");
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
}
