package gameboard.tiles;

/**
 * this class represents the Silo for storage of the grain
 * @author Luisaibele
 *
 */
public class Silo extends TileWithBuilding{
	private int capacity;
	
	/**
	 * constructor for the Silo
	 * @param id
	 */
	public Silo(int id) {
		super(id);
	}
	
	/**
	 * This constructor will be used for reloading the game.
	 */
	public Silo() {
		
	}

}
