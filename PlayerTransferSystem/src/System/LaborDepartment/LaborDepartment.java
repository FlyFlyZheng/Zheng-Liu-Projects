/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.LaborDepartment;

import System.Organization.Organization;
import System.Role.Evaluation.EvaluationEmployee;
import System.Role.Labor.LaborStaff;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class LaborDepartment extends Organization implements java.io.Serializable{

    public LaborDepartment(String name) {
        super(name, OrganizationType.LaborStaffOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new LaborStaff());
       return roleList;
    }
    
    
}
