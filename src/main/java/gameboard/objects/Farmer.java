package gameboard.objects;

/**
 * this class represents the farmer (= player) of our game
 * @author Luisaibele
 *
 */
public class Farmer extends MovingObject{

	public Farmer(){
		super(27, 6, true);
	}

	public Farmer(int x, int y, boolean selected){
		super(x, y, selected);
	}

}
