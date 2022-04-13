package com.nirmalbhetwal.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nirmalbhetwal.androidfinalexam.Models.Country;
import com.nirmalbhetwal.androidfinalexam.Models.Place;

import java.util.ArrayList;

public class DestinationDetails extends AppCompatActivity {
    Spinner spinnerCountryList;
    ArrayList<Country> countryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);

        fillData();
        // initialize the spinner
        spinnerCountryList = (Spinner) findViewById(R.id.spinnerCountryList);
        ArrayAdapter countryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countryList);
        spinnerCountryList.setAdapter(countryAdapter);
    }

    void fillData () {
        ArrayList<Place> canadaPlaceOfInterest = new ArrayList<>();
        int[] niagaraImages = {R.drawable.canada};
        canadaPlaceOfInterest.add(new Place("Niagara Falls", 100, niagaraImages));
        int[] cnTowerImages = {R.drawable.canada};
        canadaPlaceOfInterest.add(new Place("CN Tower", 30, cnTowerImages));
        int[] buchartImages = {R.drawable.canada};
        canadaPlaceOfInterest.add(new Place("The Buchart Gardens", 30, buchartImages));
        Country canada = new Country("Canada", "Ottawa", R.drawable.canada, canadaPlaceOfInterest);
        countryList.add(canada);

        ArrayList<Place> usaPlaceOfInterest = new ArrayList<>();
        int[] statueOfLibertyImages = {R.drawable.usa};
        usaPlaceOfInterest.add(new Place("The Statue of Liberty", 90, statueOfLibertyImages));
        int[] whiteHouseImages = {R.drawable.usa};
        usaPlaceOfInterest.add(new Place("The Statue of Liberty", 90, whiteHouseImages));
        int[] timeSquareImages = {R.drawable.usa};
        usaPlaceOfInterest.add(new Place("The Statue of Liberty", 90, timeSquareImages));
        Country usa = new Country("USA", "Washington DC", R.drawable.usa, usaPlaceOfInterest);
        countryList.add(usa);

        ArrayList<Place> englandPlaceOfInterest = new ArrayList<>();
        Country england = new Country("England", "London", R.drawable.england, englandPlaceOfInterest);
        int[] bigBenImages = {R.drawable.england};
        englandPlaceOfInterest.add(new Place("Big Ben", 30, bigBenImages));
        int[] westMinisterImages = {R.drawable.england};
        englandPlaceOfInterest.add(new Place("Westminster Abbey", 25, westMinisterImages));
        int[] hydeParkImages = {R.drawable.england};
        englandPlaceOfInterest.add(new Place("Westminster Abbey", 15, hydeParkImages));
        countryList.add(england);
    }
}