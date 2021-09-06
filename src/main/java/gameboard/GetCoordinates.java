/**
 * 
 */
package gameboard;

import java.util.HashMap;

/**
 * 
 * @author Luisaibele
 *
 */
public class GetCoordinates {

	/* creating a hashmap for the gameboard itself with the first value (int) representing an index for each tile 
	* and the second value representing a boolean for checking if each tile is solid or not.
	*/
	private HashMap<Integer, Boolean> board = new HashMap<>();
	
	private int index; //values: 0-600 the index for each tile on the board
	
}
