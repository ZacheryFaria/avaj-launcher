package zfaria.avajlauncher.vehicles;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return longitude;
	}

	public int getLatitude()
	{
		return latitude;
	}

	public int getHeight()
	{
		return height;
	}

	public int changeLongitude(int val)
	{
		longitude += val;
		return longitude;
	}

	public int changeLatitude(int val)
	{
		latitude += val;
		return latitude;
	}

	public int changeHeight(int val)
	{
		height += val;
		if (height > 100)
			height = 100;
		if (height < 0)
			height = 0;
		return (height);
	}
}