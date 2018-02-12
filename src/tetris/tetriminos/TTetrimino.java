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
public class TTetrimino extends Tetrimino {

    public TTetrimino() {
        // spawn tetrimino on 5th column of the spawn row and 4th-6th of the row below
        this(new XYCoord(TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.SINGLE_BLOCK_RADIUS*7) + (TetrisGameState.TETRIMINO_BORDER_SIZE*2), TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.SINGLE_BLOCK_RADIUS*3) + (TetrisGameState.TETRIMINO_BORDER_SIZE)));     
    }
    
    public TTetrimino(XYCoord spawnLocation) {
        shapeCoords.add(spawnLocation);
        shapeCoords.add(new XYCoord(spawnLocation.getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), spawnLocation.getY()));
        shapeCoords.add(new XYCoord(spawnLocation.getX(), spawnLocation.getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
        shapeCoords.add(new XYCoord(spawnLocation.getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), spawnLocation.getY()));
        this.color = Color.PINK;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // update tetrimino coordinates after left-rotation
        // (coordinates are ordered like so: first is always middle block, then top to bottom or left to right depending on orientation)
        switch(orientation) {
            case WEST:
                XYCoord tempCoordW = shapeCoords.get(1);
                shapeCoords.set(1, shapeCoords.get(2));
                shapeCoords.set(2, tempCoordW);
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case EAST:
                XYCoord tempCoordE = shapeCoords.get(3);
                shapeCoords.set(3, shapeCoords.get(2));
                shapeCoords.set(2, tempCoordE);
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                shapeCoords.set(3, shapeCoords.get(2));
                shapeCoords.set(2, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
            case SOUTH:
                shapeCoords.set(1, shapeCoords.get(2));
                shapeCoords.set(2, shapeCoords.get(3));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
        }
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        
        // update tetrimino coordinates after right-rotation
        // (coordinates are ordered like so: first is always middle block, then top to bottom or left to right depending on orientation)
        switch(orientation) {
            case WEST:
                shapeCoords.set(3, shapeCoords.get(2));
                shapeCoords.set(2, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case EAST:
                shapeCoords.set(1, shapeCoords.get(2));
                shapeCoords.set(2, shapeCoords.get(3));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                XYCoord tempCoordN = shapeCoords.get(1);
                shapeCoords.set(1, shapeCoords.get(2));
                shapeCoords.set(2, tempCoordN);
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
            case SOUTH:
                XYCoord tempCoordS = shapeCoords.get(2);
                shapeCoords.set(2, shapeCoords.get(3));
                shapeCoords.set(3, tempCoordS);
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
        }
    }

}
