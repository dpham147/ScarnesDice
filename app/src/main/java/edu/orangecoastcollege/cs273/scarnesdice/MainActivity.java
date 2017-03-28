package edu.orangecoastcollege.cs273.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView userScoreTextView;
    private TextView cpuScoreTextView;
    private TextView turnScoreTextView;
    private ImageView diceImageView;

    private Button rollButton;
    private Button holdButton;

    private int userScore = 0;
    private int userTurnScore = 0;
    private int cpuScore = 0;
    private int cpuTurnScore = 0;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userScoreTextView = (TextView) findViewById(R.id.userScoreTextView);
        cpuScoreTextView = (TextView) findViewById(R.id.cpuScoreTextView);
        diceImageView = (ImageView) findViewById(R.id.diceImageView);
        turnScoreTextView = (TextView) findViewById(R.id.turnScoreTextView);
        rollButton = (Button) findViewById(R.id.rollButton);
        holdButton = (Button) findViewById(R.id.holdButton);

    }

    public void reset(View view)
    {
        diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
        userTurnScore = 0;
        cpuTurnScore = 0;
        userScore = 0;
        cpuScore = 0;

        userScoreTextView.setText(R.string.player_score + 0);
        cpuScoreTextView.setText(R.string.cpu_score + 0);
        turnScoreTextView.setText(R.string.turnScore + 0);
    }

    public void rollDice(View view)
    {
        int roll = rollDice();
        switch (roll){
            case 0: {

                break;
            }
            case 1: {

                break;
            }
            case 2: {

                break;
            }
            case 3: {

                break;
            }
            case 4: {

                break;
            }
            case 5: {

                break;
            }
        }
    }

    private int rollDice()
    {
        int roll = random.nextInt(6);
        switch(roll){
            case 0: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                break;
            case 1: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                break;
            case 2: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                break;
            case 3: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                break;
            case 4: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                break;
            case 5: diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                break;
        }
        return roll;
    }
}
