package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherEvent events[] = new WeatherEvent[4];

    static {
        events[0] = new WeatherSun();
        events[1] = new WeatherFog();
        events[2] = new WeatherSnow();
        events[3] = new WeatherRain();
    }

    public static WeatherEvent getWeatherEvent(Coordinates c) {
        int seed = c.getHeight() + c.getLongitude() + c.getLatitude();
        Random rand = new Random(seed);
        return events[rand.nextInt(4)];
    }

}
