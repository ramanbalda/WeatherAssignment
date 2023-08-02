package org.example.entity;

import java.util.List;

public class WeatherData {
    private String cod;
    private double message;
    private int cnt;
    private List<WeatherInfo> list;
    private City city;

    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<WeatherInfo> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setList(List<WeatherInfo> list) {
        this.list = list;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

