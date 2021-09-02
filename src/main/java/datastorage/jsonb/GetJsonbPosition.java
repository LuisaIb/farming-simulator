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
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmersPosition() { //eventuell mit Vererbung f�r die Ger�te und den Menschen
		GameBoard gbf = new GameBoard();
		// get x und y koordinaten, Farmer klasse??
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbf = jsonb.toJson(gbf);
		return serializedgbf;
	}
	
	/**
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
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvestersPosition() { 
		GameBoard gbh = new GameBoard();
		// Koordinaten des Harvesters
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgbh = jsonb.toJson(gbh);
		return serializedgbh;
	}
	
	// fehlende Ger�te folgen
}
