/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubContract;

import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Message.Message;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import System.WorkRequest.WorkRequest;
import System.WorkRequest.WorkRequest.WorkRequestType;
import UserInterface.BGPanel;
import UserInterface.CalendarPanel.CalendarPanel;
import UserInterface.ClubPanel;
import UserInterface.MainJFrame;
import UserInterface.PlayerAgent.PlayerTransferListJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liufulai
 */
public class ProcessBuyPlayerFromAgent extends ClubPanel {

    /**
     * Creates new form ProcessBuyPlayer
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    private WorkRequest request;
    
   

    ProcessBuyPlayerFromAgent(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest work) {
      this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.request = work;
        initComponents();
        ShowInfo(); 
        configSlide();
        ConfigDateText();
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            this.labPlayer.setText(transferRequest.getPlayer().getName());
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            this.labPlayer.setText(loanRequest.getPlayer().getName());
            this.labPlayer.setText(loanRequest.getPlayer().getName());           
        }
       

    }
    
    public void ShowTable(){
        
       DefaultTableModel model = (DefaultTableModel) this.tblAdditionalItem.getModel();        
       model.setRowCount(0);
       int i =0;
       if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message m: transferRequest.getAgentAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m.getMessage();
                model.addRow(row);
               
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            for (Message m: loanRequest.getAgentAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m.getMessage();
                model.addRow(row);
              
            }
        }

    }
    
    public void configSlide(){
        this.sldaPrice.setMinimum(0);
        int budget = 10000;
        this.sldaPrice.setMaximum(budget);

        this.sldwPrice.setMinimum(0);
        int budget1 = 500;
        this.sldwPrice.setMaximum(budget1);
        
    }
    
     public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount1.setText(account.getUsername());
    }

    
    public void ConfigDateText(){
        CalendarPanel p = new CalendarPanel(this.txtTransferDateStart, "yyyy/MM/dd");
        p.initCalendarPanel();
        JLabel l = new JLabel("日历面板");
        this.add(l);
        this.add(p);
        
        CalendarPanel p1 = new CalendarPanel(this.txtTransferDateEnd, "yyyy/MM/dd");
        p1.initCalendarPanel();
        JLabel l1 = new JLabel("日历面板");
        this.add(l1);
        this.add(p1);
        
        CalendarPanel p2 = new CalendarPanel(this.txtLoanDataStart, "yyyy/MM/dd");
        p2.initCalendarPanel();
        JLabel l2 = new JLabel("日历面板");
        this.add(l2);
        this.add(p2);
        
        CalendarPanel p3 = new CalendarPanel(this.txtLoanDataEnd, "yyyy/MM/dd");
        p3.initCalendarPanel();
        JLabel l3 = new JLabel("日历面板");
        this.add(l3);
        this.add(p3);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labUserAccount1 = new javax.swing.JLabel();
        labPlayer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sldaPrice = new javax.swing.JSlider();
        labaPrice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdditionalItem = new javax.swing.JTable();
        txtItem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        vrnRemove = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnSendtoAgent = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTransferDateStart = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTransferDateEnd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        sldwPrice = new javax.swing.JSlider();
        labwPrice = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtLoanDataStart = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtLoanDataEnd = new javax.swing.JTextField();

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("UserAccount:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("NetWork:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Enterprise:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Organization:");

        labPlayer.setText("<Player>");

        jLabel2.setText("Player:");

        jLabel3.setText("<Player photo>");

        jLabel11.setText("Price to Agent:");

        sldaPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldaPriceStateChanged(evt);
            }
        });

        labaPrice.setText("<Price>");

        tblAdditionalItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Item Content"
            }
        ));
        jScrollPane2.setViewportView(tblAdditionalItem);

        btnAdd.setText("Add an item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        vrnRemove.setText("Remove");
        vrnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vrnRemoveActionPerformed(evt);
            }
        });

        jLabel13.setText("Additional Item:");

        btnSendtoAgent.setText("Send to Agent");
        btnSendtoAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendtoAgentActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Transfer Date Start:");

        jLabel14.setText("Transfer Date End:");

        jLabel15.setText("Player's week salary:");

        sldwPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldwPriceStateChanged(evt);
            }
        });

        labwPrice.setText("<Price>");

        jLabel16.setText("Loan Date Start:");

        jLabel17.setText("Loan Date End:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10)
                        .addGap(48, 48, 48)
                        .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(labPlayer))
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sldwPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labwPrice))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sldaPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labaPrice)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(311, 311, 311)
                                        .addComponent(btnSendtoAgent))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vrnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(25, 25, 25)
                                                .addComponent(txtLoanDataStart, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(25, 25, 25)
                                                .addComponent(txtTransferDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(33, 33, 33)
                                                .addComponent(txtTransferDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(33, 33, 33)
                                                .addComponent(txtLoanDataEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(labPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labaPrice))))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldaPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labwPrice)
                            .addComponent(sldwPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransferDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransferDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoanDataStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoanDataEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(vrnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnSendtoAgent))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sldaPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldaPriceStateChanged
        // TODO add your handling code here:
        this.labaPrice.setText(String.valueOf(this.sldaPrice.getValue()));
    }//GEN-LAST:event_sldaPriceStateChanged

    private void sldwPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldwPriceStateChanged
        // TODO add your handling code here:
        this.labwPrice.setText(String.valueOf(this.sldwPrice.getValue()));
    }//GEN-LAST:event_sldwPriceStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(txtItem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Additional Item cannot be empty");
            return;
        }
        Message msg = new Message();
        msg.setMessage(txtItem.getText());
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){           
            TransferRequest transferRequest = (TransferRequest)this.request;
            transferRequest.getAgentAdditionalItem().getMessageList().add(msg);            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.getAgentAdditionalItem().getMessageList().add(msg);
        }
        this.ShowTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void vrnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vrnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.tblAdditionalItem.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete an item!");
            return;
        }
        Message msg = (Message)this.tblAdditionalItem.getValueAt(selectedRow, 1);
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){           
            TransferRequest transferRequest = (TransferRequest)this.request;
            transferRequest.getAgentAdditionalItem().getMessageList().remove(msg);            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.getAgentAdditionalItem().getMessageList().remove(msg);
        }
        this.ShowTable();
    }//GEN-LAST:event_vrnRemoveActionPerformed

    private void btnSendtoAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendtoAgentActionPerformed
        // TODO add your handling code here:

        UserAccount agent = null;
        if(this.request.getWorkRequestType().equals(WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            if(this.txtTransferDateStart.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Please select start date");
               return;
            }
            if(this.txtTransferDateEnd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Please select end date");
               return;
            }
            transferRequest.setAgentPrice(Integer.parseInt(this.labaPrice.getText()));
            transferRequest.setPlayerSalary(Integer.parseInt(this.labwPrice.getText()));
            transferRequest.setTransferStart(this.txtTransferDateStart.getText());
            transferRequest.setTransferEnd(this.txtTransferDateEnd.getText()); 
            agent = transferRequest.getPlayer().getAgent();
        }
        
        else if(this.request.getWorkRequestType().equals(WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            if(this.txtLoanDataStart.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Please select start date");
               return;
            }
            if(this.txtLoanDataEnd.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Please select end date");
               return;
            }
            loanRequest.setAgentPrice(Integer.parseInt(this.labaPrice.getText()));
            loanRequest.setPlayerSalary(Integer.parseInt(this.labwPrice.getText()));
            loanRequest.setLoanStart(this.txtLoanDataStart.getText());
            loanRequest.setLoanEnd(this.txtLoanDataEnd.getText()); 
            agent = loanRequest.getPlayer().getAgent();
        }

        this.request.setStatus("SendToAgent");       
        System.out.println(agent.getUsername());
        agent.getWorkQueue().getWorkRequestList().add(this.request);
        
       
        
        
        JOptionPane.showMessageDialog(null, "You have send the transfer request to agent");
        
    }//GEN-LAST:event_btnSendtoAgentActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ClubContractTransactionJPanel sap = (ClubContractTransactionJPanel) c;
        sap.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSendtoAgent;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labPlayer;
    private javax.swing.JLabel labUserAccount1;
    private javax.swing.JLabel labaPrice;
    private javax.swing.JLabel labwPrice;
    private javax.swing.JSlider sldaPrice;
    private javax.swing.JSlider sldwPrice;
    private javax.swing.JTable tblAdditionalItem;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtLoanDataEnd;
    private javax.swing.JTextField txtLoanDataStart;
    private javax.swing.JTextField txtTransferDateEnd;
    private javax.swing.JTextField txtTransferDateStart;
    private javax.swing.JButton vrnRemove;
    // End of variables declaration//GEN-END:variables
}
