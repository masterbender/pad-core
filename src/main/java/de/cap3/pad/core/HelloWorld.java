package de.cap3.pad.core;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named("HelloWorld")
@SessionScoped
public class HelloWorld implements Serializable {

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
