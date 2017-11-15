package edu.dlsu.mobapde.mobapdetugmenot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PauseDialog extends Activity {
    ImageButton ibCont, ibRetry, ibQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_dialog);

        ibCont = findViewById(R.id.ib_cont);
        ibRetry = findViewById(R.id.ib_retry);
        ibQuit = findViewById(R.id.ib_quit);

        ibCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), GameActivity.class);
                startActivity(i);
            }
        });

        ibRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), GameActivity.class);
                startActivity(i);
            }
        });

        ibQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
