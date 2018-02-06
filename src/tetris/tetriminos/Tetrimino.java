/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.BasicStroke;
import java.awt.Color;
import tetris.utils.Orientation;
import tetris.utils.TetrisGameState;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import tetris.utils.XYCoord;

/**
 *
 * @author leandrogil
 */
public abstract class Tetrimino {
    
    protected XYCoord[] shapeCoords = new XYCoord[4];       // coordinates of the blocks that make up the complete shape
    protected Orientation orientation = Orientation.NORTH;   // current orientation of the shape (left, right, ...)
    protected Color color;
    
    // paint the entire shape on the specified Graphics object
    // (REMINDER: origin of coordinate system is upper-left corner !!!))
    public void paintShape(Graphics g) {
        System.out.println("Drawing " + toString());
        Color originalColor = g.getColor();
        Stroke bs = ((Graphics2D)g).getStroke();
        g.setColor(color);
        for(XYCoord xyc : shapeCoords) {
            g.fillRect(xyc.getX()-TetrisGameState.SINGLE_BLOCK_RADIUS, xyc.getY()-TetrisGameState.SINGLE_BLOCK_RADIUS, TetrisGameState.SINGLE_BLOCK_RADIUS*2, TetrisGameState.SINGLE_BLOCK_RADIUS*2);
        }
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(TetrisGameState.TETRIMINO_BORDER_SIZE));
        for(XYCoord xyc : shapeCoords) {
            g.drawRect(xyc.getX()-TetrisGameState.SINGLE_BLOCK_RADIUS, xyc.getY()-TetrisGameState.SINGLE_BLOCK_RADIUS, TetrisGameState.SINGLE_BLOCK_RADIUS*2, TetrisGameState.SINGLE_BLOCK_RADIUS*2);
        }
        g.setColor(originalColor);
        ((Graphics2D)g).setStroke(bs);
    }
    
    // replaces a shape's coordinate with a different one
    public void updateShapeCoord(XYCoord currentCoord, XYCoord newCoord) {
        for(XYCoord xyc : shapeCoords) {
            if(xyc.equals(currentCoord)) xyc = newCoord;
        }
    }
    
    //  function that updates the shape's coordinates to reflect a down-movement on the Tetris field
    public void moveShapeDown() {
        // check if tetrimino can be moved down without going over the bottom border
        for(XYCoord xyc : shapeCoords) {
            if(xyc.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2) > TetrisGameState.TETRIS_PANE_HEIGHT) {
                return;
            }
        }
        for(XYCoord xyc : shapeCoords) xyc.setY(xyc.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
    
    // move tetrimino one block to the left
    public void moveToLeft() {
        // check if tetrimino can be moved to the left without going over the left border
        for(XYCoord xyc : shapeCoords) {
            if(xyc.getX()-(TetrisGameState.SINGLE_BLOCK_RADIUS*2)-(TetrisGameState.TETRIMINO_BORDER_SIZE/2) < 0) {
                return;
            }
        }
        
        // TODO: check if there is no other tetrimino in the way before moving to the left
        
        for(XYCoord xyc : shapeCoords) xyc.setX(xyc.getX()-TetrisGameState.SINGLE_BLOCK_RADIUS*2-(TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
        
    // move tetrimino one block to the right
    public void moveToRight() {
        // check if tetrimino can be moved to the right without going over the right border
        for(XYCoord xyc : shapeCoords) {
            if(xyc.getX()+(TetrisGameState.SINGLE_BLOCK_RADIUS*2)+(TetrisGameState.TETRIMINO_BORDER_SIZE/2) > TetrisGameState.TETRIS_PANE_WIDTH) {
                return;
            }
        }
        
        // TODO: check if there is no other tetrimino in the way before moving to the right
        
        for(XYCoord xyc : shapeCoords) xyc.setX(xyc.getX()+TetrisGameState.SINGLE_BLOCK_RADIUS*2+(TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
    
    // some method stubs, TODO
    public boolean canBeMovedDown() {
        return true;
    }
    public boolean canBeMovedLeft() {
        return true;
    }
    public boolean canBeMovedRight() {
        return true;
    }
    public boolean canBeRotatedLeft() {
        return true;
    }
    public boolean canBeRotatedRight() {
        return true;
    }
    
    // rotate tetrimino to the left
    public abstract void rotateLeft();
    // rotate tetrimino to the right
    public abstract void rotateRight();
}
