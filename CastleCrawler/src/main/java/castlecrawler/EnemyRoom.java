/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class EnemyRoom extends Room {
    
    private int atk;
    private int hp;
    private int maxHp;
    private int exp;
    private String description;
    
    EnemyRoom(int a, int h, int e, String d){
        atk=a;
        maxHp=h;
        hp=h;
        exp=e;
        description = d;
    }
    
    EnemyRoom(EnemyRoom e){
        this(e.atk, e.hp, e.exp, e.description);
        maxHp=e.maxHp;
    }
    
    public int getAttack(){
        return atk;
    }
    
    public int getHp(){
        return hp;
    }
    
    public int getMaxHp(){
        return maxHp;
    }
    
    public int getExp(){
        return exp;
    }
    
    public String getDescription(){
        return description;
    }
    
    public boolean damage(int dmg){
        hp-=dmg;
        return hp <= 0; // Death
    }
    
    public void buff(int a, int h){ // Increase enemy strength according to stage number
        atk+=a;
        maxHp+=h;
        hp=maxHp;
    }
    
    @Override
    public RoomType getType() {
        return RoomType.ENEMYROOM;
    }
    
    @Override
    public String toString(){
        return "E";
    }
}
