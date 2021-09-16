package gameboard.objects;

/**
 * this class represents the farmer (= player) of our game
 * @author Luisaibele
 *
 */
public class Farmer extends MovingObject{

	/**
	 * empty constructor of Farmer for starting the game
	 */
	public Farmer(){
		super(27, 5, true);
	}

	/**
	 * constructor of Farmer to continue working with the farmer / reloading the game
	 * @param x
	 * @param y
	 * @param selected
	 */
	public Farmer(int x, int y, boolean selected){
		super(x, y, selected);
	}
	
	
}
