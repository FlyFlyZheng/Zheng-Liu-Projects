/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Enterprise;

import System.Organization.Organization;
import System.Organization.OrganizationDirectory;

/**
 *
 * @author liufulai
 */
public abstract class Enterprise extends Organization implements java.io.Serializable{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    public enum EnterpriseType{
        AgentCompany("Agent Company"),
        Club("Club"),
        EvaluatingCompany("Evaluating Company"),
        Labor("Labor");
    
    private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }   
    
        EnterpriseType(String value){
           this.value = value;
        }
        
        public String toString(){
            return value;
        }
    }

    public Enterprise(String name, EnterpriseType type) {
        super(name, null);
        organizationDirectory = new OrganizationDirectory();
        this.enterpriseType = type;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    
    
}
