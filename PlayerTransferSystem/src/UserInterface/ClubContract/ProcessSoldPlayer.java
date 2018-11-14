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
import UserInterface.ClubPanel;
import UserInterface.MainJFrame;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liufulai
 */
public class ProcessSoldPlayer extends ClubPanel {

    /**
     * Creates new form ProcessSoldPlayer
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    private WorkRequest request;
    

    ProcessSoldPlayer(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest work) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.request = work;
        initComponents();
        ShowInfo(); 
        populateInfo();
        
    }
    
    public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount1.setText(account.getUsername());
    }
    
    public void populateInfo(){
        Enterprise ent = null;
                for(Network n :this.business.getNetworkList()){
                    for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                        for(Organization org : e.getOrganizationDirectory().getOrganizationList()){
                            for(UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){                             
                                if(ua.equals(this.request.getSender())){
                                    ent = e;
                                }
                            }
                        }
                    }
                }
        this.labSender.setText(ent.getName());
        
        
        if(this.request.getWorkRequestType().equals(WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            this.labPlayer.setText(transferRequest.getPlayer().getName());
            this.labPrice.setText(String.valueOf(transferRequest.getClubPrice()));
        }
        if(this.request.getWorkRequestType().equals(WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            this.labPlayer.setText(loanRequest.getPlayer().getName());
            this.labPrice.setText(String.valueOf(loanRequest.getClubPrice()));
            this.txtLoanStart.setText(String.valueOf(loanRequest.getLoanStart()));
            this.txtLoanEnd.setText(String.valueOf(loanRequest.getLoanEnd()));
        }
        ShowAdditionalItemTable();
        populateMessageLog();
    }
    
    public void ShowAdditionalItemTable(){
       DefaultTableModel model = (DefaultTableModel) this.tblAdditionalItem.getModel(); 
       model.setRowCount(0);
       int i =0;
       if(this.request.getWorkRequestType().equals(WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message m: transferRequest.getClubAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m.getMessage();
                model.addRow(row);
                populateMessageLog();
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            for (Message m: loanRequest.getClubAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m.getMessage();
                model.addRow(row);
                populateMessageLog();
            }
        }

    }
    
    public void populateMessageLog(){
       DefaultTableModel model = (DefaultTableModel) this.tblMessage.getModel(); 
       model.setRowCount(0);
       if(this.request.getWorkRequestType().equals(WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message m: transferRequest.getClubMessageLog().getMessageList()){
               Object[] row = new Object[1];
               row[0] = m;
               model.addRow(row);
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            for (Message m: loanRequest.getClubMessageLog().getMessageList()){
                Object[] row = new Object[1];
                row[0] = m;
                model.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMessage = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labSender = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labPlayer = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        txtMessageLog = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        brnDenied = new javax.swing.JButton();
        btnArgue = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        labEnterprise = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labUserAccount1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdditionalItem = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtLoanStart = new javax.swing.JLabel();
        txtLoanEnd = new javax.swing.JLabel();
        labPrice3 = new javax.swing.JLabel();

        tblMessage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Message"
            }
        ));
        tblMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMessage);

        jLabel1.setText("Sender: ");

        labSender.setText("<>");

        jLabel2.setText("Player:");

        jLabel3.setText("Price");

        jLabel4.setText("Additional Item:");

        labPlayer.setText("<>");

        labPrice.setText("<>");

        txtMessageLog.setColumns(20);
        txtMessageLog.setLineWrap(true);
        txtMessageLog.setRows(5);
        txtMessageLog.setWrapStyleWord(true);

        jLabel5.setText("Message Log");

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        brnDenied.setText("Denied");
        brnDenied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDeniedActionPerformed(evt);
            }
        });

        btnArgue.setText("Argue");
        btnArgue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArgueActionPerformed(evt);
            }
        });

        jLabel6.setText("I am solding a player!!!!!");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Enterprise:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Organization:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("UserAccount:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("NetWork:");

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

        jLabel11.setText("Period:");

        txtLoanStart.setText("<Loan Start>");

        txtLoanEnd.setText("<Loan End>");

        labPrice3.setText("TO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labPrice))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labPlayer))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(40, 40, 40)
                                    .addComponent(labSender)))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brnDenied, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnArgue)
                                        .addGap(96, 96, 96)
                                        .addComponent(btnApprove))
                                    .addComponent(txtMessageLog, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(txtLoanStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labPrice3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoanEnd)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labSender))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labPlayer)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labPrice))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLoanStart)
                    .addComponent(txtLoanEnd)
                    .addComponent(labPrice3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMessageLog, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(brnDenied)
                    .addComponent(btnArgue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMessageMouseClicked
        // TODO add your handling code here:
       int selectedRow = this.tblMessage.getSelectedRow();
       if (selectedRow < 0){
           JOptionPane.showMessageDialog(null, "Please selete a Message");
           return;
       }
       Message msg = (Message)tblMessage.getValueAt(selectedRow, 0);
       txtMessageLog.setText(msg.getMessage());
    }//GEN-LAST:event_tblMessageMouseClicked

    private void btnArgueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArgueActionPerformed
        // TODO add your handling code here:
        Message msg = new Message();                
        msg.setMessage(this.txtMessageLog.getText());
        if(this.txtMessageLog.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "message cannot be empty");
            return;
        }
        this.request.setStatus("OutClubReply");
        if(this.request.getWorkRequestType().equals(WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            transferRequest.getClubMessageLog().getMessageList().add(msg);
        }
        if(this.request.getWorkRequestType().equals(WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.getClubMessageLog().getMessageList().add(msg);
        }
       
        JOptionPane.showMessageDialog(null, "Reply has been send");
    }//GEN-LAST:event_btnArgueActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        this.request.setStatus("OutClubApproved");
        
        JOptionPane.showMessageDialog(null, "You have approved this transfer, please wait for following process");
    }//GEN-LAST:event_btnApproveActionPerformed

    private void brnDeniedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDeniedActionPerformed
        // TODO add your handling code here:
        this.request.setStatus("OutClubDenied");
        
        JOptionPane.showMessageDialog(null, "You have denied this transfer, transaction cancelled");
    }//GEN-LAST:event_brnDeniedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ClubContractTransactionJPanel sap = (ClubContractTransactionJPanel) c;
        sap.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnDenied;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnArgue;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labPlayer;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labPrice3;
    private javax.swing.JLabel labSender;
    private javax.swing.JLabel labUserAccount1;
    private javax.swing.JTable tblAdditionalItem;
    private javax.swing.JTable tblMessage;
    private javax.swing.JLabel txtLoanEnd;
    private javax.swing.JLabel txtLoanStart;
    private javax.swing.JTextArea txtMessageLog;
    // End of variables declaration//GEN-END:variables
}
