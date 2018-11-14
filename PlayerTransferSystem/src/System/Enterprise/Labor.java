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
public class Labor extends Enterprise implements java.io.Serializable{
    
    public Labor(String name) {
        super(name, EnterpriseType.Labor);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
