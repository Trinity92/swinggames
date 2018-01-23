/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.utils;

/**
 *
 * @author leandrogil
 */
public class XYCoord {
    
    private int x,y;

    public XYCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    
    @Override
    public boolean equals(Object o) {
        return (o != null && this.getClass().isInstance(o) && ((XYCoord)o).getX() == this.x && ((XYCoord)o).getY() == this.y);
    }
    
}
