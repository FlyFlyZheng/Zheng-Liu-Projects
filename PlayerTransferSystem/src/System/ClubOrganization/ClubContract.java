/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.ClubOrganization;

import System.Organization.Organization;
import System.Role.Club.ClubAdminRole;
import System.Role.Club.ClubContractManager;
import System.Role.Role;
import static System.Role.Role.RoleType.ClubContractManager;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class ClubContract extends Organization implements java.io.Serializable{

    public ClubContract(String name) {
        super(name, OrganizationType.ClubContractOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new ClubContractManager());
       return roleList;
    }
    
}
