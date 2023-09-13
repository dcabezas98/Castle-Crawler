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
        return stage.canMove(m);
    }
    
    public void move(Move m){
        if(stage.canMove(m))
            stage.move(m);
    }
    
    public int getRow(){
        return stage.getCurrentRow();
    }
    
    public int getCol(){
        return stage.getCurrentCol();
    }
}
