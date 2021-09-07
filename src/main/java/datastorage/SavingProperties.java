/**
 * 
 */
package datastorage;

import datastorage.information.ConvertingToJsonb;
import datastorage.information.fromjsonb.ConvertingFromJsonb;
import exceptions.datastorage.ReloadGameException;
import exceptions.datastorage.SavingGameException;

/**
 * @author Isabel
 *
 */
public class SavingProperties {

	/**
	 * This method deals with starting a new game, all necessary information of the game will be set in this method.
	 */
	public void CreateNewGame() {
		NewGame ng = new NewGame();
		ng.getGameInformation();
		
		
		// alle Informationen für den Spielstart gesammelt aufrufen
		// Levelauswahl
		// Game
		// Poitionen der Ojekte
		// Tank
		// Silofüllstand
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
