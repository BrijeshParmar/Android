package com.ict.genesis.stopwatch;

/**
 * Created by Genesis on 7/12/2017.
 */

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends Activity {
    //Number of seconds displayed on the stopwatch.
    private int seconds = 0;
    //Is the stopwatch running?
    private boolean running;
    private int first_run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        running=false;
        first_run=0;

/*        // changes as per bundle creation v.1

        if(savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");

        }
*/
    }


/*    // changes as per bundle creation v.1



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }
    //end*/


    @Override
    protected void onPause() {
        super.onPause();
        running=false;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); this will back press acitivity so exits app
        moveTaskToBack(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        running=false;
        seconds=0;
    }

    //Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view) {
        first_run++;
        if(first_run==1)
            runTimer();
        running = true;
    }
    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false;
    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    //Sets the number of seconds on the timer.
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}

