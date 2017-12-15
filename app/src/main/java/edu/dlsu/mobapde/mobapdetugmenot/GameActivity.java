package edu.dlsu.mobapde.mobapdetugmenot;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;

public class GameActivity extends Activity{
    GestureDetector gestureDetector;
    SurfaceView gameBoard;
    boolean gameState;
    Gesture currGesture;
    DrawingThread thread;
    ImageButton ibPause;

    int avatarX = 0;
    int avatarY = 0;

    ArrayList<Rope> rop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameState = false;
        currGesture = Gesture.getRandomGesture();

        gestureDetector = new GestureDetector(getBaseContext(), onGestureListener);

        ibPause = (ImageButton) findViewById(R.id.ib_pause);

        ibPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), PauseDialog.class);
                startActivity(i);
            }
        });

        // this is the actual view you will draw on
        gameBoard = (SurfaceView) findViewById(R.id.game);

        initObjects();

        gameBoard.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                thread = new DrawingThread(gameBoard.getHolder());
                thread.setRunning(true);
                thread.start();

                tryDrawing(surfaceHolder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
                tryDrawing(surfaceHolder);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }

            private void tryDrawing(SurfaceHolder holder) {
                Log.i("", "Trying to draw...");

                Canvas canvas = holder.lockCanvas();
                if (canvas == null) {
                    Log.e("", "Cannot draw onto the canvas as it's null");
                } else {
                    draw(canvas);
                    holder.unlockCanvasAndPost(canvas);
                }
            }


        });
    }

    private void initObjects() {
        rop = new ArrayList<>();
        Bitmap ropepic = BitmapFactory.decodeResource(getResources(), R.drawable.rope);
        rop.add(new Rope(300, 0, ropepic, 5));
    }

    private void moveRopeDown(){
        for(Rope r:rop){
            r.moveDown();
        }
    }

    public static final int FLING_DISTANCE = 130;
    public static final int FLING_VELOCITY = 150;

    GestureDetector.SimpleOnGestureListener onGestureListener
            = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // method triggered when swipe event is detected

            switch(currGesture)
            {
                case UP:
                    if(e1.getY() - e2.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY)
                    {
                        Toast.makeText(getBaseContext(), "UP ehe", Toast.LENGTH_SHORT).show();
                        // success
                    } else {
                        // fail
                    }
                    break;
                case DOWN:
                    if(e2.getY() - e1.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY)
                    {

                    } else {

                    }
                    break;
                case LEFT:
                    if(e1.getX() - e2.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY)
                    {

                    } else {

                    }
                    break;
                case RIGHT:
                    if(e2.getX() - e1.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY)
                    {

                    } else {

                    }
                    break;
                case NOTUP:
                    if((e2.getY() - e1.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY) ||
                            (e1.getX() - e2.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY) ||
                            (e2.getX() - e1.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY))
                    {

                    } else {

                    }
                    break;
                case NOTDOWN:
                    if((e1.getY() - e2.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY) ||
                            (e1.getX() - e2.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY) ||
                            (e2.getX() - e1.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY))
                    {

                    } else {

                    }
                    break;
                case NOTLEFT:
                    if((e1.getY() - e2.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY) ||
                            (e2.getY() - e1.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY) ||
                            (e2.getX() - e1.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY))
                    {

                    } else {

                    }
                    break;
                case NOTRIGHT:
                    if((e1.getY() - e2.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY) ||
                            (e1.getX() - e2.getX() > FLING_DISTANCE && Math.abs(velocityX) > FLING_VELOCITY) ||
                            (e2.getY() - e1.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY))
                    {

                    } else {

                    }
                    break;
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // method triggered when touch event is detected

        return gestureDetector.onTouchEvent(event);
    }

    private void draw(Canvas canvas) {

        if(canvas!=null) {
            // clear the board
            canvas.drawRGB(1, 125, 25);

            // ... or draw a bitmap
            Bitmap ropepic = BitmapFactory.decodeResource(getResources(), R.drawable.rope);

            for(Rope r:rop){
                canvas.drawBitmap(r.getBitmap(), r.getX(), r.getY(), null);

                Log.i("collision", " left " + r.getX());
                Log.i("collision", " up " + r.getY());
                Log.i("collision", " right " + r.getX()+100);
                Log.i("collision", " bottom " + r.getY()+100);
                Log.i("collission", "avatarX " + (int) (avatarX-(ropepic.getWidth()/2)));
                Log.i("collission", "avatarY " + (int) (avatarY-(ropepic.getHeight()/2)));

                //if(r.contains(avatarX-(android.getWidth()/2), avatarY-(android.getHeight()/2))){
                //Log.i("collides","collission");
                //}
            }
        }
    }

    class DrawingThread extends Thread {
        private SurfaceHolder _surfaceHolder;

        private boolean running = false;

        public DrawingThread(SurfaceHolder surfaceHolder) {
            _surfaceHolder = surfaceHolder;
        }

        public void setRunning(boolean run) {
            running = run;
        }

        @Override
        public void run() {
            Canvas c;
            while (running && !Thread.interrupted()) {
                c = null;
                try {
                    c = _surfaceHolder.lockCanvas(null);
                    synchronized (_surfaceHolder) {
                        //call a method that draws all the required objects onto the canvas.
                        draw(c);
                        moveRopeDown();
                    }
                } finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        _surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
                //sleep for a short period of time.
                if (!running) return;  //don't sleep, just exit if we are done.
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }

}
