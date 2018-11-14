/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Organization;

import System.Employee.EmployeeDirectory;
import System.Role.Role;
import System.UserAccount.UserAccountDirectory;
import System.WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public abstract class Organization implements java.io.Serializable{
    public String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private OrganizationType organizationtype;
    private WorkQueue workQueue;
    private int organizationID;
    private static int counter=1;
    
    
    public enum OrganizationType{
        //Different Organization Type
        ClubAdminOrganization("Club Admin Organization"),
        ClubContractOrganization("Club Contract Organization"),
        ClubFinanicalOrganization("Clu bFinanical Organization"),
        AgentAdminOrganization("Agent Admin Organization"),
        PlayerAgentOrganization("Player Agent Organization"),
        EvaluatingCompanyAdminOrganization("Evaluating Company Admin Organization"),
        EvaluatingCompanyFinancialOrganization("Evaluating Company Financial Organization"),
        EvaluatingEmployeeOrganization("Evaluating Employee Organization"),
        PlayerDataAnalysisOrganization("Player Data Analysis Organization"),
        LaborStaffOrganization("Labor Staff Organization");
        
        
        public String value;

        private OrganizationType(String v) {
            this.value = v;
        }

        public String getValue() {
            return value;
        }
     
    }

    public Organization(String name, OrganizationType type){
        this.name = name;
        this.organizationtype = type;     
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        workQueue = new WorkQueue();
        counter++;
    }
    
    
    //abstract method
    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public OrganizationType getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(OrganizationType organizationtype) {
        this.organizationtype = organizationtype;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    
    
    @Override
    public String toString() {
        return name;
    }

    
    
    
}
