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
public class ITetrimino extends Tetrimino {

    public ITetrimino() {
        // spawn tetrimino on the 22nd row, across the 4th and 7th columns by default
        this(new XYCoord(TetrisMainFrame.SINGLE_BLOCK_RADIUS*7, TetrisMainFrame.SINGLE_BLOCK_RADIUS));
    }
    
    public ITetrimino(XYCoord spawnLocation) {
        shapeCoords[0] = new XYCoord(spawnLocation.getX(), spawnLocation.getY());
        shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + (TetrisMainFrame.SINGLE_BLOCK_RADIUS*2), shapeCoords[0].getY());
        shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisMainFrame.SINGLE_BLOCK_RADIUS*2), shapeCoords[0].getY());
        shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisMainFrame.SINGLE_BLOCK_RADIUS*2), shapeCoords[0].getY());
        this.color = Color.CYAN;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "I-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
}
