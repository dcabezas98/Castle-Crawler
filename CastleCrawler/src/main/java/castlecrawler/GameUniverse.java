/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import castlecrawler.Move;

/**
 *
 * @author David Cabezas
 */
public class GameUniverse {
    
    private Difficulty diff;
    private Dice dice;
    private Stage stage;
    private Player player;
    
    public GameUniverse(Difficulty d){
 
        diff = d;
        dice = new Dice(d);
        stage = new Stage(d, 5, 5);
    }
    
    public Stage getStage(){
        return stage;
    }
    
    public boolean canMove(Move m){
        boolean can = false;
        switch(m){
            case UP:
                can = player.getRow() > 0;
            case DOWN:
                can = player.getRow() < stage.getNRows();
            case LEFT:
                can = player.getCol() > 0;
            case RIGHT:
                can = player.getCol() < stage.getNCols();
        }
        return can;
    }
    
    public void move(Move m){
        stage.move(m);
    }
    
    public int getRow(){
        return player.getRow();
    }
    
    public int getCol(){
        return player.getCol();
    }
}
