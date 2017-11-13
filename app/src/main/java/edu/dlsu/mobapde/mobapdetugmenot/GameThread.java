package edu.dlsu.mobapde.mobapdetugmenot;

import android.view.SurfaceHolder;

/**
 * Created by Sean Paragas on 11/13/2017.
 */

public class GameThread extends Thread
{

    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;

    public GameThread(SurfaceHolder surfaceHolder, GameView gameView)
    {
        super();
        this.gameView = gameView;
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run()
    {
        while(running)
        {

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
