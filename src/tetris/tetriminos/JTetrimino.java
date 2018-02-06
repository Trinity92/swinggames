/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.TetrisGameState;
import tetris.utils.XYCoord;

/**
 *
 * @author leandrogil
 */
public class JTetrimino extends Tetrimino {

    public JTetrimino() {
        // spawn tetrimino on 4th column of the spawn row and 4th-6th of the row below
        this(new XYCoord(TetrisGameState.SINGLE_BLOCK_RADIUS*7+3*TetrisGameState.TETRIMINO_BORDER_SIZE, TetrisGameState.SINGLE_BLOCK_RADIUS+TetrisGameState.TETRIMINO_BORDER_SIZE));
    }
    
    public JTetrimino(XYCoord spawnLocation) {
        shapeCoords[0] = spawnLocation;
        shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
        shapeCoords[2] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
        shapeCoords[3] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
        this.color = Color.ORANGE;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // update tetrimino coordinates after left-rotation
        // (TODO: coordinates are ordered like so: first the middle block, then the two neighbouring blocks on one end, and finally the single block at the other end)
        switch(orientation) {
            case WEST:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case EAST:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case NORTH:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                break;
            case SOUTH:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                break;
        }
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        // update tetrimino coordinates after right-rotation
        // (TODO: coordinates are ordered like so: first the middle block, then the two neighbouring blocks on one end, and finally the single block at the other end)
        switch(orientation) {
            case WEST:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case EAST:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX(), shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case NORTH:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                break;
            case SOUTH:
                shapeCoords[1] = new XYCoord(shapeCoords[0].getX() - TetrisGameState.SINGLE_BLOCK_RADIUS*2-TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[3] = new XYCoord(shapeCoords[0].getX() + TetrisGameState.SINGLE_BLOCK_RADIUS*2+TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[0].getY());
                break;
        }
    }
    
    @Override
    public String toString() {
        return "J-Tetrimino[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }

}
