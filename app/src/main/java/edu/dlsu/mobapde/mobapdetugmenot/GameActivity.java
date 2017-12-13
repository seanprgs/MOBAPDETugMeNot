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

//game screen
public class GameActivity extends Activity {

    GestureDetector gestureDetector;
    LinearLayout gameView;
    ImageButton ibPause;
    public static final int GAME_MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

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

    GestureDetector.SimpleOnGestureListener onGestureListener
            = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // method triggered when swipe event is detected

            // check if game is 1P or 2P

            // locate touch event

            // check player action prompt
                // was action done?


            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // method triggered when touch event is detected

        return gestureDetector.onTouchEvent(event);
    }
}
