/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EvaluationReport;

import Socket.Client;
import System.ClubOrganization.ClubContract;
import System.EcoSystem;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.Enterprise.EvaluatingCompany;
import System.EvaluationReport.ListEvaluationReport;
import System.EvaluationReport.Report;
import System.Network.Network;
import System.Organization.Organization;
import System.Player.Player;
import System.UserAccount.UserAccount;
import System.WorkRequest.FindPlayerListRequest;
import System.WorkRequest.WorkRequest;
import UserInterface.BGPanel;
import UserInterface.EvaPanel;
import UserInterface.MainJFrame;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class ProcessMultipleJPanel extends EvaPanel {

    /**
     * Creates new form ProcessMultipleJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private EvaluatingCompany enterprise;  
    private Organization organization;
    private UserAccount account;
    private FindPlayerListRequest workRequest;
    private ArrayList<Player> resultList;
    
    
    public ProcessMultipleJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest workRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = (EvaluatingCompany)enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.workRequest = (FindPlayerListRequest)workRequest;
        this.resultList = new ArrayList<Player>();
        initComponents();
        ShowInfo();
        showRequestInfo();
        populateCombo();
        this.txtTotalPrice.setText(String.valueOf(this.CalPrice()));
        
        
    }
    
    public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount.setText(account.getUsername());
    }
    
    public void showRequestInfo(){
        this.txtSenderUsername.setText(this.workRequest.getSender().getUsername());
        this.txtSenderClub.setText(((ClubContract)(business.locateUser(this.workRequest.getSender().getUsername()))).getName());
        this.txtMessage.setText(this.workRequest.getMessage());
    }
    
    public void populateCombo(){
        this.comboPotential.removeAllItems();
        this.comboPotential.addItem("common");
        this.comboPotential.addItem("good");
        this.comboPotential.addItem("best");
        this.comboSkill.removeAllItems();
        this.comboSkill.addItem("common");
        this.comboSkill.addItem("good");
        this.comboSkill.addItem("best");
        this.comboSpeed.removeAllItems();
        this.comboSpeed.addItem("common");
        this.comboSpeed.addItem("good");
        this.comboSpeed.addItem("best");
        this.comboType.removeAllItems();
        this.comboType.addItem("Striker");
        this.comboType.addItem("Midfielder");
        this.comboType.addItem("Deffender");
        this.comboType.addItem("Goalkeeper");

    }
    
    private void populateTable(ArrayList<Player> playerList){
        DefaultTableModel model = (DefaultTableModel) this.tblPlayer.getModel();        
        model.setRowCount(0);
        
        for (Player p : playerList){
            Object[] row = new Object[2];
            row[0] = p.getName();
            row[1] = p.gettotalvalue();
            model.addRow(row);       
        }
        this.resultList = playerList;
        
    }
    
    public void rank(ArrayList<Player> playerList){
        double a=0;
        double b=0;
        for(int i=0;i<playerList.size()-1;i++){
            for(int j=0;j<playerList.size()-1-i;j++){
                a = playerList.get(j).gettotalvalue();
                b = playerList.get(j+1).gettotalvalue();             
                if(a<b){
                    Player jj = playerList.get(j);                  
                    Player aa = new Player(jj.getPlayerType());
                    aa = jj;                   
                    playerList.set(j, playerList.get(j+1));
                    playerList.set(j+1, aa);
                }
            }
        }      
    } 
    
    public int CalPrice(){
        int price = enterprise.getBasicPriceofList();
        if(this.checkBoxType.isSelected()){          
            price += 100;
        }
        if(this.checkBoxAge.isSelected()){
            price += 100;                
        }
        if(this.checkBoxSpeed.isSelected()){
            price += 100; 
        }
        if(this.checkBoxSkill.isSelected()){
            price += 100; 
        }
        if(this.checkBoxPotential.isSelected()){
            price += 100; 
        }
        if(this.checkBoxBudget.isSelected()){
            price += 100;
        }
        return price;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labUserAccount = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSenderUsername = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSenderClub = new javax.swing.JLabel();
        checkBoxType = new javax.swing.JCheckBox();
        checkBoxAge = new javax.swing.JCheckBox();
        checkBoxSpeed = new javax.swing.JCheckBox();
        checkBoxSkill = new javax.swing.JCheckBox();
        checkBoxPotential = new javax.swing.JCheckBox();
        checkBoxBudget = new javax.swing.JCheckBox();
        comboType = new javax.swing.JComboBox<>();
        comboSpeed = new javax.swing.JComboBox<>();
        comboSkill = new javax.swing.JComboBox<>();
        comboPotential = new javax.swing.JComboBox<>();
        txtLowAge = new javax.swing.JTextField();
        txtHighAge = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        txtTotalPrice = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlayer = new javax.swing.JTable();

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Message:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Sender:");

        txtSenderUsername.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtSenderUsername.setText("<sender username>");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Club:");

        txtSenderClub.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtSenderClub.setText("<sender club>");

        checkBoxType.setText("Type:");
        checkBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxTypeActionPerformed(evt);
            }
        });

        checkBoxAge.setText("Age:");
        checkBoxAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAgeActionPerformed(evt);
            }
        });

        checkBoxSpeed.setText("Speed:");
        checkBoxSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSpeedActionPerformed(evt);
            }
        });

        checkBoxSkill.setText("Skill:");
        checkBoxSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSkillActionPerformed(evt);
            }
        });

        checkBoxPotential.setText("Potential:");
        checkBoxPotential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPotentialActionPerformed(evt);
            }
        });

        checkBoxBudget.setText("Budget:");
        checkBoxBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxBudgetActionPerformed(evt);
            }
        });

        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSkill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPotential.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("—");

        txtBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBudgetActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtTotalPrice.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtTotalPrice.setText("<Total Price>");

        txtMessage.setColumns(20);
        txtMessage.setLineWrap(true);
        txtMessage.setRows(5);
        txtMessage.setWrapStyleWord(true);
        txtMessage.setEnabled(false);

        tblPlayer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player", "Overall Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPlayer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(16, 16, 16)
                                        .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSenderUsername)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSenderClub))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(19, 19, 19)
                                        .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(518, 518, 518))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxSkill)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxSpeed)
                                    .addComponent(checkBoxAge)
                                    .addComponent(checkBoxType)
                                    .addComponent(checkBoxPotential))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtLowAge, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtHighAge, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboPotential, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkBoxBudget)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSenderUsername)
                    .addComponent(jLabel8)
                    .addComponent(txtSenderClub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkBoxType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkBoxSpeed)
                                    .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLowAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHighAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkBoxSkill)
                            .addComponent(comboSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkBoxPotential)
                            .addComponent(comboPotential, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkBoxBudget)
                                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxTypeActionPerformed

    private void checkBoxAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxAgeActionPerformed

    private void checkBoxSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSpeedActionPerformed

    private void checkBoxSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSkillActionPerformed

    private void checkBoxPotentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPotentialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxPotentialActionPerformed

    private void checkBoxBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxBudgetActionPerformed

    private void txtBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBudgetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ReporterChooseRequestJPanel sap = (ReporterChooseRequestJPanel) c;
        sap.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        ArrayList<Player> PlayerList = (ArrayList<Player>)this.network.getPlayerDirectory().getPlayerList().clone();
        if(this.checkBoxType.isSelected()){
            //Select type
            PlayerList= TypeFliter(PlayerList);     
        }
        if(this.checkBoxAge.isSelected()){
            //Select age
            PlayerList= AgeFliter(PlayerList);                  
        }
        if(this.checkBoxSpeed.isSelected()){
            //Select speed
            PlayerList= SpeedFliter(PlayerList);  
        }
        if(this.checkBoxSkill.isSelected()){
            //Select Skill
            PlayerList= SkillFliter(PlayerList);  
        }
        if(this.checkBoxPotential.isSelected()){
            //Select Potential
            PlayerList= PotentialFliter(PlayerList);  
        }
        if(this.checkBoxBudget.isSelected()){
            //Select Budget
            if(this.txtBudget.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "budge cannot be null");
            }
            else{
                PlayerList= BudgetFliter(PlayerList);  
            }            
        }
        if(PlayerList.isEmpty()){
            JOptionPane.showMessageDialog(null, "Matched Result not Found!");
            return;
        }
                
        rank(PlayerList);
        populateTable(PlayerList);
        this.txtTotalPrice.setText(String.valueOf(this.CalPrice()));
           
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        int number = this.resultList.size();
        if(number <= 3){
            JOptionPane.showMessageDialog(null, "Player list does not have enough number, report cannot generated");
            return;
        }
        
        ListEvaluationReport listreport = new ListEvaluationReport();
        workRequest.setReport(listreport);
        this.workRequest.setTotalprice(Double.parseDouble(this.txtTotalPrice.getText()));
        Date date = new Date();
        workRequest.setResolveDate(date);
        workRequest.setStatus("finish");
        ((ListEvaluationReport)this.workRequest.getReport()).getPlayerList().setPlayerList(this.resultList);
        //不知道有没有同步organization的
     
        
        JOptionPane.showMessageDialog(null, "Report send successfully");
    }//GEN-LAST:event_btnSendActionPerformed

    private ArrayList<Player> TypeFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        String type = this.comboType.getSelectedItem().toString();       
        for(Player p : PlayerList){
            if(p.getPlayerType().getValue().equals(type)){
                players.add(p);
            }
        }       
        return players;
    }
    
    private ArrayList<Player> AgeFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        int lowAge = Integer.parseInt(this.txtLowAge.getText());
        int highAge = Integer.parseInt(this.txtHighAge.getText());
        for(Player p : PlayerList){
            if((p.getAge()>=lowAge)&&(p.getAge()<=highAge)){
                players.add(p);
            }         
        }       
        return players;
    }
    
    private ArrayList<Player> SpeedFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        String level = this.comboSpeed.getSelectedItem().toString();       
        for(Player p : PlayerList){
            if(level.equalsIgnoreCase("common")){
                if(p.getSpeed()<=60){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("good")){
                if((p.getSpeed()<=85)&&(p.getSpeed()>60)){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("best")){
                if(p.getSpeed()>85){
                    players.add(p);
                }               
            }
        }       
        return players;
    }
    
    private ArrayList<Player> SkillFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        String level = this.comboSkill.getSelectedItem().toString();       
        for(Player p : PlayerList){
            if(level.equalsIgnoreCase("common")){
                if(p.getSkill()<=60){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("good")){
                if((p.getSkill()<=85)&&(p.getSkill()>60)){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("best")){
                if(p.getSkill()>85){
                    players.add(p);
                }               
            }
        }       
        return players;
    }
    
    private ArrayList<Player> PotentialFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        String level = this.comboPotential.getSelectedItem().toString();       
        for(Player p : PlayerList){
            if(level.equalsIgnoreCase("common")){
                if(p.getPotential()<=60){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("good")){
                if((p.getPotential()<=85)&&(p.getPotential()>60)){
                    players.add(p);
                }
            }
            else if(level.equalsIgnoreCase("best")){
                if(p.getPotential()>85){
                    players.add(p);
                }               
            }
        }       
        return players;
    }
    
    private ArrayList<Player> BudgetFliter (ArrayList<Player> PlayerList){
        ArrayList<Player> players = new ArrayList<Player>();
        int budget = Integer.parseInt(this.txtBudget.getText());       
        for(Player p : PlayerList){
            if(p.gettotalvalue()<=budget){
                players.add(p);
            }         
        }       
        return players;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSend;
    private javax.swing.JCheckBox checkBoxAge;
    private javax.swing.JCheckBox checkBoxBudget;
    private javax.swing.JCheckBox checkBoxPotential;
    private javax.swing.JCheckBox checkBoxSkill;
    private javax.swing.JCheckBox checkBoxSpeed;
    private javax.swing.JCheckBox checkBoxType;
    private javax.swing.JComboBox<String> comboPotential;
    private javax.swing.JComboBox<String> comboSkill;
    private javax.swing.JComboBox<String> comboSpeed;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labUserAccount;
    private javax.swing.JTable tblPlayer;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextField txtHighAge;
    private javax.swing.JTextField txtLowAge;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JLabel txtSenderClub;
    private javax.swing.JLabel txtSenderUsername;
    private javax.swing.JLabel txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}
