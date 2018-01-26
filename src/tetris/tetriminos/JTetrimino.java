/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.Orientation;
import tetris.utils.TetrisGameState;
import tetris.utils.XYCoord;

/**
 *
 * @author leandrogil
 */
public class JTetrimino extends Tetrimino {

    public JTetrimino() {
        // spawn tetrimino on 4th column of the spawn row and 4th-6th of the row below
        this(new XYCoord(TetrisGameState.SINGLE_BLOCK_RADIUS*8, TetrisGameState.SINGLE_BLOCK_RADIUS*2));
    }
    
    public JTetrimino(XYCoord spawnLocation) {
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(spawnLocation.getX(), spawnLocation.getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2));
        shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
        shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2), spawnLocation.getY());
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
