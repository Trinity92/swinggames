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
        try {
            long timeRef = System.currentTimeMillis();
            TetrisGameState.getInstance().resetGameState();
            while(gameIsRunning) {
                // make Tetriminos move downward at a fixed interval of 1 second
                if(System.currentTimeMillis() - timeRef > 1000) {

                    synchronized(TetrisGameState.getInstance().getFallingTetrimino()) {
                        // spawn next tetrimino in bag if current one has been placed already
                        if(!TetrisGameState.getInstance().getFallingTetrimino().canBeMovedDown()) {
                            // check if any rows can be cleared
                            TetrisGameState.getInstance().spawnNextTetrimino();
                            if(TetrisGameState.getInstance().getTetriminosOnField().size() > 2)
                                TetrisGameState.getInstance().clearRows();
                        }
                    }
                    synchronized(TetrisGameState.getInstance().getFallingTetrimino()) {
                        TetrisGameState.getInstance().getFallingTetrimino().moveShapeDown();
                    }

                    timeRef = System.currentTimeMillis() + (System.currentTimeMillis()-timeRef-1000);
                    tetrisMainFrame.revalidate();
                    tetrisMainFrame.repaint();
                }       
            }
        } catch (Exception e) {
            System.err.println("Caught exception in GameLoopWorker thread!");
            e.printStackTrace();
            throw e;
        }
        return gameOver;
    }
    
    @Override
    public void done() {
        // reset game state (tetriminos, bag, etc.)
        //TetrisGameState.getInstance().setFallingTetrimino(null);
        //TetrisGameState.getInstance().getTetriminosOnField().clear();
        //tetrisMainFrame.revalidate();
        //tetrisMainFrame.repaint();
    }
    
}
