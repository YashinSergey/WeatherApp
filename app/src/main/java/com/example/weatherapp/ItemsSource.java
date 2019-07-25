package com.example.weatherapp;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class ItemsSource {

    private List<Items> itemsSource;
    private Resources resources;

    public ItemsSource(Resources resources) {
        this.resources = resources;
        itemsSource = new ArrayList<>(6);
    }

    public ItemsSource build() {
        Item[] weatherInfo = 
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
