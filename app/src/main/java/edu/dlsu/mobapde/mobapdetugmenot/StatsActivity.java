package edu.dlsu.mobapde.mobapdetugmenot;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class StatsActivity extends Activity
{

    ImageButton ibBack;
    TextView tvRecord, tvWL, tvFWT, tvTime;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_stats);

        Typeface square = Typeface.createFromAsset(getAssets(), "fonts/Square.ttf");
        Typeface imagine = Typeface.createFromAsset(getAssets(), "fonts/imagine_font.ttf");

        ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvRecord = findViewById(R.id.tv_record);
        tvRecord.setTypeface(square);
        tvTime = findViewById(R.id.tv_time);
        tvTime.setTypeface(square);
        tvWL = findViewById(R.id.tv_wl);
        tvWL.setTypeface(imagine);
        tvFWT = findViewById(R.id.tv_fwt);
        tvFWT.setTypeface(imagine);


        databaseHelper = new DatabaseHelper(getBaseContext());

        tvRecord.setText("" + databaseHelper.getWins() + "-" + databaseHelper.getLosses());
        tvTime.setText("" + databaseHelper.getFastestTime());

    }
}
