package gameboard.tiles;

/**
 * this class represents a path tile on the gameboard
 * 
 * @author Luisaibele
 *
 */
public class PathTile extends Tile{

	/**
	 * Constructor of the PathTile
	 */
	public PathTile() {
		super();
		
	}
	
	/**
	 * this method checks if the farmer can run over a path tile
	 * and returns the equal boolean value
	 */
	@Override
	public boolean isSolid() {
		return true;
	}

}
