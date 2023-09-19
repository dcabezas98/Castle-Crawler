/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class EventRoom extends Room {
    
    private String description;
    private EventType eventType;
    
    EventRoom(String d, EventType et){
        description=d;
        eventType=et;
    }
    
    EventRoom(EventRoom v){
        this(v.description, v.eventType);
    }
    
    public String getDescription(){
        return description;
    }
    
    public EventType getEventType(){
        return eventType;
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
