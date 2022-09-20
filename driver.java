
public class driver 
{

	public static void main(String[] args) 
	{
		Coin c = new Coin();
		if (!c.locked())
			System.out.println("The coin is unlocked");
		else
			System.out.println("The coin is locked");
		
		c.setKey(1984);
		System.out.println("The key is 1984");
		System.out.println("Accessing toString");
		System.out.println(c.toString());
		System.out.println("Now trying to lock the coin object with 100 and 1984");
		c.lock(100);
		c.lock(1984);
		
		System.out.println("Trying to access toString");
		System.out.println(c.toString());
		System.out.println("Trying to access flip");
		c.flip();
		
		System.out.println("Trying to unlock with 500");
		c.unlock(500);
		System.out.println("Trying to unlock with 1984");
		c.unlock(1984);
	}

}
