package gameboard.tiles;

/**
 * This class represents a tile, which is a field
 * @author Luisaibele
 *
 */
public class FieldTile extends Tile{
	private int growthState; //representing the state of growth of a field

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
	
	public int getGrowthState() {
		return growthState;
	}

	public void setGrowthState(int growthState) {
		this.growthState = growthState;
	}

}
