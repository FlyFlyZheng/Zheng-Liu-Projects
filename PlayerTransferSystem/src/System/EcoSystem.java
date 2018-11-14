/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.Role.Role;
import System.Role.System.*;
import System.UserAccount.UserAccount;
import System.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author liufulai，luoxiao,liyang
 */
public class EcoSystem extends Organization implements java.io.Serializable{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private UserAccountDirectory masterUserAccountDirectory;
    
    
    public static EcoSystem getInstance(){
        
        if(business == null){
            business = new EcoSystem();          
        }        
        return business;
        
    }

    public EcoSystem() {
        super(null,null);
        networkList = new ArrayList<Network>();
        masterUserAccountDirectory = new UserAccountDirectory();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createNetwork(String name){
        Network n = new Network();
        n.setName(name);
        this.networkList.add(n);
        return n;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new SystemAdminRole());
       roleList.add(new SystemFinancialAdmin());
       return roleList;
    }
    
    public boolean checkIfUserNameIsUnique(String name){
        return this.getUserAccountDirectory().checkIfUsernameIsUnique(name);
    }    

    public UserAccountDirectory getMasterUserAccountDirectory() {
        return masterUserAccountDirectory;
    }

    public void setMasterUserAccountDirectory(UserAccountDirectory masterUserAccountDirectory) {
        this.masterUserAccountDirectory = masterUserAccountDirectory;
    }
    
    public int refereshMasterUserAccount (){
        ArrayList<UserAccount> copy = (ArrayList<UserAccount>)this.masterUserAccountDirectory.getUserAccountList().clone();
        for(UserAccount us : copy){
            this.masterUserAccountDirectory.getUserAccountList().remove(us);
        }
        //Add a business user account
        for(UserAccount ua: EcoSystem.getInstance().getUserAccountDirectory().getUserAccountList()){
            this.masterUserAccountDirectory.getUserAccountList().add(ua);
        }
        for(Network n : EcoSystem.getInstance().getNetworkList()){
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                for(UserAccount ua: e.getUserAccountDirectory().getUserAccountList()){
                    this.masterUserAccountDirectory.getUserAccountList().add(ua);
                }
                for(Organization org : e.getOrganizationDirectory().getOrganizationList())
                    for(UserAccount ua: org.getUserAccountDirectory().getUserAccountList()){
                        this.masterUserAccountDirectory.getUserAccountList().add(ua);
                }
            }
        }
        return this.masterUserAccountDirectory.getUserAccountList().size();
    }
    
    public Organization locateUser(String username){
        UserAccount userAccount = new UserAccount();
        userAccount = EcoSystem.getInstance().getUserAccountDirectory().findUserWithUsername(username);
        
        Network inNetwork = null;
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        
        if(userAccount == null){        
            //Step2: Go inside each network and check  each enterprise;
            for(Network network: networkList){
                for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount = enterprise.getUserAccountDirectory().findUserWithUsername(username);                
                    //System.out.println(network.getName());
                    if(userAccount == null){
                        //step3: check against each organization inside enterprise:
                        for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()){
                            userAccount = organization.getUserAccountDirectory().findUserWithUsername(username);                           
                            if(userAccount != null){       
                                inNetwork = network;                                
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                return inOrganization;                                
                            }
                        }
                    }
                    else{
                        inEnterprise = enterprise;
                        inNetwork = network;
                        return inEnterprise;                      
                    }
                    if(inOrganization != null){
                        break;
                    }
                }
                if(inEnterprise != null){
                    break;
                }
            }           
        }
        
        if(userAccount == null){
            return null;
        }
        else{
            return business;
            //log in system admin
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
