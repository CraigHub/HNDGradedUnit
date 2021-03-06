/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Bike;
import Models.DBManager;
import Models.Skateboard;
import Models.Staff;
import javax.swing.ButtonGroup;

/**
 *
 * @author Project Manager
 */
public class AddProduct extends javax.swing.JFrame {
    //Declare the attribute loggedInStaff to pass in staff information
    private Staff loggedInStaff;

    /**
     * Creates new form AddProduct
     */
    public AddProduct(Staff staff) {
        //attribute to access the Staff class
        loggedInStaff = staff;
        initComponents();
        //Sets the background colour for the program
        getContentPane().setBackground(new java.awt.Color(255, 216, 57));
        
        //This makes the additional fields invisible when the program runs
        lblAdditional.setVisible(false);
        txtAdditional.setVisible(false);
        
        //ButtomGroup allows two individual buttons to be grouped into one
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdnSkateboard);
        btnGroup.add(rdnBike); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rdnBike = new javax.swing.JRadioButton();
        rdnSkateboard = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStockLevel = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblAdditional = new javax.swing.JLabel();
        txtAdditional = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add New Product");

        rdnBike.setText("Bicycle");
        rdnBike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnBikeActionPerformed(evt);
            }
        });

        rdnSkateboard.setText("Skateboard");
        rdnSkateboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnSkateboardActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Price:");

        jLabel4.setText("Stock:");

        txtStockLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockLevelActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblAdditional.setText("Additional:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(btnBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)))
                    .addComponent(lblAdditional))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rdnBike)
                            .addGap(18, 18, 18)
                            .addComponent(rdnSkateboard))
                        .addComponent(jLabel1)
                        .addComponent(txtName)
                        .addComponent(txtPrice)
                        .addComponent(txtStockLevel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSubmit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear))
                        .addComponent(txtAdditional)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdnBike)
                    .addComponent(rdnSkateboard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdditional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnClear)
                    .addComponent(btnBack))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockLevelActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        StaffViewProducts viewProducts = new StaffViewProducts(loggedInStaff);
        this.dispose();
        viewProducts.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void rdnBikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnBikeActionPerformed
        lblAdditional.setText("FrameSize:");
        txtAdditional.setText("");
        lblAdditional.setVisible(true);
        txtAdditional.setVisible(true);
        lblMessage.setText("");
    }//GEN-LAST:event_rdnBikeActionPerformed

    private void rdnSkateboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnSkateboardActionPerformed
        lblAdditional.setText("Type:");
        txtAdditional.setText("");
        lblAdditional.setVisible(true);
        txtAdditional.setVisible(true);
        lblMessage.setText("");
    }//GEN-LAST:event_rdnSkateboardActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //Check if any textboxes are empty
        if(!txtName.getText().isEmpty() && !txtPrice.getText().isEmpty() && 
                !txtStockLevel.getText().isEmpty() && !txtAdditional.getText().isEmpty())
        {   
            //Get text from user and declare local attributes
            String name = txtName.getText();
            double price;
            int stockLevel;
            
            
            try
            {
                //Parsing StockLevel string to integer, store value in attribute
                stockLevel = Integer.parseInt(txtStockLevel.getText());                        
            }
            catch(Exception ex)
            {
                //Checks the stock level is in the correct format, displays an error instead of crashing
                lblMessage.setText("Error: Stock Level is not in Correct Format");
                return;
            }
            
            try
            {
                //Parsing Price string to double, storing value in attribute
                price = Double.parseDouble(txtPrice.getText());                        
            }
            catch(Exception ex)
            {
                //Exception message if price entered is in wrong 
                lblMessage.setText("Error: Price not in Correct Format");
                return;
            }
            
            //Code below checks which radio button is selected
            if(rdnSkateboard.isSelected())
            {
                String type = txtAdditional.getText();
                Skateboard newSkateboard = new Skateboard(name, price, stockLevel, type);
                DBManager db = new DBManager();
                db.addProduct(newSkateboard);
                lblMessage.setText("New skateboard added successfully");
            }
           
            else
            {
               
                int frameSize = Integer.parseInt(txtAdditional.getText());
                Bike newBike = new Bike(name, price, stockLevel, frameSize);
                DBManager db = new DBManager();
                db.addProduct(newBike);
                lblMessage.setText("New bike added successfully");
            }
        }
        else
        {
            lblMessage.setText("Please Complete All Fields");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //Sets the textboxes to empty when cleared
        txtName.setText("");
        txtPrice.setText("");
        txtStockLevel.setText("");
        txtAdditional.setText("");
        rdnSkateboard.setSelected(false);
        rdnBike.setSelected(false);
        txtAdditional.setVisible(false);
        lblAdditional.setVisible(false);
        lblMessage.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAdditional;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JRadioButton rdnBike;
    private javax.swing.JRadioButton rdnSkateboard;
    private javax.swing.JTextField txtAdditional;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockLevel;
    // End of variables declaration//GEN-END:variables
}
