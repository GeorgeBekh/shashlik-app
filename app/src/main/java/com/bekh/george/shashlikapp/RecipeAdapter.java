package com.bekh.george.shashlikapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by george on 06.07.16.
 */
public class RecipeAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<RecipeItem> recipeItems;

    public RecipeAdapter(LayoutInflater inflater, List<RecipeItem> recipeItems) {
        this.inflater = inflater;
        this.recipeItems = recipeItems;
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
            viewHolder.cookingTime = (TextView) convertView.findViewById(R.id.cooking_time);
            viewHolder.recipeName = (TextView) convertView.findViewById(R.id.recipe_name);

            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.cookingTime.setText(recipeItem.getTime());
        viewHolder.recipeName.setText(recipeItem.getName());

        return convertView;
    }
}
