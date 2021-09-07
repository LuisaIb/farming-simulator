/**
 * 
 */
package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import datastorage.jsonb.GetJsonbValue;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class GetPojoValue {
	
	/**
	 * This method creates an new object of the class GameValue.
	 * @return deserialized as a new game object of the cash, filling values and the day
	 */
	public GameValue toDeserializeGame() {
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		GameValue deserializedgame = jb.fromJson(jbv.toSerializeGame(), GameValue.class);
		return deserializedgame; // kann nun als neues Objekt der Klasse Game() verwendet werden um den Konstruktor zu befüllen
	}
	
	/**
	 * This method creates an new object of the class LevelOfDifficulty.
	 * @return deserialized as a new Enum object of the level of difficulty
	 */
	public LevelOfDifficulty toDeserializeLevel() {
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		LevelOfDifficulty deserializedlod = jb.fromJson(jbv.toSerializeLevel(), LevelOfDifficulty.class);
		return deserializedlod; // kann nun als neues Objekt der Klasse LevelOfDifficulty() verwendet werden um den Konstruktor zu befüllen
	}
	
	/**
	 * This method creates an new object of the class FieldTile.
	 * @return deserialized as a new FieldTile object of the fieldtile's contitions
	 */
	public FieldTile toDeserializeFieldtiles() {  
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		FieldTile deserializedft = jb.fromJson(jbv.toSerializeFieldtiles(), FieldTile.class);
		return deserializedft;	// kann nun als neues Objekt der Klasse FieldTile() verwendet werden um den Konstruktor zu befüllen
	}
	
	/**
	 * This method creates an new object of the class Silo.
	 * @return deserialized as a new Silo object of the Silo's contitions
	 */
	public Silo toDeserializeSilo() {  
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		Silo deserializedft = jb.fromJson(jbv.toSerializeFieldtiles(), Silo.class);
		return deserializedft;	// kann nun als neues Objekt der Klasse Silo() verwendet werden um den Konstruktor zu befüllen
	}
	
	/**
	 * This method creates an new object of the class CourtTrade.
	 * @return deserialized as a new CourtTrade object of the CourtTrade's contitions
	 */
	public CourtTrade toDeserializeCourtTrade() {  
		GetJsonbValue jbv = new GetJsonbValue();
		Jsonb jb = JsonbBuilder.create();
		CourtTrade deserializedft = jb.fromJson(jbv.toSerializeFieldtiles(), CourtTrade.class);
		return deserializedft;	// kann nun als neues Objekt der Klasse FieldTile() verwendet werden um den Konstruktor zu befüllen
	}
	// Silo Hofladen
}
