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
import UserInterface.BGPanel;
import UserInterface.CalendarPanel.CalendarPanel;
import UserInterface.ClubPanel;
import UserInterface.MainJFrame;
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
public class ProcessBuyPlayerFromClub extends ClubPanel {

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
   

    ProcessBuyPlayerFromClub(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest work) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.request = work;    
        initComponents();
        ShowInfo(); 
        ConfigDateText();
        this.sldPrice.setMinimum(0);
        int budget = 599;
        this.sldPrice.setMaximum(budget);
   
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            this.labPlayer.setText(transferRequest.getPlayer().getName());
            this.sldPrice.setValue(transferRequest.getClubPrice());
            this.labPrice.setText(String.valueOf(transferRequest.getClubPrice()));
            this.txtDateStart.setEnabled(false);
            this.txtDateFinish.setEnabled(false);
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            this.labPlayer.setText(loanRequest.getPlayer().getName());
            this.sldPrice.setValue(loanRequest.getClubPrice());
            this.labPrice.setText(String.valueOf(loanRequest.getClubPrice()));
            this.txtDateStart.setText(String.valueOf(loanRequest.getLoanStart()));
            this.txtDateFinish.setText(String.valueOf(loanRequest.getLoanEnd()));
        }

        this.ShowAdditionalItemTable();
        populateMessageLog();
    
    }
    
    public void ConfigDateText(){
        CalendarPanel p = new CalendarPanel(this.txtDateStart, "yyyy/MM/dd");
        p.initCalendarPanel();
        JLabel l = new JLabel("日历面板");
        this.add(l);
        this.add(p);
        
        CalendarPanel p1 = new CalendarPanel(this.txtDateFinish, "yyyy/MM/dd");
        p1.initCalendarPanel();
        JLabel l1 = new JLabel("日历面板");
        this.add(l1);
        this.add(p1);
        
    }
    public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount1.setText(account.getUsername());
    }
    
    public void ShowAdditionalItemTable(){
       DefaultTableModel model = (DefaultTableModel) this.tblAdditionalItem.getModel();
       model.setRowCount(0);
       int i =0;
       if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message m: transferRequest.getClubAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m;
                model.addRow(row);
                populateMessageLog();
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            for (Message m: loanRequest.getClubAdditionalItem().getMessageList()){
                Object[] row = new Object[2];
                i++;
                row[0] = i;
                row[1] = m;
                model.addRow(row);
                populateMessageLog();
            }
        }
    }
    
    public void populateMessageLog(){
       DefaultTableModel model = (DefaultTableModel) this.tblMessage.getModel(); 
       model.setRowCount(0);
       if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest transferRequest = (TransferRequest)this.request;
            for (Message m: transferRequest.getClubMessageLog().getMessageList()){
               Object[] row = new Object[1];
               row[0] = m;
               model.addRow(row);
            }
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
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
        sldPrice = new javax.swing.JSlider();
        labPrice = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdditionalItem = new javax.swing.JTable();
        txtItem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMessage = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtMessageLog = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtDateStart = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDateFinish = new javax.swing.JTextField();

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

        jLabel11.setText("Price:");

        sldPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPriceStateChanged(evt);
            }
        });

        labPrice.setText("<Price>");

        jLabel12.setText("Message Log:");

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

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

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
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMessage);

        jLabel13.setText("Additional Item:");

        txtMessageLog.setColumns(20);
        txtMessageLog.setLineWrap(true);
        txtMessageLog.setRows(5);
        txtMessageLog.setWrapStyleWord(true);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnStop.setText("Stop This Transfer");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel15.setText("Date Start:");

        jLabel16.setText("Date End:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
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
                                .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(25, 25, 25)
                                            .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel16)
                                            .addGap(31, 31, 31)
                                            .addComponent(txtDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(labPlayer))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(sldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(labPrice)))
                                            .addGap(81, 81, 81)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel13))
                                    .addGap(32, 32, 32)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnStop)
                                    .addGap(99, 99, 99)
                                    .addComponent(btnSend))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMessageLog, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btnBack))
                .addContainerGap(54, Short.MAX_VALUE))
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
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(labPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(13, 13, 13))
                            .addComponent(labPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sldPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessageLog)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnStop)
                    .addComponent(btnBack))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.tblAdditionalItem.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete an item!");
            return;
        }
        Message msg = (Message)this.tblAdditionalItem.getValueAt(selectedRow, 1);
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){           
            TransferRequest transferRequest = (TransferRequest)this.request;
            transferRequest.getClubAdditionalItem().getMessageList().remove(msg);            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.getClubAdditionalItem().getMessageList().remove(msg);
        }
       
        this.ShowAdditionalItemTable();
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void sldPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPriceStateChanged
        // TODO add your handling code here:
        labPrice.setText(""+sldPrice.getValue());
    }//GEN-LAST:event_sldPriceStateChanged

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
            transferRequest.getClubAdditionalItem().getMessageList().add(msg);            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.getClubAdditionalItem().getMessageList().add(msg);
        }
        this.ShowAdditionalItemTable();
    }//GEN-LAST:event_btnAddActionPerformed

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

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        Message msg = new Message();   
        msg.setMessage(this.txtMessageLog.getText());
        if(this.txtMessageLog.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "message cannot be empty");
            return;
        }
        if(this.txtDateStart.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "date cannot be empty");
            return;
        }
        if(this.txtDateFinish.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "date cannot be empty");
            return;
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.TransferRequest)){           
            TransferRequest transferRequest = (TransferRequest)this.request;
            transferRequest.setClubPrice(Integer.parseInt(this.labPrice.getText()));       
            transferRequest.getClubMessageLog().getMessageList().add(msg);            
        }
        if(this.request.getWorkRequestType().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest loanRequest = (LoanRequest)this.request;
            loanRequest.setClubPrice(Integer.parseInt(this.labPrice.getText()));       
            loanRequest.getClubMessageLog().getMessageList().add(msg); 
        } 
        this.request.setStatus("InClubReply");
        
        
        JOptionPane.showMessageDialog(null, "Reply has been send");
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        this.request.setStatus("OutClubCanceled");
        
        JOptionPane.showMessageDialog(null, "You have denied this transfer, transaction cancelled");
    }//GEN-LAST:event_btnStopActionPerformed

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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel labUserAccount1;
    private javax.swing.JSlider sldPrice;
    private javax.swing.JTable tblAdditionalItem;
    private javax.swing.JTable tblMessage;
    private javax.swing.JTextField txtDateFinish;
    private javax.swing.JTextField txtDateStart;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextArea txtMessageLog;
    // End of variables declaration//GEN-END:variables
}
