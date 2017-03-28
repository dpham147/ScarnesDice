package edu.orangecoastcollege.cs273.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView userScoreTextView;
    private TextView cpuScoreTextView;
    private TextView turnScoreTextView;
    private ImageView diceImageView;

    private Button rollButton;
    private Button holdButton;

    private int userScore;
    private int userTurnScore;
    private int cpuScore;
    private int cpuTurnScore;

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

        userScoreTextView.setText("Player Score: 0");
        cpuScoreTextView.setText("Computer Score: 0");
        turnScoreTextView.setText("Turn Score: 0");

        userScore = 0;
        userTurnScore = 0;
        cpuScore = 0;
        cpuTurnScore = 0;

    }

    public void reset(View view)
    {
        diceImageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
        userTurnScore = 0;
        cpuTurnScore = 0;
        userScore = 0;
        cpuScore = 0;

        userScoreTextView.setText("Player Score: 0");
        cpuScoreTextView.setText("Computer Score: 0");
        turnScoreTextView.setText("Turn Score: 0");
    }

    public void holdTurn (View view) {
        userScore += userTurnScore;
        userTurnScore = 0;
        userScoreTextView.setText("Player Score: " + userScore);
        computerTurn();
    }

    public void rollDice(View view)
    {
        int roll = rollDice();
        if (roll == 1)
        {
            userTurnScore = 0;
            turnScoreTextView.setText("Turn Score: 0");
            computerTurn();
        }
        else
        {
            userTurnScore += roll;
            turnScoreTextView.setText("Turn Score: " + userTurnScore);
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
        return roll + 1;
    }

    private void computerTurn()
    {
        holdButton.setEnabled(false);
        rollButton.setEnabled(false);

        boolean rollOne = false;
        while (cpuTurnScore < 20 && !rollOne)
        {
            int roll = rollDice();
            if (roll == 1)
            {
                cpuTurnScore = 0;
                turnScoreTextView.setText("Turn Score: 0");
                rollOne = true;
                Toast.makeText(this, "CPU Holds", Toast.LENGTH_SHORT);
            }
            else
            {
                cpuTurnScore += roll;
                turnScoreTextView.setText("Turn Score: " + cpuTurnScore);
                rollOne = false;
            }
        }
    }

}
