package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import simulator.Game;
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
	public GameValue toDeserializeGame(String jb) {
		Jsonb jb1 = JsonbBuilder.create();
		GameValue deserializedgame = jb1.fromJson(jb, GameValue.class);
		return deserializedgame; // kann nun als neues Objekt der Klasse Game() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * This method creates an new object of the class LevelOfDifficulty.
	 * @return deserialized as a new Enum object of the level of difficulty
	 */
	public LevelOfDifficulty toDeserializeLevel(String jb) {
		Jsonb jb1 = JsonbBuilder.create();
		LevelOfDifficulty deserializedlod = jb1.fromJson(jb, LevelOfDifficulty.class);
		return deserializedlod; // kann nun als neues Objekt der Klasse LevelOfDifficulty() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * This method creates an new object of the class FieldTile.
	 * @return deserialized as a new FieldTile object of the fieldtile's contitions
	 */
	public FieldTile toDeserializeFieldtiles(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		FieldTile deserializedft = jb1.fromJson(jb, FieldTile.class);
		return deserializedft;	// kann nun als neues Objekt der Klasse FieldTile() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * This method creates an new object of the class Silo.
	 * @return deserialized as a new Silo object of the Silo's contitions
	 */
	public Silo toDeserializeSilo(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		Silo deserializeds = jb1.fromJson(jb, Silo.class);
		return deserializeds;	// kann nun als neues Objekt der Klasse Silo() verwendet werden um den Konstruktor zu bef�llen
	}
	
	/**
	 * This method creates an new object of the class CourtTrade.
	 * @return deserialized as a new CourtTrade object of the CourtTrade's contitions
	 */
	public CourtTrade toDeserializeCourtTrade(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		CourtTrade deserializedct = jb1.fromJson(jb, CourtTrade.class);
		return deserializedct;	// kann nun als neues Objekt der Klasse CourtTrade() verwendet werden um den Konstruktor zu bef�llen
	}
	
}
