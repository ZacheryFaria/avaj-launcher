package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.vehicles.Vehicle;

public class WeatherSnow implements WeatherEvent {
    @Override
    public void trigger(Vehicle v) {
        v.snow();
    }
}
