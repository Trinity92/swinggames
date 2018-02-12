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
public class ZTetrimino extends Tetrimino {

    public ZTetrimino() {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        this(new XYCoord(TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.SINGLE_BLOCK_RADIUS*7) + (TetrisGameState.TETRIMINO_BORDER_SIZE*2), TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.TETRIMINO_BORDER_SIZE/2) + TetrisGameState.SINGLE_BLOCK_RADIUS));
    }
    
    public ZTetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 4th-5th column of the spawn row and 5th-6th of the row below
        shapeCoords.add(spawnLocation);
        shapeCoords.add(new XYCoord(spawnLocation.getX(), spawnLocation.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
        shapeCoords.add(new XYCoord(spawnLocation.getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), spawnLocation.getY()));
        shapeCoords.add(new XYCoord(spawnLocation.getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(2).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
        this.color = Color.RED;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // update tetrimino coordinates after left-rotation
        // (coordinates are ordered like so: first the two middle blocks (first of those: left/top-most middle block), then from top to bottom/left to right depending on orientation)
        switch(orientation) {
            case WEST:
                shapeCoords.set(2, shapeCoords.get(0));
                shapeCoords.set(0, new XYCoord(shapeCoords.get(1).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case EAST:
                shapeCoords.set(3, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                shapeCoords.set(3, shapeCoords.get(1));
                shapeCoords.set(1, shapeCoords.get(0));          
                shapeCoords.set(0, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(0).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
            case SOUTH:
                shapeCoords.set(2, shapeCoords.get(0));
                shapeCoords.set(0, shapeCoords.get(1));               
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(1).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                break;
        }
    }
    
    @Override
    public void rotateRight() {
        orientation = orientation.getNextRightRotation();
        
        // update tetrimino coordinates after right-rotation
        // (coordinates are ordered like so: first the two middle blocks (first of those: left/top-most middle block), then from top to bottom/left to right depending on orientation)
        switch(orientation) {
            case WEST:
                break;
            case EAST:
                shapeCoords.set(2, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(0).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                break;
            case SOUTH:
                break;
        }
    }
    
}
