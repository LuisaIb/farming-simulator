package gameboard.objects;

/**
 * this class represents the device Cultivator, 
 * which is supposed to wrap a field when it's ready to do so
 * @author Luisaibele
 *
 */
public class Cultivator extends WorkingDevice {

	/**
	 * Empty Constructor of Cultivator for starting a new game.
	 */
	public Cultivator(){
		super(18, 7, false);
	}

	/**
	 * Constructor of Cultivator for loading the game.
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 */
	public Cultivator(int x, int y, boolean selected){
		super(x, y, selected);
	}
	
}
