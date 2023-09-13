/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import castlecrawler.Room;

/**
 *
 * @author David Cabezas
 */
public abstract class RoomView extends javax.swing.JPanel {
    
    private boolean visible = false;
    private boolean selected = false;
    
    public RoomView (boolean v, boolean s){
        visible = v;
        selected = s;
    }
    
    public void setBorder(){
        setOpaque(visible);
        if (selected)
            setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(153, 51, 0)));
        else
            setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
    }
         
}