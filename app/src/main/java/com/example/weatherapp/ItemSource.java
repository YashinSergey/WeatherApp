package com.example.weatherapp;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class ItemSource {

    private List<Items> itemsSource;
    private Resources resources;

    public ItemSource(Resources resources) {
        this.resources = resources;
        itemsSource = new ArrayList<>(6);
    }

    public ItemSource build() {
        String[] weatherInfo = resources.getStringArray(R.array.weather_array1);
        for (int i = 0; i < weatherInfo.length; i++) {
            itemsSource.add(new Items(weatherInfo[i]));
        }
        return this;
    }

    public Items getItem(int pos) {
        return itemsSource.get(pos);
    }

    public int size() {
        return itemsSource.size();
    }

}
