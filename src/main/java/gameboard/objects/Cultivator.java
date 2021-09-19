package gameboard.objects;


/**
 * this class represents the device Cultivator, 
 * which is supposed to wrap a field when it's read to do so
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
	 * @param x
	 * @param y
	 * @param selected
	 */
	public Cultivator(int x, int y, boolean selected){
		super(x, y, selected);
	}

	
}
