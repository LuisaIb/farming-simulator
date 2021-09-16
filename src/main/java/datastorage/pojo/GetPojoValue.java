package datastorage.pojo;

import javax.json.bind.Jsonb;

import javax.json.bind.JsonbBuilder;

import gameboard.GameValue;
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
	public Game toDeserializeGame(String jb) {
//		Jsonb jb1 = JsonbBuilder.create();
//		GameValue deserializedgame = jb1.fromJson(jb, GameValue.class);
//		return deserializedgame; // kann nun als neues Objekt der Klasse Game() verwendet werden um den Konstruktor zu bef�llen
		Jsonb jb2 = JsonbBuilder.create();
		Game deserializeddf = jb2.fromJson(jb, Game.class);
		return deserializeddf;
	}
	
	/**
	 * This method creates an new object of the class LevelOfDifficulty.
	 * @return deserialized as a new Enum object of the level of difficulty
	 */
	public Game toDeserializeLevel(String jb) {
//		Jsonb jb1 = JsonbBuilder.create();
//		LevelOfDifficulty deserializedlod = jb1.fromJson(jb, LevelOfDifficulty.class);
//		return deserializedlod; // kann nun als neues Objekt der Klasse LevelOfDifficulty() verwendet werden um den Konstruktor zu bef�llen
		Jsonb jb2 = JsonbBuilder.create();
		Game deserializeddf = jb2.fromJson(jb, Game.class);
		return deserializeddf;
	}
	
	/**
	 * This method creates an new object of the class FieldTile.
	 * @return deserialized as a new FieldTile object of the fieldtile's contitions
	 */
	public Game toDeserializeFieldtiles(String jb) {  
//		Jsonb jb1 = JsonbBuilder.create();
//		FieldTile deserializedft = jb1.fromJson(jb, FieldTile.class);
//		return deserializedft;	// kann nun als neues Objekt der Klasse FieldTile() verwendet werden um den Konstruktor zu bef�llen
		Jsonb jb2 = JsonbBuilder.create();
		Game deserializeddf = jb2.fromJson(jb, Game.class);
		return deserializeddf;
	}
	
	/**
	 * This method creates an new object of the class Silo.
	 * @return deserialized as a new Silo object of the Silo's contitions
	 */
	public Game toDeserializeSilo(String jb) {  
//		Jsonb jb1 = JsonbBuilder.create();
//		Silo deserializeds = jb1.fromJson(jb, Silo.class);
//		return deserializeds;	// kann nun als neues Objekt der Klasse Silo() verwendet werden um den Konstruktor zu bef�llen
		Jsonb jb2 = JsonbBuilder.create();
		Game deserializeddf = jb2.fromJson(jb, Game.class);
		return deserializeddf;
	}
	
}
