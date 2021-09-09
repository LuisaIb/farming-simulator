package gameboard.objects;

/**
 * This class implements the methods, that are needed for a DumpTruck.
 * 
 * @author Hanna
 */
public class DumpTruck extends WorkingDevice {
	
	private final int GRAIN_TANK_CAPACITY = 120;
	private int grainFillLevel;
	// private int id = 2 -> for attachement on tractor
	
	/**
	 * the constructor sets the harvest fill level of the Dump Truck
	 * @param grainFillLevel
	 */
	public DumpTruck(int x, int y, boolean selected, int grainFillLevel) {
		super(x, y, selected);
		this.grainFillLevel = grainFillLevel;
	}
	
	/**
	 * This constructor will be used for starting a new game.
	 */
	public DumpTruck() {
		super(18, 7, false);
		grainFillLevel = 0;
	}
	
	/**
	 * this method loads the Dump Truck with harvest
	 */
	public void load() {
		if(grainFillLevel < GRAIN_TANK_CAPACITY) {
			grainFillLevel++;
		} 
		else if(grainFillLevel == GRAIN_TANK_CAPACITY) {
			System.out.println("The Dump Truck must be unloaded!");
		}
	}
	
	/**
	 * this method unloads the harvest in the Dump Truck into the Silo or the Land Trade
	 */
	public void unload() {
		grainFillLevel = 0;
	}

	public int getFillLevel() {
		return grainFillLevel;
	}
}
