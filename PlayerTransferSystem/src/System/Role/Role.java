/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Role;

import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author liufulai
 */
public abstract class Role implements java.io.Serializable {
    
     public enum RoleType{
        AgentAdmin("Agent Admin"), 
        PlayerAgent("Player Agent"), 
        ClubAdmin("Club Admin"),
        ClubContractManager("Club Contract Manager"),
        ClubFinancialManager("Club Financial Manager"),
        EvaluationAdmin("Evaluation Admin"),
        EvaluationDataAnalysis("Evaluation Data Analysis"),
        EvaluationEmployee("Evaluation Employee"),
        EvaluationFinancial("Evaluation Financial"),
        SystemAdmin("System Admin"),
        SystemFinancialAdmin("System Financial Admin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }
 
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
     public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network,
            EcoSystem business );
    
     
     @Override
     public String toString() {
        return this.getClass().getName();
    }
}
