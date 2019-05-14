package zfaria.avajlauncher.vehicles;

public class NonExistantVehicleException extends Exception
{
	public NonExistantVehicleException(String vehicle)
	{
		super(vehicle + " does not exist!");
	}
}