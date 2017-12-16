package edu.dlsu.mobapde.mobapdetugmenot;

import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Sean Paragas on 12/13/2017.
 */

public enum Gesture
{
    UP(R.drawable.up),
    DOWN(R.drawable.down),
    LEFT(R.drawable.left),
    RIGHT(R.drawable.right),
    NOTUP(R.drawable.notup),
    NOTDOWN(R.drawable.notdown),
    NOTLEFT(R.drawable.notleft),
    NOTRIGHT(R.drawable.notright);

    private final int drawable;

    private Gesture(int drawable) {
        this.drawable = drawable;
    }

    public int getDrawable() {
        return this.drawable;
    }

    public static Gesture getRandomGesture()
    {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
