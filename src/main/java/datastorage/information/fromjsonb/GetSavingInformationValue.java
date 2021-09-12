package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoValue;
import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 * This class converts the JSONB file into a class object and generates new constructor values
 *
 */
public class GetSavingInformationValue {

	/**
	 * This method deserialize the JSONB file. It is also possible to get the values of the cash, the tank filling and the gameday.
	 * It implements a new GameValue object by using the class constructor.
	 */
	public GameValue GetSavingInformationGame() {
		GetPojoValue gpv = new GetPojoValue();
			GameValue deserializedcash = gpv.toDeserializeGame();
			int cash = deserializedcash.getCash();
						
			GameValue deserializedday = gpv.toDeserializeGame();
			int day = deserializedday.getDay();
		
			GameValue updatedGameValue = new GameValue(cash, day);
			return updatedGameValue;
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the level of difficulty.
	 * It implements a new LevelOfDifficulty object by using the class constructor.
	 */
	public LevelOfDifficulty GetSavingInformationLevel() {
		GetPojoValue gpv = new GetPojoValue();
			LevelOfDifficulty deserializedlevel = gpv.toDeserializeLevel();
			int newLevel = deserializedlevel.getLevel();
			
			LevelOfDifficulty updatedLevel = new LevelOfDifficulty(newLevel);
			return updatedLevel;
					
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the growth state of field one, the growth state of field two and the growth state of field three.
	 * It implements a new FieldTile object by using the class constructor.
	 */
	public FieldTile GetSavingInformationFieldtiles() {
		GetPojoValue gpv = new GetPojoValue();
			FieldTile deserializedft1 = gpv.toDeserializeFieldtiles();
			int ft1 = deserializedft1.getGrowthState();
			
			FieldTile deserializedft2 = gpv.toDeserializeFieldtiles();
			int ft2 = deserializedft2.getGrowthState2();
			
			FieldTile deserializedft3 = gpv.toDeserializeFieldtiles();
			int ft3 = deserializedft3.getGrowthState3();
			
		FieldTile updatedFieldTile = new FieldTile(ft1, ft2, ft3);
		return updatedFieldTile;
					
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
	 * It implements a new Silo object by using the class constructor.
	 */
	public Silo GetSavingInformationSilo() {
		GetPojoValue gpv = new GetPojoValue();
			Silo deserializedcapacity = gpv.toDeserializeSilo();
			int capacity = deserializedcapacity.getCapacity();
			
		Silo updatedSilo = new Silo (capacity);
		return updatedSilo;
		
					
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
	 * It implements a new Silo object by using the class constructor.
	 */
	public CourtTrade GetSavingInformationCourtTrade() {
		GetPojoValue gpv = new GetPojoValue();
			CourtTrade deserializedGrainFillLevel = gpv.toDeserializeCourtTrade();
			int grainFillLevel = deserializedGrainFillLevel.getGrainFillLevel();
			
			//cash Variable, ggf GameValue l�schen und cash zum hofladen
			
		CourtTrade updatedCourtTrade = new CourtTrade(grainFillLevel);
		return updatedCourtTrade;
					
	}
}
