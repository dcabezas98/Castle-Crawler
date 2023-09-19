/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author David Cabezas
 */
public class Dice {
    
    private float ENEMYPROB1;
    private float EVENTPROB1;
    private float LOOTPROB1;
    private float ENEMYPROB2;
    private float EVENTPROB2;
    private float LOOTPROB2;
    private float STAYPROB;
    private Difficulty dif;
    private Random generator;
    
    Dice(Difficulty... d){
        ENEMYPROB1 = 0.45f;
        ENEMYPROB2 = 0.55f;
        EVENTPROB1 = 0.05f;
        EVENTPROB2 = 0.15f;
        LOOTPROB1 = 0.1f;
        LOOTPROB2 = 0.3f;
        STAYPROB = 0.5f;
        generator = new Random();
        dif = d.length>0 ? d[0] : Difficulty.NORMAL;
        
        if (dif==Difficulty.EASY){
            ENEMYPROB1 = 0.4f;
            ENEMYPROB2 = 0.5f;
            LOOTPROB1 = 0.15f;            
            LOOTPROB2 = 0.35f;
            STAYPROB = 0.4f;
        } else if (dif==Difficulty.HARD){
            ENEMYPROB1 = 0.5f;
            ENEMYPROB2 = 0.6f;
            LOOTPROB1 = 0.05f;
            LOOTPROB2 = 0.25f;
            STAYPROB = 0.6f;
        }
    }
    
    int nLootRoom(int size){
        float x = generator.nextFloat()*(LOOTPROB2-LOOTPROB1)+LOOTPROB1;
        return Math.round(size*x);
    }
    
    int nEnemyRoom(int size){
        float x = generator.nextFloat()*(ENEMYPROB2-ENEMYPROB1)+ENEMYPROB1;
        return Math.round(size*x);
    }
    
    int nEventRoom(int size){
        float x = generator.nextFloat()*(EVENTPROB2-EVENTPROB1)+EVENTPROB1;
        return Math.round(size*x);
    }
    
    boolean playerStays(float enemyHp){
        float x = generator.nextFloat();
        return enemyHp*STAYPROB>x;
    }
    
    int nHealNap(){
        return generator.nextInt(1,4);
    }
    
    List<Integer> randomSequence(int size) {
        List<Integer> ret = new ArrayList<>(size);
        for (int i=0; i<size; i++) {
          ret.add(i);
        }
        java.util.Collections.shuffle(ret);
        return ret;  
    }       
 

}
