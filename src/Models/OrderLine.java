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
public class OrderLine {
    
    //Private Attributes
    private int orderLineId;
    private int quantity;
    private double lineTotal;
    private Product product;
    
    //Overloaded Constructors
    public OrderLine(Order orderIn, Product productIn)
    {
        //Using the generateOrderId in Order class
        orderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        quantity = 1;
        lineTotal = product.getPrice() * quantity;
    }
    
    public OrderLine(Order orderIn, Product productIn, double lineTotalIn, int quantityIn)
    {
        orderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        quantity = quantityIn;
        lineTotal = lineTotalIn;
    }

   public OrderLine(int orderIn, Product productIn, double lineTotalIn, int quantityIn)
   {
       orderLineId = orderIn;
       product = productIn;
       quantity = quantityIn;
       lineTotal = lineTotalIn;
   }
   //Getters and Setters
    public Product getProduct(){
        return product;
    }
    
    public void setProduct(Product productIn){
        product = productIn;
    }
    
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int oLineIdIn) {
        orderLineId = oLineIdIn;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantityIn){
        quantity = quantityIn;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(double lineTotalIn) {
        lineTotal = lineTotalIn;
    }
    
    
    //Constructor
    public OrderLine() {
        
        orderLineId = 0;
        quantity = 0;
        lineTotal = 0.0;
    }
    
    
    //Overloaded Constructor
    public void OrderLine(int orderLineIdIn, Product productIn, double lineTotalIn, int quantityIn)
    {
        
        orderLineId = orderLineIdIn;
        product = productIn;
        lineTotal = lineTotalIn;
        quantity = quantityIn;
    }
   
    
}
