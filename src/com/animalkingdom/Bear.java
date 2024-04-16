package com.animalkingdom;

import java.awt.Color;
import java.util.Random;

// Bear class extending Critter with specific behaviors.
public class Bear extends Critter {
    private boolean polar; // True for polar bear, false for non-polar.
    private boolean slash = true; // Used to alternate appearance between moves.
    private boolean firstMove = true; // Tracks if it's the bear's first move.

    // Default constructor. Assigns polar status randomly.
    public Bear() {
        Random random = new Random();
        this.polar = random.nextBoolean(); // Randomly polar or not.
    }

    // Constructor with polar parameter.
    public Bear(boolean polar) {
        this.polar = polar;
    }

    @Override
    public Color getColor() {
        // Return color based on polar status: white for polar, black otherwise.
        return polar ? Color.WHITE : Color.BLACK;
    }

    @Override
    public String toString() {
        // Determines the bear's appearance.
        if (polar && firstMove) {
            firstMove = false; // Ensures this only affects the first move.
            return "/";
        } else {
            // Alternates appearance between moves.
            if (slash) {
                slash = false;
                return "/";
            } else {
                slash = true;
                return "\\";
            }
        }
    }
    @Override
    public Action getMove(CritterInfo info) {
        // Decides the next move based on the situation.
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT; // Infect if enemy is in front.
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP; // Hop if space is empty.
        } else {
            return Action.LEFT; // Turn left otherwise.
        }
    }
}