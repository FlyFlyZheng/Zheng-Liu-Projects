/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Enterprise;

import System.Player.PlayerDirectory;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class Club extends Enterprise implements java.io.Serializable{
    
    private PlayerDirectory playerDirectory;
    private double revenue;
    private String path;

    public Club(String name) {
        super(name, EnterpriseType.Club);
        playerDirectory = new PlayerDirectory();

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public PlayerDirectory getPlayerDirectory() {
        return playerDirectory;
    }

    public void setPlayerDirectory(PlayerDirectory playerDirectory) {
        this.playerDirectory = playerDirectory;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    
     @Override
    public String toString() {
        return name;
    }
    
    
}
