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
        this(new XYCoord(TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.SINGLE_BLOCK_RADIUS*7) + (TetrisGameState.TETRIMINO_BORDER_SIZE*2), TetrisGameState.TETRIS_PANE_BORDER_WIDTH + (TetrisGameState.TETRIMINO_BORDER_SIZE/2) + TetrisGameState.SINGLE_BLOCK_RADIUS));
    }
    
    public STetrimino(XYCoord spawnLocation) {
        // spawn tetrimino on 5th-6th column of the spawn row and 4th-5th of the row below (main mino: second bottom one)
        shapeCoords.add(spawnLocation);
        shapeCoords.add(new XYCoord(spawnLocation.getX(), spawnLocation.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
        shapeCoords.add(new XYCoord(spawnLocation.getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), spawnLocation.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
        shapeCoords.add(new XYCoord(spawnLocation.getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), spawnLocation.getY()));
        this.color = Color.GREEN;
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.getNextLeftRotation();
        
        // update tetrimino coordinates after left-rotation
        // (coordinates are ordered like so: first the two middle blocks (first of those: left/top-most middle block), then from top to bottom/left to right depending on orientation)
        switch(orientation) {
            case WEST:
                shapeCoords.set(0, shapeCoords.get(2));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case EAST:
                shapeCoords.set(1, shapeCoords.get(3));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                shapeCoords.set(1, shapeCoords.get(0));
                shapeCoords.set(0, shapeCoords.get(2));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(1).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                break;
            case SOUTH:
                shapeCoords.set(0, shapeCoords.get(1));
                shapeCoords.set(1, shapeCoords.get(3));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(1).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
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
                shapeCoords.set(1, shapeCoords.get(0));
                shapeCoords.set(0, new XYCoord(shapeCoords.get(1).getX() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                shapeCoords.set(2, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case EAST:
                shapeCoords.set(2, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                break;
            case NORTH:
                shapeCoords.set(2, shapeCoords.get(1));
                shapeCoords.set(1, new XYCoord(shapeCoords.get(0).getX(), shapeCoords.get(0).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(1).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(1).getY()));
                break;
            case SOUTH:
                shapeCoords.set(2, shapeCoords.get(0));
                shapeCoords.set(0, new XYCoord(shapeCoords.get(1).getX(), shapeCoords.get(1).getY() - (TetrisGameState.SINGLE_BLOCK_RADIUS*2) - (TetrisGameState.TETRIMINO_BORDER_SIZE/2)));
                shapeCoords.set(3, new XYCoord(shapeCoords.get(0).getX() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2), shapeCoords.get(0).getY()));
                break;
        }
    }
    
}
