package com.example.weatherapp;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MyBackground extends MainActivity {

    public MyBackground(ConstraintLayout layout, Const weatherConst) {
        switch (weatherConst){
            case SUNNY:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
            case CLEAR:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
            case FOGGY:
                layout.setBackgroundResource(R.drawable.foggy);
                break;
            case CLOUDY:
                layout.setBackgroundResource(R.drawable.cloudy);
                break;
            case RAINY:
                layout.setBackgroundResource(R.drawable.rainy_drizzle);
                break;
            case SNOWY:
                layout.setBackgroundResource(R.drawable.snowy);
                break;
            case THUNDER:
                layout.setBackgroundResource(R.drawable.thunder);
                break;
            case DRIZZLE:
                layout.setBackgroundResource(R.drawable.rainy_drizzle);
                break;
            case NO_WEATHER_DATA_FOUND:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
        }
    }

}
