/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class FinalRoom extends Room {
        
    @Override
    public RoomType getType() {
        return RoomType.FINALROOM;
    }
    
    @Override
    public String toString(){
        return "F";
    }
}
