package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cityName;
    TextView cityNameForTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCitySelectionButton(View view) {
        setContentView(R.layout.city_selection);
    }

    public void onClickMoscowRB(View view){
        citySelect(R.string.moscow);
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
