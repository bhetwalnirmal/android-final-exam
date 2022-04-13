package com.nirmalbhetwal.androidfinalexam.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {
    private String name;
    private String capital;
    private int flagId;
    private ArrayList<Place> places;

    public Country(String name, String capital, int flagId, ArrayList<Place> places) {
        this.name = name;
        this.capital = capital;
        this.flagId = flagId;
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagId() {
        return flagId;
    }

    public void setFlagId(int flagId) {
        this.flagId = flagId;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
