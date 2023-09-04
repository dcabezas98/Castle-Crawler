/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class GameUniverse {
    
    private Difficulty diff;
    private Dice dice;
    private Stage stage;
    
    public GameUniverse(Difficulty d){
 
        diff = d;
        dice = new Dice(d);
        stage = new Stage(d, 5, 5);
    }
    
    public Stage getStage(){
        return stage;
    }
}
