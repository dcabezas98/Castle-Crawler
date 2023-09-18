/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
class EnemyCardDeck extends CardDeck<EnemyRoom> {
    
    @Override
    public EnemyRoom next() {
        EnemyRoom e = (EnemyRoom) (super.next());
        return new EnemyRoom(e);
    }
    
}
