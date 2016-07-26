package com.bekh.george.shashlikapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class RecipeArrayAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    private final List<RecipeItem> recipeItems;

    public RecipeArrayAdapter(LayoutInflater inflater, List<RecipeItem> recipeItems, Context context) {
        this.inflater = inflater;
        this.recipeItems = recipeItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.recipeItems.size();
    }

    @Override
    public RecipeItem getItem(int position) {
        return this.recipeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.recipeItems.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final RecipeItem recipeItem = getItem(position);

        if(convertView == null){
            convertView = this.inflater.inflate(R.layout.recipe_item, parent, false);
            final  ViewHolder viewHolder = new ViewHolder();
            viewHolder.cookingIngredient = (TextView) convertView.findViewById(R.id.cooking_ingredient);
            viewHolder.cookingTime = (TextView) convertView.findViewById(R.id.cooking_time);
            viewHolder.recipeName = (TextView) convertView.findViewById(R.id.recipe_name);

            convertView.setTag(viewHolder);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimerActivity(recipeItem);
            }
        });
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.cookingIngredient.setText(recipeItem.getIngredient());
        Date date = new Date(recipeItem.getTime() * 1000);
        DateFormat format = new SimpleDateFormat("mm:ss", Locale.US);
        String time = format.format(date);
        viewHolder.cookingTime.setText(time);
        viewHolder.recipeName.setText(recipeItem.getName());

        return convertView;
    }

    private void startTimerActivity(RecipeItem recipeItem) {
        Intent intent = new Intent();
        intent.setClass(context, TimerActivity.class);
        intent.putExtra("recipeItem", recipeItem);
        context.startActivity(intent);
    }
}
