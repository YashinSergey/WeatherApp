package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CitySelection extends AppCompatActivity {

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
        citySelect(R.string.moscow, "19", R.string.weather_thunder, "762");
    }

    public void onClickSaintPetersburgRB(View view){
        citySelect(R.string.saint_petersburg, "18", R.string.weather_rainy, "756");
    }

    public void onClickWashingtonRB(View view){
        citySelect(R.string.washington, "21", R.string.weather_sunny, "760");
    }

    public void onClickMunichRB(View view){
        citySelect(R.string.munich, "19", R.string.weather_cloudy, "755");
    }

    public void onClickLosAngelesRB(View view){
        citySelect(R.string.los_angeles, "27", R.string.weather_sunny, "759");
    }

    public void onClickViennaRB(View view){
        citySelect(R.string.vienna, "25", R.string.weather_clear, "760");
    }

    private void citySelect(int p, String temp, int atmPh, String press) {
        tData.cityName = p;
        tData.temperature = temp;
        tData.atmosphericPhenomena = atmPh;
        tData.pressure = press;

        Intent intentRes = new Intent();
        intentRes.putExtra("CITY_NAME", tData.cityName);
        intentRes.putExtra("TEMPERATURE", tData.temperature);
        intentRes.putExtra("ATMOSPHERIC_PHENOMENA", tData.atmosphericPhenomena);
        intentRes.putExtra("PRESSURE", tData.pressure);
        setResult(RESULT_OK, intentRes);
        finish();
    }
}
