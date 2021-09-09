/**
 * 
 */
package datastorage;

import datastorage.information.ConvertingToJsonb;
import datastorage.information.fromjsonb.ConvertingFromJsonb;

/**
 * @author Isabel
 *
 */
public class SavingProperties {

	/**
	 * This method deals with starting a new game, all necessary information of the game will be set in this method.
	 */
	public void CreateNewGame() {
		StartNewGame sng = new StartNewGame();
		sng.getGameInformation();
		
		
		// alle Informationen f�r den Spielstart gesammelt aufrufen
		// Levelauswahl
		// Game
		// Poitionen der Ojekte
		// Tank
		// Silof�llstand
	}
	
	/**
	 * This method deals with saving the Game status.
	 */
	public void SavingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		ctj.SetSavingInformation();
	}
	
	/**
	 * This method deals with reloading the Game status.
	 */
	public void ReloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		cfj.GetSavingInformation();
	}
}
