package com.bekh.george.shashlikapp;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimerActivity extends ActionBarActivity {
    private CountDownTimer countDownTimer;
    private long currentTime;
    private RecipeItem recipeItem;
    private TextView countDown;
    private TextView recipe;
    private Button pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        initialize();
        setCountDownTimer(recipeItem.getTime());
        recipe.setText(recipeItem.getRecipe());
    }

    private void initialize(){
        recipeItem = (RecipeItem) getIntent().getSerializableExtra("recipeItem");
        countDown = (TextView) findViewById(R.id.count_down);
        recipe = (TextView) findViewById(R.id.recipe);
        pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            Boolean clicked = false;

            @Override
            public void onClick(View v) {
                if(currentTime == 0){
                    return;
                }
                if (clicked) {
                    setCountDownTimer((int) currentTime / 1000);
                    setTimersTime(currentTime);
                    pause.setText(R.string.button_pause);
                    clicked = false;
                    return;
                }
                countDownTimer.cancel();
                pause.setText(R.string.button_continue);
                clicked = true;
            }
        });

    }

    private void setCountDownTimer(final Integer time) {
        countDownTimer = new CountDownTimer((long) (time*1000), 1000){
            long lastTurnTime = time;

            public void onTick(long millisUntilFinished){
                currentTime = millisUntilFinished;
                setTimersTime(millisUntilFinished);
                if (itsTimeToMakeTurn(millisUntilFinished)){
                    showAlertDialog(R.string.alertDialog_message_turn);
                    showPushNotification(
                            getResources().
                                    getString(R.string.alertDialog_message_turn)
                    );
                    lastTurnTime = millsToSec(millisUntilFinished);
                }
            }

            private boolean itsTimeToMakeTurn(long millisUntilFinished) {
                Double rotationPeriod = recipeItem.getRotationPeriod();
                return lastTurnTime - millsToSec(millisUntilFinished)
                        >= rotationPeriod;
            }

            @Override
            public void onFinish() {
                currentTime = 0;
                showAlertDialog(R.string.alertDialog_message_finish);
                showPushNotification(getResources().getString(R.string.alertDialog_message_finish));
                countDown.setText(getResources().getString(R.string.alertDialog_message_finish));
            }
        };
        countDownTimer.start();
    }
    private long millsToSec(long mills){
        return mills / 1000;
    }

    private void setTimersTime(long time){
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("mm:ss", Locale.US);
        String outputTime = formatter.format(date);
        countDown.setText(outputTime);
    }
    private void showAlertDialog(int messageId){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(messageId)
                .setTitle(R.string.alertDialog_message_header);

        AlertDialog dialog = builder.create();
        try {
            dialog.show();
        }catch (WindowManager.BadTokenException badTokenException){
            Log.v(MainActivity.TAG, badTokenException.getMessage());
        }

    }

    private void showPushNotification(String text){
        NotificationManager notificationManager;
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                new Intent(this, TimerActivity.class),
                0
        );
        notificationManager = (NotificationManager) getSystemService(
                TimerActivity.NOTIFICATION_SERVICE
        );
        Notification notification = new Notification.Builder(TimerActivity.this)
                .setContentTitle(getResources().getString(R.string.alertDialog_message_header))
                .setContentText(text)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(0, notification);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.countDownTimer.cancel();
    }
}
