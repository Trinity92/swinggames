/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import tetris.utils.TetrisGameState;

/**
 *
 * @author leandrogil
 */
public class GameLoopWorker extends SwingWorker<Boolean, Void> {
    
    // boolean that indicates if a game is running
    private boolean gameIsRunning = true;
    private boolean gameOver = false;
    private TetrisMainFrame tetrisMainFrame;      // reference to TetrisGame instance needed for GUI updating
    
    public GameLoopWorker(TetrisMainFrame tetrisGameInstance) {
        this.tetrisMainFrame = tetrisGameInstance;
    }
    
    public boolean gameIsRunning() { return gameIsRunning;}
    public void setGameIsRunningFlag() { gameIsRunning = false; }

    @Override
    protected Boolean doInBackground() throws Exception {
        long timeRef = System.currentTimeMillis();
        int tetriminoCount = 0;
        while(gameIsRunning) {
            // shuffle tetrimino bag if all tetrimino types have spawned already
            if(tetriminoCount == 7) {
                TetrisGameState.getInstance().shuffleTetriminoBag();
                tetriminoCount = 0;
            }
            
            // make Tetriminos move downward at a fixed interval of 1 second
            if(System.currentTimeMillis() - timeRef > 1000) {
                synchronized(TetrisGameState.getInstance().getFallingTetrimino()) {
                    TetrisGameState.getInstance().getFallingTetrimino().moveShapeDown();
                }
                timeRef = System.currentTimeMillis() + (System.currentTimeMillis()-timeRef-1000);
                tetrisMainFrame.revalidate();
                tetrisMainFrame.repaint();
            }
            
            // spawn next tetrimino in bag if current one has been placed already
            if(TetrisGameState.getInstance().getFallingTetrimino() == null) {
                TetrisGameState.getInstance().spawnNextTetrimino();
                tetriminoCount++;
            }
                  
        }
        return gameOver;
    }
    
    @Override
    public void done() {
        // reset game state (tetriminos, bag, etc.)
        TetrisGameState.getInstance().setFallingTetrimino(null);
        TetrisGameState.getInstance().getTetriminosOnField().clear();
        tetrisMainFrame.revalidate();
        tetrisMainFrame.repaint();
    }
    
}
