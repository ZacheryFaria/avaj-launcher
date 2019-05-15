package zfaria.avajlauncher.aircraft;

public class NoSuchAircraftException extends Exception {
    public NoSuchAircraftException(String type) {
        super(type + " is not a valid aircraft.");
    }
}
