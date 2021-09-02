/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetPojoPosition;

/**
 * @author Isabel
 *
 */
public class GetSavingInformationPosition {

	GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeFarmersPosition();
		gpp.toDeserializeTractorsPosition();
		gpp.toDeserializeHarvestersPosition();
}
