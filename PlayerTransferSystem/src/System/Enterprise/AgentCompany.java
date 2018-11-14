/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Enterprise;

import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class AgentCompany extends Enterprise implements java.io.Serializable{

    public AgentCompany(String name) {
        super(name, EnterpriseType.AgentCompany);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
