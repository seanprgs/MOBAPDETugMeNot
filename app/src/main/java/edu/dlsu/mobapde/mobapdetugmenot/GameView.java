package edu.dlsu.mobapde.mobapdetugmenot;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by Sean Paragas on 11/13/2017.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback
{

    private GameThread thread;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        // draw lol
    }


}
