package zfaria.avajlauncher;

import zfaria.avajlauncher.vehicles.Coordinates;
import zfaria.avajlauncher.vehicles.Vehicle;
import zfaria.avajlauncher.vehicles.VehicleFactory;
import zfaria.avajlauncher.vehicles.NonExistantVehicleException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Simulator {
    public static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter(new File("simulation.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot create simulation file.");
        }
    }

	public static void main(String args[]) {
		if (args.length == 0) {
            System.out.println("Not enough arguments.");
            System.exit(1);
        }
		Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(new File(args[0])));
        } catch (FileNotFoundException e) {
            System.out.println("No such file. " + args[0]);
            System.exit(1);
        }
        Tower t = null;
        VehicleFactory factory = new VehicleFactory();
        try {
            int i = Integer.parseInt(scanner.nextLine());
            if (i <= 0) throw new IndexOutOfBoundsException("Simulation count too low: " + i);
            t = new Tower(i);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String s[] = line.split(" ");
                if (s.length != 5) throw new FileFormatException("Invalid token amount: " + s.length);
                Coordinates c = new Coordinates(Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]));
                Vehicle v = factory.getVehicle(s[0], s[1], c);
                t.registerVehicle(v);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (FileFormatException e) {
            System.out.println(e.getMessage());
        } catch (NonExistantVehicleException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        t.runSimulation();
        writer.flush();
        writer.close();
    }
}