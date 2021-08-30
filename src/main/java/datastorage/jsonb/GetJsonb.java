/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import simulator.LevelOfDifficulty;
import gameboard.GameBoard;
import gameboard.tiles.Tile;

/**
 * @author Isabel
 *
 */
public class GetJsonb {
	// serialize und deserialize Methode f�r alle zu speichernden Elemente, 
	// in einer eigenden MEthode werden dann alle objekte zusammengef�gt und zur�ck gegeben oder gespeichert

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
	 * @return
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
	 * @return
	 */
	public String toSerializePosition() {
		//Klassenobjekt
		GameBoard gb = new GameBoard();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(gb);
		//System.out.println("serialized " + serialized);
		return serialized;
	}
	
	/**
	 * @return
	 */
	public String toSerializeTiles() {
		//Klassenobjekt
		Tile gb = new Tile();
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(gb);
		//System.out.println("serialized " + serialized);
		return serialized;
	}

}