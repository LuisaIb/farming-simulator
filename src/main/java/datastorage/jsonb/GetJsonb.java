/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import simulator.LevelOfDifficulty;
import gameboard.GameBoard;
import gameboard.tiles.FieldTile;


/**
 * @author Isabel
 *
 */
public class GetJsonb {
	// serialize und deserialize Methode für alle zu speichernden Elemente, 
	// in einer eigenden MEthode werden dann alle objekte zusammengefügt und zurück gegeben oder gespeichert

	/**
	 * @return serialized as a JSONB object of the cash and filling values
	 */
	public String toSerializeGame() {
		//Klassenobjekt
		Game game = new Game(0, 0.0);
//		game.setCash(50);
//		game.setFilling(110.0);
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(game);
		//System.out.println("serialized " + serialized);
		return serialized;
	}
	
	/**
	 * @return serialized as a JSONB object of the level of difficulty
	 */
	public String toSerializeLevel() {
		//Klassenobjekt
		LevelOfDifficulty lod = new LevelOfDifficulty();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(lod);
		//System.out.println("serialized " + serialized);
		return serialized;
	}
	
	/**
	 * @return serialized as a JSONB object of the farmer's and machine's positions
	 */
	public String toSerializePosition() { //eventuell mit Vererbung für die Geräte und den Menschen
		//Klassenobjekt
		GameBoard gb = new GameBoard();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(gb);
		//System.out.println("serialized " + serialized);
		return serialized;
	}
	
	/**
	 * @return serialized as a JSONB object of the fieldtile's contitions
	 */
	public String toSerializeTiles() { //eventuell mit Vererbung für die Felder 1-3
		//Klassenobjekt
		FieldTile gb = new FieldTile();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(gb);
		//System.out.println("serialized " + serialized);
		return serialized;
	}

}
