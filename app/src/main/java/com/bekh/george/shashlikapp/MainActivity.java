package com.bekh.george.shashlikapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
    private Button startCooking;
    public static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        startCooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cookingIntent = new Intent();
                cookingIntent.setClass(MainActivity.this, CookingActivity.class);
                startActivity(cookingIntent);
            }
        });
    }

    private void initialize(){
        startCooking = (Button) findViewById(R.id.start_cooking);
    }
}
