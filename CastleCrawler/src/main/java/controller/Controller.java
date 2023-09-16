/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import GUI.MainView;
import castlecrawler.GameState;
import castlecrawler.EscapeResult;
import castlecrawler.CombatResult;
import castlecrawler.GameUniverse;
import castlecrawler.Move;
import castlecrawler.Player;

/**
 *
 * @author David Cabezas
 */
public class Controller {
    
    private GameUniverse game;
    private Player player;
    private MainView view;
    
    public Controller(GameUniverse g, MainView v){
        game = g;
        view = v;
        view.setController(this);
        view.createKeyBindings();
    }
    
    public void start(){
        view.updateView();
        view.showView();
    }
    
    public void finish(int i) {
        if (i == 0){
            if (view.confirmExitMessage())
                System.exit(0);
        }
        if (i == 1){
            view.deathMessage();
            System.exit(0);
        }
    }
    
    public void flee(){
        EscapeResult result = game.flee();
        view.escapeMessage(result==EscapeResult.YES);
        view.updateView();
        if(result == EscapeResult.DEATH)
            finish(1);
    }
    
    public void combat(){
        CombatResult result = game.combat();
        view.updateView();
        if(result == CombatResult.LOST)
            finish(1);
    }
    
    public GameUniverse getGameUniverse(){
        return game;
    }
    
    public boolean canMove(Move m){
        return game.canMove(m);
    }
    
    public void move(Move m){
        game.move(m);
        view.updateView();
    }
    
    public GameState getGameState(){
        return game.getGameState();
    }
}
