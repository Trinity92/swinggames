/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
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
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // update tetrimino coordinates after left-rotation
        // (coordinates are ordered like so: first the two middle blocks, then from top to bottom/left to right depending on orientation)
        switch(orientation) {
            case WEST:
                shapeCoords[1] = shapeCoords[2];
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX(), shapeCoords[1].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                break;
            case EAST:
                shapeCoords[1] = shapeCoords[3];
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                shapeCoords[3] = new XYCoord(shapeCoords[1].getX(), shapeCoords[1].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                break;
            case NORTH:
                shapeCoords[2] = shapeCoords[1];
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                shapeCoords[3] = new XYCoord(shapeCoords[1].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[1].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                break;
            case SOUTH:
                shapeCoords[1] = shapeCoords[3];
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[1].getY());
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[0].getY());
                break;
        }
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        
        // update tetrimino coordinates after right-rotation
        // (coordinates are ordered like so: first the two middle blocks, then from top to bottom/left to right depending on orientation)
        switch(orientation) {
            case WEST:
                shapeCoords[3] = shapeCoords[1];
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[0].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX(), shapeCoords[1].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                break;
            case EAST:
                shapeCoords[2] = shapeCoords[1];
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[0].getY());
                shapeCoords[3] = new XYCoord(shapeCoords[1].getX(), shapeCoords[1].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                break;
            case NORTH:
                shapeCoords[2] = shapeCoords[1];
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                shapeCoords[3] = new XYCoord(shapeCoords[1].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[1].getY());
                break;
            case SOUTH:
                shapeCoords[3] = shapeCoords[1];
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2);
                shapeCoords[1] = new XYCoord(shapeCoords[1].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2, shapeCoords[1].getY());
                break;
        }

    }
    
    @Override
    public String toString() {
        return "S-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
}
