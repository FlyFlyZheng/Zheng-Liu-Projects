/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.Message.MessageDirectory;
import System.Player.Player;
import java.util.Date;

/**
 *
 * @author liufulai
 */
public class TransferRequest extends WorkRequest implements java.io.Serializable{
    
    private Player player;
    private int clubPrice;
    private int agentPrice;
    private int playerSalary;
    private String TransferStart;
    private String TransferEnd;
    private MessageDirectory clubMessageLog;
    private boolean laborPermit;
    private MessageDirectory ClubAdditionalItem;
    private MessageDirectory AgentAdditionalItem;
    
    
    

    public TransferRequest() {
        super(WorkRequestType.TransferRequest);
        clubMessageLog = new MessageDirectory();
        ClubAdditionalItem = new MessageDirectory();
        AgentAdditionalItem = new MessageDirectory();
        laborPermit = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getClubPrice() {
        return clubPrice;
    }

    public void setClubPrice(int clubPrice) {
        this.clubPrice = clubPrice;
    }

    public int getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(int agentPrice) {
        this.agentPrice = agentPrice;
    }

    
    public String getTransferStart() {
        return TransferStart;
    }

    public void setTransferStart(String TransferStart) {
        this.TransferStart = TransferStart;
    }

    public String getTransferEnd() {
        return TransferEnd;
    }

    public void setTransferEnd(String TransferEnd) {
        this.TransferEnd = TransferEnd;
    }

    public int getPlayerSalary() {
        return playerSalary;
    }

    public void setPlayerSalary(int playerSalary) {
        this.playerSalary = playerSalary;
    }

    public MessageDirectory getClubMessageLog() {
        return clubMessageLog;
    }

    public void setClubMessageLog(MessageDirectory clubMessageLog) {
        this.clubMessageLog = clubMessageLog;
    }

    public boolean isLaborPermit() {
        return laborPermit;
    }

    public void setLaborPermit(boolean laborPermit) {
        this.laborPermit = laborPermit;
    }

    public MessageDirectory getClubAdditionalItem() {
        return ClubAdditionalItem;
    }

    public void setClubAdditionalItem(MessageDirectory ClubAdditionalItem) {
        this.ClubAdditionalItem = ClubAdditionalItem;
    }

    public MessageDirectory getAgentAdditionalItem() {
        return AgentAdditionalItem;
    }

    public void setAgentAdditionalItem(MessageDirectory AgentAdditionalItem) {
        this.AgentAdditionalItem = AgentAdditionalItem;
    }
    
    
    
    
    
    
}
