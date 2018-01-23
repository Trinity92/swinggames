/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import tetris.utils.TetrisGameState;

/**
 *
 * @author leandrogil
 */
public class GameLoopThread extends Thread {
    
    // boolean that indicates if a game is running
    private boolean gameIsRunning = true;
    private TetrisMainFrame tetrisGameInstance;      // reference to TetrisGame instance needed for GUI updating
    
    public GameLoopThread(TetrisMainFrame tetrisGameInstance) {
        this.tetrisGameInstance = tetrisGameInstance;
    }
    
    public boolean gameIsRunning() { return gameIsRunning;}

   @Override
    public void run() { 
        int tetriminoCount = 0;
        while(gameIsRunning) {
            // shuffle tetrimino bag if all tetrimino types has spawned already
            if(tetriminoCount == 7) {
                TetrisGameState.getInstance().shuffleTetriminoBag();
                tetriminoCount = 0;
            }
            
            // make Tetrominos move downward at a fix interval
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameLoopThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(TetrisGameState.getInstance().getFallingTetrimino() == null) {
                TetrisGameState.getInstance().spawnNextTetrimino();
            }
            TetrisGameState.getInstance().getFallingTetrimino().moveShapeDown();
            tetrisGameInstance.revalidate();
            tetrisGameInstance.repaint();
            tetriminoCount++;
        }
    }
    
}
