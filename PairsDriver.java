import java.util.Scanner;

public class PairsDriver 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double n1; double n2;
		
		System.out.println("Enter number 1: ");
		n1 = scan.nextDouble();
		System.out.println("Enter number 2: ");
		n2 = scan.nextDouble();
		
		Pairs pair1 = new Pairs(n1, n2);
		System.out.println("Sum: " + pair1.getSum());
		System.out.println("Difference: " + pair1.getDifference());
		System.out.println("Product: " + pair1.getProduct());
		System.out.println("Average: " + pair1.getAverage());
		System.out.println("Distance: " + pair1.getDistance());
		System.out.println("Maximum: " + pair1.getMax());
		System.out.println("Minimum: " + pair1.getMin());



	}

}
