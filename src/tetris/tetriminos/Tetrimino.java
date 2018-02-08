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
import java.util.Arrays;
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
    
    //  function that updates the shape's coordinates to reflect a down-movement on the Tetris field
    public void moveShapeDown() {
        if(canBeMovedDown())
            for(XYCoord xyc : shapeCoords)
                xyc.setY(xyc.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
    
    // move tetrimino one block to the left
    public void moveToLeft() {
        if(canBeMovedLeft())
            for(XYCoord xyc : shapeCoords)
                xyc.setX(xyc.getX()-TetrisGameState.SINGLE_BLOCK_RADIUS*2-(TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
        
    // move tetrimino one block to the right
    public void moveToRight() {
        if(canBeMovedRight())
            for(XYCoord xyc : shapeCoords)
                xyc.setX(xyc.getX()+TetrisGameState.SINGLE_BLOCK_RADIUS*2+(TetrisGameState.TETRIMINO_BORDER_SIZE/2));
    }
    
    // some method stubs, TODO
    public boolean canBeMovedDown() {
        for(XYCoord xy1 : shapeCoords) {
            // check if tetrimino can be moved down without going over the bottom border   
            if(xy1.getY() + (TetrisGameState.SINGLE_BLOCK_RADIUS*2) + (TetrisGameState.TETRIMINO_BORDER_SIZE/2) > TetrisGameState.TETRIS_PANE_HEIGHT) {
                return false;
            }
            for(Tetrimino t : TetrisGameState.getInstance().getTetriminosOnField()) {            
                for(XYCoord xy2 : t.getCoordinates()) {
                    if(xy1.getY()+(TetrisGameState.SINGLE_BLOCK_RADIUS*2)+(TetrisGameState.TETRIMINO_BORDER_SIZE/2) >= xy2.getY() && xy1.getX() == xy2.getX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean canBeMovedLeft() {
        for(XYCoord xy1 : shapeCoords) {
            // check if tetrimino can be moved down without going over the bottom border   
            if(xy1.getX()-(TetrisGameState.SINGLE_BLOCK_RADIUS*2)-(TetrisGameState.TETRIMINO_BORDER_SIZE/2) < 0) {
                return false;
            }
            for(Tetrimino t : TetrisGameState.getInstance().getTetriminosOnField()) {
                for(XYCoord xy2 : t.getCoordinates()) {
                    if(xy1.getX()-(TetrisGameState.SINGLE_BLOCK_RADIUS*2)-(TetrisGameState.TETRIMINO_BORDER_SIZE/2) == xy2.getX() && xy1.getY() == xy2.getY()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean canBeMovedRight() {
        for(XYCoord xy1 : shapeCoords) {
            // check if tetrimino can be moved down without going over the right border   
            if(xy1.getX()+(TetrisGameState.SINGLE_BLOCK_RADIUS*2)+(TetrisGameState.TETRIMINO_BORDER_SIZE/2) > TetrisGameState.TETRIS_PANE_WIDTH) {
                return false;
            }
            for(Tetrimino t : TetrisGameState.getInstance().getTetriminosOnField()) {       
                for(XYCoord xy2 : t.getCoordinates()) {
                    if(xy1.getX()+(TetrisGameState.SINGLE_BLOCK_RADIUS*2)+(TetrisGameState.TETRIMINO_BORDER_SIZE/2) == xy2.getX() && xy1.getY() == xy2.getY()) {
                        return false;
                    }
                }
            }
        }
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
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ "[" + shapeCoords[0].getX() + "," + shapeCoords[0].getY() + "]";
    }
    
    public XYCoord[] getCoordinates() { return shapeCoords; }
}
