/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Organization;

import System.AgentCompany.*;
import System.ClubOrganization.*;
import System.Enterprise.*;
import System.Enterprise.Enterprise;
import System.EvaluationCompany.*;
import System.LaborDepartment.LaborDepartment;
import System.Organization.Organization.OrganizationType;
import System.Role.Labor.LaborStaff;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class OrganizationDirectory implements java.io.Serializable{
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    
    
    //create Organization type
    public Organization createOrganization(String name, OrganizationType type){
        Organization o = null;
        if(type == Organization.OrganizationType.AgentAdminOrganization){
            o = (AgentAdmin)new AgentAdmin(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.PlayerAgentOrganization){
            o = (PlayerAgentOrganization)new PlayerAgentOrganization(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.ClubAdminOrganization){
            o = (ClubAdmin)new ClubAdmin(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.ClubContractOrganization){
            o = (ClubContract)new ClubContract(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.ClubFinanicalOrganization){
            o = (ClubFinancial)new ClubFinancial(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.EvaluatingCompanyAdminOrganization){
            o = (EvaluatingCompanyAdmin)new EvaluatingCompanyAdmin(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.EvaluatingCompanyFinancialOrganization){
            o = (EvaluatingCompanyFinancial)new EvaluatingCompanyFinancial(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.EvaluatingEmployeeOrganization){
            o = (EvaluatingEmployee)new EvaluatingEmployee(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.PlayerDataAnalysisOrganization){
            o = (PlayerDataAnalysis)new PlayerDataAnalysis(name);
            this.organizationList.add(o);
        }
        if(type == Organization.OrganizationType.LaborStaffOrganization){
            o = (LaborDepartment)new LaborDepartment(name);
            this.organizationList.add(o);
        }
        
        
        return o;
    }
    
}
