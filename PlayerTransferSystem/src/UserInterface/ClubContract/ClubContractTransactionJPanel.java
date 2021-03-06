/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubContract;

import PDF.exportPDF;
import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.LaborDepartment.LaborDepartment;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.EvaluateAPlayerRequest;
import System.WorkRequest.FindPlayerListRequest;
import System.WorkRequest.FreeTransferRequest;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import System.WorkRequest.WorkRequest;
import System.WorkRequest.WorkRequest.WorkRequestType;
import static System.WorkRequest.WorkRequest.WorkRequestType.EvaluateAPlayerRequest;
import UserInterface.BGPanel;
import UserInterface.ClubPanel;
import UserInterface.EvaluationData.GameManagementJPanel;
import UserInterface.EvaluationReport.ProcessSingalJPanel;
import UserInterface.MainJFrame;
import UserInterface.SystemAdminWorkArea.ManageEnterpriseJPanel;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class ClubContractTransactionJPanel extends ClubPanel {

    /**
     * Creates new form ClubContractTransactionJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    
    ClubContractTransactionJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
      
      this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        initComponents();
        ShowInfo();
        populateTable();
       
        
    
    
    }
      
    public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount.setText(account.getUsername());
    }
    
    
    
    public void populateTable(){
        //populate my work queue
        DefaultTableModel model = (DefaultTableModel) this.tblRequest.getModel();        
        model.setRowCount(0);
        
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()){
        if(wr instanceof TransferRequest|| wr instanceof LoanRequest|| wr instanceof FreeTransferRequest){
           // if(wr.getStatus().equalsIgnoreCase(TOOL_TIP_TEXT_KEY))
                Object[] row = new Object[4];           
                row[0] = wr;
                row[1] = wr.getStatus();
                row[2] = wr.getWorkRequestType();
                Enterprise ent = null;
                for(Network n :this.business.getNetworkList()){
                    for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                        for(Organization org : e.getOrganizationDirectory().getOrganizationList()){
                            for(UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){
                                if(ua.getUsername().equals(wr.getSender().getUsername())){
                                    ent = e;
                                }
                            }
                        }
                    }
                }
                row[3] = ent.getName();
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

        labOrganization = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        labEnterprise = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        labUserAccount = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Id", "Status", "Type", "Sender Club"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jButton2.setText("Export Contract");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnStart.setText("Strat A transfer");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnStart)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))))))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete a Work request!");
            return;
        }
        int flag = 0;
        WorkRequest work = (WorkRequest)tblRequest.getValueAt(selectedRow, 0);
    
        if(!work.getSender().equals(account)&&(work.getStatus().equalsIgnoreCase("InClubReply")||work.getStatus().equalsIgnoreCase("Processing"))){
            flag =1;
        ProcessSoldPlayer processSoldPlayer = new ProcessSoldPlayer(userProcessContainer,business,network,enterprise,organization,account,work);
        userProcessContainer.add("processSoldPlayer",processSoldPlayer);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer);     
        }
        
        if(work.getSender().equals(account)&&work.getStatus().equalsIgnoreCase("OutClubApproved")){
        flag =1;
        ProcessBuyPlayerFromAgent processBuyPlayerFromAgent = new ProcessBuyPlayerFromAgent(userProcessContainer,business,network,enterprise,organization,account,work);
        userProcessContainer.add("processBuyPlayerFromAgent",processBuyPlayerFromAgent);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
        }
        
         if(work.getSender().equals(account)&&work.getStatus().equalsIgnoreCase("OutClubReply")){
        
            flag = 1;
        ProcessBuyPlayerFromClub processBuyPlayerFromClub = new ProcessBuyPlayerFromClub(userProcessContainer,business,network,enterprise,organization,account,work);
        userProcessContainer.add("processBuyPlayerFromClub",processBuyPlayerFromClub);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
        
         }
         
         
         Network innet = null;
         if(work.getStatus().equalsIgnoreCase("AgentApproved"))
         {
             flag =1;
            for(Network n :EcoSystem.getInstance().getNetworkList()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount u :o.getUserAccountDirectory().getUserAccountList()){
                        if(u.equals(work.getSender())){
                            innet = n;
                        }
                }
            }
        }
        }
            for(Enterprise e : innet.getEnterpriseDirectory().getEnterpriseList()){
                for( Organization o: e.getOrganizationDirectory().getOrganizationList())
                    if(o instanceof LaborDepartment){
                        o.getWorkQueue().getWorkRequestList().add(work);
                         JOptionPane.showMessageDialog(null, "The labor permation request has been send to the Labor Enterprise");
                    }
            }
         }
         
         
         if(flag==0) {
             JOptionPane.showMessageDialog(null, "You are not allowed to enter this transaction, Please wait for reply!!!");
         }

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        StartBuyPlayer startBuyPlayer = new StartBuyPlayer(userProcessContainer,business,network,enterprise,organization,account);
        userProcessContainer.add("startBuyPlayer",startBuyPlayer);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete a Work request!");
            return;
        }
        
        WorkRequest work1 = (WorkRequest)tblRequest.getValueAt(selectedRow, 0);
        if(work1.getStatus().equalsIgnoreCase("Paid")){
             JOptionPane.showMessageDialog(null, "You have paid for this transcation!");
             return;
        }
        if(work1 instanceof TransferRequest&&work1.getStatus().equalsIgnoreCase("Finished"))
        {
           TransferRequest work=(TransferRequest) work1;
            work.setTotalprice(work.getClubPrice());
            work.setStatus("Paid");
            business.getWorkQueue().getWorkRequestList().add(work);
            for(UserAccount ua:business.getUserAccountDirectory().getUserAccountList()){
                if(ua.getUsername().equalsIgnoreCase("sysfinancialadmin")){
                    ua.getWorkQueue().getWorkRequestList().add(work);
                    ua.setPersonRevenue(ua.getPersonRevenue()+(int)(work.getTotalprice()*0.05));
                   
                }
            }
        
           Club buyclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.equals(work.getSender())){
                                System.out.println("Find buyer Club");
                                buyclub =(Club) e;
                            }
                        }
                    }
                }
            }
            
            System.out.println("work recevicer "+work.getFirstReceiver().getUsername());
           // System.out.println("work ua "+work.getFirstReceiver().getUsername());
            Club sellclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(work.getFirstReceiver().getUsername())){
                                System.out.println("Find seller Club");
                                sellclub =(Club) e;
                            }
                        }
                    }
                }
            }
            
        buyclub.getPlayerDirectory().getPlayerList().add(work.getPlayer());
        buyclub.setRevenue(buyclub.getRevenue()-work.getClubPrice());
        buyclub.setRevenue(buyclub.getRevenue()-work.getAgentPrice());
        buyclub.setRevenue(buyclub.getRevenue()-work.getTotalprice()*0.05);
        
        sellclub.setRevenue(sellclub.getRevenue()+work.getClubPrice());
        work.getPlayer().getAgent().setPersonRevenue(work.getPlayer().getAgent().getPersonRevenue()+work.getAgentPrice());
        
          String path=null;

         JFileChooser File= new JFileChooser();
         File.setFileSelectionMode(JFileChooser.FILES_ONLY);
         int i=File.showOpenDialog(null);
         if(i == File.APPROVE_OPTION){
             path=File.getSelectedFile().getAbsolutePath();
             String name=File.getSelectedFile().getName();
             
             System.out.println("The path of current file"+path+"\nthe current file name"+name);}
         else{
         System.out.println("no File choosen");
              }
           
             
         exportPDF.TransferContract((TransferRequest)work, path,business);
        }
        
        
          if(work1 instanceof LoanRequest&&work1.getStatus().equalsIgnoreCase("Finished"))
        {
            LoanRequest work=(LoanRequest)work1;
            work.setStatus("Paid");
            business.getWorkQueue().getWorkRequestList().add(work);
            for(UserAccount ua:business.getUserAccountDirectory().getUserAccountList()){
                if(ua.getUsername().equalsIgnoreCase("sysfinancialadmin")){
                    ua.getWorkQueue().getWorkRequestList().add(work);
                    ua.setPersonRevenue(ua.getPersonRevenue()+(int)(work.getTotalprice()*0.05));
                    
                }
            }
        
           Club buyclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.equals(work.getSender())){
                                System.out.println("Find buyer Club");
                                buyclub =(Club) e;
                            }
                        }
                    }
                }
            }
            
            System.out.println("work recevicer "+work.getFirstReceiver().getUsername());
           // System.out.println("work ua "+work.getFirstReceiver().getUsername());
            Club sellclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(work.getFirstReceiver().getUsername())){
                                System.out.println("Find seller Club");
                                sellclub =(Club) e;
                            }
                        }
                    }
                }
            }
            
        buyclub.getPlayerDirectory().getPlayerList().add(work.getPlayer());
        buyclub.setRevenue(buyclub.getRevenue()-work.getClubPrice());
        buyclub.setRevenue(buyclub.getRevenue()-work.getAgentPrice());
        buyclub.setRevenue(buyclub.getRevenue()-work.getTotalprice()*0.05);
        
        sellclub.setRevenue(sellclub.getRevenue()+work.getClubPrice());
        work.getPlayer().getAgent().setPersonRevenue(work.getPlayer().getAgent().getPersonRevenue()+work.getAgentPrice());
        
          String path=null;

         JFileChooser File= new JFileChooser();
         File.setFileSelectionMode(JFileChooser.FILES_ONLY);
         int i=File.showOpenDialog(null);
         if(i == File.APPROVE_OPTION){
             path=File.getSelectedFile().getAbsolutePath();
             String name=File.getSelectedFile().getName();
             
             System.out.println("The path of current file"+path+"\nthe current file name"+name);}
         else{
         System.out.println("no File choosen");
              }
           
             
         exportPDF.LoanContract((LoanRequest)work, path,business);
        }
          
       
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labUserAccount;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
