/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Game;

import java.util.ArrayList;

/**
 *
 * @author liufulai
 */
public class GameDirectory implements java.io.Serializable{
    private ArrayList<Game> gameList;

    public GameDirectory() {
        gameList = new ArrayList<Game>();
    }

    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }
    
    public Game AddGame(){
        Game g = new Game();
        this.gameList.add(g);
        return g;
    }
    
    
    
    
}
