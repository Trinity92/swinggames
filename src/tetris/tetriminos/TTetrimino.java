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
public class TTetrimino extends Tetrimino {

    public TTetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 5th column of the spawn row and 4th-6th of the row below
        //this(new XYCoord(TetrisGame.SINGLE_BLOCK_RADIUS*8, TetrisGame.SINGLE_BLOCK_RADIUS*2));     
    }
    
    public TTetrimino() {
        //shapeCoords[0] = spawnLocation;
        //shapeCoords[1] = new XYCoord(spawnLocation.getX(), spawnLocation.getY()+(TetrisGame.SINGLE_BLOCK_RADIUS*2));
        //shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisGame.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        //shapeCoords[3] = new XYCoord(shapeCoords[1].getX() - (TetrisGame.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        this.color = Color.PINK;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "T-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }

}
