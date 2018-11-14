/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.EvaluationReport.PlayerEvalutionReport;
import System.Player.Player;

/**
 *
 * @author liufulai
 */
public class EvaluateAPlayerRequest extends WorkRequest implements java.io.Serializable{
    private Player player;
    private PlayerEvalutionReport report;

    public EvaluateAPlayerRequest() {
        super(WorkRequestType.EvaluateAPlayerRequest);
        report = new PlayerEvalutionReport();       
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerEvalutionReport getReport() {
        return report;
    }

    public void setReport(PlayerEvalutionReport report) {
        this.report = report;
    }
    
    
}
