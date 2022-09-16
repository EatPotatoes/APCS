import java.text.DecimalFormat;

//********************************************************************
//  Rational.java       Author: Lewis/Loftus/Cocking
//
//  Represents one rational number with a numerator and denominator.
//********************************************************************

public class Rational implements Comparable
{
   private int numerator, denominator;
   private DecimalFormat df = new DecimalFormat("#.0000")	;

   /**
    * Initializes the numerator and denominator
    * @param numer
    * @param denom
    */
   //-----------------------------------------------------------------
   //  Sets up the rational number by ensuring a nonzero denominator
   //  and making only the numerator signed.
   //-----------------------------------------------------------------
   public Rational (int numer, int denom)
   {
      if (denom == 0)
         denom = 1;

      // Make the numerator "store" the sign
      if (denom < 0)
      {
         numer = numer * -1;
         denom = denom * -1;
      }

      numerator = numer;
      denominator = denom;

      reduce();
   }

   
   /**
    * gets the numerator of the rational number
    * @return the numerator
    */
   //-----------------------------------------------------------------
   //  Returns the numerator of this rational number.
   //-----------------------------------------------------------------
   public int getNumerator ()
   {
      return numerator;
   }

   /**
    * gets the denominator of the rational number
    * @return the denominator
    */
   //-----------------------------------------------------------------
   //  Returns the denominator of this rational number.
   //-----------------------------------------------------------------
   public int getDenominator ()
   {
      return denominator;
   }

   
   /**
    * returns the reciprocal of the rational number
    * @return the reciprocal
    */
   //-----------------------------------------------------------------
   //  Returns the reciprocal of this rational number.
   //-----------------------------------------------------------------
   public Rational reciprocal ()
   {
      return new Rational (denominator, numerator);
   }

   
   /**
    * adds two rational numbers together
    * @param op2 the rational number to be added to the original
    * @return the sum of the rational numbers
    */
   //-----------------------------------------------------------------
   //  Adds this rational number to the one passed as a parameter.
   //  A common denominator is found by multiplying the individual
   //  denominators.
   //-----------------------------------------------------------------
   public Rational add (Rational op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int sum = numerator1 + numerator2;

      return new Rational (sum, commonDenominator);
   }

   /**
    * returns the difference of the rational numbers
    * @param op2 the rational number to be subtracted
    * @return the difference
    */
   //-----------------------------------------------------------------
   //  Subtracts the rational number passed as a parameter from this
   //  rational number.
   //-----------------------------------------------------------------
   public Rational subtract (Rational op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int difference = numerator1 - numerator2;

      return new Rational (difference, commonDenominator);
   }

   /**
    * returns the product of the rational numbers
    * @param op2 the number to be multiplied 
    * @return the product
    */
   //-----------------------------------------------------------------
   //  Multiplies this rational number by the one passed as a
   //  parameter.
   //-----------------------------------------------------------------
   public Rational multiply (Rational op2)
   {
      int numer = numerator * op2.getNumerator();
      int denom = denominator * op2.getDenominator();

      return new Rational (numer, denom);
   }

   
   /**
    * returns the quotient of the rational numbers
    * @param op2 the number to be divided
    * @return the quotient
    */
   //-----------------------------------------------------------------
   //  Divides this rational number by the one passed as a parameter
   //  by multiplying by the reciprocal of the second rational.
   //-----------------------------------------------------------------
   public Rational divide (Rational op2)
   {
      return multiply (op2.reciprocal());
   }

   /**
    * returns true if the rational numbers are equal
    * @param op2 the rational number to compare
    * @return true or false depending on equality
    */
   //-----------------------------------------------------------------
   //  Determines if this rational number is equal to the one passed
   //  as a parameter.  Assumes they are both reduced.
   //-----------------------------------------------------------------
   public boolean equals (Rational op2)
   {
      return ( numerator == op2.getNumerator() &&
               denominator == op2.getDenominator() );
   }


   /**
    * returns the difference using tolerance value of 0.0001
    * @param otherF the rational number to be compared
    * @return the difference cut off at 4 decimals
    */
   public double compareTo (Comparable otherF)
   {
	   Rational other = (Rational) otherF;
	   
	   double r1 = (double) this.getNumerator() / this.getDenominator() ;
	   double r2 = (double) other.getNumerator() / other.getDenominator() ;
	   
	   String fraction1 = df.format(r1);
	   String fraction2 = df.format(r2);
	   
	   r1 = Double.parseDouble(fraction1);
	   r2 = Double.parseDouble(fraction2);
	      
	   return r1 - r2;
   }
   
   //-----------------------------------------------------------------
   //  Returns this rational number as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result;

      if (numerator == 0)
         result = "0";
      else
         if (denominator == 1)
            result = numerator + "";
         else
            result = numerator + "/" + denominator;
    
      return result;
   }

   /**
    * reduces the rational number
    */
   //-----------------------------------------------------------------
   //  Reduces this rational number by dividing both the numerator
   //  and the denominator by their greatest common divisor.
   //-----------------------------------------------------------------
   private void reduce ()
   {
      if (numerator != 0)
      {
         int common = gcd (Math.abs(numerator), denominator);

         numerator = numerator / common;
         denominator = denominator / common;
      }
   }

   /**
    * returns the greatest common denominator of two numbers
    * @param num1 the first number
    * @param num2 the second number
    * @return the greatest common denominator
    */
   //-----------------------------------------------------------------
   //  Computes and returns the greatest common divisor of the two
   //  positive parameters. Uses Euclid's algorithm.
   //-----------------------------------------------------------------
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
         if (num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;

      return num1;
   }
}
