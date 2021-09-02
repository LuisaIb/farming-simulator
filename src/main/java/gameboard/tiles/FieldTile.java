package gameboard.tiles;

/**
 * This class represents a tile, which is a field with its several properties
 * @author Luisaibele
 *
 */
public class FieldTile extends Tile{
	private int growthState; //representing the state of growth of the first field
	private int growthState2; //representing the state of growth of the second field
	private int growthState3; //representing the state of growth of the third field

	/**
	 * @param id
	 * @param growthState
	 */
	public FieldTile(int id, int growthState, int growthState2, int growthState3 ) {
		super(id);
		this.growthState = growthState;
		this.growthState2 = growthState2;
		this.growthState3 = growthState3;
	}
	
	public FieldTile() {
		
	}
		
	/**
	 * this method is supposed to check whether the farmer can run over 
	 * a field tile or not
	 * @return the checked boolean value
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
	public int getGrowthState2() {
		return growthState2;
	}

	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
	}

	public int getGrowthState3() {
		return growthState3;
	}

	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
	}

}
