/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import castlecrawler.GameUniverse;
import controller.Controller;
import GUI.MainView;

/**
 *
 * @author David Cabezas
 */
public class Play {

    public static void main(String[] args) {
        
        castlecrawler.Difficulty diff = castlecrawler.Difficulty.NORMAL;
        
        GameUniverse game = new GameUniverse(diff);
        
        MainView view = new MainView();
        
        Controller controller = new Controller(game, view);
        
        controller.start();
        
        //System.out.println(game.getStage());
    }
    
}
