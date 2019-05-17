package zfaria.avajlauncher.aircraft;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int lon, int lat, int hei) throws NoSuchAircraftException{
        if (type.equals("JetPlane"))
            return new JetPlane(name, new Coordinates(lon, lat, hei));
        else if (type.equals("Baloon"))
            return new Baloon(name, new Coordinates(lon, lat, hei));
        else if (type.equals("Helicopter"))
            return new Helicopter(name, new Coordinates(lon, lat, hei));
        else if (type.equals("Glider"))
            return new Glider(name, new Coordinates(lon, lat, hei));
        else
            throw new NoSuchAircraftException(type);
    }
}
