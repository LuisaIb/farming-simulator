/**
 * 
 */
package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.GameValue;
import gameboard.tiles.FieldTile;
import datastorage.jsonb.GetJsonbValue;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class GetPojoValue {
	
	/**
	 * @return deserialized as a new game object of the cash, filling values and the day
	 */
	public GameValue toDeserializeGame() {
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		GameValue deserializedgame = jb.fromJson(jbv.toSerializeGame(), GameValue.class);
		return deserializedgame; // kann nun als neues Objekt der Klasse Game() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * @return deserialized as a new Enum object of the level of difficulty
	 */
	public LevelOfDifficulty toDeserializeLevel() {
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		LevelOfDifficulty deserializedlod = jb.fromJson(jbv.toSerializeLevel(), LevelOfDifficulty.class);
		return deserializedlod; // kann nun als neues Objekt der Klasse LevelOfDifficulty() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * @return deserialized as a new GameBoard object of the fieldtile's contitions
	 */
	public FieldTile toDeserializeFieldtiles() {  
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		FieldTile deserializedft = jb.fromJson(jbv.toSerializeFieldtiles(), FieldTile.class);
		return deserializedft;	// kann nun als neues Objekt der Klasse FieldTile() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * @return deserialized as a new GameBoard object of the tank filling status
	 */
	public GameValue toDeserializeTank() {
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		Class deserializedtank = jb.fromJson(jbv.toSerializeTank(), null);
		//deserializedtank.getDeclaredMethod(null, null);
		return null; // Klassenaufruf findet hier statt, bezug zu der jeweiligen Klasse muss noch erstellt werden
	}
}
