/**
 * 
 */
package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoPosition;

/**
 * @author Isabel
 * * This class converts the JSONB file into a class object and generates new constructor values
 */
public class GetSavingInformationPosition {
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
	 * It implements a new position (x and y value) of the farmer.
	 */
	public void GetSavingInformationFarmer() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeFarmersPosition();
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
	 * It implements a new position (x and y value) of the tractor.
	 */
	public void GetSavingInformationTractor() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeTractorsPosition();

	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public void GetSavingInformationHarvester() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeHarvestersPosition();
	}
	// Bezug auf das Koordinatensystem muss noch erzeugt werden
	// x und y werte werden zurück gegebne und neu initialisiert
}
