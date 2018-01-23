/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import java.awt.Graphics;
import tetris.utils.Orientation;
import tetris.utils.XYCoord;
import tetris.gui.TetrisMainFrame;

/**
 *
 * @author leandrogil
 */
public class JTetrimino extends Tetrimino {

    public JTetrimino() {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        //this(new XYCoord(TetrisGame.SINGLE_BLOCK_RADIUS*8, TetrisGame.SINGLE_BLOCK_RADIUS*2));
    }
    
    public JTetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        //hapeCoords[0] = spawnLocation;
        //shapeCoords[1] = new XYCoord(spawnLocation.getX() + (TetrisGame.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        //shapeCoords[2] = new XYCoord(shapeCoords[1].getX(), spawnLocation.getY() - (TetrisGame.SINGLE_BLOCK_RADIUS*2));
        //shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGame.SINGLE_BLOCK_RADIUS*2), shapeCoords[2].getY());
        this.color = Color.ORANGE;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "J-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }

}
