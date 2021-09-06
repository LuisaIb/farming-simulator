/**
 * 
 */
package simulator;

/**
 * @author Isabel
 * @param level
 *
 */
public class LevelOfDifficulty {
	// Enum bei den Positionen der Movemethode einsetzten UP DOWN, LEFT RIGHT...
	
	private int level;
	
	/**
	 * This constructor deals with setting a level of difficulty of the game.
	 * @param level
	 */
	public LevelOfDifficulty(int level) {
		this.level = level;
		
		if (level == 1) {
			level = 1;
			System.out.println("You have chosen level 'easy'.");
			
		} else if(level == 2){
			level = 2;
			System.out.println("You have chosen level 'medium'.");
			
		} else if(level == 3){
			level = 3;
			System.out.println("You have chosen level 'difficult'.");
		
		} else {
			System.out.println("something went wrong"); // eventuell throw Exception
		}
	}
	
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
