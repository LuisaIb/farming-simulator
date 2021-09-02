/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import simulator.LevelOfDifficulty;
import gameboard.tiles.FieldTile;


/**
 * @author Isabel
 *
 */
public class GetJsonbValue {
	// serialize und deserialize Methode für alle zu speichernden Elemente, 
	// in einer eigenden MEthode werden dann alle objekte zusammengefügt und zurück gegeben oder gespeichert

	/**
	 * @return serialized as a JSONB object of the cash, filling values and the day
	 */
	public String toSerializeGame() {
		Game game = new Game();
		game.getCash();
		game.getFilling();
		game.getDay();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedgame = jsonb.toJson(game);
		return serializedgame;
	}
	
	/**
	 * @return serialized as a JSONB object of the level of difficulty
	 */
	public String toSerializeLevel() {
		LevelOfDifficulty lod = null;
		// get Enum level
		Jsonb jsonb = JsonbBuilder.create();
		String serializedlod = jsonb.toJson(lod);
		return serializedlod;
	}
	
	/**
	 * @return serialized as a JSONB object of the fieldtile's contitions
	 */
	public String toSerializeFieldtiles() { 
		FieldTile ft = new FieldTile(0);
		// get Field id of the three fields
		Jsonb jsonb = JsonbBuilder.create();
		String serializedft = jsonb.toJson(ft);
		return serializedft;
	}

}
