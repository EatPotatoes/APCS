//********************************************************************
//  Coin.java       Author: Lewis/Loftus/Cocking
//
//  Represents a coin with two sides that can be flipped.
//********************************************************************

import java.util.Random;

public class Coin implements Lockable
{
   private final int HEADS = 0;
   private final int TAILS = 1;

   private int face;
   
   private boolean status = false;
   private int key = 0;

   //-----------------------------------------------------------------
   //  Sets up the coin by flipping it initially.
   //-----------------------------------------------------------------
   public Coin ()
   {
      if (!status)
    	  flip();
      else
    	  System.out.println("Object is locked");
   }

   //-----------------------------------------------------------------
   //  Flips the coin by randomly choosing a face value.
   //-----------------------------------------------------------------
   public void flip ()
   {
      if (!status)
    	  face = (int) (Math.random() * 2);
      else
    	  System.out.println("Cannot use \'flip\' because object is locked");
   }

   //-----------------------------------------------------------------
   //  Returns true if the current face of the coin is heads.
   //-----------------------------------------------------------------
   public boolean isHeads ()
   {
      return (face == HEADS);
   }
   
   /**
	 * Sets the key
	 * @param k the key
	 */
   public void setKey(int k)
   {
	   if (!status)
	   {
		   key = k;
		   System.out.println("Key set successfully");
	   }
	   else
		   System.out.println("Cannot use /'setKey/' because the object is locked.");
   }
	
   /**
	 * Locks the object if key is correct
	 * @param k the key to be checked
	 */
   public void lock(int k)
   {
	   if(k == key)
	   {
		   status = true;
		   System.out.println("Object locked successfully");
	   }
	   else
		   System.out.println("Cannot use \'lock\' because key is incorrect");
   }
	
   /**
	 * Unlocks the object if the key is correct
	 * @param k the key to be checked
	 */
   public void unlock(int k)
   {
	   if(k == key)
	   {
		   status = false;
		   System.out.println("Object unlocked successfully");
	   }
	   else
		   System.out.println("Cannot use \'unlock\' because key is incorrect");
   }
	
   /**
	 * Checks the status of the object
	 * @return true for locked, false for unlocked
	 */
   public boolean locked()
   {
	   return status;
   }

   //-----------------------------------------------------------------
   //  Returns the current face of the coin as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      if (!status)
      {
		  String faceName;
	      if (face == HEADS)
	         faceName = "Heads";
	      else
	         faceName = "Tails";
	
	      return faceName;
      }
      else
    	  return ("Cannot use \'toString\' because the object is locked");
   }
}
