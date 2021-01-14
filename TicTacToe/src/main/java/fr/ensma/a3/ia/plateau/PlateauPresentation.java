/**
 * 
 */
package fr.ensma.a3.ia.plateau;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.ensma.a3.player.Player;
/**
 * @author lammi
 *
 */
public class PlateauPresentation extends PlateauModel implements IPlateauPresentation, ActionListener {
    
    private Random random = new Random();
    private JFrame frame = new JFrame();
    private JPanel title_panel = new JPanel();
    private JPanel button_panel = new JPanel();
    private JLabel textfield = new JLabel();
    private JButton[] buttons = new JButton[9];

    private PlateauModel model = new PlateauModel();
    private Player playerX, playerO;
    
  
    public PlateauPresentation () {
        initPresentation();
    }
    
    public void initPresentation(){
//        random = new Random();
//        frame = new JFrame();
//        title_panel = new JPanel();
//        button_panel = new JPanel();
//        textfield = new JLabel();
//        buttons = new JButton[9];

        model.initModel();
    
        // init table
        frame.setTitle("TicTacToe from ISAE-ENSMA --- Author: LAM Minh Triet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        
        // init players
        playerX = new Player(1);
        playerO = new Player(2);
        
        playerX.setTurn(true);
        playerO.setTurn(false);
        
    }
    

    @Override
    public void highlightWin(int[] posWin){
        for (int i = 0; i < 3; i++){
            buttons[posWin[i]].setBackground(Color.GREEN);
        }
         
        for (int i=0; i<9; i++) {
                buttons[i].setEnabled(false);
        }
    }
    
    @Override
    public void resetGame(){
        System.out.println("Reset game");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if (buttons[i].getText()=="") {
                    if (playerX.getTurn()) {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText(playerX.getIcon());
                        playerX.setTurn(false);
                        playerO.setTurn(true);
                        textfield.setText(playerO.getIcon() + " turn");
                        
                        model.updateTable(playerX.getPlayerID(), i);
                        playerX.setPosWin(model.vectorPlayerWin(playerX.getPlayerID()));

                    } else {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText(playerO.getIcon());
                        playerO.setTurn(false);
                        playerX.setTurn(true);
                        textfield.setText(playerX.getIcon() + " turn");
                        
                        model.updateTable(playerO.getPlayerID(), i);
                        playerO.setPosWin(model.vectorPlayerWin(playerO.getPlayerID()));
                    }
                } 
                
                if (playerX.getState()){
                    highlightWin(playerX.getPosWin());
                    textfield.setText(playerX.getIcon() + " won!");
                }else if (playerO.getState()){
                    highlightWin(playerO.getPosWin());
                    textfield.setText(playerO.getIcon() + " won!");
                }
                if (playerX.getState() || playerO.getState() || model.noMove()){                 
                    resetGame();
                }
                
            }	
            
            
        }
    }
 
}
