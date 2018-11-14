/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.AgentCompany.AgentAdmin;
import System.AgentCompany.PlayerAgentOrganization;
import System.ClubOrganization.ClubAdmin;
import System.ClubOrganization.ClubContract;
import System.ClubOrganization.ClubFinancial;
import System.EvaluationCompany.EvaluatingCompanyAdmin;
import System.EvaluationCompany.EvaluatingCompanyFinancial;
import System.EvaluationCompany.EvaluatingEmployee;
import System.EvaluationCompany.PlayerDataAnalysis;
import System.LaborDepartment.LaborDepartment;
import System.Organization.Organization;
import System.WorkRequest.WorkRequest.WorkRequestType;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class WorkQueue implements java.io.Serializable{
    
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public WorkRequest CreateWorkRequest(WorkRequestType type){
        WorkRequest wr = null;
        if(type == WorkRequestType.EvaluateAPlayerRequest){
            wr = (EvaluateAPlayerRequest)new EvaluateAPlayerRequest();
            this.workRequestList.add(wr);
        }
        if(type == WorkRequestType.FindPlayerListRequest){
            wr = (FindPlayerListRequest)new FindPlayerListRequest();
            this.workRequestList.add(wr);
        }
        if(type == WorkRequestType.FreeTransferRequest){
            wr = (FreeTransferRequest)new FreeTransferRequest();
            this.workRequestList.add(wr);
        }
        if(type == WorkRequestType.LoanRequest){
            wr = (LoanRequest)new LoanRequest();
            this.workRequestList.add(wr);
        }
        if(type == WorkRequestType.TransferRequest){
            wr = (TransferRequest)new TransferRequest();
            this.workRequestList.add(wr);
        }
        if(type == WorkRequestType.LaborPermitRequest){
            wr = (LaborPermitRequest)new LaborPermitRequest();
            this.workRequestList.add(wr);
        }       
        return wr;
         
    }
}
