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

    public boolean selected = false;
    
    public boolean isSelected () {
        return selected;
    }
}