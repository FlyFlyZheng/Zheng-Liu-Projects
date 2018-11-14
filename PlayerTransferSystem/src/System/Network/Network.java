/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Network;

import System.Message.Message;
import System.Enterprise.EnterpriseDirectory;
import System.Game.GameDirectory;
import System.Message.MessageDirectory;
import System.Player.PlayerDirectory;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class Network implements java.io.Serializable{
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private PlayerDirectory playerDirectory;
    private GameDirectory gameDirectory;
    private MessageDirectory boardcastMessageDirectory;
    
    
    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        this.playerDirectory = new PlayerDirectory();
        this.gameDirectory = new GameDirectory();
        boardcastMessageDirectory = new MessageDirectory();
    }

    public GameDirectory getGameDirectory() {
        return gameDirectory;
    }

    public void setGameDirectory(GameDirectory gameDirectory) {
        this.gameDirectory = gameDirectory;
    }

    public MessageDirectory getBoardcastMessageDirectory() {
        return boardcastMessageDirectory;
    }

    public void setBoardcastMessageDirectory(MessageDirectory boardcastMessageDirectory) {
        this.boardcastMessageDirectory = boardcastMessageDirectory;
    }

    
    



    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public PlayerDirectory getPlayerDirectory() {
        return playerDirectory;
    }

    public void setPlayerDirectory(PlayerDirectory playerDirectory) {
        this.playerDirectory = playerDirectory;
    }
    
    
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
    
    
    
}
