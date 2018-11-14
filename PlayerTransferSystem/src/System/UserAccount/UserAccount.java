/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.UserAccount;

import System.Employee.Employee;
import System.Player.PlayerDirectory;
import System.Role.Role;
import System.WorkRequest.WorkQueue;

/**
 *
 * @author liufulai
 */
public class UserAccount implements java.io.Serializable{
    private String username;
    private String password;
    private Employee employee;
    private PlayerDirectory playerDirectory;
    private Role role;
    private WorkQueue workQueue;
    private int personRevenue;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public UserAccount() {
        playerDirectory = new PlayerDirectory();
        this.workQueue = new WorkQueue();
    }

    public int getPersonRevenue() {
        return personRevenue;
    }

    public void setPersonRevenue(int personRevenue) {
        this.personRevenue = personRevenue;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public String toString(){
        return this.username;
    }

    public PlayerDirectory getPlayerDirectory() {
        return playerDirectory;
    }

    public void setPlayerDirectory(PlayerDirectory playerDirectory) {
        this.playerDirectory = playerDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    
    
    
    
    
    
    
}
