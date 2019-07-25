package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weatherapp.daysOfaWeekFragments.FridayFragment;
import com.example.weatherapp.daysOfaWeekFragments.MondayFragment;
import com.example.weatherapp.daysOfaWeekFragments.SaturdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.SundayFragment;
import com.example.weatherapp.daysOfaWeekFragments.ThursdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.TuesdayFragment;
import com.example.weatherapp.daysOfaWeekFragments.WednesdayFragment;

public class MainActivity extends AppCompatActivity {

    public static Const weatherConst;

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
        weatherConst = Const.CLEAR;

        layout = findViewById(R.id.main_activity);

        sundayF = new SundayFragment();
        mondayF = new MondayFragment();
        tuesdayF = new TuesdayFragment();
        wednesdayF = new WednesdayFragment();
        thursdayF = new ThursdayFragment();
        fridayF = new FridayFragment();
        saturdayF = new SaturdayFragment();

        ItemSource dataSource = new ItemSource(getResources());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter itemAdapter = new ItemAdapter(dataSource);
        recyclerView.setAdapter(itemAdapter);

    }

    public void onClickCitySelectionButton(View view) {
        Intent intent = new Intent(getApplicationContext(), CitySelection.class);
        tData = new TransmissionData();
        tData.temperature = temperatureMA.getText().toString();
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
            pressureMA.setText(data.getStringExtra("PRESSURE"));
            atmosphericPhenomenaMA.setText(data.getIntExtra("ATMOSPHERIC_PHENOMENA", 0));

            new MyBackground(layout, weatherConst);
        }
    }

    public void onClickSun(View view) {
            setDayOfAWeek(sundayF);
    }

    public void onClickMon(View view) {
        setDayOfAWeek(mondayF);
    }

    public void onClickTue(View view) {
        setDayOfAWeek(tuesdayF);
    }

    public void onClickWed(View view) {
        setDayOfAWeek(wednesdayF);
    }

    public void onClickThu(View view) {
        setDayOfAWeek(thursdayF);
    }

    public void onClickFri(View view) {
        setDayOfAWeek(fridayF);
    }

    public void onClickSat(View view) {
        setDayOfAWeek(saturdayF);
    }

    public void setDayOfAWeek(Fragment fragment){
        ListenerOnAdd listenerOnAdd = new ListenerOnAdd(fragment);
        listenerOnAdd.addFragment();
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
            fragmentTransaction.replace(R.id.day_of_the_week, fragment);
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
