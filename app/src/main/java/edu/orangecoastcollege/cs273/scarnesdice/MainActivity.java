package edu.orangecoastcollege.cs273.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView playerScoreTextView;
    private TextView cpuScoreTextView;
    private ImageView diceImageView;
    private TextView turnScoreTextView;

    private Button rollButton;
    private Button holdButton;

    private int userScore = 0;
    private int userTurnScore = 0;
    private int cpuScore = 0;
    private int cpuTurnScore = 0;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerScoreTextView = (TextView) findViewById(R.id.playerScoreTextView);
        cpuScoreTextView = (TextView) findViewById(R.id.cpuScoreTextView);
        diceImageView = (ImageView) findViewById(R.id.diceImageView);
        turnScoreTextView = (TextView) findViewById(R.id.turnScoreTextView);
        rollButton = (Button) findViewById(R.id.rollButton);
        holdButton = (Button) findViewById(R.id.holdButton);

    }

    protected void reset(View view)
    {
        diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
        userTurnScore = 0;
        cpuTurnScore = 0;
        userScore = 0;
        cpuScore = 0;

        playerScoreTextView.setText(R.string.player_score + 0);
        cpuScoreTextView.setText(R.string.cpu_score + 0);
        turnScoreTextView.setText(R.string.turnScore + 0);
    }

    protected void rollDice(View view)
    {
        int roll = random.nextInt(6);
        switch (roll){
            case 1: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                userTurnScore = 0;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
                computerTurn();
            }
            case 2: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                userTurnScore += 2;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
            }
            case 3: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                userTurnScore += 3;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
            }
            case 4: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                userTurnScore += 4;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
            }
            case 5: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                userTurnScore += 5;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
            }
            case 6: {
                diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                userTurnScore += 6;
                turnScoreTextView.setText(R.string.turnScore + userTurnScore);
            }

        }
    }

    protected void holdTurn(View view)
    {
        userScore += userTurnScore;
        userTurnScore = 0;
        turnScoreTextView.setText(R.string.turnScore + 0);

        computerTurn();
    }

    private void computerTurn()
    {
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);

        while(cpuScore < 20)
        {
            int roll = random.nextInt(6);
            switch (roll){
                case 1: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                    cpuTurnScore = 0;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }
                case 2: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                    cpuTurnScore += 2;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }
                case 3: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                    cpuTurnScore += 3;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }
                case 4: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                    cpuTurnScore += 4;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }
                case 5: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                    cpuTurnScore += 5;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }
                case 6: {
                    diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                    cpuTurnScore += 6;
                    turnScoreTextView.setText(R.string.turnScore + cpuTurnScore);
                }

            }
        }
    }
}
