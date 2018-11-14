/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class EnterpriseDirectory implements java.io.Serializable{
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    //create Enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(type == Enterprise.EnterpriseType.AgentCompany){
            enterprise = (AgentCompany)new AgentCompany(name);
            this.enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Club){
            enterprise = (Club)new Club(name);
            this.enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.EvaluatingCompany){
            enterprise = (EvaluatingCompany)new EvaluatingCompany(name);
            this.enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Labor){
            enterprise = (Labor)new Labor(name);
            this.enterpriseList.add(enterprise);
        }   
        return enterprise;
        
    }
    
    
    
    
    
}
