package com.example.weatherapp.model;

public class Main {

    private float temp;
    private int pressure;
    private int humidity;

    public float getTemp() {

        return temp - 273.15F;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
