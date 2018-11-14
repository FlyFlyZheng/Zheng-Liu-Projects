/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.EvaluationReport;

/**
 *
 * @author liufulai
 */
public abstract class Report implements java.io.Serializable{
    private static int count=1;
    private int reportId;

    public Report() {
        count ++;
        this.reportId = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Report.count = count;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
    
}
