package zfaria.avajlauncher.vehicles;

import zfaria.avajlauncher.Simulator;

public class JetPlane extends Vehicle
{
	public JetPlane(Coordinates coor, String name, int id)
	{
		super(coor, "JetPlane", name, id);
	}
	
	public void sun()
	{
		Simulator.writer.println("Ladies and gentleman, the skies are great, sit tight and enjoy the flight.");
		getCoord().changeLatitude(10);
		getCoord().changeHeight(2);
	}

	public void rain()
	{
		Simulator.writer.println("This is your pilot speaking, we may expierence a bit of turbulence, I apologize for the inconvenience.");
		getCoord().changeLatitude(5);
	}

	public void fog()
	{
		Simulator.writer.println("Low visibility is going to restrict our ability to land anytime soon, sit tight and relax.");;
		getCoord().changeLatitude(1);
	}

	public void snow()
	{
		Simulator.writer.println("It's a beautiful winter wonder outside..");
		getCoord().changeHeight(-7);
	}
}