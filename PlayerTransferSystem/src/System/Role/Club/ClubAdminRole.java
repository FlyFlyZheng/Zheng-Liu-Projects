/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Role.Club;

import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.Role.Role;
import System.UserAccount.UserAccount;
import UserInterface.ClubAdmin.*;
import javax.swing.JPanel;

/**
 *
 * @author liufulai
 */
public class ClubAdminRole extends Role implements java.io.Serializable{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new ClubAdminWorkArea(userProcessContainer,account, network, enterprise, business);
    }
}
