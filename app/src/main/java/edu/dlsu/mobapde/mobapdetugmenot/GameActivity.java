package edu.dlsu.mobapde.mobapdetugmenot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//game screen
public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}
