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
public class Bike extends Product{
    
    //Private Attribute
    private int frameSize;
    
    //Geters and Setters
    public int getFrameSize(){
        return frameSize;
    }
    
    public void setFrameSize(int frameSizeIn){
        frameSize = frameSizeIn;
    }
    
    //Default Constructor
    public Bike(){
        super();
        frameSize = 0;
    }
    
    //Overloaded Constructor
    public Bike(int productIdIn, String productNameIn, double unitPriceIn, int stockLevelIn, int frameSizeIn){
        super(productIdIn, productNameIn, unitPriceIn, stockLevelIn);
        frameSize = frameSizeIn;
    }
    public Bike(String productNameIn, double unitPriceIn, int stockLevelIn, int frameSizeIn){
        super(productNameIn, unitPriceIn, stockLevelIn);
        frameSize = frameSizeIn;
    }
    
}
