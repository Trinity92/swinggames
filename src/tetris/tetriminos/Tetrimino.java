/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tetriminos;

import java.awt.Color;
import tetris.utils.Orientation;
import tetris.gui.TetrisMainFrame;
import java.awt.Graphics;
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
        g.setColor(color);
        for(XYCoord xyc : shapeCoords) {
            g.fillRect(xyc.getX()-TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getY()-TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getX()+TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getY()+TetrisMainFrame.SINGLE_BLOCK_RADIUS);
        }
        g.setColor(Color.BLACK);
        for(XYCoord xyc : shapeCoords) {
            g.drawRect(xyc.getX()-TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getY()-TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getX()+TetrisMainFrame.SINGLE_BLOCK_RADIUS, xyc.getY()+TetrisMainFrame.SINGLE_BLOCK_RADIUS);
        }
        g.setColor(originalColor);
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
            xyc.setY(xyc.getY()+TetrisMainFrame.SINGLE_BLOCK_RADIUS*2);
        }
    }
    
    // change orientation of the shape and change coordinates to reflect that change
    public abstract void changeOrientation(Orientation orientation);
}
