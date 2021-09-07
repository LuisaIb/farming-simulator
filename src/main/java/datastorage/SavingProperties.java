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
		// alle Informationen für den Spielstart gesammelt aufrufen
		// LEvelauswahl
		//Game
		//Poitionen der Ojekte
		//Tank
		//Silofüllstand
	}
	
	/**
	 * This method deals with saving the Game status, if there are any problems with saving the game a the SavingGameException will be thrown.
	 */
	public void SavingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		ctj.SetSavingInformation();
	}
	
	/**
	 * This method deals with reloading the Game status, if there are any problems with reloading the game a the ReloadGameException will be thrown.
	 */
	public void ReloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		cfj.GetSavingInformation();
	}
}
