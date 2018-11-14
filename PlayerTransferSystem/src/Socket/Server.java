/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;
import System.EcoSystem;
import System.Network.Network;
import System.UserAccount.UserAccount;
import java.io.*;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.ArrayList;
import java.util.logging.Level;  
import java.util.logging.Logger; 
/**
 *
 * @author liufulai
 */
public class Server {
    private final static Logger logger = Logger.getLogger(Server.class.getName()); 
    
   public static void main(String[] args) throws IOException{
        // TODO code application logic here
        ServerSocket updateserver = new ServerSocket(10000); 
        ServerSocket downloadserver = new ServerSocket(10001);
  
        while (true) {  
            Socket updatesocket = updateserver.accept();  
            update(updatesocket);              
            System.out.println("a client has been connected");
        }  
    }
    
    private static void update(final Socket socket) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                ObjectInputStream is = null;  
                ObjectOutputStream os = null;  
                try { 
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); 
                    Object result = (Object)is.readObject();
                    String action = (String)result;                    

                    if(action.equalsIgnoreCase("update")){
                        
                        os = new ObjectOutputStream(socket.getOutputStream());  
                        String str = "update";
                        os.writeObject(str);
                        os.flush();
                        
                        is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); 
                        Object system = (Object)is.readObject();
                        EcoSystem business = (EcoSystem) system;
                        ArrayList<Network> copyNetwork = (ArrayList<Network>) EcoSystem.getInstance().getNetworkList().clone();
                        ArrayList<UserAccount> copyMasterUserAccount = (ArrayList<UserAccount>)EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().clone();
                        EcoSystem originalSystem = EcoSystem.getInstance();
                        for(Network n : copyNetwork){
                            originalSystem.getNetworkList().remove(n);
                        }
                        for(Network n:business.getNetworkList()){
                            originalSystem.getNetworkList().add(n);
                        }
                        for(UserAccount ua: copyMasterUserAccount){
                            originalSystem.getMasterUserAccountDirectory().getUserAccountList().remove(ua);
                        }
                        for(UserAccount ua: business.getMasterUserAccountDirectory().getUserAccountList()){
                            originalSystem.getMasterUserAccountDirectory().getUserAccountList().add(ua);
                        }
                        
                       os = new ObjectOutputStream(socket.getOutputStream());  
                       os.writeObject("Update Successfully");
                       os.flush();
                       System.out.println("[Server Business]"+"network num: "+EcoSystem.getInstance().getNetworkList().size());
                       System.out.println("[Server Business]"+"UserAccount num: "+EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().size());

                    }
                    if(action.equalsIgnoreCase("download")){
                        
                       os = new ObjectOutputStream(socket.getOutputStream());  
                       String str = "download";
                       os.writeObject(str);
                       os.flush();
                                         
                       os.writeObject(EcoSystem.getInstance());  
                       os.flush();  
                       
                       is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
                       Object feedback = (Object)is.readObject(); 
                       String Feedback = (String) feedback;
                       System.out.println(Feedback);
                    }
                    
                    
                    
                           
                   
                   
                } catch (IOException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } catch(ClassNotFoundException ex) {  
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
        }).start();  
    }
    
    private static void download(final Socket socket) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                ObjectInputStream is = null;  
                ObjectOutputStream os = null;  
                try {  
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); 
                    os = new ObjectOutputStream(socket.getOutputStream());  
                    
                    Object system = (Object)is.readObject();
                    EcoSystem business = (EcoSystem) system;
                    System.out.println("business network num: "+business.getNetworkList().size());
                    
                   Network n1 = new Network();
                   n1.setName("asia");
                   business.getNetworkList().add(n1);
                   os.writeObject(business);
                   os.flush();
             
                   
                   
                } catch (IOException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } catch(ClassNotFoundException ex) {  
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
        }).start();  
    }
}
