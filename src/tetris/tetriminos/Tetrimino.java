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
    protected Orientation orientation = Orientation.LEFT;   // current orientation of the shape (left, right, ...)
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
        ((Graphics2D)g).setStroke(new BasicStroke(3));
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
        for(XYCoord xyc : shapeCoords) {
            // check if it is possible to move down without clipping off the field's bottom border
            xyc.setY(xyc.getY()+TetrisGameState.SINGLE_BLOCK_RADIUS*2);
        }
    }
    
    // move tetrimino one block to the left
    public void moveToLeft() {
        for(XYCoord xyc : shapeCoords) xyc.setX(xyc.getX()+TetrisGameState.SINGLE_BLOCK_RADIUS*2);
    }
        
    // move tetrimino one block to the right
    public void moveToRight() {
        for(XYCoord xyc : shapeCoords) xyc.setX(xyc.getX()-TetrisGameState.SINGLE_BLOCK_RADIUS*2);
    }
    
    // change orientation of the shape and change coordinates to reflect that change
    public abstract void changeOrientation(Orientation orientation);
}
