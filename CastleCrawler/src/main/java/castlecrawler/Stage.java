/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castlecrawler;

import castlecrawler.Move;
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
    
    private int currentR;
    private int currentC;
    
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
        currentR = seq.get(r)/nRows;
        currentC = seq.get(r)%nRows;
        map[currentR][currentC] = new StartRoom();
        map[currentR][currentC].show();
        map[currentR][currentC].select();
        r++;
        
        for (; r < nLootRoom+1; r++){
            
            // int[] ep = dice.getLootStats()
            int e = 1;
            int p = 2;
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new LootRoom(e, p);
        }
        for (; r < nEnemyRoom+nLootRoom+1; r++){
            
            // int[] ahep = dice.getEnemyStats()
            int a = 10;
            int h = 50;
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EnemyRoom(a,h);
        }
        for (; r < nEventRoom+nEnemyRoom+nLootRoom+1; r++){
            // String des = dealer.getEvent() 
            String des = "TODO: descripción";
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EventRoom(des);
        }
        for (; r < nRows*nCols-1; r++){
            map[seq.get(r)/nRows][seq.get(r)%nRows] = new EmptyRoom();
        }
        map[seq.get(r)/nRows][seq.get(r)%nRows] = new FinalRoom();
    }
    
    public Room[][] getMap(){
        return map;
    }
    
    public int getNRows(){
        return nRows;
    }
    
    public int getNCols(){
        return nCols;
    }
    
    public int getCurrentRow(){
        return currentR;
    }
    
    public int getCurrentCol(){
        return currentC;
    }
    
    public void move(Move m){
        map[currentR][currentC].deselect();           
        switch (m){
            case UP:
                currentR--;
                break;
            case DOWN:
                currentR++;
                break;
            case LEFT:
                currentC--;
                break;
            case RIGHT:
                currentC++;
        }
        map[currentR][currentC].select();
        map[currentR][currentC].show();      
    }
        
    public boolean canMove(Move m){
        boolean can = false;
        switch(m){
            case UP:
                can = (currentR > 0);
                break;
            case DOWN:
                can = (currentR < nRows-1);
                break;
            case LEFT:
                can = (currentC > 0);
                break;
            case RIGHT:
                can = (currentC < nCols-1);
        }
        return can;
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
