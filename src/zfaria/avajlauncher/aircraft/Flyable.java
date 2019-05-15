package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower tower);
}
