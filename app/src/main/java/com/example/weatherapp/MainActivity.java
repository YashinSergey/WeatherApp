package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cityName;
    private TextView cityNameForeTime;
    private TextView temperatureMA;
    private TextView atmosphericPhenomenaMA;
    private TextView pressureMA;
    private ConstraintLayout layout;
    private TransmissionData tData;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.city_name);
        cityNameForeTime = findViewById(R.id.city_name_for_time);
        temperatureMA = findViewById(R.id.temperature);
        atmosphericPhenomenaMA = findViewById(R.id.atmospheric_phenomena);
        pressureMA = findViewById(R.id.pressure);

        layout = findViewById(R.id.main_activity);
    }

    public void onClickCitySelectionButton(View view) {
        Intent intent = new Intent(getApplicationContext(), CitySelection.class);
        tData = new TransmissionData();
        tData.temperature = temperatureMA.getText().toString();
        tData.atmosphericPhenomena = R.string.weather_cloudy;
        tData.pressure = pressureMA.getText().toString();
        startActivityForResult(intent, 2);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 2) {
            super.onActivityResult(requestCode,resultCode,data);
            return;
        }
        if (resultCode == RESULT_OK) {
            assert data != null;
            cityName.setText(data.getIntExtra("CITY_NAME", 0));
            cityNameForeTime.setText(data.getIntExtra("CITY_NAME", 0));
            temperatureMA.setText(data.getStringExtra("TEMPERATURE"));
            atmosphericPhenomenaMA.setText(data.getIntExtra("ATMOSPHERIC_PHENOMENA",0));
            pressureMA.setText(data.getStringExtra("PRESSURE"));

            myBackground(layout, tData.atmosphericPhenomena);
        }
    }

    private void myBackground(ConstraintLayout layout, int kindOfWeather) {
        switch (kindOfWeather){
            case R.string.weather_sunny:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
            case R.string.weather_clear:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
            case R.string.weather_foggy:
                layout.setBackgroundResource(R.drawable.foggy);
                break;
            case R.string.weather_cloudy:
                layout.setBackgroundResource(R.drawable.cloudy);
                break;
            case R.string.weather_rainy:
                layout.setBackgroundResource(R.drawable.rainy_drizzle);
                break;
            case R.string.weather_snowy:
                layout.setBackgroundResource(R.drawable.snowy);
                break;
            case R.string.weather_thunder:
                layout.setBackgroundResource(R.drawable.thunder);
                break;
            case R.string.weather_drizzle:
                layout.setBackgroundResource(R.drawable.rainy_drizzle);
                break;
            case R.string.place_not_found:
                layout.setBackgroundResource(R.drawable.sunny_clear);
                break;
        }
    }
}
