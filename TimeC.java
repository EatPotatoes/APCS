/**
 * TimeA - a class to store records of race times that run 
 * in units measured in hours/minutes/seconds.
 * 
 * @author dlevine
 * @version August 31, 2006
 *
 */
public class TimeC implements Time
{
    
    private String t;
    
    /**
     * Simple constructor assumes data is in proper format
     * @param h number of hours
     * @param m number of minutes
     * @param s number of seconds
     */
    /*
    public TimeC(int h, int m, int s) 
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
    
    /*
    public TimeC(int total) 
    {
        hours = total/3600;
        minutes = (total/60) % 60;
        seconds = total % 60;
    }
    */
    
    /**
     * Constructor that assumes a properly formatted time String
     * @param time the time as a string
     */
    public TimeC(String time) 
    {
        t = time;
    	//System.out.println(t);
    }

    /**
     * Adds the given time to the current time, producing the sum
     * @param other the given time to add
     * @return the sum of this time and the other time
     */
    public Time add (Time other) 
    {
    	TimeC otherTime = (TimeC) other;

    	int total = this.getSeconds() + otherTime.getSeconds() + (this.getMinutes() + otherTime.getMinutes()) * 60 + (this.getHours() + otherTime.getHours()) * 3600;
    	int totalH = total / 3600;
    	int totalM = (total / 60) % 60;
    	int totalS = total % 60;
    	return new TimeC((totalH) + ":" + totalM + ":" + totalS);
    }
    
    public int getHours()
    {
    	String[] data = t.split(":");
        int hours = Integer.parseInt(data[0]);
        
    	return hours;
    }
    
    public int getMinutes()
    {
    	String[] data = t.split(":");
        int minutes = Integer.parseInt(data[1]);

        //System.out.println(minutes);
        
    	return minutes;
    }
    
    public int getSeconds()
    {
    	String[] data = t.split(":");
        int seconds = Integer.parseInt(data[2]);
        
    	return seconds;
    }
    
    /**
     * Return a String representation of this time
     * @return this time represented as a String in hh:mm:ss format
     */
    public String toString() 
    {
         return this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds();
    } 
}
