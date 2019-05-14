package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.vehicles.Vehicle;

public class WeatherSun implements WeatherEvent {
    @Override
    public void trigger(Vehicle v) {
        v.sun();
    }
}
