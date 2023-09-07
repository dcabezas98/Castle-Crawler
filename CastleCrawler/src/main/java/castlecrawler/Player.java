/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

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
    
    private int row;
    private int col;
    
    Player(int r, int c){
        maxHp=100;
        hp=100;
        atk=30;
        def=10;
        hea=1;
        
        level=1;
        expTo=10;
        
        row=r;
        col=c;
    }
    
    void levelUp(){
        level++;
        expTo=10;
        maxHp+=10;
        atk+=3;
        def+=1;
        hea+=1;
        // power up stat
        heal();
    }
    
    void powerUp(Stat stat){
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
    
    int attack(){
        return atk;
    }
    
    int defense(){
        return def;
    }
    
    int healthPoints(){
        return hp;
    }
    
    void heal(){
        hp=Math.min(hp+hea,maxHp);
    }
    
    int damage(int dmg){
        hp-=dmg;
        return hp;
    }
}
