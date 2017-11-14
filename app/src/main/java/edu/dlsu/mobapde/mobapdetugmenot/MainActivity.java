package edu.dlsu.mobapde.mobapdetugmenot;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

//main menu
public class MainActivity extends Activity
{
    ImageButton ibOne, ibTwo, ibTutorial, ibSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ibOne = findViewById(R.id.ib_one);
        ibTwo = findViewById(R.id.ib_two);
        ibTutorial = findViewById(R.id.ib_tutorial);
        ibSettings = findViewById(R.id.ib_settings);
    }
}
