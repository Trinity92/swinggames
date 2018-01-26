/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.Orientation;
import tetris.utils.XYCoord;
import tetris.gui.TetrisMainFrame;
import tetris.utils.TetrisGameState;

/**
 *
 * @author leandrogil
 */
public class LTetrimino extends Tetrimino {

    public LTetrimino() {
        // spawn tetrimino on 6th column of the spawn row and 4th-6th of the row below
        this(new XYCoord(TetrisGameState.SINGLE_BLOCK_RADIUS*12, TetrisGameState.SINGLE_BLOCK_RADIUS*2));
    }
    
    public LTetrimino(XYCoord spawnLocation) {
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(spawnLocation.getX(), spawnLocation.getY()-(TetrisGameState.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[2] = new XYCoord(shapeCoords[0].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        shapeCoords[3] = new XYCoord(shapeCoords[0].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*4), spawnLocation.getY());
        this.color = Color.BLUE;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "L-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
}
