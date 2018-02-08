/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.*;

/**
 *
 * @author leandrogil
 */
public class ITetrimino extends Tetrimino {

    public ITetrimino() {
        // spawn tetrimino on the 22nd row, across the 4th and 7th columns by default
        this(new XYCoord(TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.SINGLE_BLOCK_RADIUS*7) + (TetrisGameState.TETRIMINO_BORDER_SIZE*2), TetrisGameState.SINGLE_BLOCK_RADIUS + (TetrisGameState.TETRIMINO_BORDER_SIZE/2) + TetrisGameState.TETRIS_PANE_BORDER_WIDTH));
    }
    
    public ITetrimino(XYCoord spawnLocation) {
        // NOTE: Java Swing borders of components are drawn in the inside (meaning: the thickness of borders will grow towards the inside only if you increase the thickness)
        shapeCoords[0] = new XYCoord(spawnLocation.getX(), spawnLocation.getY());
        shapeCoords[1] = new XYCoord(shapeCoords[0].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[0].getY());
        shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[0].getY());
        shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[0].getY());
        this.color = Color.CYAN;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        // update tetrimino coordinates after left-rotation
        // (coordinates are ordered from left to right, or top to bottom otherwise)
        switch(orientation) {
            case WEST:
                shapeCoords[0] = new XYCoord(shapeCoords[0].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[0].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX(), shapeCoords[1].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                break;
            case EAST:
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[1] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[0] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*4) - TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case NORTH:
                shapeCoords[2] = shapeCoords[1];
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[2].getY());
                shapeCoords[1] = new XYCoord(shapeCoords[2].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[2].getY());
                shapeCoords[0] = new XYCoord(shapeCoords[1].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                break;
            case SOUTH:
                shapeCoords[1] = shapeCoords[2];
                shapeCoords[0] = new XYCoord(shapeCoords[1].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                break;
        }
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        // update tetrimino coordinates after right-rotation
        switch(orientation) {
            case WEST:
                shapeCoords[2] = shapeCoords[1];
                shapeCoords[0] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*4) - TetrisGameState.TETRIMINO_BORDER_SIZE);
                shapeCoords[1] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                break;
            case EAST:
                shapeCoords[1] = shapeCoords[2];
                shapeCoords[0] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[2] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX(), shapeCoords[2].getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*4) + TetrisGameState.TETRIMINO_BORDER_SIZE);
                break;
            case NORTH:
                shapeCoords[0] = new XYCoord(shapeCoords[1].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                shapeCoords[2] = new XYCoord(shapeCoords[1].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[1].getY());
                shapeCoords[3] = new XYCoord(shapeCoords[1].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*4) + TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[1].getY());
                break;
            case SOUTH:
                shapeCoords[0] = new XYCoord(shapeCoords[2].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*4) - TetrisGameState.TETRIMINO_BORDER_SIZE, shapeCoords[2].getY());
                shapeCoords[1] = new XYCoord(shapeCoords[2].getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[2].getY());
                shapeCoords[3] = new XYCoord(shapeCoords[2].getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords[2].getY());
                break;
        }
    }
    
}
