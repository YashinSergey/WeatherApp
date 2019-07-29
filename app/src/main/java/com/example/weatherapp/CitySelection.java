package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CitySelection extends BaseActivity {

    private TransmissionData tData;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection);
        tData = new TransmissionData();
    }

    @SuppressLint("SetTextI18n")
    public void onClickMoscowRB(View view){
        citySelect(R.string.moscow, "19", Const.THUNDER, "762");
    }

    public void onClickSaintPetersburgRB(View view){
        citySelect(R.string.saint_petersburg, "18", Const.RAINY, "756");
    }

    public void onClickWashingtonRB(View view){
        citySelect(R.string.washington, "21", Const.SUNNY, "760");
    }

    public void onClickMunichRB(View view){
        citySelect(R.string.munich, "19", Const.CLOUDY, "755");
    }

    public void onClickLosAngelesRB(View view){
        citySelect(R.string.los_angeles, "27", Const.CLEAR, "759");
    }

    public void onClickViennaRB(View view){
        citySelect(R.string.vienna, "25", Const.FOGGY, "760");
    }

    private void citySelect(int p, String temp, Const weatherConst, String press) {
        tData.cityName = p;
        tData.temperature = temp;
        setAtmosphericPhenomena(weatherConst);
        tData.pressure = press;
        MainActivity.weatherConst = weatherConst;

        Intent intentRes = new Intent();
        intentRes.putExtra("CITY_NAME", tData.cityName);
        intentRes.putExtra("TEMPERATURE", tData.temperature);
        intentRes.putExtra("ATMOSPHERIC_PHENOMENA", tData.atmosphericPhenomena);
        intentRes.putExtra("PRESSURE", tData.pressure);
        setResult(RESULT_OK, intentRes);
        finish();
    }

    private void setAtmosphericPhenomena(Const weatherConst) {
        switch (weatherConst){
            case SUNNY:
                tData.atmosphericPhenomena = R.string.weather_sunny;
                break;
            case CLEAR:
                tData.atmosphericPhenomena = R.string.weather_clear;
                break;
            case FOGGY:
                tData.atmosphericPhenomena = R.string.weather_foggy;
                break;
            case CLOUDY:
                tData.atmosphericPhenomena = R.string.weather_cloudy;
                break;
            case RAINY:
                tData.atmosphericPhenomena = R.string.weather_rainy;
                break;
            case SNOWY:
                tData.atmosphericPhenomena = R.string.weather_snowy;
                break;
            case THUNDER:
                tData.atmosphericPhenomena = R.string.weather_thunder;
                break;
            case DRIZZLE:
                tData.atmosphericPhenomena = R.string.weather_drizzle;
                break;
        }
    }
}
