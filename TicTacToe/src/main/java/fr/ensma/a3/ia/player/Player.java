/**
 * 
 */
package fr.ensma.a3.ia.player;

/**
 * @author lammi
 *
 */
public class Player {
    private int playerID;
    private boolean state;
    private int[] posWin;
    private boolean isTurn;
    private String icon;
    
    public Player(int playerID){
        this.playerID = playerID;
        this.state = false;
        this.posWin = new int[3];
        this.isTurn = false;
        
        setIcon();
    }
    
    private void setIcon(){
        if (this.playerID == 1){
            this.icon = "X";
        }else{
            this.icon = "O";
        }
    }
    
    public String getIcon(){
        return this.icon;
    }
    
    public int getPlayerID(){
        return this.playerID;
    }
    
    public void setState(boolean state){
        this.state = state;
    }
    
    private void updateState(){
        if (posWin[0] == 0 && posWin[1] == 0 && posWin[2] == 0){
            this.state = false;
                
        }else{
            this.state = true;
        }
 
    }
    
    public boolean getState(){
        return this.state;
    }
    
    public void setPosWin(int[] posWin){
        this.posWin = posWin;
        updateState();
    }
    
    public int[] getPosWin(){
        return this.posWin;
    }
    
    public void setTurn(boolean isTurn){
        this.isTurn = isTurn;
    }
    
    public boolean getTurn(){
        return this.isTurn;
    }
}
