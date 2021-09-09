/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;

/**
 * @author Isabel
 *
 */
public class GetJsonbMovingObject {

	/**
	 * This method gets the position of the farmer of the class...
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmer() { //eventuell mit Vererbung f�r die Ger�te und den Menschen
		Farmer gbf = new Farmer();
		// getter und setter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbf = jsonb.toJson(gbf);
		return serializedgbf;
	}
	
	/**
	 * This method gets the position of the tractor of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeTractor() { 
		Tractor gbt = new Tractor();
		// getter und setter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbt = jsonb.toJson(gbt);
		return serializedgbt;
	}
	
	/**
	 * This method gets the position of the harvester of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvester() { 
		Harvester gbh = new Harvester();
		// getter und setter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeCultivator() { 
		Cultivator gbh = new Cultivator();
		// getter und setter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeDumpTruck() { 
		DumpTruck gbh = new DumpTruck();// leeren konstruktor erstellen
		// getter und setter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeSeedDrill() { 
		SeedDrill gbh = new SeedDrill();
		// Koordinaten des Harvesters
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	// fehlende Ger�te folgen
	// allgemeine Informationen �ber position, Tankstand, Grainstand
	// Kommentare anpassen DumpTruck SeedDrill
	
}
