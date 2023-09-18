/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
class EventCardDeck extends CardDeck<EventRoom> {
    
    @Override
    public EventRoom next() {
        EventRoom v = (EventRoom) (super.next());
        return new EventRoom(v);
    }
    
}
