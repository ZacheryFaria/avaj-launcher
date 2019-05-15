package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.WeatherTower;

public class Baloon extends Aircraft {

    private WeatherTower tower;

    Baloon(String name, Coordinates coords) {
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
            coords.addCoordinates(2, 0, 4);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " RAINY");
            coords.addCoordinates(0, 0, -5);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " FOGGY");
            coords.addCoordinates(0, 0, -3);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " SNOWY");
            coords.addCoordinates(0, 0, -15);
        }
    }

    public String toString() {
        return String.format("Baloon#%s (%d)", name, id);
    }
}
