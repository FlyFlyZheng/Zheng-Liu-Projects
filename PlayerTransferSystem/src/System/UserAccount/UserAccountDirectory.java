/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.UserAccount;

import System.EcoSystem;
import System.Employee.Employee;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class UserAccountDirectory implements java.io.Serializable{
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    //Authenticate User
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount findUserWithUsername(String username){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username)){
                return ua;
            }
        return null;
    }
    
    //Create UserAccount
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
          
        if(!this.checkIfUsernameIsUnique(username)){
           
         System.out.println("After create a userAccount with error : "+ EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().size());
         return null;
        }
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        EcoSystem.getInstance().refereshMasterUserAccount();
        
      System.out.println("After create a userAccount with success : "+ EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().size());
     
        return userAccount;
        
    }
    
    //Check if user name is unique
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList()){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    
  
    
    
}
