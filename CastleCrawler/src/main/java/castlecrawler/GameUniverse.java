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
    private GameState state;
    private Room currentRoom;
    
    private boolean canPeek;
    
    public GameUniverse(Difficulty d){
 
        diff = d;
        dice = new Dice(d);
        stage = new Stage(d, 5, 5);
        player = new Player();
        
        state = GameState.EXPLORING;
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
                player.giveExp(enemy.getExp());
                return CombatResult.WIN;
            }

            if(player.damage(enemy.getAttack())) // Player dies
                return CombatResult.LOST;

            state = GameState.COMBAT; // Combat has not ended
        }
        return CombatResult.UNFINISHED;
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
    
    public boolean canMove(Move m){
        if(state == GameState.COMBAT)
            return false;
        return stage.canMove(m);
    }
    
    public void move(Move m){
        if(canMove(m))
            stage.move(m);
        
        Room cRoom = stage.getCurrentRoom();
        if(cRoom.getType()==RoomType.ENEMYROOM){
            state = GameState.COMBAT;
            enemy = (EnemyRoom) cRoom;
        }
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
}
