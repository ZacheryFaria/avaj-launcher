package zfaria.avajlauncher;

import zfaria.avajlauncher.aircraft.Coordinates;
import zfaria.avajlauncher.aircraft.Flyable;
import zfaria.avajlauncher.weather.Tower;
import zfaria.avajlauncher.weather.WeatherProvider;

import java.util.ArrayList;
import java.util.List;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coords) {
        return WeatherProvider.getProvider().getCurrentWeather(coords);
    }

    void changeWeather() {
        super.conditionsChanged();
    }
}
