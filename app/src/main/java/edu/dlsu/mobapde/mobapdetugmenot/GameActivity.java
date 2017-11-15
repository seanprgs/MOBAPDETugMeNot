package edu.dlsu.mobapde.mobapdetugmenot;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//game screen
public class GameActivity extends Activity {
    LinearLayout gameView;
    ImageButton ibPause;

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
}
