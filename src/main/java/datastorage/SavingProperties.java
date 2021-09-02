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
	 * 
	 */
	public void CreateNewGame() {
		
	}
	
	/**
	 * 
	 */
	public void SavingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		ctj.SetSavingInformation();
	}
	
	/**
	 * 
	 */
	public void ReloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		cfj.GetSavingInformation();
	}
}
