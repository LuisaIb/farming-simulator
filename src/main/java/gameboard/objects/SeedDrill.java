package gameboard.objects;


/**
 * This class represents the device SeedDrill.
 *
 * @author Luisaibele
 *
 */
public class SeedDrill extends WorkingDevice {
	/**
	 * Constructor of SeedDrill for starting the game
	 */
	public SeedDrill(){
		super(18, 7, false);
	}

	/**
	 * Constructor of SeedDrill for reloading / continuing the game
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 */
	public SeedDrill(int x, int y, boolean selected){
		super(x, y, selected);
	}

}
