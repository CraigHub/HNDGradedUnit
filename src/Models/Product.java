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
public class Product {
    
    //Private Attributes
    
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;

    
    @Override
    public String toString()
    {
        return (productName);
    }

    //Getters and Setters


    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productIdIn) {
        productId = productIdIn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productNameIn) {
        productName = productNameIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double priceIn) {
        price = priceIn;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevelIn) {
        stockLevel = stockLevelIn;
    }
    
    //Constructor

    public Product() {
        productId = 0;
        productName = "";
        price = 0.0;
        stockLevel = 0;
    }
    
    //Overloaded Constructor
    public Product(String productNameIn, double priceIn, int stockLevelIn) {
        
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
        
        
    }
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
}
