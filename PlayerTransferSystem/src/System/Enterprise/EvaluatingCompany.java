/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Enterprise;

import System.Game.GameDirectory;
import System.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class EvaluatingCompany extends Enterprise implements java.io.Serializable{
   
    
    private GameDirectory gameDirectory;
    private int basicPriceOfSingle;
    private int basicPriceofList;
    
    
    public EvaluatingCompany(String name) {
        super(name, EnterpriseType.EvaluatingCompany);
        this.gameDirectory = new GameDirectory();
        basicPriceOfSingle = 1000;
        basicPriceofList = 1000;
    }

    public GameDirectory getGameDirectory() {
        return gameDirectory;
    }
    
    public void setGameDirectory(GameDirectory gameDirectory) {
        this.gameDirectory = gameDirectory;
    }

    public int getBasicPriceOfSingle() {
        return basicPriceOfSingle;
    }

    public void setBasicPriceOfSingle(int basicPriceOfSingle) {
        this.basicPriceOfSingle = basicPriceOfSingle;
    }

    public int getBasicPriceofList() {
        return basicPriceofList;
    }

    public void setBasicPriceofList(int basicPriceofList) {
        this.basicPriceofList = basicPriceofList;
    }
    
    
    
       
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
