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
public enum Orientation {
    WEST{
        @Override
        public Orientation getNextLeftRotation() {
            return SOUTH; // see below for options for this line
        };
    },
    NORTH,
    EAST,
    SOUTH{   
        @Override
        public Orientation getNextRightRotation() {
            return WEST; // see below for options for this line
        };
    };
    
    public Orientation getNextLeftRotation() {
        return values()[this.ordinal()-1];
    }
    
    public Orientation getNextRightRotation() {
        return values()[this.ordinal()+1];
    }
}
