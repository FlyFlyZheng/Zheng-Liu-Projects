/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.EvaluationCompany;

import System.Organization.Organization;
import System.Role.Agent.PlayerAgentRole;
import System.Role.Evaluation.EvaluationAdmin;
import System.Role.Role;
import static System.Role.Role.RoleType.EvaluationAdmin;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class EvaluatingCompanyAdmin extends Organization implements java.io.Serializable{

    public EvaluatingCompanyAdmin(String name) {
        super(name, OrganizationType.EvaluatingCompanyAdminOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new EvaluationAdmin());
       return roleList;
    }
}
