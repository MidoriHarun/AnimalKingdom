package com.animalkingdom;

import java.awt.Color;
public class Tiger extends Critter {
    private int moves;
    private Color currentColor;

    public Tiger(){
        moves=0;
    }
    /*Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
    and uses that color for three moves, then randomly picks one of those colors
    again for the next three moves, and so on.*/
    public Color getColor(){
        int rand;
        if(moves%3==0){
            rand=(int) (Math.random()*3);
            if(rand==0){
                currentColor=Color.RED;
            }
            if(rand==1){
                currentColor=Color.BLUE;
            }
            if(rand==2){
                currentColor=Color.GREEN;
            }
        }
        return currentColor;
    }

    public String toString(){
        return "TGR";
    }

    /*always infect if an enemy is in front, otherwise if a wall is in front or
    to the right, then turn left, otherwise if a fellow Tiger is in front, then
    turn right, otherwise hop.*/
    public Action getMove(CritterInfo info){
        moves++;
        if(info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        }
        else if(info.getFront()==Neighbor.SAME){
            return Action.RIGHT;
        }
        else{
            return Action.HOP;
        }
    }
}