/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import System.ConfigureASystem;
import System.EcoSystem;
import System.Network.Network;
import System.UserAccount.UserAccount;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liufulai
 */
public class Client {
    private final static Logger logger = Logger.getLogger(Client.class.getName()); 
    private String type;
    
    
    public Client(String type) throws Exception {
        this.type = type;
       Socket socket = null;  
       ObjectOutputStream os = null;  
       ObjectInputStream is = null;  
              
       try { 
           socket = new Socket("localhost", 10000);
           System.out.println("I AM HERE");
           //update
           if(this.type.equals("update")){               
               os = new ObjectOutputStream(socket.getOutputStream());                      
               os.writeObject("update");
               os.flush();
               
               is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
               Object result = (Object)is.readObject();
               String result1 = (String)result;
               
               if(result1.equalsIgnoreCase("update")){
                   os = new ObjectOutputStream(socket.getOutputStream());  
                   EcoSystem system = EcoSystem.getInstance();
                   //System.out.println("Client: system num " + system.getNetworkList().size());  
                   os.writeObject(system);  
                   os.flush();  
                   
                   is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
                   Object feedback = (Object)is.readObject(); 
                   String Feedback = (String) feedback;
                   System.out.println(Feedback);
               }
           }
           if(this.type.equals("download")){
               os = new ObjectOutputStream(socket.getOutputStream());                      
               os.writeObject("download");
               os.flush();
               
               is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
               Object result = (Object)is.readObject();
               String result1 = (String)result;
               
               if(result1.equalsIgnoreCase("download")){
                    Object system = (Object)is.readObject();
                    EcoSystem business = (EcoSystem) system;                   
                    EcoSystem b = EcoSystem.getInstance();
                    ArrayList<Network> copyNetwork = (ArrayList<Network>)b.getNetworkList().clone();
                    ArrayList<UserAccount> copyMasterUserAccount = (ArrayList<UserAccount>)b.getMasterUserAccountDirectory().getUserAccountList().clone();
                    for(Network n : copyNetwork){
                        b.getNetworkList().remove(n);
                    }
                    for(Network n:business.getNetworkList()){
                        b.getNetworkList().add(n);
                    }
                    for(UserAccount ua: copyMasterUserAccount){
                        b.getMasterUserAccountDirectory().getUserAccountList().remove(ua);
                    }
                    for(UserAccount ua: business.getMasterUserAccountDirectory().getUserAccountList()){
                        b.getMasterUserAccountDirectory().getUserAccountList().add(ua);
                    }
                    
                    os = new ObjectOutputStream(socket.getOutputStream());  
                    String string1 = "download successfully";
                    os.writeObject(string1);
                    os.flush();
                    
                    System.out.println("[Client Business]"+"network num: "+EcoSystem.getInstance().getNetworkList().size());
                    System.out.println("[Client Business]"+"UserAccount num: "+EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().size());

               }
           }            
       }catch(IOException ex) {  
           logger.log(Level.SEVERE, null, ex);                  
       } finally { 
           try { 
               is.close();  
           } catch(Exception ex) {}  
           try {  
               os.close();  
           } catch(Exception ex) {}  
           try {  
               socket.close();  
           } catch(Exception ex) {}  
       }
    }
    /**   
    public static void main(String[] args) throws Exception{
       new UpdateClient("update");
      //new UpdateClient("download");
    }**/
        
       
    
}
