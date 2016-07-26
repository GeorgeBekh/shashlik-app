package com.bekh.george.shashlikapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CookingActivity extends ActionBarActivity {
    private ListView recipesList;
    private static Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
        initialize();
        ArrayList<RecipeItem> recipes;
        recipes = JsonUtil.convertJsonToRecipeItemArrayList(
                FileManager.getStringFromRawFile(R.raw.recipes, this)
        );
        RecipeArrayAdapter arrayAdapter = new RecipeArrayAdapter(
                this.getLayoutInflater(),
                recipes,
                this
        );
        recipesList.setAdapter(arrayAdapter);

    }


    private void initialize(){
        mContext = this;
        this.recipesList = (ListView) findViewById(R.id.recipesList);
    }

    public static Context getContext(){
        return mContext;
    }






}
