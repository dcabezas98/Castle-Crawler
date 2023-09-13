/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import castlecrawler.Move;

/**
 *
 * @author David Cabezas
 */
public class Player {
    
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private int hea;
    
    private int level;
    private int expTo;
    
    Player(){
        maxHp=100;
        hp=100;
        atk=30;
        def=10;
        hea=1;
        
        level=1;
        expTo=10;
    }
    
    public void levelUp(){
        level++;
        expTo=10;
        maxHp+=10;
        atk+=3;
        def+=1;
        hea+=1;
        // power up stat
        heal();
    }
    
    public void powerUp(Stat stat){
        switch (stat) {
            case HP:
                maxHp+=10;
                break;
            case ATK:
                atk+=3;
                break;
            case DEF:
                def+=1;
                break;
            case HEAL:
                hea+=1;
                break;
        }
    }
    
    public int attack(){
        return atk;
    }
    
    public int defense(){
        return def;
    }
    
    public int healthPoints(){
        return hp;
    }
    
    public void heal(){
        hp=Math.min(hp+hea,maxHp);
    }
    
    public int damage(int dmg){
        hp-=dmg;
        return hp;
    }
}
