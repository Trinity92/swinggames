/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.gui;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetris.utils.TetrisGameState;

/**
 *
 * @author leandrogil
 */
public class TetrisMainFrame extends javax.swing.JFrame {

    private GameLoopWorker gameLoopWorker;                    // reference to game loop thread
            
    public TetrisMainFrame() {
        initComponents();
        tetrisPanel.setFocusable(true);
        // set preferred size
        //tetrisPanel.setPreferredSize(new Dimension(TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_WIDTH, TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_HEIGHT));
        //tetrisPanel.setMinimumSize(getPreferredSize());
        //tetrisPanel.setMaximumSize(getPreferredSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnEndGame = new javax.swing.JButton();
        btnStartGame = new javax.swing.JButton();
        tetrisPanel = new tetris.gui.TetrisPanel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setMaximumSize(new java.awt.Dimension(277, 506));
        setMinimumSize(new java.awt.Dimension(277, 506));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnEndGame.setText("End game");
        btnEndGame.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 10));
        btnEndGame.setEnabled(false);
        btnEndGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndGameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(btnEndGame, gridBagConstraints);

        btnStartGame.setText("Start game");
        btnStartGame.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 5));
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(btnStartGame, gridBagConstraints);

        tetrisPanel.setBackground(new java.awt.Color(255, 255, 255));
        tetrisPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        tetrisPanel.setMaximumSize(new Dimension(TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_WIDTH, TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_HEIGHT));
        tetrisPanel.setMinimumSize(new Dimension(TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_WIDTH, TetrisGameState.SINGLE_BLOCK_RADIUS*2*TetrisGameState.MAX_GRID_HEIGHT));
        tetrisPanel.setPreferredSize(new Dimension(TetrisGameState.TETRIS_PANE_WIDTH, TetrisGameState.TETRIS_PANE_HEIGHT));
        tetrisPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tetrisPanelKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout tetrisPanelLayout = new javax.swing.GroupLayout(tetrisPanel);
        tetrisPanel.setLayout(tetrisPanelLayout);
        tetrisPanelLayout.setHorizontalGroup(
            tetrisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tetrisPanelLayout.setVerticalGroup(
            tetrisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(tetrisPanel, gridBagConstraints);

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("<html>Click on the \"Start game\" button<br />to begin a new Tetris game.</html>");
        lblStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(lblStatus, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndGameActionPerformed
        // set loop flag in game loop worker instance to false
        gameLoopWorker.setGameIsRunningFlag();
        try {
            while(!gameLoopWorker.isDone()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TetrisMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnStartGame.setEnabled(true);
        btnEndGame.setEnabled(false);
    }//GEN-LAST:event_btnEndGameActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        // instantiate game loop thread to start the game
        gameLoopWorker = new GameLoopWorker(this);
        gameLoopWorker.execute();
        btnStartGame.setEnabled(false);
        btnEndGame.setEnabled(true);
        //System.out.println(tetrisPanel.getPreferredSize() + " <> " + tetrisPanel.getSize() + " <> " + TetrisGameState.TETRIS_PANE_WIDTH + "x" + TetrisGameState.TETRIS_PANE_HEIGHT);
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void tetrisPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tetrisPanelKeyTyped
        
    }//GEN-LAST:event_tetrisPanelKeyTyped

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
            java.util.logging.Logger.getLogger(TetrisMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TetrisMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TetrisMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TetrisMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TetrisMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEndGame;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JLabel lblStatus;
    private tetris.gui.TetrisPanel tetrisPanel;
    // End of variables declaration//GEN-END:variables
        
}
