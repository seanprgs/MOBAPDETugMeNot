package edu.dlsu.mobapde.mobapdetugmenot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

//main menu
public class MainActivity extends Activity
{
    ImageButton ibPlay, ibStats, ibTutorial, ibSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ibPlay = findViewById(R.id.ib_play);
        ibStats = findViewById(R.id.ib_stats);
        ibTutorial = findViewById(R.id.ib_tutorial);
        ibSettings = findViewById(R.id.ib_settings);

        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), GameActivity.class);
                startActivity(i);
            }
        });

        ibStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), StatsActivity.class);
                startActivity(i);
            }
        });

        ibTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), TutorialActivity.class);
                startActivity(i);
            }
        });

        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), SettingsActivity.class);
                startActivity(i);
            }
        });
    }
}
