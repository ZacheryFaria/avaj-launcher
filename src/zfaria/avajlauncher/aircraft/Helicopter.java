package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.WeatherTower;
import zfaria.avajlauncher.weather.WeatherProvider;

public class Helicopter extends Aircraft {

    private WeatherTower tower;

    Helicopter(String name, Coordinates coords) {
        super(name, coords);
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.tower = tower;
    }

    @Override
    public void updateConditions() {
        String weather = tower.getWeather(coords);
        if (weather.equals("SUN")) {
            Logger.getInstance().out.println(this + " SUNNY");
            coords.addCoordinates(10, 0, 2);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " RAINY");
            coords.addCoordinates(5, 0, 0);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " FOGGY");
            coords.addCoordinates(1, 0, 0);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " SNOWY");
            coords.addCoordinates(0, 0, -12);
        }
    }

    @Override
    public String toString() {
        return String.format("Helicopter#%s (%d)", name, id);
    }
}
