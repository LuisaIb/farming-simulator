package gameboard;

/**
 * This class represents the level of difficulty, in which the player plays the game.
 * @author Isabel
 */
public class LevelOfDifficulty {
	/**
	 * integer that holds the level of difficulty
	 * 1 = easy
	 * 2 = medium
	 * 3 = hard
	 */
	private int level;
	
	/**
	 * This constructor deals with setting a level of difficulty of the game.
	 * It will be used for reloading and starting the game.
	 * @param level the value that is set as level of difficulty
	 */
	public LevelOfDifficulty(int level) {
		this.level = level;
	}
	
	/**
	 * This default constructor is needed for the saving and loading process.
	 */
	public LevelOfDifficulty() {
		
	}

	/**
	 * This method gets the level of difficulty.
	 * @return the level of difficulty
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
}
