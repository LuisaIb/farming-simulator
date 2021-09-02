package gameboard.tiles;

/**
 * This class represents a tile, which is a field
 * @author Luisaibele
 *
 */
public class FieldTile extends Tile{

	public FieldTile(int id) {
		super(id);
	}
		
	/**
	 * this method returns a boolean to check wether the field Tile
	 * is solid or not
	 * @return the checked boolean variable
	 */
	public boolean isSolid() {
		return true;
	}

}
