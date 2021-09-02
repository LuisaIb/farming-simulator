/**
 * 
 */
package datastorage.information;

import datastorage.jsonb.GetPojoPosition;
import datastorage.jsonb.GetPojoValue;
import gameboard.tiles.FieldTile;
import simulator.Game;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class ConvertingFromJsonb {
	/**
	 * This method is converting all the data into a class object
	 */
	public void toDeserialize() {
	//all numeric values
		GetSavingInformationGame();
		GetSavingInformationLevel();
		GetSavingInformationFieldtiles();
		GetSavingInformationFieldtiles();
			
		GetPojoPosition gpp = new GetPojoPosition();	
			gpp.toDeserializeFarmersPosition();
			gpp.toDeserializeTractorsPosition();
			gpp.toDeserializeHarvestersPosition();
		
	}
	
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
			
			FieldTile updatedFieldTile = new FieldTile(null,ft1, ft2, ft3);
					
	}
}
