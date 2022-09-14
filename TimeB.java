/**
 * TimeA - a class to store records of race times that run 
 * in units measured in hours/minutes/seconds.
 * 
 * @author dlevine
 * @version August 31, 2006
 *
 */
public class TimeB implements Time
{
    
    //private int hours;
    //private int minutes;
    private int seconds;
    
    /**
     * Simple constructor assumes data is in proper format
     * @param h number of hours
     * @param m number of minutes
     * @param s number of seconds
     */
    
    /*
    public TimeB(int h, int m, int s) 
    {
        hours = h;
        minutes = m;
        seconds = s;
    }
    */
    
    /**
     * Constructor that assumes a total number of seconds
     * @param total the total number of seconds taken
     */   
    public TimeB(int total) 
    {
        seconds = total;
    }
    
    /**
     * Constructor that assumes a properly formatted time String
     * @param time the time as a string
     */
    /*
    public TimeB(String time) 
    {
        String[] data = time.split(":");
        hours = Integer.parseInt(data[0]);
        minutes = Integer.parseInt(data[1]);
        seconds = Integer.parseInt(data[2]);
    }
    */
    /**
     * Adds the given time to the current time, producing the sum
     * @param other the given time to add
     * @return the sum of this time and the other time
     */
    public Time add (Time other) 
    {
    	TimeB otherTime = (TimeB) other;
    	
    	int totalH = this.getHours() + otherTime.getHours();
    	int totalM = this.getMinutes() + otherTime.getMinutes();
    	int totalS = this.getSeconds() + otherTime.getSeconds();
    	return new TimeB((totalH * 3600) + (totalM * 60) + totalS);
    }
    
    public int getHours()
    {
    	int hours = seconds / 3600;
    	return hours;
    }
    
    public int getMinutes()
    {
    	int minutes = (seconds / 60) % 60;
    	return minutes;
    }
    
    public int getSeconds()
    {
    	return seconds % 60;
    }
    
    /**
     * Return a String representation of this time
     * @return this time represented as a String in hh:mm:ss format
     */
    public String toString() 
    {
         return (seconds / 3600) + ":" + ((seconds / 60) % 60) + ":" + (seconds % 60);
    } 
}
