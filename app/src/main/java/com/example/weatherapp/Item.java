package com.example.weatherapp;

public class Item {

    private String symbol;
    private String temperature;
    private String celsius;
    private String atmPhenomena;
    private String pressure;
    private String mmHg;

    public Item(String symbol, String temperature, String celsius, String atmPhenomena, String pressure, String mmHg) {
        this.symbol = symbol;
        this.temperature = temperature;
        this.celsius = celsius;
        this.atmPhenomena = atmPhenomena;
        this.pressure = pressure;
        this.mmHg = mmHg;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getCelsius() {
        return celsius;
    }

    public String getAtmPhenomena() {
        return atmPhenomena;
    }

    public String getPressure() {
        return pressure;
    }

    public String getMmHg() {
        return mmHg;
    }
}
