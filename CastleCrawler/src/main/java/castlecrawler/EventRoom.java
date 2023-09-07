/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class EventRoom implements Room {
    
    private String description;
    
    EventRoom(String d){
        description=d;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public RoomType getType() {
        return RoomType.EVENTROOM;
    }
    
    @Override
    public String toString(){
        return "V";
    }
    
    
}
