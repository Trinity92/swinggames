/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.Orientation;
import java.awt.Graphics;
import tetris.utils.XYCoord;
import tetris.gui.TetrisMainFrame;

/**
 *
 * @author leandrogil
 */
public class LTetrimino extends Tetrimino {

    public LTetrimino() {
        // spawn tetrimino on 4th column of the spawn row and 4th-6th of the row below
        this(new XYCoord(TetrisMainFrame.SINGLE_BLOCK_RADIUS*8, 0));
    }
    
    public LTetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 4th column of the spawn row and 4th-6th of the row below
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(spawnLocation.getX(), spawnLocation.getY()-(TetrisMainFrame.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisMainFrame.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY()+(TetrisMainFrame.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[3] = new XYCoord(shapeCoords[1].getX() + (TetrisMainFrame.SINGLE_BLOCK_RADIUS*4), spawnLocation.getY()+(TetrisMainFrame.SINGLE_BLOCK_RADIUS*2));
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
