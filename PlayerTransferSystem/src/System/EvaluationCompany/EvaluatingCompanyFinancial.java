/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.EvaluationCompany;

import System.Organization.Organization;
import System.Role.Evaluation.EvaluationFinanical;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class EvaluatingCompanyFinancial extends Organization implements java.io.Serializable{

    public EvaluatingCompanyFinancial(String name) {
        super(name, OrganizationType.EvaluatingCompanyFinancialOrganization);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new EvaluationFinanical());
       return roleList;
    }
}
