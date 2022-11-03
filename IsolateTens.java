
public class IsolateTens 
{
	public IsolateTens()
	{
		
	}
	
	public static int Isolate(int x)
	{
		x = x / 10;
		x = x % 10;
		return x;
	}
}
