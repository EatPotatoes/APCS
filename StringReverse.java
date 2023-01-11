import java.util.StringTokenizer;

public class StringReverse 
{
	public static void main(String[] args) 
	{
		reverse("hello there");
		System.out.println();
		reverseOrder("hi my name is bob");
	}
	
	public static String reverse(String s)
	{
		if(s.length() < 1)
			return "";
		else
		{
			System.out.print(s.charAt(s.length() - 1));
			return reverse(s.substring(0, s.length() - 1));
		}
		
	}
	
	public static String reverseOrder(String s)
	{
		StringTokenizer st = new StringTokenizer(s);
		if(!st.hasMoreTokens())
		{
			return "";
		}
		else
		{
			String token = null;
			while(st.hasMoreTokens())
			{
				token = st.nextToken();
			}
			System.out.print(token + " ");
			return reverseOrder(s.replaceAll(token, ""));
		}
	}

}
