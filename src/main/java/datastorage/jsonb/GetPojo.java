/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import gameboard.GameBoard;
import gameboard.tiles.Tile;
import datastorage.jsonb.GetJsonb;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class GetPojo {
	
	/**
	 * @return deserialized as a new game object the cash and filling values
	 */
	public Game toDeserializeGame() {
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		Game deserialized = jb.fromJson(gjb.toSerializeGame(), Game.class);
		System.out.println("deserialized, neues Klassenobjekt = " + deserialized);
		return deserialized;	
	}
	
	/**
	 * @return
	 */
	public LevelOfDifficulty toDeserializeLevel() {
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		LevelOfDifficulty deserialized = jb.fromJson(gjb.toSerializeLevel(), LevelOfDifficulty.class);
		return deserialized;
	}
	
	/**
	 * @return
	 */
	public GameBoard toDeserializePosition() {  //eventuell mit Vererbung für die Geräte und den Menschen
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserialized = jb.fromJson(gjb.toSerializePosition(), GameBoard.class);
		return deserialized;	
	}
	
	/**
	 * @return
	 */
	public Tile toDeserializeTiles() {  //eventuell mit Vererbung für die Felder 1-3
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		Tile deserialized = jb.fromJson(gjb.toSerializeTiles(), Tile.class);
		return deserialized;	
	}
}
