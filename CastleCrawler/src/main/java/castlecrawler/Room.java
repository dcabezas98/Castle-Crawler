/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public abstract class Room {
    
    private boolean visible=false;
    private boolean selected=false;
    
    public abstract RoomType getType();
    
    public void show(){
        visible = true;
    }
    
    public void hide(){
        visible = false;
    }
    
    public void select(){
        selected = true;
    }
    
    public void deselect(){
        selected = false;
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public boolean selected(){
        return selected;
    }
}
