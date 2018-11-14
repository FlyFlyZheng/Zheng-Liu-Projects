/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.ClubOrganization;

import System.Organization.Organization;
import System.Role.Club.ClubContractManager;
import System.Role.Club.ClubFinancialManager;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class ClubFinancial extends Organization implements java.io.Serializable{

    public ClubFinancial(String name) {
        super(name, OrganizationType.ClubFinanicalOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new ClubFinancialManager());
       return roleList;
    }
    
}
