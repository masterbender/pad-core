package de.cap3.pad.core;

import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@ManagedBean
public class HelloWorld {

    private String firstName = "Johnny";
    private String lastName = "Doe";

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

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
        logger.error("Sending greeting");
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
}
