package com.bekh.george.shashlikapp;

import junit.framework.TestCase;


public class RecipeItemTest extends TestCase {
    RecipeItem recipeItem;
    public void setUp() throws Exception {
        super.setUp();
        recipeItem = new RecipeItem();

    }

    public void testGetTime() throws Exception {
        recipeItem.setTime(900);

        String result = recipeItem.getTime();

        assertEquals("900 секунд", result);
    }

}