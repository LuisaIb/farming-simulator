/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import simulator.LevelOfDifficulty;
import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;


/**
 * @author Isabel
 *
 */
public class GetJsonbValue {
	// serialize und deserialize Methode für alle zu speichernden Elemente, 
	// in einer eigenden Methode werden dann alle objekte zusammengefügt und zurück gegeben oder gespeichert

	/**
	 * This method gets the values of the cash, the filling and the gameday of the class GameValue.
	 * @return serialized as a JSONB object of the cash, filling values and the day.
	 */
	public String toSerializeGame() {
		GameValue game = new GameValue();
		game.getCash();
		game.getDay();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgame = jsonb.toJson(game);
		return serializedgame;
	}
	
	/**
	 * This method gets the value of the level of difficulty of the class LevelOfDifficulty.
	 * @return serialized as a JSONB object of the level of difficulty.
	 */
	public String toSerializeLevel() {
		LevelOfDifficulty lod = new LevelOfDifficulty();
		lod.getLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedlod = jsonb.toJson(lod);
		return serializedlod;
	}
	
	/**
	 * This method gets the growth state of all three fields of the class FieldTile.
	 * @return serialized as a JSONB object of the fieldtile's conditions.
	 */
	public String toSerializeFieldtiles() { 
		FieldTile ft = new FieldTile();
		ft.getGrowthState(); // get Field id + status of the three fields.
		ft.getGrowthState2();
		ft.getGrowthState3();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedft = jsonb.toJson(ft);
		return serializedft;
	}
	
	/**
	 * This method gets the filling of the silo.
	 * @return serialized as a JSONB object of the Silo's conditions.
	 */
	public String toSerializeSilo() { 
		Silo s = new Silo();
		//getter
		Jsonb jsonb = JsonbBuilder.create();
		String serializeds = jsonb.toJson(s);
		return serializeds;
	}
	
	/**
	 * This method gets the filling of the silo.
	 * @return serialized as a JSONB object of the Silo's conditions.
	 */
	public String toSerializeCourtTrade() { 
		CourtTrade ct = new CourtTrade();
		//getter
		Jsonb jsonb = JsonbBuilder.create();
		String serializedct = jsonb.toJson(ct);
		return serializedct;
	}
	
		// Soli und Hofladen Zustand, // Silostand, hofladen
}
