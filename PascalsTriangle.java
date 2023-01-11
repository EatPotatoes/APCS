
public class PascalsTriangle 
{
	public static void main(String[] args) 
	{
		int x = 8;
		pascal(x);
		for(int i = 0; i < x ; i++)
		{
			System.out.print(pascal(x + 1)[i] + " ");
		}
	}
	
	public static int[] pascal(int k)
	{
	    int[] pt = new int[k];
	    if (k == 1) 
	    {
	        pt[0] = 1; 
	        return pt;
	    } 
	    else 
	    {
	        int[] ppt = pascal(k - 1);
	        pt[0] = pt[k - 1] = 1;
	        for (int i = 1; i < ppt.length; i++) 
	        {
	        	pt[i] = ppt[i - 1] + ppt[i];
	        }
	    }
	    return pt;
	}
}
