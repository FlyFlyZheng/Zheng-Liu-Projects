/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Player;

import System.Employee.Employee;
import System.Enterprise.Club;
import System.UserAccount.UserAccount;

/**
 *
 * @author liufulai
 */
public class Player implements java.io.Serializable{
    private String name;
    private int id;
    private UserAccount agent;
    private static int count = 1;
    private Club club;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    private PlayerType playerType;
    private double height=0;
    private double weight=0;
    private double skill=0;
    private double speed=0;
    private double strengh=0;
    private int age=0;
    
    private int gameNumber =0;
    
    //Potential and status can be calcualated according to player's age and game performance
    private double potential;
    private double status;
    
    //qianfeng/Striker
    private double shootAccuracy;
    //zhongchang/Midfielder
    private double ballControl;
    private double passAccuracy;
    //houwei/Deffender
    private double denfence;
    private double calmness;
    //shoumenyuan/Goalkeeper
    private double reactionSpeed;
           
    private double allGameScore=0;

    public double getAllGameScore() {
        return allGameScore;
    }

    public void setAllGameScore(double allGameScore) {
        this.allGameScore = allGameScore;
    }
    private double apperence=0;
    private double gamePerformance;
    
    
    private double OverallScore=0;
    private double value=0;
    
    public String picturePath;
    
    
    public Player(PlayerType type) {
        id = count;
        count++;
        agent = null;
        this.playerType = type;
        
    }

    public String getPicturePath() {
        return picturePath;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    
    public enum PlayerType{
      //Different Organization Type
        Striker("Striker"),
        Midfielder("Midfielder"),
        Defender("Defender"),
        Goalkeeper("Goalkeeper");
     
        public String value;

        private PlayerType(String value) {
            this.value = value;
        }
      
        public String getValue() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Player.count = count;
    }

    public UserAccount getAgent() {
        return agent;
    }

    public void setAgent(UserAccount agent) {
        this.agent = agent;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getStrengh() {
        return strengh;
    }

    public void setStrengh(double strengh) {
        this.strengh = strengh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPotential() {
        this.potential=(Double.parseDouble(String.valueOf(30-this.age))*this.gamePerformance)/40;
        return this.potential;
    }

    public void setPotential(double potential) {
        this.potential = potential;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }

    public double getShootAccuracy() {
        return shootAccuracy;
    }

    public void setShootAccuracy(double shootAccuracy) {
        this.shootAccuracy = shootAccuracy;
    }

    public double getBallControl() {
        return ballControl;
    }

    public void setBallControl(double ballControl) {
        this.ballControl = ballControl;
    }

    public double getPassAccuracy() {
        return passAccuracy;
    }

    public void setPassAccuracy(double passAccuracy) {
        this.passAccuracy = passAccuracy;
    }

    public double getDenfence() {
        return denfence;
    }

    public void setDenfence(double denfence) {
        this.denfence = denfence;
    }

    public double getCalmness() {
        return calmness;
    }

    public void setCalmness(double calmness) {
        this.calmness = calmness;
    }

    public double getReactionSpeed() {
        return reactionSpeed;
    }

    public void setReactionSpeed(double reactionSpeed) {
        this.reactionSpeed = reactionSpeed;
    }

    public double getApperence() {
        return apperence;
    }

    public void setApperence(double apperence) {
        this.apperence = apperence;
    }

    public double getGamePerformance() {
        return ((double)this.allGameScore)/((double)this.gameNumber);
    }

    public void setGamePerformance() {
        this.gamePerformance = (double)(((double)this.allGameScore)/((double)this.gameNumber))/2;
    }

    public double getOverallScore() {
        return OverallScore;
    }

    public void setOverallScore(double OverallScore) {
        this.OverallScore = OverallScore;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public double getbasicscore(){
        double basicscore=0.0;
        if(this.playerType.getValue().equals(PlayerType.Striker.getValue())){
            basicscore=((this.skill*2)+(this.speed*2)+(this.strengh*1.5)+(this.shootAccuracy*2.5)+(this.ballControl*2)+(this.passAccuracy*2)+(this.denfence*0.5)+(this.calmness)+(this.reactionSpeed*0.5))/14;
        }
                if(this.playerType.equals(PlayerType.Midfielder)){
            basicscore=((this.skill*2.5)+(this.speed*1.5)+(this.strengh*2)+(this.shootAccuracy*2)+(this.ballControl*2.5)+(this.passAccuracy*2.5)+(this.denfence*1.5)+(this.calmness)+(this.reactionSpeed*0.5))/16;
        }
                if(this.playerType.equals(PlayerType.Defender)){
            basicscore=((this.skill*1.5)+(this.speed*1.5)+(this.strengh*2.5)+(this.shootAccuracy*1)+(this.ballControl*1)+(this.passAccuracy*1.5)+(this.denfence*2.5)+(this.calmness*1.5)+(this.reactionSpeed*0.5))/13.5;
        }
                if(this.playerType.equals(PlayerType.Goalkeeper)){
            basicscore=((this.skill)+(this.speed)+(this.strengh*0.5)+(this.ballControl*0.5)+(this.passAccuracy)+(this.denfence)+(this.calmness*2)+(this.reactionSpeed*2.5))/9.5;
        }
        return basicscore;
    }
    
    public double getcommercialvalue(){
        double com=0;
        com=this.apperence*this.gamePerformance/40;
        return com;
    }
 
    public double gettotalvalue(){
        double total=0;
        total=this.getbasicscore()*1000+this.getcommercialvalue()*500+this.getPotential()*1500;
        return total;
    }
    
    
    
    
    
    @Override
    public String toString(){
        return this.name;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    
    
    
    
    
    
}
