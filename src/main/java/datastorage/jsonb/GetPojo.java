/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;
import gameboard.GameBoard;
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
	public GameBoard toDeserializePosition() {
		//Klassenobjekt	
		GetJsonb gjb = new GetJsonb();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserialized = jb.fromJson(gjb.toSerializePosition(), GameBoard.class);
		return deserialized;	
	}
}
