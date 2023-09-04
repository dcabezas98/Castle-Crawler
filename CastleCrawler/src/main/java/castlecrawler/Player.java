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
    
    private int hp;
    private int atk;
    private int def;
    private int heal;
    
    private int level;
    private int expTo;
    
    private int row;
    private int col;
    
    Player(int h, int he, int a, int d){
        hp=10;
        atk=a;
        def=d;
        heal=he;
        
        level=1;
        expTo=10;
        
        row=0;
        col=0;
    }
    
    void levelUp(){
        level++;
        expTo=10;
        hp+=10;
        atk+=3;
        def+=1;
        heal+=1;
        // power up stat
    }
    
    void powerUp(Stat stat){
        switch (stat) {
            case HP:
                hp+=10;
                break;
            case ATK:
                atk+=3;
                break;
            case DEF:
                def+=1;
                break;
            case HEAL:
                heal+=1;
                break;
        }
    }
}
