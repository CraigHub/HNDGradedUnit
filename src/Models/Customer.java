/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Project Manager
 */

//Extends User to allow access to the user class
public class Customer extends User{
    
    private HashMap<Integer, Order> orders;
    
    //Method to find the latest order created by the customer
    public Order findLatestOrder()
    {
        //Order Class
       Order lastOrder = new Order(this);
       //If Order is empty
       if(orders.isEmpty())
       {
           //Calls the addOrder method to place in the new entry
           addOrder(lastOrder);
       }
       else
       {
           //Iterates through orders to get the value of the last order in the order class
           lastOrder = orders.entrySet().iterator().next().getValue();
           //This will loop through the orders
           for(Map.Entry<Integer, Order> orderEntry : orders.entrySet())
           {
               //Find orderDate
               if(orderEntry.getValue().getOrderDate().after(lastOrder.getOrderDate()))
               {
                   //Gets the value of the last order
                   lastOrder = orderEntry.getValue();
               }
           }
           //If status is complete, it will create a new order and add to the DB using the addOrder method
           if(lastOrder.getStatus().equals("Complete"))
           {
               lastOrder = new Order(this);
               addOrder(lastOrder);
           }
       }
       //Returns the last order
       return lastOrder;
    }
    
    //Adds a new order to the database
    public void addOrder(Order o)
    {
        //Calls the DBManager
        DBManager db = new DBManager();
        //Add this order to the DB and pass in the order and username and call it orderId
        int orderId = db.addOrder(this.getUsername(), o);
 
       //Create a new Id with the copy of the order Id
        orders.put(orderId, o);
        //Set the order Id
        orders.get(orderId).setOrderId(orderId);
    }

    //Generates a unique order id for each order
    public int generateUniqueOrderId()
    {
        //local attribute
        int orderId = 0;
        //Loop through each order in the orderlist
        for(Map.Entry<Integer, Order> orderEntry : orders.entrySet())
        {
            //If orders has a key entry, with the Order id passed in
            if(orders.containsKey(orderId))
            {
                //Incrament order Id by 1
                orderId++;
            }
        }
        //Return the order Id
        return orderId;
    }
    
    //Private Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    
    public String greeting()
    {
        String greeting = "<html>Welcome " + this.getUsername() + "<br>You are logged in as a Customer</html>";
        return greeting;
    }

    //Getters and Setters
    public HashMap<Integer, Order> getOrders()
    {
        return orders;
    }
    
    public void setOrders(HashMap<Integer, Order> keeperOrders)
    {
        orders = keeperOrders;
    }
    
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1In) {
        addressLine1 = addressLine1In;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2In) {
        addressLine2 = addressLine2In;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String townIn) {
        town = townIn;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcodeIn) {
        postcode = postcodeIn;
    }
    
    //Constructor
    public Customer() 
    {
        //User is super class
        super();
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
        orders = new HashMap<>();
    }
    
    //Overloaded Constructor
     public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
     {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
        orders = new HashMap<>();
        
     }
     public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String houseNoIn, String streetIn, String townIn, String postCodeIn)
     {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = houseNoIn;
        addressLine2 = streetIn;
        town = townIn;
        postcode = postCodeIn;
        orders = new HashMap<>();
        
     }
}
