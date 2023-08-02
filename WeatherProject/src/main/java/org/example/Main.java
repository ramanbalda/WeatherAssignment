package org.example;

import com.google.gson.Gson;

import okhttp3.*;
import org.example.entity.WeatherData;
import org.example.entity.WeatherInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Get temperature of a date");
            System.out.println("2. Get wind speed of a date");
            System.out.println("3. Get pressure of a date");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting the program.");
                break;
            } else if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            System.out.print("Enter the date (yyyy-MM-dd): ");
            String date = scanner.nextLine();

            try {
                OkHttpClient client = new OkHttpClient();
                String apiUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"; 
                Request request = new Request.Builder()
                        .url(apiUrl)
                        .build();

                    Response response = client.newCall(request).execute();
                    assert response.body() != null;
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    WeatherData weatherData = gson.fromJson(responseData, WeatherData.class);
                    ArrayList<WeatherInfo> weatherList = new ArrayList<>(weatherData.getList());
                switch (choice) {
                    case 1 -> {
                        for (WeatherInfo weatherInfo : weatherList) {
                            if (weatherInfo.getDt_txt().contains(date)) {
                                System.out.println("temperature on " + weatherInfo.getDt_txt() + ": " + weatherInfo.getMain().getTemp());
                            }
                        }
                    }
                    case 2 -> {
                        for (WeatherInfo weatherInfo : weatherList) {
                            if (weatherInfo.getDt_txt().contains(date)) {
                                System.out.println("Wind speed on " + weatherInfo.getDt_txt() + ": " + weatherInfo.getWind().getSpeed());
                            }
                        }
                    }
                    case 3 -> {
                        for (WeatherInfo weatherInfo : weatherList) {
                            if (weatherInfo.getDt_txt().contains(date)) {
                                System.out.println("Pressure  on " + weatherInfo.getDt_txt() + ": " + weatherInfo.getMain().getPressure());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Exception occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}