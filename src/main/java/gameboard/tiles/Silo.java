package gameboard.tiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class represents the Silo for the grain storage
 * @author Luisaibele, Judith
 *
 */
public class Silo {
	/**
	 * IntegerProperty for the amount of grain that is in the silo to make a binding for automatic change possible
	 */
	private IntegerProperty fillLevel = new SimpleIntegerProperty();
	/**
	 * the maximum amount of grain that can be filled into the silo
	 */
	private int capacity;

	/**
	 * Default constructor of Silo for loading the game.
	 */
	public Silo(){

	}

	/**
	 * Constructor of Silo for starting a new game. It sets the capacity depending on the level of difficulty the player
	 * has chosen.
	 * @param lod the level of difficulty the player has chosen
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
	 * Getter of the fill level of the silo.
	 * @return the requested fill level of the silo
	 */
	public int getFillLevel() {
		return fillLevel.get();
	}

	/**
	 * Setter for the fill level of the silo.
	 * @param fillLevel the value that is set as fill level
	 */
	public void setFillLevel(int fillLevel) {
		this.fillLevel.set(fillLevel);
	}

	/**
	 * This method is needed for the text field of the informationBox as the value of the fill level is needed in a String.
	 *
	 * @return a String with the value of fill level
	 */
	public String getFillLevelAsString(){
		return "" + fillLevel.get();
	}

	/**
	 * Method to get the IntegerProperty fillLevel.
	 *
	 * @return the requested IntegerProperty fillLevel
	 */
	public IntegerProperty capacity(){
		return fillLevel;
	}

	/**
	 * Getter for capacity.
	 *
	 * @return the requested capacity of the silo
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Setter for capacity.
	 * @param capacity the value that is set as capacity of the silo
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
