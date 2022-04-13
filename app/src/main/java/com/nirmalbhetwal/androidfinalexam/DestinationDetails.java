package com.nirmalbhetwal.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.nirmalbhetwal.androidfinalexam.Models.Country;
import com.nirmalbhetwal.androidfinalexam.Models.Place;

import java.util.ArrayList;

public class DestinationDetails extends AppCompatActivity {
    Spinner spinnerCountryList;
    ArrayList<Country> countryList = new ArrayList<>();
    TextView textViewCountryCapital, discount, tvTotal;
    ImageView imageViewCountryFlag;
    ListView placesList;
    Country selectedCountry = null;
    Place selectedPlace = null;
    EditText editTextNumberOfVisitors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);

        fillData();
        textViewCountryCapital = (TextView) findViewById(R.id.textViewCountryCapital);
        discount = (TextView) findViewById(R.id.tvDiscount);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        editTextNumberOfVisitors = (EditText) findViewById(R.id.editTextNumberOfVisitors);
        imageViewCountryFlag = (ImageView) findViewById(R.id.imageViewCountryFlag);
        // initialize the spinner
        spinnerCountryList = (Spinner) findViewById(R.id.spinnerCountryList);
        ArrayAdapter countryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countryList);
        spinnerCountryList.setAdapter(countryAdapter);
        selectedCountry = countryList.get(0);
        // listview
        placesList = (ListView) findViewById(R.id.listViewPlaces);
        placesList.setAdapter(new PlaceAdapter(this, countryList.get(0).getPlaces()));

        spinnerCountryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = countryList.get(i);
                selectedCountry = country;
                textViewCountryCapital.setText(country.getCapital());
                imageViewCountryFlag.setImageResource(country.getFlagId());
                placesList.setAdapter(new PlaceAdapter(DestinationDetails.this, country.getPlaces()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        placesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = selectedCountry.getPlaces().get(i);
                selectedPlace = place;

                updateTotal();
            }
        });

        editTextNumberOfVisitors.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateTotal();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void fillData () {
        ArrayList<Place> canadaPlaceOfInterest = new ArrayList<>();
        int[] niagaraImages = {R.drawable.niagra_falls};
        canadaPlaceOfInterest.add(new Place("Niagara Falls", 100, niagaraImages));
        int[] cnTowerImages = {R.drawable.cn_tower};
        canadaPlaceOfInterest.add(new Place("CN Tower", 30, cnTowerImages));
        int[] buchartImages = {R.drawable.buchart_gardens};
        canadaPlaceOfInterest.add(new Place("The Buchart Gardens", 30, buchartImages));
        Country canada = new Country("Canada", "Ottawa", R.drawable.canada, canadaPlaceOfInterest);
        int[] notredame = {R.drawable.notre_dame};
        canadaPlaceOfInterest.add(new Place("The Notre-Dame Brasilica", 30, notredame));
        countryList.add(canada);

        ArrayList<Place> usaPlaceOfInterest = new ArrayList<>();
        int[] statueOfLibertyImages = {R.drawable.statue_of_liberty};
        usaPlaceOfInterest.add(new Place("The Statue of Liberty", 90, statueOfLibertyImages));
        int[] whiteHouseImages = {R.drawable.whitehouse};
        usaPlaceOfInterest.add(new Place("White House", 90, whiteHouseImages));
        int[] timeSquareImages = {R.drawable.time_square};
        usaPlaceOfInterest.add(new Place("Time Square", 90, timeSquareImages));
        Country usa = new Country("USA", "Washington DC", R.drawable.usa, usaPlaceOfInterest);
        countryList.add(usa);

        ArrayList<Place> englandPlaceOfInterest = new ArrayList<>();
        Country england = new Country("England", "London", R.drawable.england, englandPlaceOfInterest);
        int[] bigBenImages = {R.drawable.big_ben};
        englandPlaceOfInterest.add(new Place("Big Ben", 30, bigBenImages));
        int[] westMinisterImages = {R.drawable.westminister};
        englandPlaceOfInterest.add(new Place("Westminster Abbey", 25, westMinisterImages));
        int[] hydeParkImages = {R.drawable.hyde_park};
        englandPlaceOfInterest.add(new Place("Hyde Park", 15, hydeParkImages));
        countryList.add(england);
    }

    void updateTotal () {
        int numberOfVisitors = 0;

        if (selectedCountry != null) {
            try {
                numberOfVisitors = Integer.parseInt(editTextNumberOfVisitors.getText().toString().trim());
            } catch (Exception e) {
                numberOfVisitors = 0;
            }
        }
        double total = 0;
        if (selectedPlace != null) {
            total = numberOfVisitors *  selectedPlace.getPriceOfVisit();
        }

        if (numberOfVisitors > 15) {
            total *= 0.95; // give 5% discount;
            discount.setText(String.format("$ %.2f", total * 0.05));
        } else {
            discount.setText("$ 0.00");
        }

        tvTotal.setText(String.format("$ %.2f", total));
    }
}