/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import GUI.MainView;
import castlecrawler.GameUniverse;

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
    }
    
    public void start(){
        view.updateView();
        view.showView();
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public GameUniverse getGameUniverse(){
        return game;
    }    
}
