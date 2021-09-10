package gameboard.tiles;

/**
 * this class represents the Silo for storage of the grain
 * @author Luisaibele
 *
 */
public class Silo extends TileWithBuilding{
	private int capacity; //represents the grain capacity of the silo
	private final int CAPACITY = 100; // just inspiration
	
	
	/**
	 * This empty constructor will be used for reloading the game.
	 */
	public Silo() {
		capacity = 0;
	}
	
	public Silo(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/*
	 * to be implemented
	 * final variable for full capacity
	 * throw exception if no capacity left
	 * capacity = 100? or more?
	 */
}
