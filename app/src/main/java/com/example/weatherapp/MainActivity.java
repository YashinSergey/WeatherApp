package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.daysOfaWeekFragments.FridayFragment;
import com.example.weatherapp.daysOfaWeekFragments.MondayFragment;
import com.example.weatherapp.daysOfaWeekFragments.SaturdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.SundayFragment;
import com.example.weatherapp.daysOfaWeekFragments.ThursdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.TuesdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.WednesdayFragment;

public class MainActivity extends AppCompatActivity {

    private TextView cityName;
    private TextView cityNameForeTime;
    private TextView temperatureMA;
    private TextView atmosphericPhenomenaMA;
    private TextView pressureMA;
    private ConstraintLayout layout;
    private TransmissionData tData;

    private SundayFragment sundayF;
    private MondayFragment mondayF;
    private TuesdayFragment tuesdayF;
    private WednesdayFragment wednesdayF;
    private ThursdayFragment thursdayF;
    private FridayFragment fridayF;
    private SaturdayFragment saturdayF;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.city_name);
        cityNameForeTime = findViewById(R.id.city_name_for_time);
        temperatureMA = findViewById(R.id.temperature);
        atmosphericPhenomenaMA = findViewById(R.id.atmospheric_phenomena);
        pressureMA = findViewById(R.id.mon_pressure);

        layout = findViewById(R.id.main_activity);

        sundayF = new SundayFragment();
        mondayF = new MondayFragment();
        tuesdayF = new TuesdayFragment();
        wednesdayF = new WednesdayFragment();
        thursdayF = new ThursdayFragment();
        fridayF = new FridayFragment();
        saturdayF = new SaturdayFragment();
    }

    public void onClickCitySelectionButton(View view) {
        Intent intent = new Intent(getApplicationContext(), CitySelection.class);
        tData = new TransmissionData();
        tData.temperature = temperatureMA.getText().toString();
        tData.atmosphericPhenomena = R.string.weather_thunder;
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

    public void onClickSun(View view) {
            removeAllFragments();
            setDayOfAWeek(sundayF);
    }

    public void onClickMon(View view) {
        removeAllFragments();
        setDayOfAWeek(mondayF);
    }

    public void onClickTue(View view) {
        removeAllFragments();
        setDayOfAWeek(tuesdayF);
    }

    public void onClickWed(View view) {
        removeAllFragments();
        setDayOfAWeek(wednesdayF);
    }
    public void onClickThu(View view) {
        removeAllFragments();
        setDayOfAWeek(thursdayF);
    }
    public void onClickFri(View view) {
        removeAllFragments();
        setDayOfAWeek(fridayF);
    }
    public void onClickSat(View view) {
        removeAllFragments();
        setDayOfAWeek(saturdayF);
    }

    public void setDayOfAWeek(Fragment fragment){
        ListenerOnAdd listenerOnAdd = new ListenerOnAdd(fragment);
        listenerOnAdd.addFragment();
    }

    public void removeAllFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(sundayF);
        fragmentTransaction.remove(mondayF);
        fragmentTransaction.remove(tuesdayF);
        fragmentTransaction.remove(wednesdayF);
        fragmentTransaction.remove(thursdayF);
        fragmentTransaction.remove(fridayF);
        fragmentTransaction.remove(saturdayF);
        fragmentTransaction.commit();
    }

    class ListenerOnAdd implements View.OnClickListener{

        Fragment fragment;

        ListenerOnAdd(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            addFragment();
        }

        private void addFragment(){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.day_of_the_week, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
