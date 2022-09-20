
public interface Lockable 
{
	/**
	 * Sets the key
	 * @param k the key
	 */
	public abstract void setKey(int k);
	
	/**
	 * Locks the object if key is correct
	 * @param k the key to be checked
	 */
	public abstract void lock(int k);
	
	/**
	 * Unlocks the object if the key is correct
	 * @param k the key to be checked
	 */
	public abstract void unlock(int k);
	
	/**
	 * Checks the status of the object
	 * @return true for locked, false for unlocked
	 */
	public abstract boolean locked();
}
