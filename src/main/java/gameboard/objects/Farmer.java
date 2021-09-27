package gameboard.objects;

/**
 * this class represents the farmer (= player) of our game
 * @author Luisaibele
 *
 */
public class Farmer extends MovingObject{

	/**
	 * Constructor of Farmer for starting the game
	 */
	public Farmer(){
		super(27, 5, true);
	}

	/**
	 * Constructor with parameters.
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 */
	public Farmer(int x, int y, boolean selected){
		super(x, y, selected);
	}
	
	
}
