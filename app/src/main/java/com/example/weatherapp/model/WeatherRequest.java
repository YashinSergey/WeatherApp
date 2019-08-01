package com.example.weatherapp.model;

public class WeatherRequest {

    private Clouds clouds;
    private Coord coord;
    private Main main;
    private Weather[] weather;
//    private Wind wind;
    private String name;
    private int timezone;

    public Clouds getClouds() {
        return clouds;
    }

    public Coord getCoord() {
        return coord;
    }

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

//    public Wind getWind() {
//        return wind;
//    }

    public String getName() {
        return name;
    }

    public int getTimezone() {
        return timezone;
    }
}
