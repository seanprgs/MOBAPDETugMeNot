package edu.dlsu.mobapde.mobapdetugmenot;

import java.util.Random;

/**
 * Created by Sean Paragas on 12/13/2017.
 */

public enum Gesture
{
    UP("Up"),
    DOWN("Down"),
    LEFT("Left"),
    RIGHT("Right"),
    NOTUP("Not Up"),
    NOTDOWN("Not Down"),
    NOTLEFT("Not Left"),
    NOTRIGHT("Not Right");

    private final String textRepresentation;

    private Gesture(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override public String toString() {
        return textRepresentation;
    }

    public static Gesture getRandomGesture()
    {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
