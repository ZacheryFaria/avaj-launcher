package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.vehicles.Vehicle;

public class WeatherRain implements WeatherEvent {
    @Override
    public void trigger(Vehicle v) {
        v.rain();
    }
}
