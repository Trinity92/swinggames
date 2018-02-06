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
import tetris.utils.TetrisGameState;

/**
 *
 * @author leandrogil
 */
public class ZTetrimino extends Tetrimino {

    public ZTetrimino() {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        this(new XYCoord(TetrisGameState.SINGLE_BLOCK_RADIUS*8, TetrisGameState.SINGLE_BLOCK_RADIUS*2));
    }
    
    public ZTetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(spawnLocation.getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        shapeCoords[2] = new XYCoord(shapeCoords[1].getX(), spawnLocation.getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2), shapeCoords[2].getY());
        this.color = Color.RED;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // TODO: update tetrimino coordinates after left-rotation
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        
        // TODO: update tetrimino coordinates after right-rotation
    }
    
    @Override
    public String toString() {
        return "Z-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
}
