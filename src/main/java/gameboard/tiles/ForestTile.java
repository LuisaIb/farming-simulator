package gameboard.tiles;

/**
 * this class represents a forest tile with its properties
 * @author Luisaibele
 *
 */
public class ForestTile extends Tile{

	/**
	 * Constructor of ForestTile
	 */
	public ForestTile() {
		super();
		
	}
	
	/**
	 * this method returns that the farmer can't run over a forest tile 
	 */
	@Override
	public boolean isSolid() {
		return false;
	}

}
