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
        
        MainView view = new MainView();
        view.setVisible(true);
        
        castlecrawler.Difficulty diff = view.welcomeMessage();
        
        GameUniverse game = new GameUniverse(diff);
        
        Controller controller = new Controller(game, view);
        
        controller.start();
    }
    
}
