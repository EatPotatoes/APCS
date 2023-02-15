import java.util.Scanner;

public class StringTooLongException
{
	public static void main(String[] args) throws LengthException
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter strings to be checked: ");
		System.out.println("Enter DONE to stop");
		
		String s = scan.next();
		
		
		while(!s.equals("DONE"))
		{
			LengthException e = new LengthException("The string " + s + " is too long.");
			try
			{
				if(s.length() > 20)
				{
					throw e;
				}
			}
			catch(LengthException ex)
			{
				System.out.println("The string " + s + " is too long.");
			}
			finally
			{
				s = scan.next();
			}
		}
		System.out.println("End of program");
	}

}
