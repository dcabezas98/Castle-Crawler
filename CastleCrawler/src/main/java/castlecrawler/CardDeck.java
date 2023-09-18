/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David Cabezas
 */

class CardDeck<T> {    
    private ArrayList<T> cards=new ArrayList();
    private boolean ready;
    private int count;
    
    
    CardDeck() {
        ready=false;
        count=0;
    }
    
    public void add(T t) {
        if (!ready)
            cards.add(t);
    }
    
    public T next() {
        if (!ready) {
            ready=true;
            shuffle();
        }

        T card=cards.remove(0);
        cards.add(card);
        
        count++;
        if (count==cards.size()) {
            shuffle();
            count=0;
        }
        return card;
    }
    
    private void shuffle() {
        Collections.shuffle(cards);
    }
}

