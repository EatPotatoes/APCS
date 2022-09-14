/**
 * Relay.java - a class to handle the data for a relay race.
 * 
 * The time records for each runner of the relay race are stored in
 * an array.  The contents of this array are printed to the console
 * window and (not yet implemented) the total time is also printed.
 * 
 * @author dlevine
 * @version August 31, 2006
 *
 */
public class Relay 
{

     public static void main(String[] args) 
     {
        Time[] raceLegs = new Time[3];
        raceLegs[0] = new TimeC("0:15:3");
        raceLegs[1] = new TimeC("0:1:42");
        raceLegs[2] = new TimeC("0:45:16");
        
        TimeC sum = new TimeC("0:0:0");
        sum = (TimeC) sum.add(raceLegs[0]);
        sum = (TimeC) sum.add(raceLegs[1]);
        sum = (TimeC) sum.add(raceLegs[2]);

        TimeC sum2 = new TimeC("0:0:0");
        sum2 = (TimeC) sum2.add(raceLegs[0]);
        sum2 = (TimeC) sum2.add(raceLegs[1]);
        sum2 = (TimeC) sum2.add(raceLegs[2]);
        
        System.out.println("First runner:  " + raceLegs[0].toString());
        System.out.println("Second runner: " + raceLegs[1].toString());
        System.out.println("Third runner:  " + raceLegs[2].toString());
        System.out.println("Total time: " + sum.toString());
        System.out.println("Total time (using add method): " + sum2.toString());
       
        
     }
        
}

/*
 * Do you see any references to TimeA in Time.java? If so describe where it occurs
 * 	No, I do not see any references
 * 
 * Do you see any references to Time in TimeA.java? If so describe where it occurs
 * 	There is a reference to Time at the top in the declaration where it says "implements Time"
 * 	Also, in the "add" function, there is a reference to time as a return type and as an input type
 * 
 * What output is produced?
 * 	For all three runners, it prints out "some time"
 * 
 * Look at the code in TimeA.java and explain why this output is produced
 * 	In Relay.java, it prints out the toString for TimeA, and right now the only thing in the toString
 * 	is "some time", no matter the input
 * 
 * What is the answer? (the sum)
 * 	1:2:3
 * Is this answer correct?
 * 	No
 * What happens if you change the various legs of the relay
 * 	It still results in 1:2:3
 * 
 * Does the program behave correctly? Why or why not?
 * 	The program does behave the same, because TimeB is an interface of Time, so it essentially has
 * 	the same things as Time does.
 * 
 * Now, instead change the array to hold TimeA objects even though you are creating TimeB.
 * What goes wrong? Why?
 * 	There are errors in the code, because TimeA and TimeB are different objects, even though they have
 * 	the same interface, they are too specific to be interchangable
 * 
 * Try to create a Time object as one of the types. What happens?
 * 	There are errors, because Time is not an object, just an interface used to help create the more 
 * 	specific object
 * 
 * Set TimeA to one array cell while other two stay TimeB. What happens? Why?
 * 	While the initialization of the array works, adding together the cells of the array do not, 
 * 	because the add method for TimeB does not work with TimeA, and vice versa.
 */
        