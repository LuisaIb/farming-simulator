package simulator;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import datastorage.pojo.GetPojoMovingObject;
import datastorage.pojo.GetPojoValue;
import gameboard.GameValue;
import gameboard.tiles.Silo;
import gui.controller.GameController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.controller.MovingObjectController;
import gui.controller.SavingController;
import gui.model.GameInformation;
import gui.view.GameScene;
import gui.view.MenuScene;


/**
 * @author Isabel
 *
 */
public class Game {

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
    private GameScene gameScene = new GameScene();

 

	public GameScene createNewGame(int lod){
        	farmer = new Farmer();
        	tractor = new Tractor();
	        harvester = new Harvester();
	        cultivator = new Cultivator();
	        dumpTruck = new DumpTruck();
	        seedDrill = new SeedDrill();
	        fieldTile = new FieldTile();
	        gameValue = new GameValue();
	        levelOfDifficulty = new LevelOfDifficulty(lod);
	        silo = new Silo();

        movingObject = farmer;
        GameController gameController = new GameController();

        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
				cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
				fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow(),
				gameController);
		MovingObjectController movingObjectController = new MovingObjectController(gameScene, movingObject,
				gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile);
        selectedObject = getSelectedObject();
        fillInformationFields(gameScene, silo, harvester, tractor, gameValue);
		gameController.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController);
        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);

        SavingController sc = new SavingController();
        sc.createFunctionality(gameScene, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile, silo, levelOfDifficulty);

        return gameScene;
    }




	private void fillInformationFields(GameScene gameScene, Silo silo, Harvester harvester, Tractor tractor,
									   GameValue gameValue){
		gameScene.getInformationBox().getSiloField().setText("corn in silo: " + silo.getCapacityAsString());
		gameScene.getInformationBox().getHarvesterField().setText("petrol harvester: " + harvester.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTractorField().setText("petrol tractor: " + tractor.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTimeField().setText("day: " + gameValue.getDayAsString());
		gameScene.getInformationBox().getMoneyField().setText("money: " + gameValue.getCashAsString());
	}


    /**
     * @param movingObject
     */
    public void setMovingObject(MovingObject movingObject){
    	this.movingObject = movingObject;
	}

	/**
	 * 
	 */
	public void setMovingObjectDependingOnSelected(){
		if(farmer.isSelected()){
			movingObject = farmer;
		}else if(tractor.isSelected()){
			movingObject = tractor;
		}else if(harvester.isSelected()){
			movingObject = harvester;
		}
	}

	/**
	 * @return
	 */
	public MovingObject getMovingObject(){
    	return movingObject;
	}

	/**
	 * @return
	 */
	public int getSelectedObject(){
        if(farmer.isSelected()){
            selectedObject=1;
        }else if(tractor.isSelected()){
        	if (cultivator.isSelected()) {
        		selectedObject = 4;
			} else if (dumpTruck.isSelected()){
        		selectedObject = 5;
			} else if (seedDrill.isSelected()) {
        		selectedObject = 6;
			} else {
				selectedObject=2;
			}
        }else if(harvester.isSelected()){
            selectedObject=3;
        }
        return selectedObject;
    }

    /**
     * @return
     */
    public int getRow(){
        return movingObject.getY();
    }

    /**
     * @return
     */
    public int getColumn(){
		return movingObject.getX();
    }
/**
     * @return
     */
//    public GameScene reloadGame() {
//        GameScene gameScene = new GameScene();
//		GameController gameController = new GameController();
//        //all numeric values
//        /**
//    	 * This method deserialize the JSONB file. It is also possible to get the values of the cash, the tank filling and the gameday.
//    	 * It implements a new GameValue object by using the class constructor.
//    	 */
//    	GetPojoValue gpv = new GetPojoValue();
//			Game deserializedcash = gpv.toDeserializeGame(toSerializeGameValue());
//			int cash = deserializedcash.getCash();
//						
//			Game deserializedday = gpv.toDeserializeGame(toSerializeGameValue());
//			int day = deserializedday.getDay();
//		
//		gameValue = new GameValue(cash, day);
//    	
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the level of difficulty.
//    	 * It implements a new LevelOfDifficulty object by using the class constructor.
//    	 */
//			Game deserializedlevel = gpv.toDeserializeLevel(toSerializeLevel());
//    		int newLevel = deserializedlevel.getLevel();
//    			
//    	levelOfDifficulty = new LevelOfDifficulty(newLevel);
//    	
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the growth state of field one, the growth state of field two and the growth state of field three.
//    	 * It implements a new FieldTile object by using the class constructor.
//    	 */
//    		Game deserializedft1 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
//			int ft1 = deserializedft1.getGrowthState();
//			
//			Game deserializedft2 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
//			int ft2 = deserializedft2.getGrowthState2();
//			
//			Game deserializedft3 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
//			int ft3 = deserializedft3.getGrowthState3();
//			
//		fieldTile = new FieldTile(ft1, ft2, ft3);
//		    	
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
//    	 * It implements a new Silo object by using the class constructor.
//    	 */
//    	
//			Game deserializedcapacity = gpv.toDeserializeSilo(toSerializeSilo());
//			int capacity = deserializedcapacity.getSiloCapacity();
//			
//		silo = new Silo (capacity);
//    					
//        // all positions
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
//    	 * It implements a new position (x and y value) of the farmer.
//    	 * 
//    	 */
////		
////		farmer.setX(getFarmerX());
////		
////		Jsonb jsonb = JsonbBuilder.create();
////		
////		String serializedsf = jsonb.toJson(farmer);
////				//System.out.println(serializedsf);
////			
////				Farmer deserializedfX = jsonb.fromJson(serializedsf, Farmer.class);
////				int xf = deserializedfX.getX();
////				System.out.println(xf);
////				
////				Farmer deserializedfY = jsonb.fromJson(serializedsf, Farmer.class);
////				int yf = deserializedfY.getY();
////				
////				Farmer deserializedSelectedf = jsonb.fromJson(serializedsf, Farmer.class);
////				boolean selectedf = deserializedSelectedf.isSelected();
////				
////				farmer = new Farmer(xf, yf, selectedf);
//		
//		GetPojoMovingObject gpp = new GetPojoMovingObject();
////			Farmer deserializedfX = gpp.toDeserializeFarmer(toSerializeFarmer());
////			int xf = deserializedfX.getX();
////			System.out.println(xf);
////
////			Farmer deserializedfY = gpp.toDeserializeFarmer(toSerializeFarmer());
////			int yf = deserializedfY.getY();
////
////			Farmer deserializedSelectedf = gpp.toDeserializeFarmer(toSerializeFarmer());
////			boolean selectedf = deserializedSelectedf.isSelected();
//			
////			Game deserializedfX = gpp.toDeserializeFarmer(toSerializeFarmer());
////			int xf = deserializedfX.getFarmerX();
////			
////			Game deserializedfY = gpp.toDeserializeFarmer(toSerializeFarmer());
////			int yf = deserializedfY.getFarmerY();
////			
////			Game deserializedSelectedf = gpp.toDeserializeFarmer(toSerializeFarmer());
////			boolean selectedf = deserializedSelectedf.isFarmerIsSelected();
//		
//		//farmer = new Farmer(xf, yf, selectedf);
//		
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
//    	 * It implements a new position (x and y value) of the tractor.
//    	 */
//    	
//			Tractor deserializedtX = gpp.toDeserializeTractor(toSerializeTractor());
//    		int xt = deserializedtX.getX();
//    		
//    		Tractor deserializedtY = gpp.toDeserializeTractor(toSerializeTractor());
//    		int yt = deserializedtY.getY();
//    		
//    		Tractor deserializedSelectedt = gpp.toDeserializeTractor(toSerializeTractor());
//    		boolean selectedt = deserializedSelectedt.isSelected();
//    		
//    		Tractor deserializedPetrolTankFillLevelt = gpp.toDeserializeTractor(toSerializeTractor());
//    		int petrolTankFillLevelt = deserializedPetrolTankFillLevelt.getPetrolTankFillLevel();
//    		
//    		Tractor deserializedAttachementt = gpp.toDeserializeTractor(toSerializeTractor());
//    		boolean attachementt = deserializedAttachementt.isAttachement();
//    		
//		tractor = new Tractor(xt, yt, selectedt, petrolTankFillLevelt, attachementt);
//    		
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
//    	 * It implements a new position (x and y value) of the harvester.
//    	 */
//    	
//			Game deserializedhX = gpp.toDeserializeHarvester(toSerializeHarvester());
//    		int xh = deserializedhX.getHarvesterX();
//    		
//    		Game deserializedhY = gpp.toDeserializeHarvester(toSerializeHarvester());
//    		int yh = deserializedhY.getHarvesterY();
//    		
//    		Game deserializedSelectedh = gpp.toDeserializeHarvester(toSerializeHarvester());
//    		boolean selectedh = deserializedSelectedh.isHarvesterIsSelected();
//    		
//    		Game deserializedPetrolTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
//    		int petrolTankFillLevelh = deserializedPetrolTankFillLevelh.getHarvesterPetrolTankFillLevel();
//    		
//    		Game deserializedGrainTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
//    		int grainTankFillLevelh = deserializedGrainTankFillLevelh.getHarvesterGrainTankFillLevel();
//    		
//		harvester = new Harvester(xh, yh, selectedh, petrolTankFillLevelh, grainTankFillLevelh);
//    	
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
//    	 * It implements a new position (x and y value) of the harvester.
//    	 */
//    		
//			Game deserializedcX = gpp.toDeserializeCultivator(toSerializeCultivator());
//    		int xc = deserializedcX.getCultivatorX();
//    		
//    		Game deserializedcY = gpp.toDeserializeCultivator(toSerializeCultivator());
//    		int yc = deserializedcY.getCultivatorY();
//    		
//    		Game deserializedSelectedc = gpp.toDeserializeCultivator(toSerializeCultivator());
//    		boolean selectedc = deserializedSelectedc.isCultivatorIsSelected();
//    		
//		cultivator = new Cultivator(xc, yc, selectedc);
//    		
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
//    	 * It implements a new position (x and y value) of the harvester.
//    	 */
//    	
//			Game deserializeddtX = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
//    		int xdt = deserializeddtX.getDumpTruckX();
//    		
//    		Game deserializeddtY = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
//    		int ydt = deserializeddtY.getDumpTruckY();
//    		
//    		Game deserializedSelecteddt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
//    		boolean selecteddt = deserializedSelecteddt.isDumpTruckIsSelected();
//    		
//    		Game deserializedGrainFillLeveldt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
//    		int grainFillLeveldt = deserializedGrainFillLeveldt.getDumpTruckGrainFillLevel();
//    		
//		dumpTruck = new DumpTruck(xdt, ydt, selecteddt, grainFillLeveldt);
//    		
//    	/**
//    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
//    	 * It implements a new position (x and y value) of the harvester.
//    	 */
//    		
//			Game deserializedsdX = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
//    		int xsd = deserializedsdX.getSeedDrillX();
//    		
//    		Game deserializedsdY = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
//    		int ysd = deserializedsdY.getSeedDrillY();
//    		
//    		Game deserializedSelectedsd = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
//    		boolean selectedsd = deserializedSelectedsd.isSeedDrillIsSelected();
//    		
//		seedDrill = new SeedDrill(xsd, ysd, selectedsd);
//		
//		 GameController gameController2 = new GameController();
//
//	        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
//	                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
//	                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow(),
//					gameController2);
//			gameScene.getInformationBox().getSiloField().setText("Corn in silo: " + silo.getCapacityAsString());
//			gameScene.getInformationBox().getHarvesterField().setText(harvester.getPetrolTankFillLevelAsString());
//			gameScene.getInformationBox().getTractorField().setText(tractor.getPetrolTankFillLevelAsString());
//			gameScene.getInformationBox().getTimeField().setText(gameValue.getDayAsString());
//			gameScene.getInformationBox().getMoneyField().setText(gameValue.getCashAsString());
//	        System.out.println(getSelectedObject());
//	        System.out.println(getColumn());
//	        System.out.println(getRow());
//	        selectedObject = getSelectedObject();
//	        MovingObjectController movingObjectController2 = new MovingObjectController(gameScene, movingObject,
//					gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile);
//			gameController2.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController2);
//	        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
//	        return gameScene;
//    }
}