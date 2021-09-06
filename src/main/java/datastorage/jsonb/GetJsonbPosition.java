/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.GameBoard;

/**
 * @author Isabel
 *
 */
public class GetJsonbPosition {

	/**
	 * This method gets the position of the farmer of the class...
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmersPosition() { //eventuell mit Vererbung für die Geräte und den Menschen
		GameBoard gbf = new GameBoard();
		// get x und y koordinaten, Farmer klasse??
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbf = jsonb.toJson(gbf);
		return serializedgbf;
	}
	
	/**
	 * This method gets the position of the tractor of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeTractorsPosition() { 
		GameBoard gbt = new GameBoard();
		// Koordinaten des Taktors
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbt = jsonb.toJson(gbt);
		return serializedgbt;
	}
	
	/**
	 * This method gets the position of the harvester of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvestersPosition() { 
		GameBoard gbh = new GameBoard();
		// Koordinaten des Harvesters
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	
	// fehlende Geräte folgen
	// 
}
