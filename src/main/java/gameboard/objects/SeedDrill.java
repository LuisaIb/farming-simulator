package gameboard.objects;

/**
 * this class represents the device SeedDrill with its functionality
 * to seed a field.
 * @author Luisaibele
 *
 */
public class SeedDrill extends WorkingDevice {
	// private int id = 1; -> for attachment hashmap
	
	/**
	 * this method is there to seed a field or to set it to growth stage 0
	 */
	public int seedGrain(int growthstate) {
		if(growthstate == 0) {
		growthstate++; 
		} 
		return growthstate;
	}

}
