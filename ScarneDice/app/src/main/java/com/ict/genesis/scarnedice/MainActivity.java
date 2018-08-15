package com.ict.genesis.scarnedice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.ict.genesis.scarnedice.R.color.colorAccent;
import static com.ict.genesis.scarnedice.R.color.colorPrimaryDark;

public class MainActivity extends AppCompatActivity {
    private TextView tvGameStatus;
    private Button bRoll;
    private Button bHold;
    private Button bReset;
    private ImageView diceImage;

    private int currentDiceValue = 1;
    private int playerScore = 0, computerScore = 0, turnScore = 0;
    private boolean isPlayerTurn;
    int images[] = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGameStatus = (TextView) findViewById(R.id.gameStatus);
        bHold = (Button) findViewById(R.id.bHold);
        bRoll = (Button) findViewById(R.id.bRoll);
        bReset = (Button) findViewById(R.id.bReset);
        diceImage = (ImageView) findViewById(R.id.ivdice);

        bHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlayerTurn) {
                    hold();
                }
            }
        });

        bRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlayerTurn) {
                    roll();
                }
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    public void roll() {
        if(!isPlayerTurn){
            bRoll.setEnabled(false);
            bRoll.setBackgroundColor(getResources().getColor(colorPrimaryDark));
            bHold.setEnabled(false);
            bHold.setBackgroundColor(getResources().getColor(colorPrimaryDark));
        }
        else{
            bRoll.setEnabled(true);
            bRoll.setBackgroundColor(getResources().getColor(colorAccent));
            bHold.setEnabled(true);
            bHold.setBackgroundColor(getResources().getColor(colorAccent));
        }
        currentDiceValue = new Random().nextInt(6) + 1;
        if (currentDiceValue == 1) {
            turnScore = 0;
            hold();
        } else {
            turnScore = turnScore + currentDiceValue;
        }
        updateUI();
    }

    public void hold() {
        if (isPlayerTurn) {
            playerScore = playerScore + turnScore;
        } else {
            computerScore = computerScore + turnScore;
        }
        turnScore = 0;
        currentDiceValue = 1;
        updateUI();

        isPlayerTurn = !isPlayerTurn;
        if(!isPlayerTurn){
            bHold.setEnabled(false);
            bHold.setBackgroundColor(getResources().getColor(colorPrimaryDark));
            bRoll.setEnabled(false);
            bRoll.setBackgroundColor(getResources().getColor(colorPrimaryDark));
        }
        else{
            bHold.setEnabled(true);
            bHold.setBackgroundColor(getResources().getColor(colorAccent));
            bRoll.setEnabled(true);
            bRoll.setBackgroundColor(getResources().getColor(colorAccent));
        }
        if(computerScore>=100  || playerScore>=100){
            Toast.makeText(this,
                    computerScore>=100?"Computer ": "Player " + "wins!",Toast.LENGTH_SHORT);
            reset();
        }

        if (!isPlayerTurn) {
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerTurn();
                }
            },1000);        }
    }

    public void reset() {
        bRoll.setEnabled(true);
        bRoll.setBackgroundColor(getResources().getColor(colorAccent));
        bHold.setEnabled(true);
        bHold.setBackgroundColor(getResources().getColor(colorAccent));
        turnScore = computerScore = playerScore = 0;
        currentDiceValue = 1;
        isPlayerTurn = true;
        updateUI();

        Toast.makeText(this, "Play Again!!!", Toast.LENGTH_SHORT).show();
    }

    public void computerTurn() {
        if(!isPlayerTurn){
            bHold.setEnabled(false);
            bHold.setBackgroundColor(getResources().getColor(colorPrimaryDark));
            bRoll.setEnabled(false);
            bRoll.setBackgroundColor(getResources().getColor(colorPrimaryDark));
            if(turnScore<15){
                roll();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        computerTurn();
                    }
                },1000);
            }
            else{
                bRoll.setEnabled(true);
                bRoll.setBackgroundColor(getResources().getColor(colorAccent));
                bHold.setEnabled(true);
                bHold.setBackgroundColor(getResources().getColor(colorAccent));
                hold();
            }
        }
    }

    public void updateUI() {
        tvGameStatus.setText("PLAYER SCORE : " + playerScore + "\n" + "COMPUTER SCORE: " + computerScore + "\n" + "Turn Score: " + turnScore);
        diceImage.setImageResource(images[currentDiceValue - 1]);
    }
}
