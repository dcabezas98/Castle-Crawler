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
public class SecondAction extends AbstractAction {
    
    public static final String FLEEPEEK = "FLEEPEEK";
    
    private Controller controller;
    
    public SecondAction(Controller c){
        controller = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(controller.getGameState()==GameState.COMBAT)
            controller.flee();
        else if(controller.canPeek())
            controller.peek();
    }
}
