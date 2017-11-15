package edu.dlsu.mobapde.mobapdetugmenot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Sean Paragas on 11/13/2017.
 */

public class GameView extends SurfaceView
{
    private Bitmap rop;
    private Bitmap cpu;
    private SurfaceHolder holder;

    public GameView(Context context){
        super(context);
        holder = getHolder();

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        rop = BitmapFactory.decodeResource(getResources(), R.drawable.rope);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawBitmap(rop, 0, 0, null);
    }
}
