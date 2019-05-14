package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.vehicles.Vehicle;

public class WeatherFog implements WeatherEvent {
    @Override
    public void trigger(Vehicle v) {
        v.fog();
    }
}
