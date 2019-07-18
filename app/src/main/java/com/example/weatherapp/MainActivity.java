package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView temperatureMA;
    public static TextView atmosphericPhenomenaMA;
    public static TextView pressureMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureMA = findViewById(R.id.temperature);
        atmosphericPhenomenaMA = findViewById(R.id.atmospheric_phenomena);
        pressureMA = findViewById(R.id.pressure);
    }

    public void onClickCitySelectionButton(View view) {
        Intent intent = new Intent(getApplicationContext(), CitySelection.class);
        WeatherCondition condition = new WeatherCondition();
        condition.temperature = temperatureMA.getText().toString();
        condition.atmosphericPhenomena = atmosphericPhenomenaMA.getText().toString();
        condition.pressure = pressureMA.getText().toString();
        intent.putExtra("WEATHER_CONDITION", condition);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 2) {
            super.onActivityResult(requestCode,resultCode,data);
            return;
        }
        if (resultCode == RESULT_OK) {
            assert data != null;
            temperatureMA.setText(data.getStringExtra("WEATHER_CONDITION_2"));
            atmosphericPhenomenaMA.setText(data.getStringExtra("WEATHER_CONDITION_2"));
            pressureMA.setText(data.getStringExtra("WEATHER_CONDITION_2"));

        }
    }
}
