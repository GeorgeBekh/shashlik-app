package com.bekh.george.shashlikapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CookingActivity extends ActionBarActivity {
    private ListView recipesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
        //startTimerActivity();
        initialize();
        RecipeItem shashlik = shashlikInit();
        ArrayList<RecipeItem> recipes = new ArrayList<RecipeItem>();
        recipes.add(shashlik);
        RecipeAdapter arrayAdapter = new RecipeAdapter(
                this.getLayoutInflater(),
                recipes
        );
        recipesList.setAdapter(arrayAdapter);

    }

    private void startTimerActivity() {
        Intent intent = new Intent();
        intent.setClass(CookingActivity.this, TimerActivity.class);
        intent.putExtra("time", 900f);
        startActivity(intent);
    }

    private void initialize(){
        this.recipesList = (ListView) findViewById(R.id.recipesList);
    }

    private RecipeItem shashlikInit(){
        RecipeItem beefShashlik = new RecipeItem();
        beefShashlik.setTime(900);
        beefShashlik.setRotationFrequency(0.008f);
        beefShashlik.setIngredient("Beef");
        beefShashlik.setName("Говяжий шашлык");
        return beefShashlik;
    }
}
