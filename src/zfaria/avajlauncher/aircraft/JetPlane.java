package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.WeatherTower;

public class JetPlane extends Aircraft {

    private WeatherTower tower;

    JetPlane(String name, Coordinates coords) {
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
            coords.addCoordinates(0, 10, 2);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " RAINY");
            coords.addCoordinates(0, 5, 0);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " FOGGY");
            coords.addCoordinates(0, 1, 0);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " SNOWY");
            coords.addCoordinates(0, 0, -7);
        }
    }

    @Override
    public String toString() {
        return String.format("JetPlane#%s (%d)", name, id);
    }
}
