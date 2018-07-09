/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Project Manager
 */
public class User {
    //Private Attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String usernameIn) {
        username = usernameIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordIn) {
        password = passwordIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstNameIn) {
        firstName = firstNameIn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNameIn) {
        lastName = lastNameIn;
    }
    
    //Constructor
    public User()
    {
        username = "";
        password = "";
        firstName = "";
        lastName = "";
    }
    
    //Overloaded Constructor
    public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }
    
    public User(String usernameIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }
        
}
