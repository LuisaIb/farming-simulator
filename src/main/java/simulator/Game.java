package simulator;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import datastorage.pojo.GetPojoMovingObject;
import datastorage.pojo.GetPojoValue;
import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.Silo;
import gui.controller.GameController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.model.GameInformation;
import gui.view.GameScene;


/**
 * @author Isabel
 *
 */
public class Game {

    MovingObject movingObject = new MovingObject();
    private Farmer farmer;
    private int farmerX;
    private int farmerY;
    private boolean farmerIsSelected;
    
    private Tractor tractor;
    private int tractorX;
    private int tractorY;
    private boolean tractorIsSelected;
    private int tractorPetrolTankFillLevel;
    private boolean tractorIsAttachment;
    
    private Harvester harvester;
    private int harvesterX;
    private int harvesterY;
    private boolean harvesterIsSelected;
    private int harvesterPetrolTankFillLevel;
    private int harvesterGrainTankFillLevel;
    
    private Cultivator cultivator;
    private int cultivatorX;
    private int cultivatorY;
    private boolean cultivatorIsSelected;
    
    private DumpTruck dumpTruck;
    private int dumpTruckX;
    private int dumpTruckY;
    private boolean dumpTruckIsSelected;
    private int dumpTruckGrainFillLevel;
    
    private SeedDrill seedDrill;
    private int seedDrillX;
    private int seedDrillY;
    private boolean seedDrillIsSelected;
    
    private FieldTile fieldTile;
    private int growthState;
    private int growthState2;
    private int growthState3;
    
    private int selectedObject;
    
    private GameValue gameValue;
    private int cash;
    private int day;
    
    private LevelOfDifficulty levelOfDifficulty;
    private int level;
    
    private Silo silo;
    private int siloCapacity;

    
    private CourtTrade courtTrade;
   


	public GameScene createNewGame(){
        GameScene gameScene = new GameScene();
        	farmer = new Farmer();
        	System.out.println(farmer.getX());
        	setFarmerX(farmer.getX());
        	System.out.println(getFarmerX());
        	setFarmerY(farmer.getY());
        	setFarmerIsSelected(farmer.isSelected());
        	
        	tractor = new Tractor();
        	setTractorX(tractor.getX());
        	setTractorY(tractor.getY());
        	setTractorIsSelected(tractor.isSelected());
        	setTractorPetrolTankFillLevel(tractor.getPetrolTankFillLevel());
        	setTractorIsAttachment(tractor.isAttachement());
        	
	        harvester = new Harvester();
	        setHarvesterX(harvester.getX());
	        setHarvesterY(harvester.getY());
	        setHarvesterIsSelected(harvester.isSelected());
	        setHarvesterPetrolTankFillLevel(harvester.getPetrolTankFillLevel());
	        setHarvesterGrainTankFillLevel(harvester.getGrainTankFillLevel());
	       
	        
	        cultivator = new Cultivator();
	        setCultivatorX(cultivator.getX());
	        setCultivatorY(cultivator.getY());
	        setCultivatorIsSelected(cultivator.isSelected());
	        
	        dumpTruck = new DumpTruck();
	        setDumpTruckX(dumpTruck.getX());
	        setDumpTruckY(dumpTruck.getY());
	        setDumpTruckIsSelected(dumpTruck.isSelected());
	        setDumpTruckGrainFillLevel(dumpTruck.getGrainFillLevel());
	        
	        seedDrill = new SeedDrill();
	        setSeedDrillX(seedDrill.getX());
	        setSeedDrillY(seedDrill.getY());
	        setSeedDrillIsSelected(seedDrill.isSelected());
	        
	        fieldTile = new FieldTile();
	        setGrowthState(fieldTile.getGrowthState());
	        setGrowthState2(fieldTile.getGrowthState2());
	        setGrowthState3(fieldTile.getGrowthState3());

	        gameValue = new GameValue();
	        setCash(gameValue.getCash());
	        setDay(gameValue.getDay());
	        
	        levelOfDifficulty = new LevelOfDifficulty(2);
	        setLevel(levelOfDifficulty.getLevel());
	        
	        silo = new Silo();
	        setSiloCapacity(silo.getCapacity());
	        
	        courtTrade = new CourtTrade();

        movingObject = farmer;
        GameController gameController = new GameController();
        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
		gameScene.getInformationBox().getSiloField().setText("Corn in silo: " + silo.getCapacityAsString());
		gameScene.getInformationBox().getHarvesterField().setText(harvester.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTractorField().setText(tractor.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTimeField().setText(gameValue.getDayAsString());
		gameScene.getInformationBox().getMoneyField().setText(gameValue.getCashAsString());
        System.out.println(getSelectedObject());
        System.out.println(getColumn());
        System.out.println(getRow());
        selectedObject = getSelectedObject();
		gameController.initGameLoop(gameScene, fieldTile, getMovingObject(), getSelectedObject(), gameValue, gameScene.getSideControlPane(), farmer, tractor,
				harvester, cultivator, dumpTruck, seedDrill);
        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
        return gameScene;
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
		if(isFarmerIsSelected()){
			movingObject = farmer;
		}else if(isTractorIsSelected()){
			movingObject = tractor;
		}else if(isHarvesterIsSelected()){
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
        if(isFarmerIsSelected()){
            selectedObject=1;
        }else if(isTractorIsSelected()){
        	if (isCultivatorIsSelected()) {
        		selectedObject = 4;
			} else if (isDumpTruckIsSelected()){
        		selectedObject = 5;
			} else if (isSeedDrillIsSelected()) {
        		selectedObject = 6;
			} else {
				selectedObject=2;
			}
        }else if(isHarvesterIsSelected()){
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

    // all numeric values
	/**
	 * This method gets the values of the cash, the filling and the gameday of the class GameValue.
	 * @return serialized as a JSONB object of the cash, filling values and the day.
	 */
	public String toSerializeGameValue() {
//		gameValue = new GameValue(120, 6);
//		gameValue.getCash();
//		gameValue.getDay();
		Game ggv = new Game();
		ggv.cash = getCash();
		ggv.day = getDay();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedGameValue = jsonb.toJson(ggv);
		return serializedGameValue;
	}
    		
   
    	/**
	 * This method gets the value of the level of difficulty of the class LevelOfDifficulty.
	 * @return serialized as a JSONB object of the level of difficulty.
	 */
	public String toSerializeLevel() {
//		levelOfDifficulty = new LevelOfDifficulty(3);
//   	levelOfDifficulty.getLevel();
		Game gl = new Game();
		gl.cash = getLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedlod = jsonb.toJson(gl);
		return serializedlod;
	}
	
	/**
	 * This method gets the growth state of all three fields of the class FieldTile.
	 * @return serialized as a JSONB object of the fieldtile's conditions.
	 */
	public String toSerializeFieldtiles() { 
//		fieldTile = new FieldTile(1, 2, 4);
//		fieldTile.getGrowthState(); // get Field id + status of the three fields.
//		fieldTile.getGrowthState2();
//		fieldTile.getGrowthState3();
		Game gft = new Game();
		gft.growthState = getGrowthState();
		gft.growthState2 = getGrowthState2();
		gft.growthState3 = getGrowthState3();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedft = jsonb.toJson(gft);
		return serializedft;
	}
	
	/**
	 * This method gets the filling of the silo.
	 * @return serialized as a JSONB object of the Silo's conditions.
	 */
	public String toSerializeSilo() { 
//		silo = new Silo(36);
//		silo.getCapacity();
		Game gs = new Game();
		gs.siloCapacity = getSiloCapacity();
		Jsonb jsonb = JsonbBuilder.create();
		String serializeds = jsonb.toJson(gs);
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
     * @param
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmer(int x, int y, boolean b) {
	
		farmer = new Farmer(x, y, b);
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsf = jsonb.toJson(farmer);
		
		
//		setFarmerX(5);
//		getFarmerY();
//		isFarmerIsSelected();
//		Jsonb jsonb = JsonbBuilder.create();
//		String serializedsf = jsonb.toJson(farmer);
		
		return serializedsf;
	}
	
	/**
	 * This method gets the position of the tractor of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeTractor() {
//		tractor = new Tractor(18, 7, false, 100, false);
//		tractor.getX();
//		tractor.getY();
//		tractor.isSelected();
//		tractor.getPetrolTankFillLevel();
//		tractor.isAttachement();
//		Jsonb jsonb = JsonbBuilder.create();
		Game gt = new Game();
		gt.tractorX = getTractorX();
		gt.tractorY = getTractorY();
		gt.tractorIsSelected = isTractorIsSelected();
		gt.tractorPetrolTankFillLevel = getTractorPetrolTankFillLevel();
		gt.tractorIsAttachment = isTractorIsAttachment();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedst = jsonb.toJson(gt);
		return serializedst;
	}
	
	/**
	 * This method gets the position of the harvester of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvester() { 
//		harvester = new Harvester(18, 7, false, 5, 5);
//		harvester.getX();
//		harvester.getY();
//		harvester.isSelected();
//		harvester.getPetrolTankFillLevel();
//		harvester.getGrainTankFillLevel();
//		Jsonb jsonb = JsonbBuilder.create();
		Game gh = new Game();
		gh.harvesterX = getHarvesterX();
		gh.harvesterY = getHarvesterY();
		gh.harvesterIsSelected = isHarvesterIsSelected();
		gh.harvesterPetrolTankFillLevel = getHarvesterPetrolTankFillLevel();
		gh.harvesterGrainTankFillLevel = getHarvesterGrainTankFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsh = jsonb.toJson(gh);
		System.out.println(serializedsh);
		return serializedsh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeCultivator() { 
//		cultivator = new Cultivator(18,7,false);
//		cultivator.getX();
//		cultivator.getY();
//		cultivator.isSelected();
		Game gc = new Game();
		gc.cultivatorX = getCultivatorX();
		gc.cultivatorY = getCultivatorY();
		gc.cultivatorIsSelected = isCultivatorIsSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsc = jsonb.toJson(gc);
		return serializedsc;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeDumpTruck() { 
//		dumpTruck = new DumpTruck(18,7,false,5);
//		dumpTruck.getX();
//		dumpTruck.getY();
//		dumpTruck.isSelected();
//		dumpTruck.getGrainFillLevel();
		Game gdt = new Game();
		gdt.dumpTruckX = getDumpTruckX();
		gdt.dumpTruckY = getDumpTruckY();
		gdt.dumpTruckIsSelected = isDumpTruckIsSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsdt = jsonb.toJson(gdt);
		return serializedsdt;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeSeedDrill() {
//		seedDrill = new SeedDrill(18,7,false);
//		seedDrill.getX();
//		seedDrill.getY();
//		seedDrill.isSelected();
		Game gsd = new Game();
		gsd.seedDrillX = getSeedDrillX();
		gsd.seedDrillY = getSeedDrillY();
		gsd.seedDrillIsSelected = isSeedDrillIsSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedssd = jsonb.toJson(gsd);
		return serializedssd;
	}
    

    /**
     * @return
     */
    public GameScene reloadGame() {
        GameScene gameScene = new GameScene();
		GameController gameController = new GameController();
        //all numeric values
        /**
    	 * This method deserialize the JSONB file. It is also possible to get the values of the cash, the tank filling and the gameday.
    	 * It implements a new GameValue object by using the class constructor.
    	 */
    	GetPojoValue gpv = new GetPojoValue();
			Game deserializedcash = gpv.toDeserializeGame(toSerializeGameValue());
			int cash = deserializedcash.getCash();
						
			Game deserializedday = gpv.toDeserializeGame(toSerializeGameValue());
			int day = deserializedday.getDay();
		
		gameValue = new GameValue(cash, day);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the level of difficulty.
    	 * It implements a new LevelOfDifficulty object by using the class constructor.
    	 */
			Game deserializedlevel = gpv.toDeserializeLevel(toSerializeLevel());
    		int newLevel = deserializedlevel.getLevel();
    			
    	levelOfDifficulty = new LevelOfDifficulty(newLevel);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the growth state of field one, the growth state of field two and the growth state of field three.
    	 * It implements a new FieldTile object by using the class constructor.
    	 */
    		Game deserializedft1 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft1 = deserializedft1.getGrowthState();
			
			Game deserializedft2 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft2 = deserializedft2.getGrowthState2();
			
			Game deserializedft3 = gpv.toDeserializeFieldtiles(toSerializeFieldtiles());
			int ft3 = deserializedft3.getGrowthState3();
			
		fieldTile = new FieldTile(ft1, ft2, ft3);
		    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
    	 * It implements a new Silo object by using the class constructor.
    	 */
    	
			Game deserializedcapacity = gpv.toDeserializeSilo(toSerializeSilo());
			int capacity = deserializedcapacity.getSiloCapacity();
			
		silo = new Silo (capacity);
    		
       	/**
    	 * This method deserialize the JSONB file. It is also possible to get the capacity of the silo.
    	 * It implements a new Silo object by using the class constructor.
    	 */
    	
			Game deserializedGrainFillLevel = gpv.toDeserializeCourtTrade(toSerializeCourtTrade());
			int grainFillLevel = deserializedGrainFillLevel.getDumpTruckGrainFillLevel();
			
			//cash Variable, ggf GameValue l�schen und cash zum hofladen
			
		courtTrade = new CourtTrade(grainFillLevel);
    					
        // all positions
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
    	 * It implements a new position (x and y value) of the farmer.
    	 */
		GetPojoMovingObject gpp = new GetPojoMovingObject();
			Farmer deserializedfX = gpp.toDeserializeFarmer(toSerializeFarmer(getFarmerX(), getFarmerY(), isFarmerIsSelected()));
			int xf = deserializedfX.getX();
			System.out.println(xf);
			
			Farmer deserializedfY = gpp.toDeserializeFarmer(toSerializeFarmer(getFarmerX(), getFarmerY(), isFarmerIsSelected()));
			int yf = deserializedfY.getY();
			
			Farmer deserializedSelectedf = gpp.toDeserializeFarmer(toSerializeFarmer(getFarmerX(), getFarmerY(), isFarmerIsSelected()));
			boolean selectedf = deserializedSelectedf.isSelected();
			
//			Game deserializedfX = gpp.toDeserializeFarmer(toSerializeFarmer());
//			int xf = deserializedfX.getFarmerX();
//			
//			Game deserializedfY = gpp.toDeserializeFarmer(toSerializeFarmer());
//			int yf = deserializedfY.getFarmerY();
//			
//			Game deserializedSelectedf = gpp.toDeserializeFarmer(toSerializeFarmer());
//			boolean selectedf = deserializedSelectedf.isFarmerIsSelected();
		
		farmer = new Farmer(xf, yf, selectedf);
		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
    	 * It implements a new position (x and y value) of the tractor.
    	 */
    	
			Game deserializedtX = gpp.toDeserializeTractor(toSerializeTractor());
    		int xt = deserializedtX.getTractorX();
    		
    		Game deserializedtY = gpp.toDeserializeTractor(toSerializeTractor());
    		int yt = deserializedtY.getTractorY();
    		
    		Game deserializedSelectedt = gpp.toDeserializeTractor(toSerializeTractor());
    		boolean selectedt = deserializedSelectedt.isTractorIsSelected();
    		
    		Game deserializedPetrolTankFillLevelt = gpp.toDeserializeTractor(toSerializeTractor());
    		int petrolTankFillLevelt = deserializedPetrolTankFillLevelt.getTractorPetrolTankFillLevel();
    		
    		Game deserializedAttachementt = gpp.toDeserializeTractor(toSerializeTractor());
    		boolean attachementt = deserializedAttachementt.isTractorIsAttachment();
    		
		tractor = new Tractor(xt, yt, selectedt, petrolTankFillLevelt, attachementt);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    	
			Game deserializedhX = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int xh = deserializedhX.getHarvesterX();
    		
    		Game deserializedhY = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int yh = deserializedhY.getHarvesterY();
    		
    		Game deserializedSelectedh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		boolean selectedh = deserializedSelectedh.isHarvesterIsSelected();
    		
    		Game deserializedPetrolTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int petrolTankFillLevelh = deserializedPetrolTankFillLevelh.getHarvesterPetrolTankFillLevel();
    		
    		Game deserializedGrainTankFillLevelh = gpp.toDeserializeHarvester(toSerializeHarvester());
    		int grainTankFillLevelh = deserializedGrainTankFillLevelh.getHarvesterGrainTankFillLevel();
    		
		harvester = new Harvester(xh, yh, selectedh, petrolTankFillLevelh, grainTankFillLevelh);
    	
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    		
			Game deserializedcX = gpp.toDeserializeCultivator(toSerializeCultivator());
    		int xc = deserializedcX.getCultivatorX();
    		
    		Game deserializedcY = gpp.toDeserializeCultivator(toSerializeCultivator());
    		int yc = deserializedcY.getCultivatorY();
    		
    		Game deserializedSelectedc = gpp.toDeserializeCultivator(toSerializeCultivator());
    		boolean selectedc = deserializedSelectedc.isCultivatorIsSelected();
    		
		cultivator = new Cultivator(xc, yc, selectedc);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    	
			Game deserializeddtX = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int xdt = deserializeddtX.getDumpTruckX();
    		
    		Game deserializeddtY = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int ydt = deserializeddtY.getDumpTruckY();
    		
    		Game deserializedSelecteddt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		boolean selecteddt = deserializedSelecteddt.isDumpTruckIsSelected();
    		
    		Game deserializedGrainFillLeveldt = gpp.toDeserializeDumpTruck(toSerializeDumpTruck());
    		int grainFillLeveldt = deserializedGrainFillLeveldt.getDumpTruckGrainFillLevel();
    		
		dumpTruck = new DumpTruck(xdt, ydt, selecteddt, grainFillLeveldt);
    		
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
    		
			Game deserializedsdX = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		int xsd = deserializedsdX.getSeedDrillX();
    		
    		Game deserializedsdY = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		int ysd = deserializedsdY.getSeedDrillY();
    		
    		Game deserializedSelectedsd = gpp.toDeserializeSeedDrill(toSerializeSeedDrill());
    		boolean selectedsd = deserializedSelectedsd.isSeedDrillIsSelected();
    		
		seedDrill = new SeedDrill(xsd, ysd, selectedsd);
		
		 GameController gameController2 = new GameController();
	        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
	                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
	                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
			gameScene.getInformationBox().getSiloField().setText("Corn in silo: " + silo.getCapacityAsString());
			gameScene.getInformationBox().getHarvesterField().setText(harvester.getPetrolTankFillLevelAsString());
			gameScene.getInformationBox().getTractorField().setText(tractor.getPetrolTankFillLevelAsString());
			gameScene.getInformationBox().getTimeField().setText(gameValue.getDayAsString());
			gameScene.getInformationBox().getMoneyField().setText(gameValue.getCashAsString());
	        System.out.println(getSelectedObject());
	        System.out.println(getColumn());
	        System.out.println(getRow());
	        selectedObject = getSelectedObject();
			gameController2.initGameLoop(gameScene, fieldTile, getMovingObject(), getSelectedObject(), gameValue, gameScene.getSideControlPane(), farmer, tractor,
					harvester, cultivator, dumpTruck, seedDrill);
	        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
	        return gameScene;
    }

	/**
	 * @return x variable of farmer
	 */
	public int getFarmerX() {
		return farmerX;
	}

	/**
	 * @param farmerX
	 */
	public void setFarmerX(int farmerX) {
		this.farmerX = farmerX;
	}
	
	/**
	 * @return
	 */
	public int getFarmerY() {
		return farmerY;
	}

	/**
	 * @param farmerY
	 */
	public void setFarmerY(int farmerY) {
		this.farmerY = farmerY;
	}
	
	/**
	 * @return
	 */
	public boolean isFarmerIsSelected() {
		return farmerIsSelected;
	}

	/**
	 * @param farmerIsSelected
	 */
	public void setFarmerIsSelected(boolean farmerIsSelected) {
		this.farmerIsSelected = farmerIsSelected;
	}

	/**
	 * @return the tractorX
	 */
	public int getTractorX() {
		return tractorX;
	}

	/**
	 * @param tractorX the tractorX to set
	 */
	public void setTractorX(int tractorX) {
		this.tractorX = tractorX;
	}

	/**
	 * @return the tractorY
	 */
	public int getTractorY() {
		return tractorY;
	}

	/**
	 * @param tractorY the tractorY to set
	 */
	public void setTractorY(int tractorY) {
		this.tractorY = tractorY;
	}

	/**
	 * @return the tractorIsSelected
	 */
	public boolean isTractorIsSelected() {
		return tractorIsSelected;
	}

	/**
	 * @param tractorIsSelected the tractorIsSelected to set
	 */
	public void setTractorIsSelected(boolean tractorIsSelected) {
		this.tractorIsSelected = tractorIsSelected;
	}

	/**
	 * @return the tractorPetrolTankFillLevel
	 */
	public int getTractorPetrolTankFillLevel() {
		return tractorPetrolTankFillLevel;
	}

	/**
	 * @param tractorPetrolTankFillLevel the tractorPetrolTankFillLevel to set
	 */
	public void setTractorPetrolTankFillLevel(int tractorPetrolTankFillLevel) {
		this.tractorPetrolTankFillLevel = tractorPetrolTankFillLevel;
	}

	/**
	 * @return the tractorIsAttachment
	 */
	public boolean isTractorIsAttachment() {
		return tractorIsAttachment;
	}

	/**
	 * @param tractorIsAttachment the tractorIsAttachment to set
	 */
	public void setTractorIsAttachment(boolean tractorIsAttachment) {
		this.tractorIsAttachment = tractorIsAttachment;
	}

	/**
	 * @return the harvesterX
	 */
	public int getHarvesterX() {
		return harvesterX;
	}

	/**
	 * @param harvesterX the harvesterX to set
	 */
	public void setHarvesterX(int harvesterX) {
		this.harvesterX = harvesterX;
	}

	/**
	 * @return the harvesterY
	 */
	public int getHarvesterY() {
		return harvesterY;
	}

	/**
	 * @param harvesterY the harvesterY to set
	 */
	public void setHarvesterY(int harvesterY) {
		this.harvesterY = harvesterY;
	}

	/**
	 * @return the harvesterIsSelected
	 */
	public boolean isHarvesterIsSelected() {
		return harvesterIsSelected;
	}

	/**
	 * @param harvesterIsSelected the harvesterIsSelected to set
	 */
	public void setHarvesterIsSelected(boolean harvesterIsSelected) {
		this.harvesterIsSelected = harvesterIsSelected;
	}

	/**
	 * @return the harvesterPetrolTankFillLevel
	 */
	public int getHarvesterPetrolTankFillLevel() {
		return harvesterPetrolTankFillLevel;
	}

	/**
	 * @param harvesterPetrolTankFillLevel the harvesterPetrolTankFillLevel to set
	 */
	public void setHarvesterPetrolTankFillLevel(int harvesterPetrolTankFillLevel) {
		this.harvesterPetrolTankFillLevel = harvesterPetrolTankFillLevel;
	}

	/**
	 * @return the harvesterGrainTankFillLevel
	 */
	public int getHarvesterGrainTankFillLevel() {
		return harvesterGrainTankFillLevel;
	}

	/**
	 * @param harvesterGrainTankFillLevel the harvesterGrainTankFillLevel to set
	 */
	public void setHarvesterGrainTankFillLevel(int harvesterGrainTankFillLevel) {
		this.harvesterGrainTankFillLevel = harvesterGrainTankFillLevel;
	}

	/**
	 * @return the cultivatorX
	 */
	public int getCultivatorX() {
		return cultivatorX;
	}

	/**
	 * @param cultivatorX the cultivatorX to set
	 */
	public void setCultivatorX(int cultivatorX) {
		this.cultivatorX = cultivatorX;
	}

	/**
	 * @return the cultivatorY
	 */
	public int getCultivatorY() {
		return cultivatorY;
	}

	/**
	 * @param cultivatorY the cultivatorY to set
	 */
	public void setCultivatorY(int cultivatorY) {
		this.cultivatorY = cultivatorY;
	}

	/**
	 * @return the cultivatorIsSelected
	 */
	public boolean isCultivatorIsSelected() {
		return cultivatorIsSelected;
	}

	/**
	 * @param cultivatorIsSelected the cultivatorIsSelected to set
	 */
	public void setCultivatorIsSelected(boolean cultivatorIsSelected) {
		this.cultivatorIsSelected = cultivatorIsSelected;
	}

	/**
	 * @return the dumpTruckX
	 */
	public int getDumpTruckX() {
		return dumpTruckX;
	}

	/**
	 * @param dumpTruckX the dumpTruckX to set
	 */
	public void setDumpTruckX(int dumpTruckX) {
		this.dumpTruckX = dumpTruckX;
	}

	/**
	 * @return the dumpTruckY
	 */
	public int getDumpTruckY() {
		return dumpTruckY;
	}

	/**
	 * @param dumpTruckY the dumpTruckY to set
	 */
	public void setDumpTruckY(int dumpTruckY) {
		this.dumpTruckY = dumpTruckY;
	}

	/**
	 * @return the dumpTruckIsSelected
	 */
	public boolean isDumpTruckIsSelected() {
		return dumpTruckIsSelected;
	}

	/**
	 * @param dumpTruckIsSelected the dumpTruckIsSelected to set
	 */
	public void setDumpTruckIsSelected(boolean dumpTruckIsSelected) {
		this.dumpTruckIsSelected = dumpTruckIsSelected;
	}

	/**
	 * @return the dumpTruckGrainFillLevel
	 */
	public int getDumpTruckGrainFillLevel() {
		return dumpTruckGrainFillLevel;
	}

	/**
	 * @param dumpTruckGrainFillLevel the dumpTruckGrainFillLevel to set
	 */
	public void setDumpTruckGrainFillLevel(int dumpTruckGrainFillLevel) {
		this.dumpTruckGrainFillLevel = dumpTruckGrainFillLevel;
	}

	/**
	 * @return the seedDrillX
	 */
	public int getSeedDrillX() {
		return seedDrillX;
	}

	/**
	 * @param seedDrillX the seedDrillX to set
	 */
	public void setSeedDrillX(int seedDrillX) {
		this.seedDrillX = seedDrillX;
	}

	/**
	 * @return the seedDrillY
	 */
	public int getSeedDrillY() {
		return seedDrillY;
	}

	/**
	 * @param seedDrillY the seedDrillY to set
	 */
	public void setSeedDrillY(int seedDrillY) {
		this.seedDrillY = seedDrillY;
	}

	/**
	 * @return the seedDrillIsSelected
	 */
	public boolean isSeedDrillIsSelected() {
		return seedDrillIsSelected;
	}

	/**
	 * @param seedDrillIsSelected the seedDrillIsSelected to set
	 */
	public void setSeedDrillIsSelected(boolean seedDrillIsSelected) {
		this.seedDrillIsSelected = seedDrillIsSelected;
	}

	/**
	 * @return the growthState
	 */
	public int getGrowthState() {
		return growthState;
	}

	/**
	 * @param growthState the growthState to set
	 */
	public void setGrowthState(int growthState) {
		this.growthState = growthState;
	}

	/**
	 * @return the growthState2
	 */
	public int getGrowthState2() {
		return growthState2;
	}

	/**
	 * @param growthState2 the growthState2 to set
	 */
	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
	}

	/**
	 * @return the growthState3
	 */
	public int getGrowthState3() {
		return growthState3;
	}

	/**
	 * @param growthState3 the growthState3 to set
	 */
	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
	}

	/**
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 * @return 
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the siloCapacity
	 */
	public int getSiloCapacity() {
		return siloCapacity;
	}

	/**
	 * @param siloCapacity the siloCapacity to set
	 */
	public void setSiloCapacity(int siloCapacity) {
		this.siloCapacity = siloCapacity;
	}
}
