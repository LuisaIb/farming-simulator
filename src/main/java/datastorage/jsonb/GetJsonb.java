/**
 * 
 */
package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import simulator.Game;

/**
 * @author Isabel
 *
 */
public class GetJsonb {
	// serialize und deserialize Methode für alle zu speichernden Elemente, 
	// in einer eigenden MEthode werden dann alle objekte zusammengefügt und zurück gegeben oder gespeichert

	/**
	 * @return serialized as a JSONB object
	 */
	public String toSerialize() {
		//Klassenobjekt
		Game game = new Game(0, 0, 0);
		game.setCash(50);
		game.setFilling(110);
		
		Jsonb jsonb = JsonbBuilder.create();
		String serialized = jsonb.toJson(game);
		System.out.println("serialized " + serialized);
		return serialized;
		}
	
	/**
	 * @return deserialized as a new class object
	 */
	public Game toDeserialize() {
		//Klassenobjekt	
		Jsonb jb = JsonbBuilder.create();
		Game deserialized = jb.fromJson(toSerialize(), Game.class);
		System.out.println("deserialized, neues Klassenobjekt = " + deserialized);
		return deserialized;
		
	}
}
