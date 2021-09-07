package machines;

/**
 * This class implements the methods, that are needed for a DumpTruck.
 * 
 * @author Hanna
 */

public class DumpTruck extends WorkingDevice {
	
	private int capacity;
	private int fillLevel;
	
	/**
	 * the constructor sets the harvest fill level of the Dump Truck
	 * @param fillLevel 
	 */
	public DumpTruck(int fillLevel) {
		this.fillLevel = fillLevel;
		
	}
	
	/**
	 * This constructor will be used for starting a new game.
	 */
	public DumpTruck() {
		
	}
	
	/**
	 * this method loads the Dump Truck with harvest
	 */
	public void load() {
		if(fillLevel < capacity) {
			fillLevel++;	
		} 
		else if(fillLevel == capacity) {
			System.out.println("The Dump Truck must be unloaded!");
		}
	}
	
	/**
	 * this method unloads the harvest in the Dump Truck into the Silo or the Land Trade
	 */
	public void unload() {
		fillLevel = 0;
	}
	
	

	}
