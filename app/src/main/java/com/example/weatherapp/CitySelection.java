package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CitySelection extends AppCompatActivity {

    private TextView cityName;
    private TextView cityNameForTime;
    private TextView temperatureCS;
    private TextView atmosphericPhenomenaCS;
    private TextView pressureCS;
    private WeatherCondition condition;
    private String wc = "WEATHER_CONDITION_2";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection);

        temperatureCS = findViewById(R.id.temperature);
        atmosphericPhenomenaCS = findViewById(R.id.atmospheric_phenomena);
        pressureCS = findViewById(R.id.pressure);

        condition = (WeatherCondition) getIntent().getExtras().getSerializable("WEATHER_CONDITION");

        assert condition != null;
        temperatureCS.setText(condition.temperature);
        atmosphericPhenomenaCS.setText(condition.atmosphericPhenomena);
        pressureCS.setText(condition.pressure);

    }

    @SuppressLint("SetTextI18n")
    public void onClickMoscowRB(View view){
        temperatureCS.setText("19");
        atmosphericPhenomenaCS.setText("BLA-BLA");
        pressureCS.setText("762");

        Intent intentRes = new Intent();
        intentRes.putExtra(wc, condition);
        setResult(RESULT_OK, intentRes);
        finish();
    }

    public void onClickSaintPetersburgRB(View view){
        citySelect(R.string.saint_petersburg);
    }

    public void onClickWashingtonRB(View view){
        citySelect(R.string.washington);
    }

    public void onClickMunichRB(View view){
        citySelect(R.string.munich);
    }

    public void onClickLosAngelesRB(View view){
        citySelect(R.string.los_angeles);
    }

    public void onClickViennaRB(View view){
        citySelect(R.string.vienna);
    }

    private void citySelect(int p) {
        setContentView(R.layout.activity_main);
        cityName = findViewById(R.id.city_name);
        cityNameForTime = findViewById(R.id.city_name_for_time);
        cityName.setText(p);
        cityNameForTime.setText(cityName.getText());
    }
}
