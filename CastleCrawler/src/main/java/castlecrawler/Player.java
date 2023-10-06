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
    private int points;
    private int hea;
    
    private int level;
    private int expTo;
    
    private boolean canPeek;
    
    Player(){
        maxHp=100;
        hp=100;
        atk=30;
        hea=2;
        canPeek=true;
        points=0;
        
        level=1;
        expTo=10;
    }
    
    public void levelUp(){
        level++;
        expTo=10+level/2;
        maxHp+=7;
        hp=Math.min(hp+7,maxHp);
        atk+=2;
        hea+=1;
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
                hea+=2;
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
        return canPeek;
    }
    
    public void peek(){
        canPeek=false;
    }
    
    public void recoverPeek(){
        canPeek=true;
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
    
    public int getpoints(){
        return points;
    }
    
    public void heal(){
        hp=Math.min(hp+hea,maxHp);
    }
    
    public boolean damage(int dmg){
        hp-=dmg;
        return hp <= 0; // Death
    }
    
    public boolean giveExp(int e){
        expTo-=e;
        if(expTo<=0){
            levelUp();
            return true;
        }
        return false;
    }
    
    public void givePoints(int p){
        points+=p;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void eventDmg(boolean severe){
        int dmg;
        if(severe)
            dmg=(int) Math.round(maxHp*0.15);
        else
            dmg=(int) Math.round(maxHp*0.05);
        hp=Math.max(1, hp-dmg);
    }
    
    public void powerUp(){
        atk+=5;
        hp=maxHp;
    }
    
    public boolean giveLoot(LootRoom r){
        
        points+=r.getPoints();
        
        return giveExp(r.getExp());
    }
}
