/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.GameValue;
import simulator.LevelOfDifficulty;
import gameboard.tiles.FieldTile;


/**
 * @author Isabel
 *
 */
public class GetJsonbValue {
	// serialize und deserialize Methode für alle zu speichernden Elemente, 
	// in einer eigenden Methode werden dann alle objekte zusammengefügt und zurück gegeben oder gespeichert

	/**
	 * This method gets the values of the cash, the filling and the gameday of the class GameValue.
	 * @return serialized as a JSONB object of the cash, filling values and the day
	 */
	public String toSerializeGame() {
		GameValue game = new GameValue();
		game.getCash();
		game.getFilling();
		game.getDay();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgame = jsonb.toJson(game);
		return serializedgame;
	}
	
	/**
	 * This method gets the value of the level of difficulty of the class LevelOfDifficulty.
	 * @return serialized as a JSONB object of the level of difficulty
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
	 * @return serialized as a JSONB object of the fieldtile's contitions
	 */
	public String toSerializeFieldtiles() { 
		FieldTile ft = new FieldTile();
		ft.getGrowthState(); // get Field id + status of the three fields
		ft.getGrowthState2();
		ft.getGrowthState3();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedft = jsonb.toJson(ft);
		return serializedft;
	}
	
	/**
	 * This method get the tank filling state of the class .
	 * @return serialized as a JSONB object of the tank filling status
	 */
	public String toSerializeTank() {
		// Tankfüllstand der beiden Geräte speichern
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedtank = jsonb.toJson(null); // wird in die machines klasse eingebunden
		return serializedtank;
	}

	// Soli und Hofladen Zustand, Füllstände(Tank)
}
