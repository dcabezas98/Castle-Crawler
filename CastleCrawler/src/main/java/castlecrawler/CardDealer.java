/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import castlecrawler.EventType;

/**
 *
 * @author David Cabezas
 */
class CardDealer {
    private static final CardDealer instance=new CardDealer();
    
    EnemyCardDeck enemies;
    LootCardDeck loots;
    EventCardDeck events;
    
    private CardDealer(){

        enemies=new EnemyCardDeck();
        loots=new LootCardDeck();
        
        initCards();
    };
           
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public EnemyRoom nextEnemy() {
        return enemies.next();
    }
    
    public LootRoom nextLoot(){
        return loots.next();
    }
    
    public EventRoom nextEvent(){
        return events.next();
    }
        
    private void initCards() {  
        createEnemies();
        createLoots();
        createEvents();
    }
    
    private void createEnemies() { 
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(10,50, 1, "Weak Enemy"));
        enemies.add(new EnemyRoom(20,70, 2, "Strong Enemy"));
        enemies.add(new EnemyRoom(20,70, 2, "Strong Enemy"));
        enemies.add(new EnemyRoom(20,70, 2, "Strong Enemy"));
        enemies.add(new EnemyRoom(20,70, 2, "Strong Enemy"));
        enemies.add(new EnemyRoom(1,200, 3, "BONUS Enemy"));
        enemies.add(new EnemyRoom(1,200, 3, "BONUS Enemy"));
        enemies.add(new EnemyRoom(25,100, 7, "BOSS Enemy"));
    }
    
    private void createLoots() { 
        loots.add(new LootRoom(1,1));
        loots.add(new LootRoom(1,1));
        loots.add(new LootRoom(1,2));
        loots.add(new LootRoom(1,2));
        loots.add(new LootRoom(1,3));
        loots.add(new LootRoom(1,3));
        loots.add(new LootRoom(2,1));
        loots.add(new LootRoom(2,2));
        loots.add(new LootRoom(2,3));
        loots.add(new LootRoom(0,3));
        loots.add(new LootRoom(0,3));
        loots.add(new LootRoom(0,5));
        loots.add(new LootRoom(0,5));
        loots.add(new LootRoom(3,3));
        loots.add(new LootRoom(5,5));
    }
    
    private void createEvents() { 
        events.add(new EventRoom("Darkness.\nYour memory better be good.", EventType.DARKNESS));
        events.add(new EventRoom("Darkness.\nYour memory better be good.", EventType.DARKNESS));
        events.add(new EventRoom("Darkness.\nYour memory better be good.", EventType.DARKNESS));
        events.add(new EventRoom("Oh no!\nYou sumbled and got mildly hurt.", EventType.SMALLDMG));
        events.add(new EventRoom("Oh no!\nYou sumbled and got mildly hurt.", EventType.SMALLDMG));
        events.add(new EventRoom("Oh no!\nYou got hit by a trap!", EventType.BIGDMG));
        events.add(new EventRoom("Nice!\nYou took a replenishing nap.", EventType.HEAL));
        events.add(new EventRoom("Nice!\nYou took a replenishing nap.", EventType.HEAL));
        events.add(new EventRoom("Nice!\nYou took a replenishing nap.", EventType.HEAL));
        events.add(new EventRoom("Nice!\nYou took a replenishing nap.", EventType.HEAL));
        events.add(new EventRoom("Nice!\nYou took a replenishing nap.", EventType.HEAL));
        events.add(new EventRoom("Amazing!\nA strage potion made you feel stronger!", EventType.LEVELUP));
    }

}
