package edu.orangecoastcollege.cs273.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView playerScoreEditText;
    private TextView cpuScoreEditText;
    private ImageView diceImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerScoreEditText = (TextView) findViewById(R.id.playerScoreTextView);
        cpuScoreEditText = (TextView) findViewById(R.id.cpuScoreTextView);
        diceImageView = (ImageView) findViewById(R.id.diceImageView);
    }
}
