/**
 * 
 */
package fr.ensma.a3.ia.plateau;
import fr.ensma.a3.ia.player.Player;
/**
 * @author lammi
 *
 */
public class PlateauModel {
    // nothing -> 0, X -> 1, O -> 2
    private static int[] table = new int[9]; 
    private int[][] matrixWin = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public PlateauModel(){
        initModel();
    }
    
    public void initModel(){
        table = new int[9];  

    }
    
    public void updateTable(int playerID, int pos){
        this.table[pos] = playerID;
    }
    
    public int[] vectorPlayerWin(int playerID){
        int[] posWin = new int[3];
        for (int i = 0; i < 8; i++){
            if(this.table[matrixWin[i][0]] == playerID && this.table[matrixWin[i][1]] == playerID && this.table[matrixWin[i][2]] == playerID){
                posWin[0] = matrixWin[i][0];
                posWin[1] = matrixWin[i][1];
                posWin[2] = matrixWin[i][2];
            }
        }
        
        return posWin;
    }
   
    
    public boolean noMove(){
        for (int i = 0;i < 9; i++){
            if (table[i] == 0){
                return false;
            }
        }
        return true;
    }
    
}
