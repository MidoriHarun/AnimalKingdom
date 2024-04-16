package com.animalkingdom;
import java.awt.Color;
public class WhiteTiger extends Critter {
    private boolean infected;
    public WhiteTiger(){
        infected=false;
    }
    public Color getColor(){
        return Color.WHITE;
    }

    //“tgr” if it hasn’t infected another Critter yet, “TGR” if it has infected.
    public String toString(){
        if(infected==true){
            return "TGR";
        }
        else{
            return "tgr";
        }
    }
    //Same as a Tiger

    public Action getMove(CritterInfo info){
        if(info.getFront()==Neighbor.OTHER){
            infected=true;
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