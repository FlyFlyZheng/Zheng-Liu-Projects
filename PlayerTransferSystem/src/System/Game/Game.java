/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Game;

import System.Enterprise.Club;
import static System.Enterprise.Enterprise.EnterpriseType.Club;
import System.Player.PlayerDirectory;
import Utility.DoubleNumber;
import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class Game implements java.io.Serializable{
    private String name;   
    private GameType gameTpye;
    
    private Club homeClub;
    private Club guestClub;
    // Player list of each team
    private PlayerDirectory homeTeam;
    private PlayerDirectory guestTeam;
    // player's score of each team
    private ArrayList<String> homePlayerScore;
    private ArrayList<String> guestPlayerScore;
    // Game data
    private int homeScore;
    private int gusetScore;
    private double homePossession;
    private int homeShootNumber;
    private int guestShootNumber;
    private int homeOffSide;
    private int guestOffSide;
    
    private int gameId;
    private static int count = 1;

    public Game() {
        gameId = count;
        count++;
        homeTeam = new PlayerDirectory();
        guestTeam = new PlayerDirectory();
        homePlayerScore = new ArrayList<String>();
        guestPlayerScore = new ArrayList<String>();
        
        
    }
    
    public enum GameType {
      //Different Organization Type
        LeagueMatch("LeagueMatch"),
        Derbymatch("Derby match"),
        KnockoutMatch("Knockout Match"),
        FinalMatch("FinalMatch");
     
        public String value;

        private GameType(String value) {
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

    public GameType getGameTpye() {
        return this.gameTpye;
    }

    public void setGameTpye(GameType gameTpye) {
        this.gameTpye = gameTpye;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getGuestClub() {
        return guestClub;
    }

    public void setGuestClub(Club guestClub) {
        this.guestClub = guestClub;
    }

    public PlayerDirectory getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(PlayerDirectory homeTeam) {
        this.homeTeam = homeTeam;
    }

    public PlayerDirectory getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(PlayerDirectory guestTeam) {
        this.guestTeam = guestTeam;
    }

    public ArrayList<String> getHomePlayerScore() {
        return homePlayerScore;
    }

    public void setHomePlayerScore(ArrayList<String> homePlayerScore) {
        this.homePlayerScore = homePlayerScore;
    }

    public ArrayList<String> getGuestPlayerScore() {
        return guestPlayerScore;
    }

    public void setGuestPlayerScore(ArrayList<String> guestPlayerScore) {
        this.guestPlayerScore = guestPlayerScore;
    }



    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getGusetScore() {
        return gusetScore;
    }

    public void setGusetScore(int gusetScore) {
        this.gusetScore = gusetScore;
    }

    public double getHomePossession() {
        return homePossession;
    }

    public void setHomePossession(double homePossession) {
        this.homePossession = homePossession;
    }

    public int getHomeShootNumber() {
        return homeShootNumber;
    }

    public void setHomeShootNumber(int homeShootNumber) {
        this.homeShootNumber = homeShootNumber;
    }

    public int getGuestShootNumber() {
        return guestShootNumber;
    }

    public void setGuestShootNumber(int guestShootNumber) {
        this.guestShootNumber = guestShootNumber;
    }

    public int getHomeOffSide() {
        return homeOffSide;
    }

    public void setHomeOffSide(int homeOffSide) {
        this.homeOffSide = homeOffSide;
    }

    public int getGuestOffSide() {
        return guestOffSide;
    }

    public void setGuestOffSide(int guestOffSide) {
        this.guestOffSide = guestOffSide;
    }

    public int getGameId() {
        return gameId;
    }
     @Override
    public String toString(){
        return this.name;
    }

    
    
    
    
    
    
}
