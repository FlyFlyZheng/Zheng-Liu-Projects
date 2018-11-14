/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.ClubOrganization;

import System.Organization.Organization;
import System.Role.Club.ClubAdminRole;
import System.Role.Role;
import System.Role.System.SystemAdminRole;
import System.Role.System.SystemFinancialAdmin;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class ClubAdmin extends Organization implements java.io.Serializable{

    public ClubAdmin(String name) {
        super(name, OrganizationType.ClubAdminOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new ClubAdminRole());
       return roleList;
    }
    
}
