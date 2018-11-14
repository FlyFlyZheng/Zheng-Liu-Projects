/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EvaluationFinancial;

import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Enterprise.EvaluatingCompany;
import System.Game.Game;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.WorkRequest;
import UserInterface.BGPanel;
import UserInterface.ClubContract.ClubContracBlackboard;
import UserInterface.MainJFrame;
import UserInterface.MoneyPanel;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liufulai
 */
public class EvaluationFinanciaJPanel extends MoneyPanel {

    /**
     * Creates new form EvaluationFinanciaJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Network network;
    private EcoSystem business;
    private Organization organization;
    private UserAccount account;
    private double money;
    public EvaluationFinanciaJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        initComponents();
        money=0;
        ShowTable();
        ShowInfo();
    }
     public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount.setText(account.getUsername());
        txtTotalRevenue.setText(Double.toString(money));
    }
     
     
      public void ShowTable(){
        DefaultTableModel model = (DefaultTableModel) tblAccount.getModel();      
        model.setRowCount(0);      
        EvaluatingCompany e = (EvaluatingCompany)enterprise;   
        double Total = 0;
        for (UserAccount account: e.getUserAccountDirectory().getUserAccountList()){
            Object[] row = new Object[3];
            double personPrice = 0;
            for(WorkRequest wr:account.getWorkQueue().getWorkRequestList()){
                if(wr.getStatus().equalsIgnoreCase("Paid")){
                    personPrice =personPrice + wr.getTotalprice();
                }
            }
            row[0] = account.getUsername();
            row[1] = account.getEmployee().getName();
            row[2] = personPrice;
            model.addRow(row);
            Total = Total + personPrice;
            money=Total;
        }
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labUserAccount = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalRevenue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Total Revenue:");

        txtTotalRevenue.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtTotalRevenue.setText("<>");

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserAccount", "Employee", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAccount);

        jButton1.setText("≤Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(48, 48, 48)
                                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel5)
                                    .addGap(26, 26, 26)
                                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel3)
                                            .addGap(19, 19, 19)
                                            .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(txtTotalRevenue)
                                            .addGap(50, 50, 50))))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalRevenue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labUserAccount;
    private javax.swing.JTable tblAccount;
    private javax.swing.JLabel txtTotalRevenue;
    // End of variables declaration//GEN-END:variables
}