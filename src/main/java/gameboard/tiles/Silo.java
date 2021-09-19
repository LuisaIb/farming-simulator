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
	 * Empty constructor of Silo for loading the game.
	 */
	public Silo(){

	}


	/**
	 * Empty constructor of Silo for starting a new game.
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

	/**
	 * Getter for fillLevel 
	 * @return
	 */
	public IntegerProperty capacity(){
		return fillLevel;
	}

	/**
	 * Getter for capacity
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Setter for capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
