package gameboard.tiles;

/**
 * this class represents a tile with a building on it on the gameboard
 * @author Luisaibele
 *
 */
public class TileWithBuilding extends Tile{

	/**
	 * the constructor sets the id of each tile with a building
	 * @param id
	 */
	public TileWithBuilding(int id) {
		super(id);
		
	}
	
	public TileWithBuilding() {
		
	}
	
	/**
	 * this method checks if the farmer can run over a tile with a building on it 
	 * and returns the equal boolean value
	 */
	@Override
	public boolean isSolid() {
		return false;
	}
	

}
