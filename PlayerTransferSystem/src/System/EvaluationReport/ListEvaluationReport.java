/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.EvaluationReport;

import System.Player.Player;
import System.Player.PlayerDirectory;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class ListEvaluationReport extends Report implements java.io.Serializable{
    private PlayerDirectory playerList;

    public ListEvaluationReport() {
        this.playerList = new  PlayerDirectory();
    }

    public PlayerDirectory getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerDirectory playerList) {
        this.playerList = playerList;
    }
    
    
    
    
    
    
}
