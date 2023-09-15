/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import castlecrawler.Move;
import controller.Controller;

/**
 *
 * @author David Cabezas
 */
public class MoveAction extends AbstractAction {
    
    public static final String MOVE_UP = "MOVE_UP";
    public static final String MOVE_DOWN = "MOVE_DOWN";
    public static final String MOVE_LEFT = "MOVE_LEFT";
    public static final String MOVE_RIGHT = "MOVE_RIGHT";
    
    private Controller controller;
    private Move action;
    
    public MoveAction(Controller c, Move m){
        controller = c;
        action = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        controller.move(action);
    }
}
