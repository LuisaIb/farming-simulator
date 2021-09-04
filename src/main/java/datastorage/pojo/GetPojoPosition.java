/**
 * 
 */
package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import datastorage.jsonb.GetJsonbPosition;
import gameboard.GameBoard;

/**
 * @author Isabel
 *
 */
public class GetPojoPosition {
	
	/**
	 * This method creates an new object of the class ....
	 * @return deserialized as a new GameBoard object of the farmer's positions
	 */
	public GameBoard toDeserializeFarmersPosition() {  
		GetJsonbPosition jbp = new GetJsonbPosition();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserializedgbf = jb.fromJson(jbp.toSerializeFarmersPosition(), GameBoard.class);
		return deserializedgbf;	
	}
	
	/**
	 * This method creates an new object of the class ....
	 * @return deserialized as a new GameBoard object of the tractor's positions
	 */
	public GameBoard toDeserializeTractorsPosition() {  	
		GetJsonbPosition jbp = new GetJsonbPosition();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserializedgbt = jb.fromJson(jbp.toSerializeTractorsPosition(), GameBoard.class);
		return deserializedgbt;	
	}
	
	/**
	 * This method creates an new object of the class ....
	 * @return deserialized as a new GameBoard object of the Harvester's positions
	 */
	public GameBoard toDeserializeHarvestersPosition() {  
		GetJsonbPosition jbp = new GetJsonbPosition();
		Jsonb jb = JsonbBuilder.create();
		GameBoard deserializedgbh = jb.fromJson(jbp.toSerializeFarmersPosition(), GameBoard.class);
		return deserializedgbh;	
	}
}
