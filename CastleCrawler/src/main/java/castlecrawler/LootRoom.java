/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

/**
 *
 * @author David Cabezas
 */
public class LootRoom extends Room {
    
    private int exp;
    private int points;
    
    LootRoom(int e, int p){
        exp=e;
        points=p;
    }
    
    LootRoom(LootRoom r){
        this(r.exp, r.points);
    }
    
    @Override
    public RoomType getType() {
        return RoomType.LOOTROOM;
    }
    
    public int getExp(){
        return exp;
    }
    
    public int getPoints(){
        return points;
    }
    
    @Override
    public String toString(){
        return "L";
    }
}
