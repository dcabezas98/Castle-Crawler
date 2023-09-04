/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class StartRoom implements Room {
    
    @Override
    public RoomType getType() {
        return RoomType.STARTROOM;
    }
    
    @Override
    public String toString(){
        return "S";
    }
}
