/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Player;

import System.Player.Player.PlayerType;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class PlayerDirectory implements java.io.Serializable{
    private ArrayList<Player> playerList;

    public PlayerDirectory() {
        this.playerList = new ArrayList<Player>();       
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
    
    public Player CreatePlayer(String name, PlayerType type){
        Player p = null;
        if(type.equals(Player.PlayerType.Striker)){
            p = new Player(PlayerType.Striker);
            p.setName(name);
            this.playerList.add(p);
        }
        else if(type.equals(Player.PlayerType.Midfielder)){
            p = new Player(PlayerType.Midfielder);
            p.setName(name);
            this.playerList.add(p);
        }
        else if(type.equals(Player.PlayerType.Defender)){
            p = new Player(PlayerType.Defender);
            p.setName(name);
            this.playerList.add(p);
        }
        else if(type.equals(Player.PlayerType.Goalkeeper)){
            p = new Player(PlayerType.Goalkeeper);
            p.setName(name);
            this.playerList.add(p);
        }
        return p;
    }
    
    
    
    
    
}
