/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;
import System.EcoSystem;
import System.Organization.Organization;
import System.Network.*;
import System.Enterprise.*;
import System.DB4OUtil.*;
import System.UserAccount.UserAccount;
import UserInterface.BGPanel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import UserInterface.*;
/**
 *
 * @author victor
 */
public class SystemAdminWorkAreaJPanel extends BGPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel container;
    EcoSystem business;
    UserAccount account;
    
    public SystemAdminWorkAreaJPanel(JPanel container, UserAccount account, EcoSystem business) {
        initComponents();
        this.container = container;
        this.business = business;
        this.account=account;
        populateTree();
        labAccount.setText(account.getUsername());
        
    }
    /**
    public void ConfigBackground(){
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/Users/liufulai/buptno1/FinalProject/src/resource/background.jpg"));
        JLabel lab =new JLabel(ii); 
        lab.setBounds(0, 0, this.RightJPanel.getWidth(), this.RightJPanel.getWidth());
        this.RightJPanel.add(lab);
    }**/
    public void populateTree(){
        
        DefaultTreeModel model = (DefaultTreeModel) treeSystem.getModel();
        
        ArrayList<Network> networkList = business.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i =0; i<networkList.size(); i++){
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size(); j++){
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                
                for(int k=0; k<organizationList.size(); k++){
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }              
            }
        }
        model.reload();
              
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        SplitJPanel = new javax.swing.JSplitPane();
        LeftJPanel = new BGPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeSystem = new javax.swing.JTree();
        RightJPanel = new BGPanel();
        btnNetwork = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnEnterprise = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNode = new javax.swing.JTextField();
        btnAdmin1 = new javax.swing.JButton();
        labAccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        treeSystem.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeSystemValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeSystem);

        javax.swing.GroupLayout LeftJPanelLayout = new javax.swing.GroupLayout(LeftJPanel);
        LeftJPanel.setLayout(LeftJPanelLayout);
        LeftJPanelLayout.setHorizontalGroup(
            LeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        LeftJPanelLayout.setVerticalGroup(
            LeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        SplitJPanel.setLeftComponent(LeftJPanel);

        RightJPanel.setBackground(new java.awt.Color(255, 255, 255));
        RightJPanel.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N

        btnNetwork.setBackground(new java.awt.Color(204, 204, 204));
        btnNetwork.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        btnNetwork.setForeground(new java.awt.Color(153, 153, 153));
        btnNetwork.setText("Manage Network");
        btnNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetworkActionPerformed(evt);
            }
        });

        btnAdmin.setText("ManageEnterpriseAdmin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnEnterprise.setText("ManageEnterprise");
        btnEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterpriseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noteworthy", 0, 24)); // NOI18N
        jLabel1.setText("Seleted Node:");

        txtNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNodeActionPerformed(evt);
            }
        });

        btnAdmin1.setText("Add Finanical Manager");
        btnAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmin1ActionPerformed(evt);
            }
        });

        labAccount.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        labAccount.setText("<>");

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("UserAccount :");

        javax.swing.GroupLayout RightJPanelLayout = new javax.swing.GroupLayout(RightJPanel);
        RightJPanel.setLayout(RightJPanelLayout);
        RightJPanelLayout.setHorizontalGroup(
            RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightJPanelLayout.createSequentialGroup()
                .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RightJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RightJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RightJPanelLayout.createSequentialGroup()
                        .addComponent(labAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(RightJPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNode, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        RightJPanelLayout.setVerticalGroup(
            RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightJPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNode, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        SplitJPanel.setRightComponent(RightJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitJPanel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void treeSystemValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeSystemValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeSystem.getLastSelectedPathComponent();
        if(selectedNode!= null){
            txtNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_treeSystemValueChanged

    private void btnAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmin1ActionPerformed
        // TODO add your handling code here:

        AddFinancialManagerJPanel addFinancialManagerJPanel = new AddFinancialManagerJPanel(container,account, business);
        container.add("addFinancialManagerJPanel",addFinancialManagerJPanel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnAdmin1ActionPerformed

    private void txtNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNodeActionPerformed

    private void btnEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpriseActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(container, account,business);
        container.add("manageEnterpriseJPanel",manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(container);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnterpriseActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(container, account,business);
        container.add("manageEnterpriseAdminJPanel",manageEnterpriseAdminJPanel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetworkActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(container, account,business);
        container.add("manageNetworkJPanel",manageNetworkJPanel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(container);        // TODO add your handling code here:
    }//GEN-LAST:event_btnNetworkActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftJPanel;
    private javax.swing.JPanel RightJPanel;
    private javax.swing.JSplitPane SplitJPanel;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAdmin1;
    private javax.swing.JButton btnEnterprise;
    private javax.swing.JButton btnNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labAccount;
    private javax.swing.JTree treeSystem;
    private javax.swing.JTextField txtNode;
    // End of variables declaration//GEN-END:variables
}
