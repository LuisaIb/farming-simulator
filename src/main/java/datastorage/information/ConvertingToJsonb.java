/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetJsonbPosition;
import datastorage.jsonb.GetJsonbValue;

/**
 * @author Isabel
 *
 */
public class ConvertingToJsonb {
	/**
	 * This method is converting all the data into a JSONB file
	 * 
	 */
	public void SetSavingInformation() {// Methodenname wird noch geändert
	// all numeric values
		GetJsonbValue gjv = new GetJsonbValue();
			gjv.toSerializeGame();
			gjv.toSerializeLevel();
			gjv.toSerializeFieldtiles();
			
	// all position values	
		GetJsonbPosition gjp = new GetJsonbPosition();
			gjp.toSerializeFarmersPosition();
			gjp.toSerializeTractorsPosition();
			gjp.toSerializeHarvestersPosition();
	}
}
