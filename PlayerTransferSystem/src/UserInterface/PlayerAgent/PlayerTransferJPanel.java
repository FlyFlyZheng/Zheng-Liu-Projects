/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PlayerAgent;

import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Message.Message;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.FreeTransferRequest;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import System.WorkRequest.WorkRequest;
import static System.WorkRequest.WorkRequest.WorkRequestType.TransferRequest;
import UserInterface.AgentPanel;
import UserInterface.BGPanel;
import UserInterface.ClubContract.ClubContractEvaluationJPanel;
import UserInterface.MainJFrame;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liufulai
 */
public class PlayerTransferJPanel extends AgentPanel {

    /**
     * Creates new form PlayerTransferJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    private WorkRequest request;
    
    public PlayerTransferJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest work) {
    
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.request = work;
        initComponents();
        populateInfo();
        ShowInfo();
        
      
        
    }
     public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount.setText(account.getUsername());
    }
    
    public void populateInfo(){
        this.txtType.setText(this.request.getWorkRequestType().getValue());
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            this.txtPlayer.setText(transferRequest.getPlayer().getName());   
            this.txtDateStart.setText(transferRequest.getTransferStart());
            this.txtDateEnd.setText(transferRequest.getTransferEnd());
            this.txtAgentPrice.setText(String.valueOf(transferRequest.getAgentPrice()));
            this.txtSalary.setText(String.valueOf(transferRequest.getPlayerSalary()));
            
               ImageIcon icon =new ImageIcon(transferRequest.getPlayer().getPicturePath());
            icon.setImage(icon.getImage().getScaledInstance(155, 155, Image.SCALE_DEFAULT));
            labPicture.setIcon(icon);
            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            this.txtPlayer.setText(loanRequest.getPlayer().getName());   
            this.txtLoanDateStart.setText(loanRequest.getLoanStart());
            this.txtLoanDateEnd.setText(loanRequest.getLoanEnd());
            this.txtAgentPrice.setText(String.valueOf(loanRequest.getAgentPrice()));
            this.txtSalary.setText(String.valueOf(loanRequest.getPlayerSalary()));
            
            ImageIcon icon =new ImageIcon(loanRequest.getPlayer().getPicturePath());
            icon.setImage(icon.getImage().getScaledInstance(155, 155, Image.SCALE_DEFAULT));
            labPicture.setIcon(icon);
        }
       
        DefaultTableModel model = (DefaultTableModel) this.tblAdditionalItem.getModel();        
        model.setRowCount(0);
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message msg : transferRequest.getAgentAdditionalItem().getMessageList()){      
                Object[] row = new Object[2];           
                row[0] = msg.getId();
                row[1] = msg.getMessage();
                model.addRow(row);
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            for (Message msg : loanRequest.getAgentAdditionalItem().getMessageList()){      
                Object[] row = new Object[2];           
                row[0] = msg.getId();
                row[1] = msg.getMessage();
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labUserAccount = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPlayer = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labPicture = new javax.swing.JLabel();
        txtAgentPrice = new javax.swing.JLabel();
        txtSalary = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDateStart = new javax.swing.JLabel();
        txtDateEnd = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdditionalItem = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        btnDenied = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtType = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtLoanDateStart = new javax.swing.JLabel();
        txtLoanDateEnd = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        jLabel6.setText("Player:");

        txtPlayer.setText("<Player>");

        jLabel11.setText("Price to Agent:");

        jLabel15.setText("Player's week salary:");

        labPicture.setText("<Player photo>");

        txtAgentPrice.setText("<price>");

        txtSalary.setText("<price>");

        jLabel12.setText("Transfer Date Start:");

        jLabel14.setText("Loan Date End:");

        txtDateStart.setText("<Data start>");

        txtDateEnd.setText("<Data end>");

        jLabel17.setText("Additional Item:");

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

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnDenied.setText("Denied");
        btnDenied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeniedActionPerformed(evt);
            }
        });

        jLabel10.setText("Transfer Type: ");

        txtType.setText("<Type>");

        jLabel13.setText("Loan Date Start:");

        jLabel16.setText("Transfer Date End:");

        txtLoanDateStart.setText("<Data start>");

        txtLoanDateEnd.setText("<Data end>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
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
                                .addComponent(jLabel4)
                                .addGap(16, 16, 16)
                                .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addGap(19, 19, 19)
                                .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPlayer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtAgentPrice))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalary))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDateStart)
                                    .addComponent(txtDateEnd))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLoanDateEnd)
                                    .addComponent(txtLoanDateStart)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtType)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labPicture))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnAccept)
                        .addGap(66, 66, 66)
                        .addComponent(btnDenied)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtAgentPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtSalary))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDateEnd)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDateStart)
                                    .addComponent(jLabel13)
                                    .addComponent(txtLoanDateStart))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLoanDateEnd))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept)
                    .addComponent(btnDenied))
                .addGap(32, 32, 32)
                .addComponent(btnBack)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        
        
        Network innet =null;
        Network outnet = null;
        for(Network n :business.getNetworkList()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount u :o.getUserAccountDirectory().getUserAccountList()){
                        if(u.equals(this.request.getFirstReceiver())){
                            outnet = n;
                        }
                }
            }
        }
        }
        for(Network n :business.getNetworkList()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount u :o.getUserAccountDirectory().getUserAccountList()){
                        if(u.equals(request.getSender())){
                            innet = n;
                        }
                }
            }
            }
        }
        if(innet.equals(outnet)){
            if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
              TransferRequest transferRequest = (TransferRequest)this.request;
              transferRequest.setLaborPermit(true);
            }
            if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
               LoanRequest loanRequest = (LoanRequest)this.request;
               loanRequest.setLaborPermit(true);
            }
           this.request.setStatus("Finished");
           JOptionPane.showMessageDialog(null, "You have acceppt this transfer");
           return;
        }
        else {
             this.request.setStatus("AgentApproved");
        }
        
        JOptionPane.showMessageDialog(null, "You have acceppt this transfer");
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnDeniedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeniedActionPerformed
        // TODO add your handling code here:
        this.request.setStatus("AgentDenied");
        
        JOptionPane.showMessageDialog(null, "You have denied this transfer, transaction cancelled");
    }//GEN-LAST:event_btnDeniedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        PlayerTransferListJPanel sap = (PlayerTransferListJPanel) c;
        sap.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDenied;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labPicture;
    private javax.swing.JLabel labUserAccount;
    private javax.swing.JTable tblAdditionalItem;
    private javax.swing.JLabel txtAgentPrice;
    private javax.swing.JLabel txtDateEnd;
    private javax.swing.JLabel txtDateStart;
    private javax.swing.JLabel txtLoanDateEnd;
    private javax.swing.JLabel txtLoanDateStart;
    private javax.swing.JLabel txtPlayer;
    private javax.swing.JLabel txtSalary;
    private javax.swing.JLabel txtType;
    // End of variables declaration//GEN-END:variables
}
