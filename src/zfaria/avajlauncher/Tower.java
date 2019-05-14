package zfaria.avajlauncher;

import zfaria.avajlauncher.vehicles.Coordinates;
import zfaria.avajlauncher.vehicles.Vehicle;
import zfaria.avajlauncher.weather.WeatherEvent;
import zfaria.avajlauncher.weather.WeatherProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Vehicle> vehicleList;
    private PrintWriter out;
    private int simCount;

    public Tower(int simCount) {
        vehicleList = new ArrayList<Vehicle>();
        try {
            out = new PrintWriter(new File("simulation.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        this.simCount = simCount;
    }

    public void registerVehicle(Vehicle v) {
        Simulator.writer.println("Tower says: " + v + " registered to tower.");
        vehicleList.add(v);
    }

    public void updateVehicles() {
        for (Vehicle vehicle : vehicleList) {
            WeatherEvent event = WeatherProvider.getWeatherEvent(vehicle.getCoord());
            Simulator.writer.print(vehicle + ": ");
            event.trigger(vehicle);
        }
        for (int i = vehicleList.size() - 1; i > 0; i--) {
            if (!vehicleList.get(i).isActive())
                unregisterVehicle(vehicleList.get(i));
        }
    }

    public void unregisterVehicle(Vehicle v) {
        v.land();
        Simulator.writer.println(v + " unregistered from tower.");
        vehicleList.remove(v);
    }

    public void runSimulation() {
        for (int i = 0; i < simCount; i++) {
            updateVehicles();
        }
    }
}
