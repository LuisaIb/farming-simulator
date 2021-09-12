package simulator;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;


import datastorage.pojo.GetPojoMovingObject;
import datastorage.pojo.GetPojoValue;
import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.Silo;
import gui.controller.MovingObjectController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.model.GameInformation;
import gui.view.DifficultyScene;
import gui.view.GameScene;

/**
 * @author Isabel
 *
 */
public class Game {

	DifficultyScene ds = new DifficultyScene();
    MovingObject movingObject = new MovingObject();
    private Farmer farmer;
    private Tractor tractor;
    private Harvester harvester;
    private Cultivator cultivator;
    private DumpTruck dumpTruck;
    private SeedDrill seedDrill;
    private FieldTile fieldTile;
    private int selectedObject;
    private GameValue gameValue;
    private LevelOfDifficulty levelOfDifficulty;
    private Silo silo;
    private CourtTrade courtTrade;
   
    


    public GameScene createNewGame(){
        GameScene gameScene = new GameScene();
	        farmer = new Farmer();
	        tractor = new Tractor();
	        harvester = new Harvester();
	        cultivator = new Cultivator();
	        dumpTruck = new DumpTruck();
	        seedDrill = new SeedDrill();
	        fieldTile = new FieldTile();
	        gameValue = new GameValue();
	        levelOfDifficulty = new LevelOfDifficulty();
	        silo = new Silo();
	        courtTrade = new CourtTrade();
        
        
        MovingObjectController movingObjectController = new MovingObjectController();
        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
        System.out.println(getSelectedObject());
        System.out.println(getColumn());
        System.out.println(getRow());
        movingObjectController.initGameLoop(gameScene, fieldTile, farmer);
        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue);
        gameValue.setCash(50);
        return gameScene;
    }

	public int getSelectedObject(){
        if(farmer.isSelected()){
            selectedObject=1;
            movingObject=farmer;
        }else if(tractor.isSelected()){
            selectedObject=2;
        }else if(harvester.isSelected()){
            selectedObject=3;
        } else if(cultivator.isSelected()) {
            selectedObject = 4;
        } else if (dumpTruck.isSelected()) {
            selectedObject = 5;
        } else if (seedDrill.isSelected()) {
            selectedObject = 6;
        }
        return selectedObject;
    }

    public int getRow(){
        selectedObject=getSelectedObject();
        if(selectedObject==1){
            return farmer.getY();
        }
        return 0;
    }

    public int getColumn(){
        selectedObject=getSelectedObject();
        if(selectedObject==1){
            return farmer.getX();
        }
        return 0;
    }

    // all numeric values
	/**
	 * This method gets the values of the cash, the filling and the gameday of the class GameValue.
	 * @return serialized as a JSONB object of the cash, filling values and the day.
	 */
	public String toSerializeGameValue() {
		gameValue = new GameValue(120, 6);
		gameValue.getCash();
		gameValue.getDay();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedGameValue = jsonb.toJson(gameValue);
		return serializedGameValue;
	}
    		
   
    	/**
	 * This method gets the value of the level of difficulty of the class LevelOfDifficulty.
	 * @return serialized as a JSONB object of the level of difficulty.
	 */
	public String toSerializeLevel() {
		levelOfDifficulty = new LevelOfDifficulty(3);
   		levelOfDifficulty.getLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedlod = jsonb.toJson(levelOfDifficulty);
		return serializedlod;
	}
	
	/**
	 * This method gets the growth state of all three fields of the class FieldTile.
	 * @return serialized as a JSONB object of the fieldtile's conditions.
	 */
	public String toSerializeFieldtiles() { 
		fieldTile = new FieldTile(1, 2, 6);
		fieldTile.getGrowthState(); // get Field id + status of the three fields.
		fieldTile.getGrowthState2();
		fieldTile.getGrowthState3();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedft = jsonb.toJson(fieldTile);
		return serializedft;
	}
	
	/**
	 * This method gets the filling of the silo.
	 * @return serialized as a JSONB object of the Silo's conditions.
	 */
	public String toSerializeSilo() { 
		silo = new Silo(36);
		silo.getCapacity();
		Jsonb jsonb = JsonbBuilder.create();
		String serializeds = jsonb.toJson(silo);
		return serializeds;
	}
	
	/**
	 * This method gets the filling of the silo.
	 * @return serialized as a JSONB object of the Silo's conditions.
	 */
	public String toSerializeCourtTrade() { 
		courtTrade = new CourtTrade(100);
		courtTrade.getGrainFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedct = jsonb.toJson(courtTrade);
		return serializedct;
	}

    // all position values
    /**
	 * This method gets the position of the farmer of the class...
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmer() {
		farmer = new Farmer(5, 13, true);
		farmer.getX();
		farmer.getY();
		farmer.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsf = jsonb.toJson(farmer);
		return serializedsf;
	}
	
	/**
	 * This method gets the position of the tractor of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeTractor() {
		tractor = new Tractor(18, 7, false, 100, false);
		tractor.getX();
		tractor.getY();
		tractor.isSelected();
		tractor.getPetrolTankFillLevel();
		tractor.isAttachement();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedst = jsonb.toJson(tractor);
		return serializedst;
	}
	
	/**
	 * This method gets the position of the harvester of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvester() { 
		harvester = new Harvester(18, 7, false, 5, 5);
		harvester.getX();
		harvester.getY();
		harvester.isSelected();
		harvester.getPetrolTankFillLevel();
		harvester.getGrainTankFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsh = jsonb.toJson(harvester);
		System.out.println(serializedsh);
		return serializedsh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeCultivator() { 
		cultivator = new Cultivator(18,7,false);
		cultivator.getX();
		cultivator.getY();
		cultivator.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsc = jsonb.toJson(cultivator);
		return serializedsc;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeDumpTruck() { 
		dumpTruck = new DumpTruck(18,7,false,5);
		dumpTruck.getX();
		dumpTruck.getY();
		dumpTruck.isSelected();
		dumpTruck.getGrainFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsdt = jsonb.toJson(dumpTruck);
		return serializedsdt;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeSeedDrill() {
		seedDrill = new SeedDrill(18,7,false);
		seedDrill.getX();
		seedDrill.getY();
		seedDrill.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedssd = jsonb.toJson(seedDrill);
		return serializedssd;
	}
    

    public GameScene reloadGame(){
        GameScene gameScene = new GameScene();
        MovingObjectController movingObjectController = new MovingObjectController();
        //all numeric values
        /**
    	 * This method deserialize the JSONB file. It is also possible to get the values of the cash, the tank filling and the gameday.
    	 * It implements a new GameValue object by using the class constructor.
    	 */
    	GetPojoValue gpv = new GetPojoValue();
			GameValue deserializedcash = gpv.toDeserializeGame(toSerializeGameValue());
			int cash = deserializedcash.getCash();
						
			GameValue deserializedday = gpv.toDeserializeGame(toSerializeGameValue());
			int day = deserializedday.getDay();
		
		gameValue = new GameValue(cash, day);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the level of difficulty.
    	 * It implements a new LevelOfDifficulty object by using the class constructor.
    	 */
 			LevelOfDifficulty deserializedlevel = gpv.toDeserializeLevel(toSerializeLevel());
    		int newLevel = deserializedlevel.getLevel();
    			
    	levelOfDifficulty = new LevelOfDifficulty(newLevel);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the growth state of field one, the growth state of field two and the growth state of field three.
    	 * It implements a new FieldTile object by using the class constructor.
    	 */
			FieldTile deserializedft1 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft1 = deserializedft1.getGrowthState();
			
			FieldTile deserializedft2 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft2 = deserializedft2.getGrowthState2();
			
			FieldTile deserializedft3 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft3 = deserializedft3.getGrowthState3();
			
		fieldTile = new FieldTile(ft1, ft2, ft3);
		    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
    	 * It implements a new Silo object by using the class constructor.
    	 */
    	
			Silo deserializedcapacity = gpv.toDeserializeSilo(toSerializeSilo());
			int capacity = deserializedcapacity.getCapacity();
			
		silo = new Silo (capacity);
    		
       	/**
    	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
    	 * It implements a new Silo object by using the class constructor.
    	 */
    	
			CourtTrade deserializedGrainFillLevel = gpv.toDeserializeCourtTrade(toSerializeCourtTrade());
			int grainFillLevel = deserializedGrainFillLevel.getGrainFillLevel();
			
			//cash Variable, ggf GameValue l�schen und cash zum hofladen
			
		courtTrade = new CourtTrade(grainFillLevel);
    					
        // all positions
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
    	 * It implements a new position (x and y value) of the farmer.
    	 */
		GetPojoMovingObject gpp = new GetPojoMovingObject();
			Farmer deserializedfX = gpp.toDeserializeFarmer(toSerializeFarmer());
			int xf = deserializedfX.getX();
			
			Farmer deserializedfY = gpp.toDeserializeFarmer(toSerializeFarmer());
			int yf = deserializedfY.getY();
			
			Farmer deserializedSelectedf = gpp.toDeserializeFarmer(toSerializeFarmer());
			boolean selectedf = deserializedSelectedf.isSelected();
		
		farmer = new Farmer(xf, yf, selectedf);
		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
    	 * It implements a new position (x and y value) of the tractor.
    	 */
    	
    		Tractor deserializedtX = gpp.toDeserializeTractor(toSerializeTractor());
    		int xt = deserializedtX.getX();
    		
    		Tractor deserializedtY = gpp.toDeserializeTractor(toSerializeTractor());
    		int yt = deserializedtY.getY();
    		
    		Tractor deserializedSelectedt = gpp.toDeserializeTractor(toSerializeTractor());
    		boolean selectedt = deserializedSelectedt.isSelected();
    		
    		Tractor deserializedPetrolTankFillLevelt = gpp.toDeserializeTractor(toSerializeTractor());
    		int petrolTankFillLevelt = deserializedPetrolTankFillLevelt.getPetrolTankFillLevel();
    		
    		Tractor deserializedAttachementt = gpp.toDeserializeTractor(toSerializeTractor());
    		boolean attachementt = deserializedAttachementt.isAttachement();
    		
		tractor = new Tractor(xt, yt, selectedt, petrolTankFillLevelt, attachementt);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    	
    		Harvester deserializedhX = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int xh = deserializedhX.getX();
    		
    		Harvester deserializedhY = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int yh = deserializedhY.getY();
    		
    		Harvester deserializedSelectedh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		boolean selectedh = deserializedSelectedh.isSelected();
    		
    		Harvester deserializedPetrolTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int petrolTankFillLevelh = deserializedPetrolTankFillLevelh.getPetrolTankFillLevel();
    		
    		Harvester deserializedGrainTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int grainTankFillLevelh = deserializedGrainTankFillLevelh.getGrainTankFillLevel();
    		
		harvester = new Harvester(xh, yh, selectedh, petrolTankFillLevelh, grainTankFillLevelh);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    		
    		Cultivator deserializedcX = gpp.toDeserializeCultivator(toSerializeCultivator());
    		int xc = deserializedcX.getX();
    		
    		Cultivator deserializedcY = gpp.toDeserializeCultivator(toSerializeCultivator());
    		int yc = deserializedcY.getY();
    		
    		Cultivator deserializedSelectedc = gpp.toDeserializeCultivator(toSerializeCultivator());
    		boolean selectedc = deserializedSelectedc.isSelected();
    		
		cultivator = new Cultivator(xc, yc, selectedc);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    	
    		DumpTruck deserializeddtX = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int xdt = deserializeddtX.getX();
    		
    		DumpTruck deserializeddtY = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int ydt = deserializeddtY.getY();
    		
    		DumpTruck deserializedSelecteddt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		boolean selecteddt = deserializedSelecteddt.isSelected();
    		
    		DumpTruck deserializedGrainFillLeveldt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int grainFillLeveldt = deserializedGrainFillLeveldt.getGrainFillLevel();
    		
		dumpTruck = new DumpTruck(xdt, ydt, selecteddt, grainFillLeveldt);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    		
    		SeedDrill deserializedsdX = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		int xsd = deserializedsdX.getX();
    		
    		SeedDrill deserializedsdY = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		int ysd = deserializedsdY.getY();
    		
    		SeedDrill deserializedSelectedsd = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		boolean selectedsd = deserializedSelectedsd.isSelected();
    		
		seedDrill = new SeedDrill(xsd, ysd, selectedsd);
    		
        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
        movingObjectController.initGameLoop(gameScene, fieldTile, farmer);
        return gameScene;
    }

}
