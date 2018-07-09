/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Project Manager
 */
public class Order {
    
    //Private Attributes
    private int orderId;
    private Customer customer;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
    
    //Mthod to remove an orderline from order
    public void removeOrderLine(int productId)
    {
        //Iterating through each entry of the orderline
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        //While iterator runs true
        while(iter.hasNext())
        {
            //Look at each orderline and get the values
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            OrderLine actualOrderLine = olEntry.getValue();
            
            //If orderline Id is equal to the Product Id
            if(actualOrderLine.getProduct().getProductId() == productId)
            {
                //Remove from the iteration
                iter.remove();
                //This claculates the order total
                //by removing lineTotal from orderTotal
                orderTotal = orderTotal - actualOrderLine.getLineTotal();
                
                //New DBManager to access the methods
                DBManager db = new DBManager();
                //DeleteOrderLine, passing in the orderId and ProductId
                //to delete the correct product
                db.deleteOrderLine(orderId, productId);
                //Update the order total, passing in orderId and -Linetotal
                db.updateOrderTotal(orderId, -actualOrderLine.getLineTotal());
            }
        }
    }
    
    
    
    
    //Method to add orderline 
    public void addOrderLine(OrderLine oLine)
    {
        //Calls the database, using it to call the addorderline method
        //Place in the order total through the OrderId
        orderLines.put(oLine.getOrderLineId(), oLine);
        DBManager db = new DBManager();
        db.addOrderLine(orderId, oLine);
        orderTotal = orderTotal + oLine.getLineTotal();
    }
    
    //Generates a unique orderline Id which incraments with each order placed
    public int generateUniqueOrderLineId()
    {
        //Variable starts the orderLine Id at zero
        int orderLineId = 10;
        //Iterate hashmap to check rderline values
        for(Map.Entry<Integer, OrderLine> orderLineEntry : orderLines.entrySet())
        {
            //If there is an orderLine Id equal to the current
            if(orderLines.containsKey(orderLineId))
            {
                //Increments orderLine Id by 1 each time an order is placed
                orderLineId++;
            }
        }
        //Returns orderLine Id
        return orderLineId;
    }
    
    //Constructor
    public Order(Customer customer)
    {
        this.customer=customer;
        orderId = customer.generateUniqueOrderId();
        orderDate = new Date();
        orderTotal = 0;
        status = "New";
        orderLines = new HashMap<>();
    }
    
    //Overloaded Constructor
    public Order(int oId, Date oDate, Customer cust, double oTotal, String oStatus)
    {
        orderId = oId;
        orderDate = oDate;
        customer = cust;
        orderTotal = oTotal;
        status = oStatus;
        orderLines = new HashMap<>();
    }

    //Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderIdIn) {
        orderId = orderIdIn;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDateIn) {
        orderDate = orderDateIn;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotalIn) {
        orderTotal = orderTotalIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statusIn) {
        status = statusIn;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer cust){
        customer = cust;
    }
    public HashMap<Integer, OrderLine> getOrderLines(){
        return orderLines;
    }
    
    public void setOrderLines(HashMap<Integer, OrderLine> oLines){
        orderLines = oLines;
    }
    
    
    //Constructor
    public Order()
    {
        orderId = customer.generateUniqueOrderId();
        orderDate = new Date();
        customer = customer;
        orderTotal = 0;
        status = "New";
        orderLines = new HashMap<>();
    }
    
    
    
    //Overloaded Constructor
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
    }

}
