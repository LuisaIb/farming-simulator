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
			System.out.println("You have chosen level 1.");
			
		} else if(level == 2){
			level = 2;
			System.out.println("You have chosen level 2.");
			
		} else if(level == 3){
			level = 3;
			System.out.println("You have chosen level 3.");
		
		} else {
			System.out.println("something went wrong"); // eventuell throw Exception
		}
	}
	
	
}
