/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import System.EcoSystem;
import UserInterface.MainJFrame;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liufulai
 */
public class DownloadThread implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
            new Client("download");
            } catch (Exception ex) {
               Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Download finished:");
            System.out.println("Network: "+EcoSystem.getInstance().getNetworkList().size());
            System.out.println("UserAccount: "+EcoSystem.getInstance().getMasterUserAccountDirectory().getUserAccountList().size());
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(DownloadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
