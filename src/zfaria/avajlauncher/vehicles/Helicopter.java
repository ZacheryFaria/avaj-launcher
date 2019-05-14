package zfaria.avajlauncher.vehicles;

import zfaria.avajlauncher.Simulator;

public class Helicopter extends Vehicle
{
	public Helicopter(Coordinates coor, String name, int id)
	{
		super(coor, "Helicopter", name, id);
	}

	public void sun()
	{
		Simulator.writer.println("Looks like a beautiful day to go sightseeing!");
		getCoord().changeLongitude(10);
		getCoord().changeHeight(2);
	}

	public void rain()
	{
		Simulator.writer.println("Hurry and close the door! It's gonna get wet!");
		getCoord().changeLongitude(5);
	}

	public void fog()
	{
		Simulator.writer.println("We are gonna have go slowly... it's hard to see");
		getCoord().changeLongitude(1);
	}

	public void snow()
	{
		Simulator.writer.println("The rotors are frozen! This isn't looking too good...");
		getCoord().changeHeight(-15);
	}	
}