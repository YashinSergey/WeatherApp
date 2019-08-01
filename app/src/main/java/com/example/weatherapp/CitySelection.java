package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class CitySelection extends BaseActivity {

    private String weatherUrl;
    private TransmissionData tData;
    private WeatherData weatherData;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection);
        weatherData = new WeatherData();
    }

    @SuppressLint("SetTextI18n")
    public void onClickMoscowRB(View view){
        citySelect(R.string.moscow);
    }

    public void onClickSaintPetersburgRB(View view){
        citySelect(R.string.saint_petersburg);
    }

    public void onClickWashingtonRB(View view){
        citySelect(R.string.washington);
    }

    public void onClickBerlinRB(View view){
        citySelect(R.string.berlin);
    }

    public void onClickLosAngelesRB(View view){
        citySelect(R.string.los_angeles);
    }

    public void onClickViennaRB(View view){
        citySelect(R.string.vienna);
    }

    private void citySelect(int p) {
        setWeatherUrl(p);
        weatherData.connect(getWeatherUrl());
        setResult(RESULT_OK);
        finish();
    }

//    private void setAtmosphericPhenomena(Const weatherConst) {
//        switch (weatherConst){
//            case SUNNY:
//                tData.atmosphericPhenomena = R.string.weather_sunny;
//                break;
//            case CLEAR:
//                tData.atmosphericPhenomena = R.string.weather_clear;
//                break;
//            case FOGGY:
//                tData.atmosphericPhenomena = R.string.weather_foggy;
//                break;
//            case CLOUDY:
//                tData.atmosphericPhenomena = R.string.weather_cloudy;
//                break;
//            case RAINY:
//                tData.atmosphericPhenomena = R.string.weather_rainy;
//                break;
//            case SNOWY:
//                tData.atmosphericPhenomena = R.string.weather_snowy;
//                break;
//            case THUNDER:
//                tData.atmosphericPhenomena = R.string.weather_thunder;
//                break;
//            case DRIZZLE:
//                tData.atmosphericPhenomena = R.string.weather_drizzle;
//                break;
//        }
//    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(int cityNameResource) {
        int id = -1;
        switch (cityNameResource) {
            case R.string.moscow:
                id = 524901;
                break;
            case R.string.saint_petersburg:
                id = 498817;
                break;
            case R.string.washington:
                id = 4497680;
                break;
            case R.string.berlin:
                id = 2950159;
                break;
            case R.string.los_angeles:
                id = 3882428;
                break;
            case R.string.vienna:
                id = 2761369;
                break;
        }
        if (id == -1) {

        }
            this.weatherUrl = "https://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=244ce3bd336403d1745b35a1ce5d5d7d";
    }
}
