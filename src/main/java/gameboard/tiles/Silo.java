package gameboard.tiles;

/**
 * this class represents the Silo for storage of the grain
 * @author Luisaibele
 *
 */
public class Silo extends TileWithBuilding{
	private int capacity; //represents the grain capacity of the silo
	
	/**
	 * constructor for the Silo
	 * @param id
	 */
	public Silo(int id) {
		super(id);
	}
	
	/**
	 * This empty constructor will be used for reloading the game.
	 */
	public Silo() {
		
	}

	/*
	 * to be implemented
	 * final variable for full capacity
	 * throw exception if no capacity left
	 * capacity = 100? or more?
	 */
}
