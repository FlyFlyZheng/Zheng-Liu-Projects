/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.EvaluationReport;

import System.Player.Player;
import System.UserAccount.UserAccount;

/**
 *
 * @author liufulai
 */
public class PlayerEvalutionReport extends Report implements java.io.Serializable{
  
    private int idealPrice;
    
    private String playerName;
    private int id;
    private UserAccount agent;
    private static int count = 1;
    
    private Player.PlayerType playerType;
    private double height=0;
    private double weight=0;
    private double skill=0;
    private double speed=0;
    private double strengh=0;
    private int age=0;
    
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
           

    private double apperence=0;
    private double gamePerformance;
    
    private double OverallScore;

    public PlayerEvalutionReport() {
        super();
    }

   
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserAccount getAgent() {
        return agent;
    }

    public void setAgent(UserAccount agent) {
        this.agent = agent;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        PlayerEvalutionReport.count = count;
    }

    public Player.PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Player.PlayerType playerType) {
        this.playerType = playerType;
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
        return potential;
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
        return gamePerformance;
    }

    public void setGamePerformance(double gamePerformance) {
        this.gamePerformance = gamePerformance;
    }

    public double getOverallScore() {
        return OverallScore;
    }

    public void setOverallScore(double OverallScore) {
        this.OverallScore = OverallScore;
    }

    public int getIdealPrice() {
        return idealPrice;
    }

    public void setIdealPrice(int idealPrice) {
        this.idealPrice = idealPrice;
    }
    
    
}
