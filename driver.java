
public class driver 
{
	public static void main(String[] args) throws InvalidDocumentCodeException
	{
		String[] documents = new String[] 
		{
				"UA", "UB", "UC", "CA", "CB", "BB", "PA", "PB", "DD", "QX"
		};
		InvalidDocumentCodeException e = new InvalidDocumentCodeException("Document Designation is invalid");
		for(int i = 0; i < documents.length; i++)
		{
			//System.out.println(documents[i].substring(0, 1));
			if(!documents[i].substring(0, 1).equals("U") && !documents[i].substring(0, 1).equals("C") && !documents[i].substring(0, 1).equals("P"))
			{
				throw e;
			}
			else
			{
				System.out.println(documents[i] + " is valid.");
			}
		}
	}
}
