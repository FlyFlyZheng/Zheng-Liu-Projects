/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AgentCompany;

import System.Organization.Organization;
import System.Role.Agent.AgentAdminRole;
import System.Role.Agent.PlayerAgentRole;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class PlayerAgentOrganization extends Organization implements java.io.Serializable{

    public PlayerAgentOrganization(String name) {
        super(name, OrganizationType.PlayerAgentOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new PlayerAgentRole());
       return roleList;
    }
    
}
