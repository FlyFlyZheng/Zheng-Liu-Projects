/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.EvaluationReport.ListEvaluationReport;
import System.Player.PlayerDirectory;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class FindPlayerListRequest extends WorkRequest implements java.io.Serializable{
    
    private ListEvaluationReport report;

    public FindPlayerListRequest() {
        super(WorkRequestType.FindPlayerListRequest);
        
    }

   

    public ListEvaluationReport getReport() {
        return report;
    }

    public void setReport(ListEvaluationReport report) {
        this.report = report;
    }

    
    
    
    
    
    
    
    
    
}
