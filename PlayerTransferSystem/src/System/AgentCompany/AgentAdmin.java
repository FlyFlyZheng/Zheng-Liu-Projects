/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AgentCompany;

import System.Organization.Organization;
import System.Role.Agent.AgentAdminRole;
import System.Role.Club.ClubAdminRole;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class AgentAdmin extends Organization implements java.io.Serializable{

    public AgentAdmin(String name) {
        super(name, OrganizationType.AgentAdminOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new AgentAdminRole());
       return roleList;
    }
    
    
}
