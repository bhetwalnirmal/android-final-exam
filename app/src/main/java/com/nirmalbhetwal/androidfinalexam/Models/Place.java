package com.nirmalbhetwal.androidfinalexam.Models;

import java.io.Serializable;
import java.util.Arrays;

public class Place implements Serializable {
    private String placeOfInterest;
    private double priceOfVisit;
    private int[] imageIds;

    public Place(String placeOfInterest, double priceOfVisit, int[] imageIds) {
        this.placeOfInterest = placeOfInterest;
        this.priceOfVisit = priceOfVisit;
        this.imageIds = imageIds;
    }

    public String getPlaceOfInterest() {
        return placeOfInterest;
    }

    public void setPlaceOfInterest(String placeOfInterest) {
        this.placeOfInterest = placeOfInterest;
    }

    public double getPriceOfVisit() {
        return priceOfVisit;
    }

    public void setPriceOfVisit(double priceOfVisit) {
        this.priceOfVisit = priceOfVisit;
    }

    public int[] getImageIds() {
        return imageIds;
    }

    public void setImageIds(int[] imageIds) {
        this.imageIds = imageIds;
    }

    @Override
    public String toString() {
        return placeOfInterest;
    }
}
