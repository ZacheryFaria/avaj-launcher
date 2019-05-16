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
            Logger.getInstance().out.println(this + " Ladies and gentlemen, weather looks great, sit tight and enjoy the flight.");
            coords.addCoordinates(0, 10, 2);
        } else if (weather.equals("RAIN")) {
            Logger.getInstance().out.println(this + " Some turbulence up ahead, sorry for the inconvenience.");
            coords.addCoordinates(0, 5, 0);
        } else if (weather.equals("FOG")) {
            Logger.getInstance().out.println(this + " Low visibility is gonna force us to delay our landing by a bit.");
            coords.addCoordinates(0, 1, 0);
        } else if (weather.equals("SNOW")) {
            Logger.getInstance().out.println(this + " Getting a bit chilly....");
            coords.addCoordinates(0, 0, -7);
        }

        if (coords.getHeight() <= 0) {
            tower.unregister(this);
            Logger.getInstance().out.printf("%s landed at Long: %d Lat: %d\n", this, coords.getLongitude(), coords.getLatitude());
        }
    }

    @Override
    public String toString() {
        return String.format("JetPlane#%s (%d):", name, id);
    }
}
