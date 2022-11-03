/**
 * Implements a Vignere cipher
 * @author 23azhang
 *
 */
public class Vigenere 
{
	private char[][] arr = new char[26][26];
	private String key;
	private String plainText;
	private String cipherText;
	
	/**
	 * Initializes the square vignere cipher, the key, and the plaintext.
	 * @param pt the plain text entered by the user
	 * @param k the key entered by the user
	 */
	public Vigenere(String pt, String k)
	{
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String first = "";
		
		for( int x = 0; x < 26; x++)
		{
			for(int y = 0; y < 26; y++)
			{
				arr[x][y] = letters.charAt(y);  //use y because it will go through the string
			}
			first = letters.charAt(0) + "";  // get the first character in the string
			letters = letters.substring(1) + first;	
		}
		
		plainText = pt.toUpperCase();
		key = (k + plainText.substring(0, pt.length() - k.length())).toUpperCase();
		cipherText = "";
	}
	
	/**
	 * Encrypts the plaintext using the key given in object initialization
	 * @return the ciphertext using plaintext and key given
	 */
	public String encrypt()
	{
		String cipher = new String("");
		int pos = 0;
		int column = 0;
		int row = 0;
		for (int y = 0; y < plainText.length(); y++)
		{
			for (int x = 0; x < 26; x++)
			{
				if (plainText.charAt(pos) == arr[0][x])
				{
					column = x;
				}
				if (key.charAt(pos) == arr[x][0])
				{
					row = x;
				}
			}
			cipher = cipher + arr[row][column];
			pos++;
		}
		cipherText = cipher;
		return cipher;
	}
	
	/**
	 * Decrypts ciphertext using the new given key
	 * @param encrypted the ciphertext to be decrypted
	 * @param k the key given to decrypt the ciphertext
	 * @return the recovered text
	 */
	public String decrypt(String encrypted, String k)
	{
		int pos = 0;
		int row = 0;
		int column = 0;
		encrypted = encrypted.toUpperCase();
		k = k.toUpperCase();

		String recoveredText = new String("");
		pos = 0;
		row = 0;
		column = 0;
		for (int y = 0; y < cipherText.length(); y++)
		{
			for (int x = 0; x < 26; x++)
			{
				if (k.charAt(pos) == arr[x][0])
				{
					row = x;
					for (int z = 0; z < 26; z++)
					{
						if (cipherText.charAt(pos) == arr[row][z])
						{
							column = z;
						}
					}
				}
			}
			recoveredText = recoveredText + arr[0][column];
			k = k + arr[0][column];
			pos++;
		}
		return recoveredText;
	}
	
	public String toString()
	{
		String result = "";
		result = result + "Plaintext: " + plainText;
		result = result + "\nKey: " + key;
		result = result + "\nCipherText (if already encoded): " + cipherText;
		return result;
	}
}
