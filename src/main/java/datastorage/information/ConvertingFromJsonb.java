/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetPojoPosition;

/**
 * @author Isabel
 *
 */
public class ConvertingFromJsonb {
	/**
	 * This method is converting all the data into a class object
	 */
	public void toDeserialize() {
	//all numeric values
	GetSavingInformationValue siv = new GetSavingInformationValue();
		siv.GetSavingInformationGame();
		siv.GetSavingInformationLevel();
		siv.GetSavingInformationFieldtiles();
		siv.GetSavingInformationFieldtiles();
		
			
		GetPojoPosition gpp = new GetPojoPosition();	
			gpp.toDeserializeFarmersPosition();
			gpp.toDeserializeTractorsPosition();
			gpp.toDeserializeHarvestersPosition();
		
	}
	
}
