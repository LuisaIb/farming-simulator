/**
 * 
 */
package simulator;

/**
 * this class represents the level of difficulty, in which the player plays the game
 * @author Isabel
 * @param level
 *
 */
public class LevelOfDifficulty {
	private int level;
	
	/**
	 * This constructor deals with setting a level of difficulty of the game.
	 * It will be used for reloading and starting the game.
	 * @param level
	 */
	public LevelOfDifficulty(int level) {
		this.level = level;
	}
	
	/**
	 * This constructor deals with setting a level of difficulty of the game.
	 */
	public LevelOfDifficulty() {
		
	}

	/**
	 * This method gets the level of difficulty.
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 *This method sets the level of difficulty.
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * This method is needed for serializing this class into JSONB.
	 */
	@Override
	public String toString() {
		return "LevelOfDifficulty [level=" + level + "]";
	}
		
}
