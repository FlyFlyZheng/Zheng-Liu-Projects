/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.WorkRequest;

import System.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author liufulai
 */

public abstract class WorkRequest implements java.io.Serializable{
    
    
    private String message;
    private WorkRequestType workRequestType;
    private UserAccount sender;
    //First Receiver: Club or Evaluaton Company
    private UserAccount FirstReceiver; 
    //Second Receiver: Agent of the player transfer process
    private UserAccount SecondReceiver; 
    //Status: Pending, Processing, Finish, Paid;
    private String status;
    private final Date requestDate;
    private Date resolveDate;
    private double totalprice;
    private int id;
    private static int count = 1;
    

    public WorkRequest(WorkRequestType Type) {
        requestDate = new Date();
        this.id=count;
        count=count+1;      
        this.setWorkRequestType(Type);
        this.status = "pending";
    }
    
    public enum WorkRequestType{
        //Different Organization Type
        EvaluateAPlayerRequest("Evaluate A Player Request"),
        FindPlayerListRequest("Find Player List Request"),
        FreeTransferRequest("Free Transfer Request"),
        LoanRequest("Loan Request"),
        TransferRequest("Transfer Request"),
        LaborPermitRequest("Labor Permit Request");
            
        public String value;

        private WorkRequestType(String v){
            this.value = v;
        }

        public String getValue() {
            return value;
        }
     
    }

    public void setWorkRequestType(WorkRequestType workRequestType) {
        this.workRequestType = workRequestType;
    }
    
    

    public WorkRequestType getWorkRequestType() {
        return workRequestType;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public int getId() {
        return id;
    }
    
    
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getFirstReceiver() {
        return FirstReceiver;
    }

    public void setFirstReceiver(UserAccount FirstReceiver) {
        this.FirstReceiver = FirstReceiver;
    }

    public UserAccount getSecondReceiver() {
        return SecondReceiver;
    }

    public void setSecondReceiver(UserAccount SecondReceiver) {
        this.SecondReceiver = SecondReceiver;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
