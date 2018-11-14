/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Message;

import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class MessageDirectory implements java.io.Serializable{
    private ArrayList<Message> messageList;

    public MessageDirectory() {
        this.messageList = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }
    
    private Message AddMessage(){
        Message m = new Message();
        this.messageList.add(m);
        return m;
    }
    
}
