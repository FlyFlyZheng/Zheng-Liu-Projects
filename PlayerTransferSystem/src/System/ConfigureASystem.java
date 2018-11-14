/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import System.AgentCompany.PlayerAgentOrganization;
import System.ClubOrganization.ClubContract;
import System.ClubOrganization.ClubFinancial;
import System.Employee.Employee;
import System.Enterprise.AgentCompany;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.Enterprise.Enterprise.EnterpriseType;
import static System.Enterprise.Enterprise.EnterpriseType.AgentCompany;
import System.Enterprise.EvaluatingCompany;
import System.Enterprise.Labor;
import System.EvaluationCompany.EvaluatingCompanyFinancial;
import System.EvaluationCompany.EvaluatingEmployee;
import System.EvaluationCompany.PlayerDataAnalysis;
import System.Game.Game;
import System.LaborDepartment.LaborDepartment;
import System.Message.Message;
import System.Network.Network;
import System.Organization.Organization;
import System.Organization.Organization.OrganizationType;
import System.Player.Player;
import System.Player.PlayerDirectory;
import System.Role.Agent.AgentAdminRole;
import System.Role.Agent.PlayerAgentRole;
import System.Role.Club.ClubAdminRole;
import System.Role.Club.ClubContractManager;
import System.Role.Club.ClubFinancialManager;
import System.Role.Evaluation.EvaluationAdmin;
import System.Role.Evaluation.EvaluationDataAanalysis;
import System.Role.Evaluation.EvaluationEmployee;
import System.Role.Evaluation.EvaluationFinanical;
import System.Role.Labor.LaborStaff;
import static System.Role.Role.RoleType.ClubContractManager;
import static System.Role.Role.RoleType.EvaluationEmployee;
import static System.Role.Role.RoleType.SystemFinancialAdmin;
import System.Role.System.SystemAdminRole;
import System.Role.System.SystemFinancialAdmin;
import System.UserAccount.UserAccount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class ConfigureASystem {
    
    
    public static EcoSystem configure(){
        
        EcoSystem business = EcoSystem.getInstance();
        business.refereshMasterUserAccount();
        //Config System Admin
        Employee employee = business.getEmployeeDirectory().createEmployee("System Admin");
        UserAccount sysAdmin = business.getUserAccountDirectory().createUserAccount("sysadmin", "123", employee, new SystemAdminRole());

        //Config System Financial Admin
        Employee sysFinancialAdminEmployee = business.getEmployeeDirectory().createEmployee("System Financial Admin");
        UserAccount sysFinancialAdmin = business.getUserAccountDirectory().createUserAccount("sysfinancialadmin", "123", sysFinancialAdminEmployee, new SystemFinancialAdmin());

        //Congfig network
        Network n = business.createNetwork("Europe");
        Network n1 = business.createNetwork("North America");
        Network n2 = business.createNetwork("China");
        
        //Config Blackboard message;
        Message m1 = new Message();
        m1.setMessage("I am in Club A, I have a striker at the end of contract, feel free to contact me.");
        n.getBoardcastMessageDirectory().getMessageList().add(m1);
        Message m2 = new Message();
        m2.setMessage("I am agent1, the player PBA want to find a more flexible club");
        n.getBoardcastMessageDirectory().getMessageList().add(m2);
        
    
        
        
        //ClubC+ ClubD +ClubE
        Club clubC = (Club)n.getEnterpriseDirectory().createAndAddEnterprise("clubc", EnterpriseType.Club);
        clubC.setRevenue(10000);
        clubC.setPath("src/resource/clubc.jpg");
        
        Club clubD = (Club)n1.getEnterpriseDirectory().createAndAddEnterprise("clubd", EnterpriseType.Club);
        clubD.setRevenue(10000);
        clubD.setPath("src/resource/clubd.jpg");
        
        Club clubE = (Club)n1.getEnterpriseDirectory().createAndAddEnterprise("clube", EnterpriseType.Club);
        clubE.setRevenue(10000);
        clubE.setPath("src/resource/clube.jpg");
        
        
        
        
        //Club A
        Club clubA = (Club)n.getEnterpriseDirectory().createAndAddEnterprise("cluba", EnterpriseType.Club);
        clubA.setRevenue(10000);
        clubA.setPath("src/resource/cluba.jpg");
        
        Employee clubAEmployee = clubA.getEmployeeDirectory().createEmployee("CLUB A Admin");
        UserAccount UAclubAadmin  = clubA.getUserAccountDirectory().createUserAccount("clubaadmin", "123", clubAEmployee, new ClubAdminRole());
        
        ClubContract clubAContract = (ClubContract)clubA.getOrganizationDirectory().createOrganization("Club Contract", OrganizationType.ClubContractOrganization);
        UserAccount UAclubAContract = clubAContract.getUserAccountDirectory().createUserAccount("clubacontract", "123", clubAEmployee, new ClubContractManager());
        
        ClubFinancial clubAFinancial = (ClubFinancial)clubA.getOrganizationDirectory().createOrganization("Club Financial", OrganizationType.ClubFinanicalOrganization);
        UserAccount UAclubAFinancial = clubAFinancial.getUserAccountDirectory().createUserAccount("clubafinancial", "123", clubAEmployee, new ClubFinancialManager());
        
        //Club B
        Club clubB = (Club)n.getEnterpriseDirectory().createAndAddEnterprise("clubb", EnterpriseType.Club);
        clubB.setRevenue(10000);
        clubB.setPath("src/resource/clubb.jpg");
        
        Employee clubBEmployee = clubB.getEmployeeDirectory().createEmployee("CLUB B Admin");
        UserAccount UAclubBadmin  = clubB.getUserAccountDirectory().createUserAccount("clubbadmin", "123", clubBEmployee, new ClubAdminRole());
        
        ClubContract clubBContract = (ClubContract)clubB.getOrganizationDirectory().createOrganization("Club Contract", OrganizationType.ClubContractOrganization);
        UserAccount UAclubBContract = clubBContract.getUserAccountDirectory().createUserAccount("clubbcontract", "123", clubBEmployee, new ClubContractManager());
        
        ClubFinancial clubBFinancial = (ClubFinancial)clubB.getOrganizationDirectory().createOrganization("Club Financial", OrganizationType.ClubFinanicalOrganization);
        UserAccount UAclubBFinancial = clubBFinancial.getUserAccountDirectory().createUserAccount("clubbfinancial", "123", clubBEmployee, new ClubFinancialManager());
        
        
        //Config players for ClubA and Club B
        PlayerDirectory pdA = clubA.getPlayerDirectory();
        Player PA1 = pdA.CreatePlayer("PA1",Player.PlayerType.Striker);
        Player PA2 = pdA.CreatePlayer("PA2",Player.PlayerType.Striker);
        Player PA3 = pdA.CreatePlayer("PA3",Player.PlayerType.Striker);
        Player PA4 = pdA.CreatePlayer("PA4",Player.PlayerType.Striker);
        Player PA5 = pdA.CreatePlayer("PA5",Player.PlayerType.Goalkeeper);
        Player PA6 = pdA.CreatePlayer("PA6",Player.PlayerType.Striker);
        Player PA7 = pdA.CreatePlayer("PA7",Player.PlayerType.Defender);
        Player PA8 = pdA.CreatePlayer("PA8",Player.PlayerType.Midfielder);
        Player PA9 = pdA.CreatePlayer("PA9",Player.PlayerType.Striker);
        Player PA10 = pdA.CreatePlayer("PA10",Player.PlayerType.Midfielder);
        Player PA11 = pdA.CreatePlayer("PA11",Player.PlayerType.Midfielder);
        clubA.setPlayerDirectory(pdA);
        
        for(Player p :pdA.getPlayerList()){
            p.setClub(clubA);
        }
        Employee clubDEmployee = clubD.getEmployeeDirectory().createEmployee("CLUB D Admin");
        ClubContract clubDContract = (ClubContract)clubD.getOrganizationDirectory().createOrganization("Club Contract", OrganizationType.ClubContractOrganization);
        UserAccount UAclubDContract = clubDContract.getUserAccountDirectory().createUserAccount("clubdcontract", "123", clubDEmployee, new ClubContractManager());
        
        
        
        PlayerDirectory pdB = clubB.getPlayerDirectory();
        Player PB1 = pdB.CreatePlayer("PB1", Player.PlayerType.Striker);
        Player PB2 = pdB.CreatePlayer("PB2",Player.PlayerType.Striker);
        Player PB3 = pdB.CreatePlayer("PB3",Player.PlayerType.Striker);
        Player PB4 = pdB.CreatePlayer("PB4",Player.PlayerType.Goalkeeper);
        Player PB5 = pdB.CreatePlayer("PB5",Player.PlayerType.Defender);
        Player PB6 = pdB.CreatePlayer("PB6",Player.PlayerType.Striker);
        Player PB7 = pdB.CreatePlayer("PB7",Player.PlayerType.Defender);
        Player PB8 = pdB.CreatePlayer("PB8",Player.PlayerType.Midfielder);
        Player PB9 = pdB.CreatePlayer("PB9",Player.PlayerType.Striker);
        Player PB10 = pdB.CreatePlayer("PB10",Player.PlayerType.Midfielder);
        Player PB11 = pdB.CreatePlayer("PB11",Player.PlayerType.Midfielder);
        clubB.setPlayerDirectory(pdB);
        for(Player p :pdB.getPlayerList()){
            p.setClub(clubB);
        }
         PlayerDirectory pdC = clubC.getPlayerDirectory();
        Player PC1 = pdC.CreatePlayer("PC1",Player.PlayerType.Striker);
        Player PC2 = pdC.CreatePlayer("PC2",Player.PlayerType.Striker);
        Player PC3 = pdC.CreatePlayer("PC3",Player.PlayerType.Striker);
        Player PC4 = pdC.CreatePlayer("PC4",Player.PlayerType.Striker);
        Player PC5 = pdC.CreatePlayer("PC5",Player.PlayerType.Goalkeeper);
        Player PC6 = pdC.CreatePlayer("PC6",Player.PlayerType.Striker);
        Player PC7 = pdC.CreatePlayer("PC7",Player.PlayerType.Defender);
        Player PC8 = pdC.CreatePlayer("PC8",Player.PlayerType.Midfielder);
        Player PC9 = pdC.CreatePlayer("PC9",Player.PlayerType.Striker);
        Player PC10 = pdC.CreatePlayer("PC10",Player.PlayerType.Midfielder);
        Player PC11 = pdC.CreatePlayer("PC11",Player.PlayerType.Midfielder);
        clubC.setPlayerDirectory(pdC);
        
        for(Player p :pdC.getPlayerList()){
            p.setClub(clubC);
        }
        PlayerDirectory pdD = clubD.getPlayerDirectory();
        Player PD1 = pdD.CreatePlayer("PD1",Player.PlayerType.Striker);
        Player PD2 = pdD.CreatePlayer("PD2",Player.PlayerType.Striker);
        Player PD3 = pdD.CreatePlayer("PD3",Player.PlayerType.Striker);
        Player PD4 = pdD.CreatePlayer("PD4",Player.PlayerType.Striker);
        Player PD5 = pdD.CreatePlayer("PD5",Player.PlayerType.Goalkeeper);
        Player PD6 = pdD.CreatePlayer("PD6",Player.PlayerType.Striker);
        Player PD7 = pdD.CreatePlayer("PD7",Player.PlayerType.Defender);
        Player PD8 = pdD.CreatePlayer("PD8",Player.PlayerType.Midfielder);
        Player PD9 = pdD.CreatePlayer("PD9",Player.PlayerType.Striker);
        Player PD10 = pdD.CreatePlayer("PD10",Player.PlayerType.Midfielder);
        Player PD11 = pdD.CreatePlayer("PD11",Player.PlayerType.Midfielder);
        clubD.setPlayerDirectory(pdD);
        
        for(Player p :pdD.getPlayerList()){
            p.setClub(clubD);
        }
        
        
        PlayerDirectory pdE = clubE.getPlayerDirectory();
        Player PE1 = pdE.CreatePlayer("PE1",Player.PlayerType.Striker);
        Player PE2 = pdE.CreatePlayer("PE2",Player.PlayerType.Striker);
        Player PE3 = pdE.CreatePlayer("PE3",Player.PlayerType.Striker);
        Player PE4 = pdE.CreatePlayer("PE4",Player.PlayerType.Striker);
        Player PE5 = pdE.CreatePlayer("PE5",Player.PlayerType.Goalkeeper);
        Player PE6 = pdE.CreatePlayer("PE6",Player.PlayerType.Striker);
        Player PE7 = pdE.CreatePlayer("PE7",Player.PlayerType.Defender);
        Player PE8 = pdE.CreatePlayer("PE8",Player.PlayerType.Midfielder);
        Player PE9 = pdE.CreatePlayer("PE9",Player.PlayerType.Striker);
        Player PE10 = pdE.CreatePlayer("PE10",Player.PlayerType.Midfielder);
        Player PE11 = pdE.CreatePlayer("PE11",Player.PlayerType.Midfielder);
        clubE.setPlayerDirectory(pdE);
        
        for(Player p :pdE.getPlayerList()){
            p.setClub(clubE);
        }
        
        
        
        
        
        
        int pp =0;
        for(Player p : pdA.getPlayerList()){
            pp++;
            n.getPlayerDirectory().getPlayerList().add(p);
            p.setPicturePath("/Users/victor/Desktop/Picture/"+pp+".jpg" );
        }
        for(Player p : pdB.getPlayerList()){
             pp++;
            n.getPlayerDirectory().getPlayerList().add(p);
            p.setPicturePath("/Users/victor/Desktop/Picture/"+pp+".jpg" );
        }
        for(Player p : pdC.getPlayerList()){
             pp++;
            n.getPlayerDirectory().getPlayerList().add(p);
            p.setPicturePath("/Users/victor/Desktop/Picture/"+pp+".jpg" );
        }
        for(Player p : pdD.getPlayerList()){
             pp++;
            n1.getPlayerDirectory().getPlayerList().add(p);
            p.setPicturePath("/Users/victor/Desktop/Picture/"+pp+".jpg" );
        }
        for(Player p : pdE.getPlayerList()){
             pp++;
            n1.getPlayerDirectory().getPlayerList().add(p);
            p.setPicturePath("/Users/victor/Desktop/Picture/"+pp+".jpg" );
        }
        //Config Agent Company
        AgentCompany agentComppany = (AgentCompany)n.getEnterpriseDirectory().createAndAddEnterprise("agent company", EnterpriseType.AgentCompany);
        Employee agentEmployee = agentComppany.getEmployeeDirectory().createEmployee("Agent company employee");
        UserAccount agentAadmin  = agentComppany.getUserAccountDirectory().createUserAccount("agentadmin", "123", agentEmployee, new AgentAdminRole());
        
        PlayerAgentOrganization playerAgent1 = (PlayerAgentOrganization)agentComppany.getOrganizationDirectory().createOrganization("Player Agent organization", OrganizationType.PlayerAgentOrganization);
        UserAccount agent1 = playerAgent1.getUserAccountDirectory().createUserAccount("agent1", "123", agentEmployee, new PlayerAgentRole());
        agent1.setPersonRevenue(5000);
        
        
        
        
        AgentCompany agentComppany2 = (AgentCompany)n1.getEnterpriseDirectory().createAndAddEnterprise("agent company2", EnterpriseType.AgentCompany);
        Employee agentEmployee2 = agentComppany2.getEmployeeDirectory().createEmployee("Agent company employee2");
        UserAccount agentAadmin2  = agentComppany2.getUserAccountDirectory().createUserAccount("agentadmin2", "123", agentEmployee2, new AgentAdminRole());
        
        PlayerAgentOrganization playerAgent2 = (PlayerAgentOrganization)agentComppany2.getOrganizationDirectory().createOrganization("Player Agent organization2", OrganizationType.PlayerAgentOrganization);
        UserAccount agent2 = playerAgent2.getUserAccountDirectory().createUserAccount("agent2", "123", agentEmployee2, new PlayerAgentRole());
        agent2.setPersonRevenue(5000);
        
        
          for(Player p : pdD.getPlayerList()){
            agent2.getPlayerDirectory().getPlayerList().add(p);
            p.setAgent(agent2);
        }
        for(Player p : pdA.getPlayerList()){
            agent1.getPlayerDirectory().getPlayerList().add(p);
            p.setAgent(agent1);
        }
        for(Player p : pdB.getPlayerList()){
            agent1.getPlayerDirectory().getPlayerList().add(p);
            p.setAgent(agent1);
        }
         for(Player p : pdC.getPlayerList()){
            agent1.getPlayerDirectory().getPlayerList().add(p);
            p.setAgent(agent1);
        }
        
        //Config evaluation employee
        EvaluatingCompany evaluationCompany = (EvaluatingCompany)n.getEnterpriseDirectory().createAndAddEnterprise("Evaluation Company", EnterpriseType.EvaluatingCompany);
        Employee evaluationEmployee = evaluationCompany.getEmployeeDirectory().createEmployee("eva emloyee");
        UserAccount evaadmin = evaluationCompany.getUserAccountDirectory().createUserAccount("evaadmin", "123", evaluationEmployee, new EvaluationAdmin());
        
        EvaluatingCompanyFinancial  evaFinancial = (EvaluatingCompanyFinancial)evaluationCompany.getOrganizationDirectory().createOrganization("Evaluation Financial Organization", OrganizationType.EvaluatingCompanyFinancialOrganization);
        UserAccount UAevafinancial = evaFinancial.getUserAccountDirectory().createUserAccount("evafinancial", "123", evaluationEmployee, new EvaluationFinanical());
        
        EvaluatingEmployee  evaReport = (EvaluatingEmployee)evaluationCompany.getOrganizationDirectory().createOrganization("Evaluation Report Organization", OrganizationType.EvaluatingEmployeeOrganization);
        UserAccount UAevareport = evaReport.getUserAccountDirectory().createUserAccount("evareport", "123", evaluationEmployee, new EvaluationEmployee());
        
        PlayerDataAnalysis  evaDataAnalysis = (PlayerDataAnalysis)evaluationCompany.getOrganizationDirectory().createOrganization("Evaluation data analysis Organization", OrganizationType.PlayerDataAnalysisOrganization);
        UserAccount UAevadataAnalysis = evaDataAnalysis.getUserAccountDirectory().createUserAccount("evadata", "123", evaluationEmployee, new EvaluationDataAanalysis());
        
        //Config labor
        Labor labor = (Labor)n.getEnterpriseDirectory().createAndAddEnterprise("Labor", EnterpriseType.Labor);
        LaborDepartment ld = (LaborDepartment)labor.getOrganizationDirectory().createOrganization("labor Department", OrganizationType.LaborStaffOrganization);
        Employee laborEmployee = ld.getEmployeeDirectory().createEmployee("labor employee");
        UserAccount UAlaboradmin = ld.getUserAccountDirectory().createUserAccount("laboradmin", "123", laborEmployee, new LaborStaff());
        
         Labor labor2 = (Labor)n1.getEnterpriseDirectory().createAndAddEnterprise("Labor2", EnterpriseType.Labor);
        LaborDepartment ld2 = (LaborDepartment)labor2.getOrganizationDirectory().createOrganization("labor Department2", OrganizationType.LaborStaffOrganization);
        Employee laborEmployee2 = ld2.getEmployeeDirectory().createEmployee("labor employee2");
        UserAccount UAlaboradmin2 = ld2.getUserAccountDirectory().createUserAccount("laboradmin2", "123", laborEmployee2, new LaborStaff());
        

        //print 
        System.out.println(" ******************************************************** " );
        System.out.println(" Config result: " );
        System.out.println("Network create: "+n.getName());
        System.out.println("Network player num: "+n.getPlayerDirectory().getPlayerList().size());
        for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
            System.out.println("Enterprise name: "+e.getName());
            System.out.println("User Account num: "+e.getUserAccountDirectory().getUserAccountList().size());
            if(e instanceof Club){
                System.out.println("club player num: " +((Club) e).getPlayerDirectory().getPlayerList().size());
            }
            for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
                System.out.println("Organization name: "+o.getName());
                System.out.println("User Account num: "+o.getUserAccountDirectory().getUserAccountList().size());
            }
        }
        System.out.println("Master user account: "+business.getMasterUserAccountDirectory().getUserAccountList().size());
        System.out.println(" ******************************************************** " );
        
        ReadPlayer("src/data/ClubAPlayer.csv","cluba");
        ReadPlayer("src/data/ClubBPlayer.csv","clubb");
        ReadPlayer("src/data/ClubCPlayer.csv","clubc");
        ReadPlayer("src/data/ClubDPlayer.csv","clubd");
        ReadPlayer("src/data/ClubEPlayer.csv","clube");
        
        return business;
        
    }
    
   public static void ReadPlayer(String path,String clubname){
        Club club = null;
        
        
        File csv = new File(path);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(csv));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try{
            ArrayList<String> allString = new ArrayList<>();
                for(Network nw:EcoSystem.getInstance().getNetworkList()){
                    for(Enterprise ep :nw.getEnterpriseDirectory().getEnterpriseList()){
                        if(ep.getName().equals(clubname)&& ep instanceof Club)
                        { 
                             club =(Club) ep;
                        }
                    }
                }
                            int i =-1;
                            while((line = br.readLine())!= null){
                               i = i+1;
                                  everyLine = line;
                                  allString.add(everyLine);
                               String [] splitStr = everyLine.split(","); 
                               Player p= club.getPlayerDirectory().getPlayerList().get(i);
                               if(splitStr[1].equals("Defender")){
                                   p.setPlayerType(Player.PlayerType.Defender);
                               }
                               else if (splitStr[1].equals("Goalkeeper")){
                                     p.setPlayerType(Player.PlayerType.Goalkeeper);
                               }
                               else if(splitStr[1].equals("Midfielder")){
                                     p.setPlayerType(Player.PlayerType.Midfielder);
                               }
                               else if(splitStr[1].equals("Striker")){
                                  p.setPlayerType(Player.PlayerType.Striker);
                            }
                              
                               p.setAge(Integer.parseInt(splitStr[2]));
                               p.setHeight(Integer.parseInt(splitStr[3]));
                               p.setWeight(Integer.parseInt(splitStr[4]));
                               p.setSkill(Integer.parseInt(splitStr[5]));
                               p.setSpeed(Integer.parseInt(splitStr[6]));
                               p.setStrengh(Integer.parseInt(splitStr[7]));
                               p.setShootAccuracy(Integer.parseInt(splitStr[8]));
                               p.setBallControl(Integer.parseInt(splitStr[9]));
                               p.setPassAccuracy(Integer.parseInt(splitStr[10]));
                               p.setDenfence(Integer.parseInt(splitStr[11]));
                               p.setCalmness(Integer.parseInt(splitStr[12]));
                               p.setReactionSpeed(Integer.parseInt(splitStr[13]));
                               p.setApperence(Integer.parseInt(splitStr[14]));
                               
                           System.out.println(p.getAge());
                          System.out.println("Here :"+p.getGamePerformance());
                        }
               
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
   
}
