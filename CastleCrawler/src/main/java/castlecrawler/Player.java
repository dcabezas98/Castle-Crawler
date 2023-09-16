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
    
    private int peeks;
    
    Player(){
        maxHp=100;
        hp=100;
        atk=30;
        hea=2;
        peeks=1;
        
        level=1;
        expTo=10;
    }
    
    public void levelUp(){
        level++;
        expTo=10;
        maxHp+=10;
        atk+=3;
        hea+=2;
        peeks+=1;
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
            case HEAL:
                hea+=1;
                break;
        }
    }
    
    public int getHp(){
        return hp;
    }
    
    public int getMaxHp(){
        return maxHp;
    }
    
    public int attack(){
        return atk;
    }

    public boolean canPeek(){
        return peeks>0;
    }
    
    public void peek(){
        if(canPeek())
            peeks--;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getXPto(){
        return expTo;
    }
    
    public int getHeal(){
        return hea;
    }
    
    public void heal(){
        hp=Math.min(hp+hea,maxHp);
    }
    
    public boolean damage(int dmg){
        hp-=dmg;
        return hp <= 0; // Death
    }
    
    public void giveExp(int e){
        expTo-=e;
        if(expTo<=0)
            levelUp();
    }
}
