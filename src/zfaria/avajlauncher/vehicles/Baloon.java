package zfaria.avajlauncher.vehicles;

import zfaria.avajlauncher.Simulator;

public class Baloon extends Vehicle
{
	public Baloon(Coordinates coor, String name, int id)
	{
		super(coor, "Baloon", name, id);
	}

	public void sun()
	{
	    Simulator.writer.println("it's looking like a great day for pictures!");
	    getCoord().changeLongitude(2);
	    getCoord().changeHeight(4);
	}

	public void rain()
    {
        Simulator.writer.println("aww man my baloon is wet!");
        getCoord().changeHeight(-5);
	}

	public void fog()
	{
        Simulator.writer.println("I can't see anything! I'm scared :(");
        getCoord().changeHeight(-3);
	}

	public void snow()
	{
        Simulator.writer.println("Iiiiiiitsss.... sooooo c-c-c-old");
        getCoord().changeHeight(-15);
	}
}