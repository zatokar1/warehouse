/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousesodp.GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import warehousemodel.Item;
import warehousesodp.ItemsDB;
import warehousesodp.LoadDataToJTable;

/**
 *
 * @author Ondrej Tokar <zatokar@gmail.com, http://fuuu.sk/>
 */
public class ManagerGUI extends javax.swing.JFrame {
 private final DefaultTableModel tableModel = new DefaultTableModel();
 ItemsDB idb= new ItemsDB();
 LoadDataToJTable loadData = new LoadDataToJTable();
    /**
     * Creates new form ManagerGUI
     */
    public ManagerGUI() {
        initComponents();
        itemsTable.setModel(tableModel);
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderGUI = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        productLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amountOrderField = new javax.swing.JTextField();
        cancelOrderGUIButton = new javax.swing.JButton();
        orderGUIButton = new javax.swing.JButton();
        newItemGUI = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        locField = new javax.swing.JTextField();
        newItemButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        orderNewButton = new javax.swing.JButton();

        orderGUI.setMinimumSize(new java.awt.Dimension(395, 131));

        jLabel2.setText("Order");

        productLabel.setText("name_of_product");

        jLabel5.setText("in stock:");

        amountLabel.setText("amount");

        jLabel3.setText("Amount to order");

        amountOrderField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cancelOrderGUIButton.setText("cancel");
        cancelOrderGUIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderGUIButtonActionPerformed(evt);
            }
        });

        orderGUIButton.setText("order");
        orderGUIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderGUIButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderGUILayout = new javax.swing.GroupLayout(orderGUI.getContentPane());
        orderGUI.getContentPane().setLayout(orderGUILayout);
        orderGUILayout.setHorizontalGroup(
            orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderGUILayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(orderGUILayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(productLabel)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(amountLabel))
                    .addGroup(orderGUILayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountOrderField))
                        .addGap(18, 18, 18)
                        .addComponent(cancelOrderGUIButton)
                        .addGap(18, 18, 18)
                        .addComponent(orderGUIButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        orderGUILayout.setVerticalGroup(
            orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderGUILayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productLabel)
                    .addComponent(jLabel5)
                    .addComponent(amountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelOrderGUIButton)
                    .addComponent(orderGUIButton))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        newItemGUI.setMinimumSize(new java.awt.Dimension(202, 289));

        jLabel4.setText("Order new item");

        jLabel6.setText("Name");

        jLabel7.setText("Quantity");

        jLabel8.setText("Location");

        quantityField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        newItemButton.setText("order");
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });

        jButton3.setText("cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newItemGUILayout = new javax.swing.GroupLayout(newItemGUI.getContentPane());
        newItemGUI.getContentPane().setLayout(newItemGUILayout);
        newItemGUILayout.setHorizontalGroup(
            newItemGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newItemGUILayout.createSequentialGroup()
                .addGroup(newItemGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newItemGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(newItemGUILayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(newItemGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(nameField)
                                .addComponent(quantityField)
                                .addComponent(locField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(newItemGUILayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4))
                        .addGroup(newItemGUILayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(newItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(newItemGUILayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        newItemGUILayout.setVerticalGroup(
            newItemGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newItemGUILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Notification:");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item name", "Quantity", "Location"
            }
        ));
        jScrollPane1.setViewportView(itemsTable);

        orderNewButton.setText("New");
        orderNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(orderNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(orderNewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadData();
        if(openOrderGUI() == true){
        orderGUI.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelOrderGUIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderGUIButtonActionPerformed
        orderGUI.setVisible(false);
    }//GEN-LAST:event_cancelOrderGUIButtonActionPerformed

    private void orderGUIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderGUIButtonActionPerformed
        if (amountOrderField.getText().equals("") || amountOrderField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Fill amount first!");
        }
        else{
            Item item = idb.getItem(productLabel.getText());            
            try {
                idb.order(item.getName(),Integer.parseInt(amountOrderField.getText()),item.getLoc());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_orderGUIButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        newItemGUI.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
        if (checkItemInput()){
            try {
                idb.order(nameField.getText(), Integer.parseInt(quantityField.getText()), locField.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        newItemGUI.setVisible(false);
        loadData();
    }//GEN-LAST:event_newItemButtonActionPerformed

    private void orderNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNewButtonActionPerformed
        newItemGUI.setVisible(true);
    }//GEN-LAST:event_orderNewButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerGUI().setVisible(true);
            }
        });
    }
    public void loadData(){
       loadData.loadData(idb.getItemsRS(), tableModel);
    }
    
    public boolean openOrderGUI(){
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        boolean result = false;
        if (itemsTable.getSelectedRow() == -1) {
            if (itemsTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Suppliers table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Select from list please.");
            }
        }
            else{
                    String nameToOrder = String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 0));
                    String amount = String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 1));
                    productLabel.setText(nameToOrder);
                    amountLabel.setText(amount);
                    result=true;
                    }
        return(result);
    }
    
    public boolean checkItemInput(){
        boolean result = true;
        if (nameField.getText().equals("") || nameField.getText().isEmpty()){
            result = false;
            JOptionPane.showMessageDialog(this,"Field 'name' is not to be empty!");
        }
        if (quantityField.getText().equals("") || nameField.getText().isEmpty()){
            try{
            int quantity = Integer.parseInt(quantityField.getText());
            }
            catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(this,"Field 'quantity' requires number input format!");
                    }
            result = false;
        }
        if (locField.getText().equals("") || locField.getText().isEmpty()){
            result = false;
            JOptionPane.showMessageDialog(this,"Field 'location' is not to be empty!");
        }
        return(result);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountOrderField;
    private javax.swing.JButton cancelOrderGUIButton;
    private javax.swing.JTable itemsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locField;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton newItemButton;
    private javax.swing.JFrame newItemGUI;
    private javax.swing.JFrame orderGUI;
    private javax.swing.JButton orderGUIButton;
    private javax.swing.JButton orderNewButton;
    private javax.swing.JLabel productLabel;
    private javax.swing.JTextField quantityField;
    // End of variables declaration//GEN-END:variables
}
