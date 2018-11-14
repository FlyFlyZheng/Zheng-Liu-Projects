/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Message;

import System.UserAccount.UserAccount;

/**
 *
 * @author liufulai
 */
public class Message implements java.io.Serializable{
    private String message;
    private UserAccount messageSender;
    private int id;
    private static int count = 0;
    

    public String getMessage() {
        id = count;
        count ++;
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(UserAccount messageSender) {
        this.messageSender = messageSender;
    }

    public int getId() {
        return id;
    }
    
    public String toString(){
        return this.message;
    }
    
    
    
    
    
    
}
