/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PlayerAgent;

import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import UserInterface.BGPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author liufulai
 */
public class PlayerAgentWorkArea extends BGPanel {

    /**
     * Creates new form PlayerAgentWorkArea
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    
    public PlayerAgentWorkArea(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
    
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        initComponents();
        Config1();
        Config2();
        Config3();
        
       
    }
    public void Config1(){
        PlayerTransferListJPanel playerEvaluationJPanel = new PlayerTransferListJPanel(containerPlayerTransfer,business,network,enterprise,organization,account);
        containerPlayerTransfer.add("playerEvaluationJPanel", playerEvaluationJPanel);
        CardLayout layout = (CardLayout) containerPlayerTransfer.getLayout();
        layout.next(containerPlayerTransfer); 
    }
    
    public void Config2(){
        PlayerEvaluationJPanel playerEvaluationJPanel = new PlayerEvaluationJPanel(containerEva,business,network,enterprise,organization,account);
        containerEva.add("playerEvaluationJPanel", playerEvaluationJPanel);
        CardLayout layout = (CardLayout) containerEva.getLayout();
        layout.next(containerEva); 
    }
    
    public void Config3(){
        AgentFinancial agentFinancial = new AgentFinancial(containerFinancial,business,network,enterprise,organization,account);
        containerFinancial.add("agentFinancial", agentFinancial);
        CardLayout layout = (CardLayout) containerFinancial.getLayout();
        layout.next(containerFinancial); 
    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        containerPlayerTransfer = new javax.swing.JPanel();
        containerEva = new javax.swing.JPanel();
        containerFinancial = new javax.swing.JPanel();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        containerPlayerTransfer.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Player Transfer", containerPlayerTransfer);

        containerEva.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Player Evaluation", containerEva);

        containerFinancial.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("My Financial", containerFinancial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        AgentFinancial agentFinancial = new AgentFinancial(containerFinancial,business,network,enterprise,organization,account);
        containerFinancial.add("agentFinancial", agentFinancial);
        CardLayout layout = (CardLayout) containerFinancial.getLayout();
        layout.next(containerFinancial); 
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerEva;
    private javax.swing.JPanel containerFinancial;
    private javax.swing.JPanel containerPlayerTransfer;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
