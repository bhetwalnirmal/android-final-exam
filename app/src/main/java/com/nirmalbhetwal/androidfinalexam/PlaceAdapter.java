package com.nirmalbhetwal.androidfinalexam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.nirmalbhetwal.androidfinalexam.Models.Place;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    ArrayList<Place> places;
    LayoutInflater inflater;
    Context context;

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        this.places = places;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CartViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.place_row, null);
            viewHolder = new CartViewHolder();
            viewHolder.placeName = view.findViewById(R.id.placeName);
            viewHolder.placePrice = view.findViewById(R.id.visitPrice);
            viewHolder.placeImage = view.findViewById(R.id.placeImage);
        } else {
            viewHolder = (CartViewHolder) view.getTag();
        }

        viewHolder.placeName.setText(places.get(i).getPlaceOfInterest());
        viewHolder.placePrice.setText(String.format("$ %.2f", places.get(i).getPriceOfVisit()));

        viewHolder.placeImage.setImageResource(places.get(i).getImageIds()[0]);

        return view;
    }

    static class CartViewHolder {
        TextView placeName, placePrice;
        ImageView placeImage;
    }
}
