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
public class STetrimino extends Tetrimino {

    public STetrimino() {
        // spawn tetrimino on 5th-6th column of the spawn row and 4th-5th of the row below
        this(new XYCoord(TetrisGameState.SINGLE_BLOCK_RADIUS*8, 0));
    }
    
    public STetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 5th-6th column of the spawn row and 4th-5th of the row below (main mino: second bottom one)
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(spawnLocation.getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        shapeCoords[2] = new XYCoord(spawnLocation.getX(), spawnLocation.getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[3] = new XYCoord(shapeCoords[2].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2), shapeCoords[2].getY());
        this.color = Color.RED;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "S-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
}
