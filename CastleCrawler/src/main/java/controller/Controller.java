/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import GUI.MainView;
import castlecrawler.RoomType;
import castlecrawler.GameState;
import castlecrawler.EscapeResult;
import castlecrawler.CombatResult;
import castlecrawler.GameUniverse;
import castlecrawler.Move;
import castlecrawler.Player;
import castlecrawler.Stat;

/**
 *
 * @author David Cabezas
 */
public class Controller {
    
    private GameUniverse game;
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
    
    public boolean canPeek(){
        return game.canPeek();
    }
    
    public boolean canLoot(){
        return game.canLoot();
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
        switch(result){
            case LOST:
                finish(1);
                break;
            case LEVELUP:
                levelUp();
                break;
        }   
    }
    
    public void levelUp(){
        Stat s = view.levelUpMessage();
        game.powerUp(s);
        view.updateView();
    }
    
    public GameUniverse getGameUniverse(){
        return game;
    }
    
    public boolean canMove(Move m){
        return game.canMove(m);
    }
    
    public void move(Move m){
        RoomType rt = game.move(m);
        view.updateView();
        
        if (rt==RoomType.FINALROOM){
            if(view.nextStageMessage()){
                game.nextStage();
                view.increaseStageCounter();
                view.updateView();
            }
        }
        
        if(rt==RoomType.EVENTROOM){
            String description = game.resolveEvent();
            view.eventMessage(description);
            view.updateView();
        }
    }
    
    public void peek(){
        game.peek();
        view.updateView();
    }
    
    public GameState getGameState(){
        return game.getGameState();
    }
    
    public void loot(){
        if(game.loot())
            levelUp();
        view.updateView();
    }
    
    public int getPoints(){
        return game.getPoints();
    }
}
