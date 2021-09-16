package gameboard.tiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * this class represents the Silo for the grain storage
 * @author Luisaibele
 *
 */
public class Silo extends TileWithBuilding{
	private IntegerProperty capacity = new SimpleIntegerProperty();	//represents the grain capacity of the silo
	private final int CAPACITY = 100; // just inspiration
	
	
	/**
	 * This empty constructor will be used for starting a new game.
	 */
	public Silo() {
		capacity.set(0);
	}
	
	/**
	 * Constructor of the Silo for reloading / continuing the game 
	 * @param capacity
	 */
	public Silo(int capacity) {
		this.capacity.set(capacity);
	}

	/**
	 * Getter of capacity 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity.get();
	}

	/**
	 * Setter of Capacity
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity.set(capacity);
	}

	/**
	 * method to give information about silo capacity as a string back to the user
	 * @return
	 */
	public String getCapacityAsString(){
		return "" + capacity.get();
	}

	public IntegerProperty capacity(){
		return capacity;
	}
	/*
	 * to be implemented
	 * final variable for full capacity
	 * throw exception if no capacity left
	 * capacity = 100? or more?
	 */
}
