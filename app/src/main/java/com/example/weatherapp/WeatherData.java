package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.example.weatherapp.model.WeatherRequest;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;

public class WeatherData {

    public static String cityName;
    public static String temperature;
    public static String pressure;

    public void connect(String url) {
        try {
            final URL uri = new URL(url);
            final Handler handler = new Handler();
            new Thread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void run() {
                    try {
                        HttpsURLConnection urlConnection;
                        urlConnection = (HttpsURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setReadTimeout(10000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String res = in.lines().collect(Collectors.joining("\n"));
                        Gson gson = new Gson();
                        final WeatherRequest weatherRequest = gson.fromJson(res, WeatherRequest.class);
                        handler.post(new Runnable() {
                            @SuppressLint("DefaultLocale")
                            @Override
                            public void run() {
                                cityName = weatherRequest.getName();
                                temperature = String.format("%d", Math.round(weatherRequest.getMain().getTemp()));
                                pressure = (((Integer)weatherRequest.getMain().getPressure()).toString());
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
