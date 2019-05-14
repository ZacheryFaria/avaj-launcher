package zfaria.avajlauncher.vehicles;

public final class VehicleFactory
{
	private int id_counter = 0;

	public Vehicle getVehicle(String type, String name, Coordinates coord) throws NonExistantVehicleException
	{
		id_counter++;
		if (type.equals("JetPlane"))
		{
			return new JetPlane(coord, name, id_counter);
		}
		else if (type.equals("Baloon"))
		{
			return new Baloon(coord, name, id_counter);
		}
		else if (type.equals("Helicopter"))
		{
			return new Helicopter(coord, name, id_counter);
		}
		else
		{
			throw new NonExistantVehicleException(type);
		}
	}
}