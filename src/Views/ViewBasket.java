/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Customer;
import Models.DBManager;
import Models.OrderLine;
import Models.Product;
import java.util.Map;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Project Manager
 */
public class ViewBasket extends javax.swing.JFrame {
    
    //Attributes to access the customer information
    private Customer loggedInCustomer;
    //Private attribute to pass in the order Id
    private int orderId;

    /**
     * Creates new form ViewBasket
     */
    public ViewBasket(Customer customer) {
        //Attribute to access the customer
        loggedInCustomer = customer;
        //Initilise the OrderId from the latest customer order
        orderId = loggedInCustomer.findLatestOrder().getOrderId();
        
        initComponents();
        //Set background colour
        getContentPane().setBackground(new java.awt.Color(255, 216, 57));
        //This will display a list of values one at a time
        tblOrderLines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Calling the DefaultTableModel to allow information to be passed in
        DefaultTableModel model = (DefaultTableModel)tblOrderLines.getModel();
        //This will look at orderlines and get order values created
        for(Map.Entry<Integer, OrderLine> olEntry : 
                loggedInCustomer.findLatestOrder().getOrderLines().entrySet())
        {
            //Gets the ordered product and value
            OrderLine actualOrderLine = olEntry.getValue();
            //Adds the information to a row and displays Product Id and Price, Quantity
            model.addRow(new Object[]{actualOrderLine.getProduct().getProductId(), actualOrderLine.getProduct().toString(),
                            actualOrderLine.getProduct().getPrice(), actualOrderLine.getQuantity()});
        }
        //This shows the total cost of the order, formatted to 2 decimal places
        lblTotal.setText("£" + String.format("%.02f",loggedInCustomer.findLatestOrder().getOrderTotal()));
    }

    ViewBasket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderLines = new javax.swing.JTable();
        btnRemoveProduct = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOrderLines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tblOrderLines);

        btnRemoveProduct.setText("Remove Item");
        btnRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit Order");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblTotal.setText("Total");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubmit)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveProduct)
                    .addComponent(lblTotal)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(lblMessage)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Remove product button
    private void btnRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductActionPerformed
       //Checks to make sure a row has been selected to delete
        if(tblOrderLines.getSelectedRow() == -1)
        {
            //Error message displayed if no row selected
            lblMessage.setText("No Product Selected");
        }
        else
        {
            //Looks at the table list
            DefaultTableModel model = (DefaultTableModel)tblOrderLines.getModel();
            //This will get the value by looking at selected column where productId is stored
            //Linking to the orderId atribute
            int productId = Integer.parseInt(String.valueOf(model.getValueAt(tblOrderLines.getSelectedRow(),0)));
            //This looks at the latest order method and removes the product from the orderline
            loggedInCustomer.findLatestOrder().removeOrderLine(productId);
            //Deletes the line from the table
            model.removeRow(tblOrderLines.getSelectedRow());
            //Message displayed for successfull deletion
            lblMessage.setText("Product Has Been Removed");
            //Updates the total and displayes the price to 2 decimal places
            lblTotal.setText("£" + String.format("%.02f",loggedInCustomer.findLatestOrder().getOrderTotal()));
        }
    }//GEN-LAST:event_btnRemoveProductActionPerformed
//Submit Button
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //New DBManager to access methods
        DBManager db = new DBManager();
        
        //Looks at the orderlines to get the order values
        for(Map.Entry<Integer, OrderLine> olEntry : 
                loggedInCustomer.findLatestOrder().getOrderLines().entrySet())
        {
            //Gets the ordered product and values
            Product orderedProduct = olEntry.getValue().getProduct();
            //Finds the quantity the customer has ordered
            if(orderedProduct.getProductId() == olEntry.getValue().getProduct().getProductId())
            {
                //Finds the stock level and subtracts the quantity ordered
                orderedProduct.setStockLevel(orderedProduct.getStockLevel() - olEntry.getValue().getQuantity());
               //Updates product quantity
                db.updateProductQuantity(orderedProduct);
            }
        }
        //Changes the status in the DB to complete
        loggedInCustomer.findLatestOrder().setStatus("Complete");
        //Pass in the order Id to find the orderline to change the status
        db.completeOrder(orderId);
        //Takes user to confirmation screen
        Confirmation confirm = new Confirmation(loggedInCustomer, orderId);
        this.dispose();
        confirm.setVisible(true);
    }//GEN-LAST:event_btnSubmitActionPerformed
//Back Button
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ViewProducts viewProducts = new ViewProducts(loggedInCustomer);
        this.dispose();
        viewProducts.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBasket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveProduct;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblOrderLines;
    // End of variables declaration//GEN-END:variables
}
