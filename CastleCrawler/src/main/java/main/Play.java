/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import castlecrawler.GameUniverse;

/**
 *
 * @author David Cabezas
 */
public class Play {

    public static void main(String[] args) {
        
        castlecrawler.Difficulty diff = castlecrawler.Difficulty.NORMAL;
        
        GameUniverse game = new GameUniverse(diff);
        
        System.out.println(game.getStage());
    }
    
}
