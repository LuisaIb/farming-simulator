/**
 * 
 */
package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoMovingObject;

/**
 * @author Isabel
 * * This class converts the JSONB file into a class object and generates new constructor values
 */
public class GetSavingInformationMovingObject {
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
	 * It implements a new position (x and y value) of the farmer.
	 */
	public void GetSavingInformationFarmer() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeFarmer();
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
	 * It implements a new position (x and y value) of the tractor.
	 */
	public void GetSavingInformationTractor() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeTractor();

	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public void GetSavingInformationHarvster() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeHarvester();
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public void GetSavingInformationCultivator() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeCultivator();
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public void GetSavingInformationDumpTruck() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeDumpTruck();
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public void GetSavingInformationSeedDrill() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		gpp.toDeserializeSeedDrill();
	}
	// Bezug auf das Koordinatensystem muss noch erzeugt werden
	// x und y werte werden zurück gegebne und neu initialisiert
}
