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
}
