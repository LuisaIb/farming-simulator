package gameboard.tiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * this class represents the Silo for the grain storage
 * @author Luisaibele
 *
 */
public class Silo extends TileWithBuilding{
	private IntegerProperty fillLevel = new SimpleIntegerProperty();	//represents the grain capacity of the silo
	private int capacity; // just inspiration

	/**
	 * Empty constructor for loading.
	 */
	public Silo(){

	}


	/**
	 * This empty constructor will be used for starting a new game.
	 */
	public Silo(int lod) {
		if (lod == 1) {
			capacity = 600;
		} else if (lod == 2) {
			capacity = 400;
		} else if (lod == 3) {
			capacity = 200;
		}
		fillLevel.set(0);
	}
	
	/**
	 * Constructor of the Silo for reloading / continuing the game 
	 * @param fillLevel
	 */
//	public Silo(int fillLevel) {
//		this.fillLevel.set(fillLevel);
//	}

	/**
	 * Getter of capacity 
	 * @return the capacity
	 */
	public int getFillLevel() {
		return fillLevel.get();
	}

	/**
	 * Setter of Capacity
	 * @param capacity the capacity to set
	 */
	public void setFillLevel(int capacity) {
		this.fillLevel.set(capacity);
	}

	/**
	 * method to give information about silo capacity as a string back to the user
	 * @return
	 */
	public String getFillLevelAsString(){
		return "" + fillLevel.get();
	}

	public IntegerProperty capacity(){
		return fillLevel;
	}

	public int getCapacity() {
		return capacity;
	}

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
