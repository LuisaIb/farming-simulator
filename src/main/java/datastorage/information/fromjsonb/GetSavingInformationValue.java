/**
 * 
 */
package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoValue;
import gameboard.tiles.FieldTile;
import simulator.Game;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 * This class converts the JSONB file into a class object and generates new constructor values
 *
 */
public class GetSavingInformationValue {

	/**
	 * 
	 */
	public void GetSavingInformationGame() {
		GetPojoValue gpv = new GetPojoValue();
			Game deserializedcash = gpv.toDeserializeGame();
			int cash = deserializedcash.getCash();
			
			Game deserializedfilling = gpv.toDeserializeGame();
			double filling = deserializedfilling.getFilling();
			
			Game deserializedday = gpv.toDeserializeGame();
			int day = deserializedfilling.getDay();
		
		Game updatedGame = new Game(cash, filling, day);
	}
	
	/**
	 * 
	 */
	public void GetSavingInformationLevel() {
		GetPojoValue gpv = new GetPojoValue();
			LevelOfDifficulty deserializedlevel = gpv.toDeserializeLevel();
			LevelOfDifficulty level = deserializedlevel.HIGH;
					
		// wird noch geändert im Bezug auf ENUM
	}
	
	/**
	 * 
	 */
	public void GetSavingInformationFieldtiles() {
		GetPojoValue gpv = new GetPojoValue();
			FieldTile deserializedft1 = gpv.toDeserializeFieldtiles();
			int ft1 = deserializedft1.getGrowthState();
			
			FieldTile deserializedft2 = gpv.toDeserializeFieldtiles();
			int ft2 = deserializedft2.getGrowthState2();
			
			FieldTile deserializedft3 = gpv.toDeserializeFieldtiles();
			int ft3 = deserializedft3.getGrowthState3();
			
			FieldTile updatedFieldTile = new FieldTile(0, ft1, ft2, ft3);
					
	}
}
