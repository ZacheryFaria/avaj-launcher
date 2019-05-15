package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.aircraft.Coordinates;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WeatherProvider {

    private WeatherProvider() {}

    private String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};
    private static WeatherProvider provider = new WeatherProvider();

    public static WeatherProvider getProvider() {
        return provider;
    }

    /*
     * Algorithm works by first created a md5 hash 'seed' which is equal to the
     * coordinate values added together, then it is hashed and stored as a byte array.
     * The first byte value is then used to select which byte to pull from the entire array.
     * This new byte is now used to select the weather.
     */
    public String getCurrentWeather(Coordinates c) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {}
        int seed = c.getLatitude() + 1 + c.getLongitude() + c.getHeight();
        md5.update((seed + "").getBytes());
        byte b[] = md5.digest();
        seed = b[0] % b.length;
        seed = Math.abs(seed);
        seed = b[seed];
        seed = Math.abs(seed);
        return weather[seed % 4];
    }
}
