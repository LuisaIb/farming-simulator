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
	 * 
	 */
	public void CreateNewGame() {
		
	}
	
	/**
	 * 
	 */
	public void SavingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		try {
			ctj.SetSavingInformation();// Exception: SavingGameException einfügen
		}catch(Exception ie) {
			System.out.println("Sorry, something went wrong during saving the game...\n Please try again");
		}
	}
	
	/**
	 * 
	 */
	public void ReloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		try {
			cfj.GetSavingInformation();// Exception: ReloadGameException einfügen
		}catch(Exception ie) {
			System.out.println("Sorry, something went wrong during reloading the game state...\\n Please try again");
		}
	}
}
