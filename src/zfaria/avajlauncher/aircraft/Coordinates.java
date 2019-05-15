package zfaria.avajlauncher.aircraft;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void addCoordinates(int longitude, int latitude, int height) {
        this.longitude += longitude;
        this.latitude += latitude;
        this.height += height;
        if (this.height < 0) this.height = 0;
        if (this.height > 100) this.height = 100;
    }

    public int dot() {
        return longitude * latitude * height;
    }
}
