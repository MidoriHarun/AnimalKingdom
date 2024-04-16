package com.animalkingdom;
import java.awt.Color;
public class NinjaCat extends Critter {
    private int infections;
    public NinjaCat(){
        infections=0;
    }

    //display number of infections
    public String toString(){
        return "k:"+infections+"";
    }

    //color is based on how many infections it has done
    public Color getColor(){
        if(infections==0){
            return Color.YELLOW;
        }
        else if(infections==1){
            return Color.cyan;
        }
        else if (infections==2){
            return Color.MAGENTA;
        }
        else if (infections==3){
            return Color.orange;
        }
        else if (infections==4){
            return Color.PINK;
        }
        else if (infections==5){
            return Color.GREEN;
        }
        return Color.RED;
    }
    //same as giant
    public Critter.Action getMove(CritterInfo info){


        if (info.getFront()==Critter.Neighbor.OTHER){
            infections++;
            return Critter.Action.INFECT;

        }
        else if(info.getFront()==Critter.Neighbor.EMPTY){
            return Critter.Action.HOP;
        }
        else{
            return Critter.Action.RIGHT;
        }
    }
}
