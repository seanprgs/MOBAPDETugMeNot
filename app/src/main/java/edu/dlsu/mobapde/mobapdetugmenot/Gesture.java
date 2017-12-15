package edu.dlsu.mobapde.mobapdetugmenot;

import java.util.Random;

/**
 * Created by Sean Paragas on 12/13/2017.
 */

public enum Gesture
{
    UP, DOWN, LEFT, RIGHT, NOTUP, NOTDOWN, NOTLEFT, NOTRIGHT;

    public static Gesture getRandomGesture()
    {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
