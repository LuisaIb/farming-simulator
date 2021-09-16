package gameboard.tiles;

/**
 * this class represents a grass tile on the gameboard
 * @author Luisaibele
 *
 */
public class GrassTile extends Tile{

	/**
	 * Constructor of GrassTile
	 */
	public GrassTile() {
		super();
		
	}
	
	/**
	 * this method checks if the farmer can run over a grass tile
	 * and returns the equal boolean value
	 */
	@Override
	public boolean isSolid() {
		return true;
	}

}
