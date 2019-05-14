package zfaria.avajlauncher.vehicles;

import zfaria.avajlauncher.Simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Vehicle
{
	private Coordinates coord;
	private String type;
	private String name;
	private int id;

	public Vehicle(Coordinates coord, String type, String name, int id)
	{
		this.coord = coord;
		this.type = type;
		this.name = name;
		this.id = id;
	}

	public boolean isActive() {
		return coord.getHeight() > 0;
	}

	public void land()
	{
        Simulator.writer.print(this + " landing. Coordinates: ");
        Simulator.writer.printf("Long: %d Lat: %d\n", getCoord().getLongitude(), getCoord().getLatitude());
	}

	public String toString()
	{
		return String.format("%s#%s(%d)", type, name, id);
	}

	public Coordinates getCoord() {
		return coord;
	}

	public abstract void sun();
	public abstract void rain();
	public abstract void fog();
	public abstract void snow();
}