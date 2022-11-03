import java.util.Scanner;

public class driver 
{
	public static void main(String[] args) 
	{
		System.out.println("EXAMPLE: TEXT IS \"LIGHTSPEEDCHEWIENOW\", KEY IS \"ARGH\"");
		String key1 = new String("ARGH");
		Vigenere v1 = new Vigenere("LIGHTSPEEDCHEWIENOW", "ARGH");
		String encrypted = v1.encrypt();
		System.out.println(v1.encrypt());
		//LZMOEAVLXVRLIZKLRKE
		System.out.println(v1.decrypt(encrypted, "ARGH"));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the plaintext");
		String plainText = scan.next();
		System.out.println("Enter the key to encrypt");
		String key = scan.next();
		Vigenere v2 = new Vigenere(plainText, key);
		String encrypt2 = v2.encrypt();
		System.out.println(v2.encrypt());
		System.out.println("Enter the key to decrypt");
		String keyB = scan.next();
		System.out.println(v2.decrypt(encrypt2, keyB));
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		
		
	}
}
