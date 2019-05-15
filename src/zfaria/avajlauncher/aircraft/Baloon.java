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
            Logger.getInstance().out.println(this + " Looks like a beautiful day for some sightseeing!");
            coords.addCoordinates(2, 0, 4);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " Aww man! My baloon is getting wet!");
            coords.addCoordinates(0, 0, -5);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " Getting hard to see... might need to land soon.");
            coords.addCoordinates(0, 0, -3);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " The snow is gonna ruin my baloon!");
            coords.addCoordinates(0, 0, -15);
        }

        if (coords.getHeight() <= 0) {
            tower.unregister(this);
            Logger.getInstance().out.printf("%s landed at Long: %d Lat: %d\n", this, coords.getLongitude(), coords.getLatitude());
        }
    }

    public String toString() {
        return String.format("Baloon#%s (%d):", name, id);
    }
}
