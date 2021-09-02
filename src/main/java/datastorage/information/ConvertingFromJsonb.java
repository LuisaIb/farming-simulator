/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetPojoPosition;
import datastorage.jsonb.GetPojoValue;

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
		GetPojoValue gpv = new GetPojoValue();
			gpv.toDeserializeGame();
			gpv.toDeserializeLevel();
			gpv.toDeserializeFieldtiles();
		
		GetPojoPosition gpp = new GetPojoPosition();	
			gpp.toDeserializeFarmersPosition();
			gpp.toDeserializeTractorsPosition();
			gpp.toDeserializeHarvestersPosition();
		
	}
}
