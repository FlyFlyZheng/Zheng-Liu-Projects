/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;
/**
 *
 * @author liufulai
 */
import System.EcoSystem;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.Message.Message;
import System.Network.Network;
import System.Organization.Organization;
import System.Player.Player;
import System.UserAccount.UserAccount;
import System.WorkRequest.EvaluateAPlayerRequest;
import System.WorkRequest.FindPlayerListRequest;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import static System.WorkRequest.WorkRequest.WorkRequestType.EvaluateAPlayerRequest;
import java.io.ByteArrayOutputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;  
import com.itextpdf.text.pdf.PdfCopy;  
import com.itextpdf.text.pdf.PdfImportedPage;  
import com.itextpdf.text.pdf.PdfReader;  
import com.itextpdf.text.pdf.PdfStamper;  
import java.util.Date;
  
public class exportPDF {  
       
       public static void fillAPlayerEvaluation(EvaluateAPlayerRequest eva, String path) {  
        // 模板路径  
        String templatePath = "src/data/PlayerEvaluationReport.pdf";  
        String newPDFPath = path;
        
        PdfReader reader;  
        FileOutputStream out;  
        ByteArrayOutputStream bos;  
        PdfStamper stamper;  
        try {  
            out = new FileOutputStream(newPDFPath);// 输出流  
            reader = new PdfReader(templatePath);// 读取pdf模板  
            System.out.println("number of orignial page"+reader.getNumberOfPages());
            bos = new ByteArrayOutputStream();  
            stamper = new PdfStamper(reader, bos);  
            AcroFields form = stamper.getAcroFields();  
            
            System.out.println("In PDF "+ eva.getReport().getPlayerName());
            int i = 0;  
            java.util.Iterator<String> it = form.getFields().keySet().iterator();  
            
            System.out.println("At first"+eva.getPlayer().getName());
           
            String pname= eva.getReport().getPlayerName();
            String type =eva.getReport().getPlayerType().getValue();
            String club=eva.getPlayer().getClub().name;
            String agent=eva.getReport().getAgent().getUsername();
            String age=eva.getReport().getAge()+"";
            String weight=eva.getReport().getWeight()+"";
            String height =eva.getReport().getHeight()+"";      
            String skill= eva.getReport().getSkill()+"";
            String speed= eva.getReport().getSpeed()+"";
            String strengh=eva.getReport().getStrengh()+"";
            String apperance=eva.getReport().getApperence()+"";
            String shoot=eva.getReport().getShootAccuracy()+"";
            String reaction =eva.getReport().getReactionSpeed()+"";
            String ballcontrol =eva.getReport().getBallControl()+"";
            String passaccuracy= eva.getReport().getPassAccuracy()+"";
            String defence =eva.getReport().getDenfence()+"";
            String calmness =eva.getReport().getCalmness()+"";
            String potential =eva.getReport().getPotential()+"";
            String status =eva.getReport().getStatus()+"";
            String number = eva.getPlayer().getGameNumber()+"";
            String overallsocre = eva.getReport().getOverallScore()+"";
            String totalvalue =eva.getPlayer().gettotalvalue()+"";
            String basicscore =eva.getPlayer().getbasicscore()+"";
            String date =eva.getResolveDate()+"";
            
            String str[] ={pname,type,club,agent,age,weight,height,skill,speed,strengh,apperance,shoot,reaction,ballcontrol,passaccuracy,
            defence,calmness,potential,status,number,overallsocre,totalvalue,basicscore,date,date};
            
            while (it.hasNext()) {  
                String name = it.next().toString();  
                System.out.println(name);  
                form.setField(name, str[i++]);  
            }  
            
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true  
            stamper.close();  
  
            Document doc = new Document();  
            PdfCopy copy = new PdfCopy(doc, out);  
            doc.open();  
            
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);  
            copy.addPage(importPage);  
           PdfImportedPage importPage1 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 2);  
            copy.addPage(importPage1);  
            
            doc.close();  
  
        } catch (IOException e) {  
            System.out.println(1);  
        } catch (DocumentException e) {  
            System.out.println(2);  
        }  
  
    }  
       public static void fillPlayersEvaluation(FindPlayerListRequest eva, String path) {  
        // 模板路径  
        String templatePath = "src/data/PlayerListReport.pdf";  
        String newPDFPath = path;
        
        PdfReader reader;  
        FileOutputStream out;  
        ByteArrayOutputStream bos;  
        PdfStamper stamper;  
        try {  
            out = new FileOutputStream(newPDFPath);// 输出流  
            reader = new PdfReader(templatePath);// 读取pdf模板  
            bos = new ByteArrayOutputStream();  
            stamper = new PdfStamper(reader, bos);  
            AcroFields form = stamper.getAcroFields();  
            
            int i = 0;  
            java.util.Iterator<String> it = form.getFields().keySet().iterator();  
            
            
            Player p1= new Player(Player.PlayerType.Defender); 
            Player p2= new Player(Player.PlayerType.Defender);
 
        
            
            
            String p1name = eva.getReport().getPlayerList().getPlayerList().get(0).getName();
            String p1score = eva.getReport().getPlayerList().getPlayerList().get(0).getOverallScore()+"";
            String p1club = eva.getReport().getPlayerList().getPlayerList().get(0).getClub().name;
            
            
            
            String p2name = eva.getReport().getPlayerList().getPlayerList().get(1).getName();
            String p2score = eva.getReport().getPlayerList().getPlayerList().get(1).getOverallScore()+"";
            String p2club = eva.getReport().getPlayerList().getPlayerList().get(1).getClub().name;
            
            String p3name = eva.getReport().getPlayerList().getPlayerList().get(2).getName();
            String p3score = eva.getReport().getPlayerList().getPlayerList().get(2).getOverallScore()+"";
            
            String p3club = eva.getReport().getPlayerList().getPlayerList().get(2).getClub().name;
            
           
            
            
            String str[] ={p1name,p1score,p1club,p2name,p2score,p2club,p3name,p3score,p3club,p3club};
            
            while (it.hasNext()) {  
                String name = it.next().toString();  
                System.out.println(name);  
                form.setField(name, str[i++]);  
            }  
            
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true  
            stamper.close();  
  
            Document doc = new Document();  
            PdfCopy copy = new PdfCopy(doc, out);  
            doc.open();  
            
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);  
            copy.addPage(importPage);  
           
          
            doc.close();  
  
        } catch (IOException e) {  
            System.out.println(1);  
        } catch (DocumentException e) {  
            System.out.println(2);  
        }  
  
    }  
       public static void TransferContract(TransferRequest transfer , String path,EcoSystem business) {  
        // 模板路径  
        String templatePath = "src/data/TransferContract.pdf";
        String newPDFPath = path;
        
        PdfReader reader;  
        FileOutputStream out;  
        ByteArrayOutputStream bos;  
        PdfStamper stamper;  
        try {  
            out = new FileOutputStream(newPDFPath);// 输出流  
            reader = new PdfReader(templatePath);// 读取pdf模板  
            bos = new ByteArrayOutputStream();  
            stamper = new PdfStamper(reader, bos);  
            AcroFields form = stamper.getAcroFields();  
            
            int i = 0;  
            
            System.out.println("Ha Ha"+transfer.getFirstReceiver().getUsername());
            System.out.println("Ha Ha"+transfer.getSender().getUsername());
            
            java.util.Iterator<String> it = form.getFields().keySet().iterator();  
            Enterprise sellclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(transfer.getFirstReceiver().getUsername())){
                              
                                sellclub = e;
                            }
                        }
                    }
                }
            }
               Enterprise buyclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(transfer.getSender().getUsername())){
                                
                                buyclub = e;
                            }
                        }
                    }
                }
            }   
                
                
                
            String p1name = sellclub.name;
            String p1score = transfer.getFirstReceiver().getUsername();
            String p1club = buyclub.name;
            String p2name = transfer.getSender().getUsername();
            
            String p2score =transfer.getPlayer().getName();
            String p2club = transfer.getPlayer().getAgent().getUsername();
            
            
            String p3name = transfer.getPlayer().gettotalvalue()+"";
            double transferfee =transfer.getTotalprice()*0.05;
            
            String p3score = transfer.getPlayer().gettotalvalue()+"";
            String p3club = transferfee+"";
            String salary = transferfee*1.5+"";
            String labor = "true";
            Message m=new Message();
            for(int q=0;q<6;q++){
            transfer.getClubAdditionalItem().getMessageList().add(m);
            transfer.getAgentAdditionalItem().getMessageList().add(m);
            }
            String it1=transfer.getClubAdditionalItem().getMessageList().get(0).getMessage();
            String it2=transfer.getClubAdditionalItem().getMessageList().get(1).getMessage();
            String it3=transfer.getClubAdditionalItem().getMessageList().get(2).getMessage();
            String it4=transfer.getClubAdditionalItem().getMessageList().get(3).getMessage();
            String it5=transfer.getClubAdditionalItem().getMessageList().get(4).getMessage();
            String it6=transfer.getAgentAdditionalItem().getMessageList().get(0).getMessage();
            String it7=transfer.getAgentAdditionalItem().getMessageList().get(1).getMessage();
            String it8=transfer.getAgentAdditionalItem().getMessageList().get(2).getMessage();
            Date date = new Date();
            String da =date.toString();
            
            
           
            
            
            String str[] ={p1name,p1score,p1club,p2name,p2score,p2club,p3name,p3score,p3club,p3club
            ,labor,it1,it2,it3,it4,it5,it6,it7,it8,da,da};
            
            while (it.hasNext()) {  
                String name = it.next().toString();  
                System.out.println(name);  
                form.setField(name, str[i++]);  
            }  
            
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true  
            stamper.close();  
  
            Document doc = new Document();  
            PdfCopy copy = new PdfCopy(doc, out);  
            doc.open();  
            
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);  
            copy.addPage(importPage);  
            PdfImportedPage importPage1 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 2);  
            copy.addPage(importPage1);  
          
            doc.close();  
  
        } catch (IOException e) {  
            System.out.println(1);  
        } catch (DocumentException e) {  
            System.out.println(2);  
        }  
  
    }  
       public static void LoanContract(LoanRequest transfer , String path,EcoSystem business) {  
        // 模板路径  
        String templatePath = "src/data/LoanContract.pdf";
        String newPDFPath = path;
        
        PdfReader reader;  
        FileOutputStream out;  
        ByteArrayOutputStream bos;  
        PdfStamper stamper;  
        try {  
            out = new FileOutputStream(newPDFPath);// 输出流  
            reader = new PdfReader(templatePath);// 读取pdf模板  
            bos = new ByteArrayOutputStream();  
            stamper = new PdfStamper(reader, bos);  
            AcroFields form = stamper.getAcroFields();  
            
            int i = 0;  
            
            System.out.println("Ha Ha"+transfer.getFirstReceiver().getUsername());
            System.out.println("Ha Ha"+transfer.getSender().getUsername());
            
            java.util.Iterator<String> it = form.getFields().keySet().iterator();  
            Enterprise sellclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(transfer.getFirstReceiver().getUsername())){
                              
                                sellclub = e;
                            }
                        }
                    }
                }
            }
               Enterprise buyclub =null;
            for(Network n :business.getNetworkList()){
                for(Enterprise e :n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            if(ua.getUsername().equals(transfer.getSender().getUsername())){
                                
                                buyclub = e;
                            }
                        }
                    }
                }
            }   
                
                
                
            String p1name = sellclub.name;
            String p1score = transfer.getFirstReceiver().getUsername();
            String p1club = buyclub.name;
            String p2name = transfer.getSender().getUsername();
            
            String p2score =transfer.getPlayer().getName();
            String p2club = transfer.getPlayer().getAgent().getUsername();
            
            
            String p3name = transfer.getPlayer().gettotalvalue()+"";
            double transferfee =transfer.getTotalprice()*0.05;
            
            String p3score = transfer.getPlayer().gettotalvalue()+"";
            String p3club = transferfee+"";
            String salary = transferfee*1.5+"";
            String labor = "true";
            Message m= new Message();
            for(int q=0;q<6;q++){
            transfer.getClubAdditionalItem().getMessageList().add(m);
            transfer.getAgentAdditionalItem().getMessageList().add(m);
            }
            String it1=transfer.getClubAdditionalItem().getMessageList().get(0).getMessage();
            String it2=transfer.getClubAdditionalItem().getMessageList().get(1).getMessage();
            String it3=transfer.getClubAdditionalItem().getMessageList().get(2).getMessage();
            String it4=transfer.getClubAdditionalItem().getMessageList().get(3).getMessage();
            String it5=transfer.getClubAdditionalItem().getMessageList().get(4).getMessage();
            String it6=transfer.getAgentAdditionalItem().getMessageList().get(0).getMessage();
            String it7=transfer.getAgentAdditionalItem().getMessageList().get(1).getMessage();
            String it8=transfer.getAgentAdditionalItem().getMessageList().get(2).getMessage();
            Date date = new Date();
            String da =date.toString();
            
            
           
            
            
            String str[] ={p1name,p1score,p1club,p2name,p2score,p2club,p3name,p3score,p3club,p3club
            ,transfer.getLoanStart(),transfer.getLoanEnd(),labor,it1,it2,it3,it4,it5,it6,it7,it8,da,da};
            
            while (it.hasNext()) {  
                String name = it.next().toString();  
                System.out.println(name);  
                form.setField(name, str[i++]);  
            }  
            
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true  
            stamper.close();  
  
            Document doc = new Document();  
            PdfCopy copy = new PdfCopy(doc, out);  
            doc.open();  
            
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);  
            copy.addPage(importPage);  
            PdfImportedPage importPage1 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 2);  
            copy.addPage(importPage1);  
          
            doc.close();  
  
        } catch (IOException e) {  
            System.out.println(1);  
        } catch (DocumentException e) {  
            System.out.println(2);  
        }  
  
    }  
   
   
   
}  
