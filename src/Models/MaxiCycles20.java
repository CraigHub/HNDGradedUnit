/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.MainMenu;

/**
 *
 * @author Project Manager
 */
public class MaxiCycles20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaxiCycles20 mainMenu  = new MaxiCycles20();
        mainMenu.start();
        
    }
    
    //Starts the application using the green play button
    public void start(){
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
    
}
