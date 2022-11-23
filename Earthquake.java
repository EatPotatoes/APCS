
public class Earthquake 
{
	private double magnitude;
	private double depth;
	private double longitude;
	private double latitude;
	private double date;
	
	public Earthquake(double[] values)
	{
		magnitude = values[4];
		depth = values[3];
		longitude = values[2];
		latitude = values[1];
		date = values[0] % 10000;
		//date = Math.floor(date / 100);
		//month
	}
	
	public double getMagnitude()
	{
		return magnitude;
	}
	
	public double getDepth()
	{
		return depth;
	}

	public double getLongitude()
	{
		return longitude;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getDate()
	{
		return date;
	}
	
	
	
	public String toString()
	{
		String result = "----\nDate: " + date + "\nLat: " + latitude + "\nLong: " + longitude + "\nDepth: " + depth + "\nMag: " + magnitude;
		return result;
	}
}
