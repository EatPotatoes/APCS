import java.util.Scanner;

public class driver 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first numerator: ");
		String num1 = scan.next();
		System.out.println("Enter first denominator: ");
		String den1 = scan.next();
		
		System.out.println("Enter second numerator: ");
		String num2 = scan.next();
		System.out.println("Enter second denominator: ");
		String den2 = scan.next();
		int top1 = Integer.parseInt(num1);
		int bot1 = Integer.parseInt(den1);
		int top2 = Integer.parseInt(num2);
		int bot2 = Integer.parseInt(den2);
		
		
		Rational fraction1 = new Rational(top1, bot1);
		Rational fraction2 = new Rational(top2, bot2);
		
		double check = fraction1.compareTo(fraction2);
		
		System.out.println("The difference between the two are: " + check);
	}
}
