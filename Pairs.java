
public class Pairs

{
	private double num1;
	private double num2;
	private double sum;
	private double difference;
	private double product;
	private double average;
	private double distance;

     /**
        Constructs a pair.

        @param aFirst the first value of the pair

        @param aSecond the second value of the pair
     */

     public Pairs( double aFirst, double aSecond )

     {
          num1 = aFirst;
          num2 = aSecond;
          sum = 0;
          difference = 0;
          product = 0;
          average = 0;
          distance = 0;
     }

      

     /**

        Computes the sum of the values of this pair.

        @return the sum of the first and second values

     */

     public double getSum()

     {
           sum = num1 + num2;
           return sum;
     }
     
     /**

     Computes the difference of the values of this pair.

     @return the difference of the first and second values

  */
     public double getDifference()
     {
    	 difference = num1 - num2;
    	 return difference;
     }
     
     /**

     Computes the product of the values of this pair.

     @return the product of the first and second values

  */
     
     public double getProduct()
     {
    	 product = num1 * num2;
    	 return product;
     }
     
     
     /**

     Computes the average of the values of this pair.

     @return the average of the first and second values

  */
     public double getAverage()
     {
    	 average = (num1 + num2) / 2;
    	 return average;
     }
     
     /**

     Computes the distance of the values of this pair.

     @return the distance of the first and second values

  */
     public double getDistance()
     {
    	 distance = Math.abs(num1 - num2);
    	 return distance;
     }
     
     
     /**

     Computes the maximum of the values of this pair.

     @return the maximum of the first and second values

  */
     public double getMax()
     {
    	 if(num1 > num2)
    		 return num1;
    	 else
    		 return num2;
     }
     
     /**

     Computes the minimum of the values of this pair.

     @return the minimum of the first and second values

  */
     public double getMin()
     {
    	 if(num1 < num2)
    		 return num1;
    	 else
    		 return num2;
     }
     
     public String toString()
     {
    	 String result = "Number 1: " + num1 + "\nNumber 2: " + num2;
    	 return result;  	 
    	 
     }

}