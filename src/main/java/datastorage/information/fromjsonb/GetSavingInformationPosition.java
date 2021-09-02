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
	 * 
	 */
	public void GetSavingInformationFarmer() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeFarmersPosition();
	}
	
	/**
	 * 
	 */
	public void GetSavingInformationTractor() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeTractorsPosition();

	}
	
	/**
	 * 
	 */
	public void GetSavingInformationHarvester() {
		GetPojoPosition gpp = new GetPojoPosition();	
		gpp.toDeserializeHarvestersPosition();
	}
	// Bezug auf das Koordinatensystem muss noch erzeugt werden
	// x und y werte werden zurück gegebne und neu initialisiert
}
