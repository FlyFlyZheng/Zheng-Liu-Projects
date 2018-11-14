/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.Network.Network;
import System.Player.Player;

/**
 *
 * @author liufulai
 */
public class LaborPermitRequest extends WorkRequest implements java.io.Serializable{
    private Player player;
    private Network destNetwork;
    private boolean result;

    public LaborPermitRequest() {
        super(WorkRequestType.LaborPermitRequest);
        result = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Network getDestNetwork() {
        return destNetwork;
    }

    public void setDestNetwork(Network destNetwork) {
        this.destNetwork = destNetwork;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    
    
}
