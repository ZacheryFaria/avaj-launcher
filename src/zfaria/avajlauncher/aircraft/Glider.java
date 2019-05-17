package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.WeatherTower;

public class Glider extends Aircraft {

    private WeatherTower tower;

    Glider(String name, Coordinates coord) {
        super(name, coord);
    }

    @Override
    public void updateConditions() {
        String weather = tower.getWeather(coords);
        if (weather.equals("SUN")) {
            Logger.getInstance().out.println(this + " Beautiful day to glide!");
            coords.addCoordinates(3, 2, 0);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " Aww man, what a way to ruin the day!");
            coords.addCoordinates(0, 5, -3);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " Can't see... getting a bit scared...");
            coords.addCoordinates(7, 1, -3);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " Why did I sign up for this?");
            coords.addCoordinates(0, 1, -12);
        }

        if (coords.getHeight() <= 0) {
            tower.unregister(this);
            Logger.getInstance().out.printf("%s landed at Long: %d Lat: %d\n", this, coords.getLongitude(), coords.getLatitude());
        }
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.tower = tower;
    }

    @Override
    public String toString() {
        return String.format("Glider#%s (%d):", name, id);
    }
}
