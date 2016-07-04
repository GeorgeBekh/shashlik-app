package com.bekh.george.shashlikapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CookingActivity extends ActionBarActivity {
    private ListView recipesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
    }

    private void initialize(){
        recipesList = (ListView) findViewById(R.id.recipesList);
    }
}
