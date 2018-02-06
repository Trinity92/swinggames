/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetris.gui.TetrisMainFrame;
import tetris.tetriminos.*;

/**
 *
 * @author leandrogil
 */
public class TetrisGameState {

    // singleton instance of the TetrisGameState
    private static TetrisGameState instance = null;
    
    // synchronized keyword is used to make the getInstance() method thread-safe
    public static TetrisGameState getInstance() {
        if(instance == null) {
            instance = new TetrisGameState();
            instance.shuffleTetriminoBag();
        }
        return instance;
    }
    
    // you may change these variables to your liking
    public static final int TETRIMINO_BORDER_SIZE = 2;        // in pixels
    public static final int TETRIS_PANE_BORDER_WIDTH = 4;     // in pixels
    public static final int SINGLE_BLOCK_RADIUS = 8;          // in pixels

    // some constants (DO NOT MODIFY!)
    public static final int MAX_GRID_HEIGHT = 22;             // default height of the Tetris grid
    public static final int MAX_GRID_WIDTH = 10;              // default width of the Tetris grid
    public static final int TETRIS_PANE_WIDTH = ((MAX_GRID_WIDTH+1)*(TETRIMINO_BORDER_SIZE/2)) + (MAX_GRID_WIDTH*SINGLE_BLOCK_RADIUS*2) + (TETRIS_PANE_BORDER_WIDTH*2);
    public static final int TETRIS_PANE_HEIGHT = ((MAX_GRID_HEIGHT+1)*(TETRIMINO_BORDER_SIZE/2)) + (MAX_GRID_HEIGHT*SINGLE_BLOCK_RADIUS*2) + (TETRIS_PANE_BORDER_WIDTH*2);

    
    // list containing the generated tetriminos, in proper sequence
    private static ArrayList<Tetrimino> tetriminoBag = new ArrayList<>();
    private static int currentTetriminoBagIndex = 0;
    
    // list of all the static tetriminos on the bottom side of the field
    private static ArrayList<Tetrimino> tetriminosOnField = new ArrayList<>();
    // tetrimino that is currently falling and controllable by the player
    private static Tetrimino fallingTetrimino = null;
    
    private TetrisGameState() {}
    
    public Tetrimino getFallingTetrimino() { return fallingTetrimino; }
    public ArrayList<Tetrimino> getTetriminosOnField() { return tetriminosOnField; }
    public ArrayList<Tetrimino> getTetriminoBag() { return tetriminoBag;}
    
    public void setFallingTetrimino(Tetrimino t) { fallingTetrimino = t; }
    public void addTetriminoToField(Tetrimino t) { tetriminosOnField.add(t);}
    
    public void shuffleTetriminoBag() {
        tetriminoBag.clear();
        // populate tetromino bag
        tetriminoBag.add(new ITetrimino());
        tetriminoBag.add(new JTetrimino());
        tetriminoBag.add(new LTetrimino());
        tetriminoBag.add(new OTetrimino());
        tetriminoBag.add(new STetrimino());
        tetriminoBag.add(new TTetrimino());
        tetriminoBag.add(new ZTetrimino());
        Collections.shuffle(tetriminoBag);
    }
    
    public void spawnNextTetrimino() {
        fallingTetrimino = tetriminoBag.get(currentTetriminoBagIndex);
        currentTetriminoBagIndex = (++currentTetriminoBagIndex) % 7;
        Logger.getLogger(TetrisMainFrame.class.getName()).log(Level.INFO, "Spawned new {0}", fallingTetrimino);
    }
    
}
