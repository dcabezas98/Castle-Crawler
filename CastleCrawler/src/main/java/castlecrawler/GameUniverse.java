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
public class GameUniverse {
    
    private Difficulty diff;
    private Dice dice;
    private Stage stage;
    private Player player;
    private EnemyRoom enemy;
    private LootRoom loot;
    private GameState state;
    private Room currentRoom;
    
    private boolean canPeek;
    
    public GameUniverse(Difficulty d){
 
        diff = d;
        dice = new Dice(d);
        stage = new Stage(d, 1, 5, 5);
        player = new Player();
        
        state = GameState.EXPLORING;
    }
    
    public void nextStage(){
        stage = new Stage(diff, stage.getStageNumber()+1, 5, 5);
        player.recoverPeek();
        player.heal();
        player.givePoints(10);
    }
    
    public EscapeResult flee(){
        if(state == GameState.COMBAT){
            if(!dice.playerStays((float) enemy.getHp()/enemy.getMaxHp())){
                state = GameState.EXPLORING;
                return EscapeResult.YES;
            } else if(player.damage(enemy.getAttack())) // Player dies
                    return EscapeResult.DEATH;
        }
        return EscapeResult.NO;
    }
    
    public CombatResult combat(){
        
        if(state == GameState.COMBAT){
        
            state = GameState.EXPLORING; // If combat ends

            if(enemy.damage(player.attack())){ // Enemy dies
                stage.emptyCurrentRoom();
                player.heal();
                player.givePoints(1);
                if(player.giveExp(enemy.getExp()))
                    return CombatResult.LEVELUP;
                return CombatResult.WIN;
            }

            if(player.damage(enemy.getAttack())) // Player dies
                return CombatResult.LOST;

            state = GameState.COMBAT; // Combat has not ended
        }
        return CombatResult.UNFINISHED;
    }
    
    public void powerUp(Stat s){
        player.powerUp(s);
    }
    
    public void setEnemy(EnemyRoom e){
        enemy = e;
    }
    
    public Stage getStage(){
        return stage;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public boolean canPeek(){
        if(state!=GameState.EXPLORING)
            return false;
        return player.canPeek();
    }
    
    public void peek(){
        if(canPeek()){
            player.peek();
            stage.peek();
        }
    }
    
    public boolean canLoot(){
        if(state!=GameState.EXPLORING)
            return false;
        return stage.canLoot();
    }
    
    public boolean loot(){
        boolean levelUp = false;
        if(canLoot()){
            levelUp =player.giveLoot(loot);
            stage.emptyCurrentRoom();
        }
        return levelUp;
    }
    
    public boolean canMove(Move m){
        if(state == GameState.COMBAT)
            return false;
        return stage.canMove(m);
    }
    
    public RoomType move(Move m){
        if(canMove(m))
            stage.move(m);
        
        Room cRoom = stage.getCurrentRoom();
        
        switch(cRoom.getType()){
            case ENEMYROOM:
                state = GameState.COMBAT;
                enemy = (EnemyRoom) cRoom;
                break;
                
            case EVENTROOM:
                break;
                
            case LOOTROOM:
                loot = (LootRoom) cRoom;
                break;               
        }
        
        return cRoom.getType();
    }
    
    public GameState getGameState(){
        return state;
    }
    
    public int getRow(){
        return stage.getCurrentRow();
    }
    
    public int getCol(){
        return stage.getCurrentCol();
    }
    
    public int getPoints(){
        return player.getPoints();
    }
}
