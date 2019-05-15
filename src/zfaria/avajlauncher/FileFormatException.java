package zfaria.avajlauncher;

public class FileFormatException extends Exception {
    public FileFormatException(String cause) {
        super(cause + " is not a valid line");
    }
}
