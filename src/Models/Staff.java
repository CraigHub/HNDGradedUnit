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
public class Staff extends User{
    
    //Private Attributes
    private double salary;
    private String position;
   
    
    //Greeting message showing staffs name on log in
    public String greeting()
    {
        String greeting = "<html>Welcome " + this.getUsername() + "<br>" + " You are logged in as a Staff Member" + "<br>";
        
        return greeting;
    }

    //Getters and Setters
    
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salaryIn) {
        salary = salaryIn;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String positionIn) {
        position = positionIn;
    }
    
    
    //Default
    public Staff(){
        
        super();
        salary = 0;
        position = "";
    }
    
    
    //Overloaded Constructor
    public Staff(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
     {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        salary = 0.0;
        position = "";
        
     }
    

    public Staff(double salary, String position, String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        this.salary = salary;
        this.position = position;
    }

    public Object findLatestOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
