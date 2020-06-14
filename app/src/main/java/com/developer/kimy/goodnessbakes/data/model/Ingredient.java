package com.developer.kimy.goodnessbakes.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@org.parceler.Parcel
public class Ingredient {

    @SerializedName("quantity")
    @Expose
    public Double quantity;
    @SerializedName("measure")
    @Expose
    public String measure;
    @SerializedName("ingredient")
    @Expose
    public String ingredient;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}