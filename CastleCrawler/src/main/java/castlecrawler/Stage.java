/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import java.util.List;

/**
 *
 * @author David Cabezas
 */
public class Stage {
    
    private int nRows;
    private int nCols; 
    private Room[][] map;
    private Difficulty diff;
    private Dice dice;
    
    Stage(Difficulty d, int nR, int nC){
        diff = d;
        nRows=nR;
        nCols=nC;
        map = new Room[nRows][nCols];
        dice = new Dice(diff);
        
        int nLootRoom=dice.nLootRoom(nRows*nCols);
        int nEnemyRoom=dice.nEnemyRoom(nRows*nCols);
        int nEventRoom=dice.nEventRoom(nRows*nCols);
                
        while(nLootRoom+nEnemyRoom+nEventRoom+2>nRows*nCols){
            nLootRoom--;
            nEnemyRoom--;
        }
        
        //System.out.println("L "+ nLootRoom + " E "+nEnemyRoom+" V "+nEventRoom);
        
        List<Integer> seq = dice.randomSequence(nRows*nCols); // Shuffled room numbers

        int r = 0; // Room counter
        map[seq.get(r)/nRows][seq.get(r)%nRows] = new StartRoom();
        r++;
        for (; r < nLootRoom+1; r++){
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new LootRoom();
        }
        for (; r < nEnemyRoom+nLootRoom+1; r++){
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EnemyRoom();
        }
        for (; r < nEventRoom+nEnemyRoom+nLootRoom+1; r++){
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EventRoom();
        }
        for (; r < nRows*nCols-1; r++){
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EmptyRoom();
        }
        map[seq.get(r)/nRows][seq.get(r)%nRows] = new FinalRoom();
    }
    
    @Override
    public String toString(){
        String str="";
        for (int i = 0; i < nRows; i++){
            for (int j = 0; j < nCols; j++){
                str+=map[i][j].toString()+" ";
            }
            str+="\n";
        }
        
        return str;
    }
}
