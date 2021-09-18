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
	 * empty Constructor of SeedDrill for starting the game
	 */
	public SeedDrill(){
		super(18, 7, false);
	}

	/**
	 * Constructor of SeedDrill for reloading / continuing the game
	 * @param x
	 * @param y
	 * @param selected
	 */
	public SeedDrill(int x, int y, boolean selected){
		super(x, y, selected);
	}

	/**
	 * this method is there to seed a field or to set it to growth stage 0
	 */
	public int seedGrain(int growthState){
		if(growthState == 1) {
			growthState++;
		} else {
			
		}
		return growthState;
	}

}
