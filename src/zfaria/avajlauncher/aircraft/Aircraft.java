package zfaria.avajlauncher.aircraft;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.WeatherTower;

public abstract class Aircraft implements Flyable {
    private static long idCounter = 0;

    protected String name;
    protected Coordinates coords;
    protected long id;

    public Aircraft(String name, Coordinates coords) {
        this.name = name;
        this.coords = coords;
        this.id = nextId();
    }

    private static long nextId() {
        idCounter++;
        return idCounter;
    }

    public boolean isActive() {
        return coords.getHeight() > 0;
    }

    public void land() {
        Logger.getInstance().out.printf("%s landed at: Long: %d Lat: %d\n", this, coords.getLongitude(), coords
        .getLatitude());
    }
}
