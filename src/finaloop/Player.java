package finaloop;

import java.io.Serializable;

public class Player implements Serializable {
    private String playerName;
    private int score;
    
    public Player(String playerName, int score){
        this.playerName = playerName;
        this.score = score;
    }

    // getters and setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}