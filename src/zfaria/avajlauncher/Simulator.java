package zfaria.avajlauncher;

import zfaria.avajlauncher.aircraft.AircraftFactory;
import zfaria.avajlauncher.aircraft.Flyable;
import zfaria.avajlauncher.aircraft.NoSuchAircraftException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Not enough arguments");
            System.exit(1);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.out.printf("File %s not found\n", args[0]);
            System.exit(1);
        }

        WeatherTower tower = new WeatherTower();
        int simulationCount = 0;
        try {
            simulationCount = Integer.parseInt(scanner.nextLine());
            if (simulationCount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("# of simulations is not well formatted. Defaulting to 10..");
            simulationCount = 10;
        }

        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String tokens[] = line.split(" ");
                if (tokens.length != 5) throw new FileFormatException(line);
                int lon = Integer.parseInt(tokens[2]);
                int lat = Integer.parseInt(tokens[3]);
                int hei = Integer.parseInt(tokens[4]);
                Flyable f = AircraftFactory.newAircraft(tokens[0], tokens[1], lon, lat, hei);
                tower.register(f);
                f.registerTower(tower);
            }
        } catch (FileFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NoSuchAircraftException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("File is not formatted properly");
            System.exit(1);
        } finally {
            scanner.close();
        }

        for (int i = 0; i < simulationCount; i++) {
            tower.changeWeather();
        }
        Logger.getInstance().finish();
        if (args.length == 2) {
            if (args[1].equals("-echo")) {
                try {
                    scanner = new Scanner(new File("simulation.txt"));
                } catch (FileNotFoundException e) {
                    System.exit(1);
                }
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}
