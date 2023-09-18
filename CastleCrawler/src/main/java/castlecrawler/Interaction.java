/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import controller.Controller;

/**
 *
 * @author David Cabezas
 */
public class Interaction extends AbstractAction {
    
    public static final String ATTACKLOOT = "ATTACKLOOT";
    
    private Controller controller;
    
    public Interaction(Controller c){
        controller = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(controller.getGameState()==GameState.COMBAT)
            controller.combat();
        else if(controller.canLoot())
            controller.loot();
    }
}
