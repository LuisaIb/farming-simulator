package gameboard.tiles;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the basic structure of a tile 
 * with its several properties.
 * 
 * @author Luisaibele
 *
 */
public class Tile {
	
	/**
	 * Empty Constructor of Tile
	 * 
	 */
	public Tile() {
		
	}

	// list for not passable points on the game board:
	private final ArrayList<Integer> places = new ArrayList<>(Arrays.asList(7, 25, 37, 42, 43, 44, 45, 46, 47, 48, 55, 67, 72, 78, 85, 90, 102, 108, 115,
			120, 121, 122, 123, 124, 125, 126, 127, 133, 134, 135, 136, 137, 138, 145, 146, 147, 148, 149, 180, 181,
			182, 183, 184, 185, 186, 187, 194, 195, 196, 197, 198, 217, 224, 228, 247, 251, 252, 253, 254, 258, 277,
			280, 288, 307, 310, 318, 337, 341, 348, 367, 371, 372, 373, 374, 375, 376, 377, 378, 397, 427, 457, 487,
			517, 547, 577));

	/**
	 * Getter for the list of not passable tiles.
	 *
	 * @return the requested list
	 */
	public ArrayList<Integer> getPlaces() {
		return places;
	}

	/**
	 * this method is supposed to check if the farmer can run over 
	 * a specific tile or not.
	 * 
	 * @return a boolean variable to show if it's possible or not to run over the field
	 */
	public boolean isSolid() {
		return false; 
	}

}
