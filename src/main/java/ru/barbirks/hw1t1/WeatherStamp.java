package ru.barbirks.hw1t1;

import java.util.Date;
import java.util.Random;

public class WeatherStamp {
    public int temperature;
    public int humidity;
    public int windSpeed;
    public int rain;
    public int cloudCover;
    public String city;
    public Date time;
    public Date timestamp = new Date();
    public WeatherStamp() {}

    public void setRandomWeather(){
        Random rand = new Random();
        temperature = rand.nextInt(25) -25;
        humidity = rand.nextInt(90) + 10;
        windSpeed = rand.nextInt(20);
        rain = rand.nextInt(100);
        cloudCover = rand.nextInt(90) + 10;
        city = "Moscow";
        time = new Date();
        time.setTime(rand.nextLong(10000000000L) + 1750000000000L);
    }
}
