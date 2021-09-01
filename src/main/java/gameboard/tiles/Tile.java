package gameboard.tiles;
/**
 * This class represents the basic structure of a tile 
 * with its several properties.
 * 
 * @author Luisaibele
 *
 */
public class Tile {
	
	private final int id; // id for recognizing each kind of tile in the field
	
	/**
	 * the constructor is there to set the id
	 * 
	 * @param id
	 */
	public Tile(int id) {
		this.id = id; 
	}
	
	/**
	 * this method is supposed to get the id of each tile
	 * @return
	 */
	public int getId() {
		return id;
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
