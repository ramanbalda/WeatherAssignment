package org.example.entity;

import java.util.List;

public class WeatherInfo {
    private long dt;
    private MainWeatherData main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Sys sys;
    private String dt_txt;

    public void setDt(long dt) {
        this.dt = dt;
    }

    public void setMain(MainWeatherData main) {
        this.main = main;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public long getDt() {
        return dt;
    }

    public MainWeatherData getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }
}
