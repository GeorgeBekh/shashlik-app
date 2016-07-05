package com.bekh.george.shashlikapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimerActivity extends ActionBarActivity {
    private Float time;
    private TextView countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        initialize();
        setTime();
    }

    private void initialize(){
        countDownTimer = (TextView) findViewById(R.id.count_down);
       // countDownTimer.setText("00");
    }

    private void setTime() {
        final Intent intent = getIntent();
        time = intent.getFloatExtra("time", 0f);
        Log.v(MainActivity.TAG, String.valueOf(time));
        new CountDownTimer((long) (time*1000), 1000){
            String outputTime;
            public void onTick(long millisUntilFinished){
                Log.v(MainActivity.TAG, String.valueOf(outputTime));
                Log.v(MainActivity.TAG, "123");
                outputTime = String.valueOf(millisUntilFinished/1000);
                countDownTimer.setText(outputTime);
            }

            @Override
            public void onFinish() {
                countDownTimer.setText("done");
            }
        }.start();
    }
}
