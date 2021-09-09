package gameboard.tiles;

/**
 * this class represents the Court Trade of the game
 * @author Luisaibele
 *
 */
public class CourtTrade extends TileWithBuilding{
	private int grainFillLevel;
	private final int GRAIN_CAPACITY = 150;

	/**
	 * This constructor will be used for reloading the game.
	 */
	public CourtTrade() {
		
	}
	
	/**
	 * this method represents the functionality to sell grain to customers
	 */
	public void sellGrain(int grainFillLevel, int cash) {
		grainFillLevel = grainFillLevel - 50;
		cash = cash + 50;
	}
	/**
	 * Getter for the GrainFillLevel
	 * @return
	 */
	public int getGrainFillLevel() {
		return grainFillLevel;
	}

	/**
	 * Setter for the GrainFillLevel
	 * @param grainFillLevel
	 */
	public void setGrainFillLevel(int grainFillLevel) {
		this.grainFillLevel = grainFillLevel;
	}

}
