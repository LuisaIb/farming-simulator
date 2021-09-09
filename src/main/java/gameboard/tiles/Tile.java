package gameboard.tiles;
/**
 * This class represents the basic structure of a tile 
 * with its several properties.
 * 
 * @author Luisaibele
 *
 */
public class Tile {
	
	/**
	 * the constructor is there to set the id
	 * 
	 */
	public Tile() {
		
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
