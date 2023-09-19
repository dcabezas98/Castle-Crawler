/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import castlecrawler.Move;
import controller.Controller;
import castlecrawler.GameState;
import castlecrawler.MoveAction;
import castlecrawler.Interaction;
import castlecrawler.SecondAction;
import castlecrawler.Stat;
import castlecrawler.EnemyRoom;
import castlecrawler.Difficulty;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author David Cabezas
 */
public class MainView extends javax.swing.JFrame {
    
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    
    static Controller controller;
    private String appName = "Castle Crawler";

    private PlayerView playerView;
    private StageView mapView;
    
    private EnemyView enemyView;
    
    public MainView() {
        initComponents();
        mapView = new StageView();
        playerView = new PlayerView();
        enemyView = new EnemyView();
        
        pEnemy.add(enemyView);
        
        pStage.add(mapView);
        pStage.setOpaque(false);
        
        pPlayer.add(playerView);
        
        revalidate();
        repaint();
                
        setTitle(appName);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.finish(0);
            }
        });  
    }
    
    public void setController(Controller c) {
        controller = c;
    }
    
    public void updateView() {
        
        mapView.setStage(controller.getGameUniverse().getStage());
        playerView.setPlayer(controller.getGameUniverse().getPlayer());
        if(controller.getGameUniverse().getGameState() == GameState.COMBAT){
            enemyView.setVisible(true);
            enemyView.setEnemy((EnemyRoom) controller.getGameUniverse().getStage().getCurrentRoom());
        } else
            enemyView.setVisible(false);
        
        bMD.setEnabled(controller.canMove(Move.DOWN));
        bML.setEnabled(controller.canMove(Move.LEFT));
        bMR.setEnabled(controller.canMove(Move.RIGHT));
        bMU.setEnabled(controller.canMove(Move.UP));
        
        bAttack.setEnabled(controller.getGameState()==GameState.COMBAT);
        bFlee.setEnabled(controller.getGameState()==GameState.COMBAT);
        bPeek.setEnabled(controller.canPeek());
        bLoot.setEnabled(controller.canLoot());
        
        lPoints.setText(String.valueOf(controller.getPoints()));
        
        revalidate();
        repaint();   
    }
        
    public void showView() {
        setVisible(true);
    }
    
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "Exit? Are you sure?", appName, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public void deathMessage(){
        JOptionPane.showMessageDialog(this,"You died :(\n Thanks for playing!");
    }
    
    public void escapeMessage(boolean escapes){
        if(escapes)
            JOptionPane.showMessageDialog(this, "You escaped successfully!");
        else
            JOptionPane.showMessageDialog(this, "You couldn't escape!");
    }
    
    public boolean nextStageMessage(){
        return (JOptionPane.showConfirmDialog(this, "Jump to the next stage?", appName, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public Stat levelUpMessage(){
        Stat s = Stat.HP;
        String[] choices = {"HP", "Attack", "Healing Power"};
        String input = (String) JOptionPane.showInputDialog(null, "You greaw stronger.\nChoose a stat to power it up even more.",
        "Level Up!", JOptionPane.QUESTION_MESSAGE, null,
        choices, // Array of choices
        choices[0]); // Initial choice
        switch(input){
            case "HP":
                s=Stat.HP;
                break;
            case "Attack":
                s=Stat.ATK;
                break;
            case "Healing Power":
                s=Stat.HEAL;
                break;
        }
        return s;
    }
    
    public Difficulty welcomeMessage(){
        Difficulty d = Difficulty.NORMAL;
        String[] choices = {"Easy", "Normal", "Hard"};
        
        String input = (String) JOptionPane.showInputDialog(null, "Welcome to Castle Crawler!\nSelect difficulty.",
        "Level Up!", JOptionPane.QUESTION_MESSAGE, null,
        choices, // Array of choices
        choices[1]); // Initial choic
        switch(input){
            case "Easy":
                d=Difficulty.EASY;
                break;
            case "Normal":
                d=Difficulty.NORMAL;
                break;
            case "Hard":
                d=Difficulty.HARD;
                break;
        }
        return d;
    }
    
    public void eventMessage(String description){
        JOptionPane.showMessageDialog(this, description);
    }
    
    public void increaseStageCounter(){
        lStageN.setText(String.valueOf(Integer.valueOf(lStageN.getText())+1));
    }
    
    public void createKeyBindings(){
        
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0, false), MoveAction.MOVE_UP);
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0, false), MoveAction.MOVE_DOWN);
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0, false), MoveAction.MOVE_LEFT);
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0, false), MoveAction.MOVE_RIGHT);
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X,0, false), Interaction.ATTACKLOOT);
        mapView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,0, false), SecondAction.FLEEPEEK);
        
        mapView.getActionMap().put(MoveAction.MOVE_UP, new MoveAction(controller,Move.UP));
        mapView.getActionMap().put(MoveAction.MOVE_DOWN, new MoveAction(controller,Move.DOWN));
        mapView.getActionMap().put(MoveAction.MOVE_LEFT, new MoveAction(controller,Move.LEFT));
        mapView.getActionMap().put(MoveAction.MOVE_RIGHT, new MoveAction(controller,Move.RIGHT));
        mapView.getActionMap().put(Interaction.ATTACKLOOT, new Interaction(controller));
        mapView.getActionMap().put(SecondAction.FLEEPEEK, new SecondAction(controller));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pStage = new javax.swing.JPanel();
        bML = new javax.swing.JButton();
        bMD = new javax.swing.JButton();
        bMU = new javax.swing.JButton();
        bMR = new javax.swing.JButton();
        pPlayer = new javax.swing.JPanel();
        bAttack = new javax.swing.JButton();
        bFlee = new javax.swing.JButton();
        bPeek = new javax.swing.JButton();
        bLoot = new javax.swing.JButton();
        pEnemy = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lStageN = new javax.swing.JLabel();
        lPoints = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pStage.setBackground(new java.awt.Color(255, 255, 255));
        pStage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        bML.setText("LEFT");
        bML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMLActionPerformed(evt);
            }
        });

        bMD.setText("DOWN");
        bMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMDActionPerformed(evt);
            }
        });

        bMU.setText("UP");
        bMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMUActionPerformed(evt);
            }
        });

        bMR.setText("RIGHT");
        bMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMRActionPerformed(evt);
            }
        });

        pPlayer.setBackground(new java.awt.Color(255, 255, 255));
        pPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PLAYER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        bAttack.setText("Attack");
        bAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAttackActionPerformed(evt);
            }
        });

        bFlee.setText("Flee");
        bFlee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFleeActionPerformed(evt);
            }
        });

        bPeek.setText("Peek");
        bPeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPeekActionPerformed(evt);
            }
        });

        bLoot.setText("Loot");
        bLoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLootActionPerformed(evt);
            }
        });

        pEnemy.setBackground(new java.awt.Color(255, 255, 255));
        pEnemy.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENEMY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("STAGE");

        lStageN.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lStageN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lStageN.setText("1");

        lPoints.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPoints.setText("0");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("POINTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bML, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bMR, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(bMU, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(bMD, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bPeek, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bLoot, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bFlee, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pStage, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lStageN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAttack)
                            .addComponent(bFlee))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bPeek)
                            .addComponent(bLoot))
                        .addGap(18, 18, 18)
                        .addComponent(bMU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bMR)
                            .addComponent(bML)))
                    .addComponent(pStage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMD)
                    .addComponent(jLabel1)
                    .addComponent(lStageN)
                    .addComponent(lPoints)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMDActionPerformed
        controller.move(Move.DOWN);
    }//GEN-LAST:event_bMDActionPerformed

    private void bMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMLActionPerformed
        controller.move(Move.LEFT);
    }//GEN-LAST:event_bMLActionPerformed

    private void bMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMUActionPerformed
        controller.move(Move.UP);
    }//GEN-LAST:event_bMUActionPerformed

    private void bMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMRActionPerformed
        controller.move(Move.RIGHT);
    }//GEN-LAST:event_bMRActionPerformed

    private void bAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAttackActionPerformed
        controller.combat();
    }//GEN-LAST:event_bAttackActionPerformed

    private void bFleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFleeActionPerformed
        controller.flee();
    }//GEN-LAST:event_bFleeActionPerformed

    private void bPeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPeekActionPerformed
        controller.peek();
    }//GEN-LAST:event_bPeekActionPerformed

    private void bLootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLootActionPerformed
        controller.loot();
    }//GEN-LAST:event_bLootActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAttack;
    private javax.swing.JButton bFlee;
    private javax.swing.JButton bLoot;
    private javax.swing.JButton bMD;
    private javax.swing.JButton bML;
    private javax.swing.JButton bMR;
    private javax.swing.JButton bMU;
    private javax.swing.JButton bPeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lPoints;
    private javax.swing.JLabel lStageN;
    private javax.swing.JPanel pEnemy;
    private javax.swing.JPanel pPlayer;
    private javax.swing.JPanel pStage;
    // End of variables declaration//GEN-END:variables
}
