package com.bekh.george.shashlikapp;


public class RecipeItem {
    private String time;
    private Float rotationFrequency;
    private String recipe;
    private String ingredient;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = Integer.toString(time) + " секунд";
    }

    public Float getRotationFrequency() {
        return rotationFrequency;
    }

    public void setRotationFrequency(Float rotationFrequency) {
        this.rotationFrequency = rotationFrequency;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeItem that = (RecipeItem) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (rotationFrequency != null ? !rotationFrequency.equals(that.rotationFrequency) : that.rotationFrequency != null)
            return false;
        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null)
            return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (rotationFrequency != null ? rotationFrequency.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
