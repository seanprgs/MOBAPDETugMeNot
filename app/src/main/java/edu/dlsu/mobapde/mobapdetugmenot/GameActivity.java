package edu.dlsu.mobapde.mobapdetugmenot;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

//game screen
public class GameActivity extends Activity {

    GestureDetector gestureDetector;
    LinearLayout gameView;
    ImageButton ibPause;
    boolean gameState; // false if game is not playing
    Prompt currPrompt;
    //public static final int GAME_MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        gameState = false;
        currPrompt = Prompt.UP;

        GameView gameV = new GameView(this);
        gameView = findViewById(R.id.game);
        gameView.addView(gameV);

        gestureDetector = new GestureDetector(getBaseContext(), onGestureListener);

        ibPause = findViewById(R.id.ib_pause);

        ibPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), PauseDialog.class);
                startActivity(i);
            }
        });
    }

    public static final int FLING_DISTANCE = 130;
    public static final int FLING_VELOCITY = 150;

    GestureDetector.SimpleOnGestureListener onGestureListener
            = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // method triggered when swipe event is detected

            switch(currPrompt)
            {
                case UP:
                    if(e1.getY() - e2.getY() > FLING_DISTANCE && Math.abs(velocityY) > FLING_VELOCITY)
                    {
                        Toast.makeText(getBaseContext(), "UP ehe", Toast.LENGTH_SHORT).show();
                    } else {

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

            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // method triggered when touch event is detected

        return gestureDetector.onTouchEvent(event);
    }
}
