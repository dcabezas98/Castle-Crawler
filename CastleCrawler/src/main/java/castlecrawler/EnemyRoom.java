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
    
    EnemyRoom(int a, int h){
        atk=a;
        hp=h;
    }
    
    public int getAttack(){
        return atk;
    }
    
    public int getHP(){
        return hp;
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
