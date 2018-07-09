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
public class Skateboard extends Product{
    
    //Private Attribute
    private String type;
    
    //Getters and Setters
    public String getType() {
        return type;
    }
    public void setType(String typeIn){
        type = typeIn;
    }
    
    //Default Constructor
    public Skateboard()
    {
        super();
        type = "";
    }
    
    //Overloaded Constructor
    public Skateboard (int productIdIn, String productNameIn, double unitPriceIn, int stockLevelIn, String typeIn){
        super(productIdIn, productNameIn, unitPriceIn, stockLevelIn);
                type = typeIn;
    }
    public Skateboard(String productNameIn, double priceIn, int stockLevelIn, String typeIn) {
        
        //Product(String productNameIn, double priceIn, int stockLevelIn)
        super (productNameIn, priceIn, stockLevelIn);
        type = typeIn;
    }
}
