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
public class FreeTransferRequest extends WorkRequest implements java.io.Serializable{
    private Player player;
    private Date TransferStart;
    private Date TransferEnd;
    private int agentPrice;
    private int playerSalary;
    private MessageDirectory AgentAdditionalItem;
    private boolean laborPermit;

    public FreeTransferRequest() {
        super(WorkRequestType.FreeTransferRequest);
        AgentAdditionalItem = new MessageDirectory();
        laborPermit = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getTransferStart() {
        return TransferStart;
    }

    public void setTransferStart(Date TransferStart) {
        this.TransferStart = TransferStart;
    }

    public Date getTransferEnd() {
        return TransferEnd;
    }

    public void setTransferEnd(Date TransferEnd) {
        this.TransferEnd = TransferEnd;
    }

    public int getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(int agentPrice) {
        this.agentPrice = agentPrice;
    }

    public int getPlayerSalary() {
        return playerSalary;
    }

    public void setPlayerSalary(int playerSalary) {
        this.playerSalary = playerSalary;
    }

    public MessageDirectory getAgentAdditionalItem() {
        return AgentAdditionalItem;
    }

    public void setAgentAdditionalItem(MessageDirectory AgentAdditionalItem) {
        this.AgentAdditionalItem = AgentAdditionalItem;
    }

    public boolean isLaborPermit() {
        return laborPermit;
    }

    public void setLaborPermit(boolean laborPermit) {
        this.laborPermit = laborPermit;
    }
    
    
    
    
}
