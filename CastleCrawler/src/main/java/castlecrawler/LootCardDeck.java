/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
class LootCardDeck extends CardDeck<LootRoom> {
    
    @Override
    public LootRoom next() {
        LootRoom l = (LootRoom) (super.next());
        return new LootRoom(l);
    }
    
}
