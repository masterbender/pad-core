package de.cap3.pad.core;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class HelloWorld {

    private String firstName = "Johnny";
    private String lastName = "Doe";

   

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
    
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
}
