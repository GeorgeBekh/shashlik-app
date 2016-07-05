package com.bekh.george.shashlikapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtil {

    public static ArrayList<RecipeItem> convertJsonToRecipeItemArrayList(String json){
        ArrayList<RecipeItem> recipeItems = new ArrayList<RecipeItem>();
        try {
            recipeItems = generateRecipeItemListFromJson(json);
        }catch (JSONException e){
            Log.e(MainActivity.TAG, "Recipes file isn't valid or doesn't exist");
        }
        return recipeItems;
    }

    private static ArrayList<RecipeItem> generateRecipeItemListFromJson(String json) throws JSONException {
        ArrayList<RecipeItem> resultList = new ArrayList<RecipeItem>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("recipes");
        for (int i = 0; i < jsonArray.length(); i++){
            resultList.add(generateRecipeItem(jsonArray, i));
        }
        return resultList;
    }

    private static RecipeItem generateRecipeItem(JSONArray jsonArray, int i) throws JSONException {
        RecipeItem recipeItem = new RecipeItem();
        JSONObject recipe = jsonArray.getJSONObject(i);
        recipeItem.setTime(recipe.getInt("time"));
        recipeItem.setName(recipe.getString("name"));
        recipeItem.setIngredient(recipe.getString("ingredient"));
        recipeItem.setRotationFrequency(recipe.getDouble("rotation frequency"));
        recipeItem.setRecipe(recipe.getString("recipe"));
        return recipeItem;
    }
}
