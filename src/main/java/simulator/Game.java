package simulator;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.tiles.CourtTrade;
import datastorage.ObjectToPojo;
import gameboard.GameValue;
import gameboard.tiles.Silo;
import gui.controller.GameController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.controller.MovingObjectController;
import gui.controller.SavingController;
import gui.model.GameInformation;
import gui.view.GameScene;

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
    private CourtTrade courtTrade;
    private int selectedObject;
    private GameValue gameValue;
    private LevelOfDifficulty levelOfDifficulty;
    private Silo silo;
    private GameScene gameScene = new GameScene();

 

	/**
	 * @param lod
	 * @return
	 */
	public GameScene createNewGame(int lod){
		levelOfDifficulty = new LevelOfDifficulty(lod);

        	farmer = new Farmer();
        	tractor = new Tractor();
	        harvester = new Harvester();
	        cultivator = new Cultivator();
	        dumpTruck = new DumpTruck();
	        seedDrill = new SeedDrill();
	        fieldTile = new FieldTile(lod);
	        gameValue = new GameValue(lod);
	        courtTrade = new CourtTrade(lod);
	        silo = new Silo();

        	movingObject = farmer;

        	GameController gameController = new GameController();

	        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
					cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
					fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), 1, farmer.getX(), farmer.getY(),
					gameController);
			MovingObjectController movingObjectController = new MovingObjectController(gameScene, movingObject,
					gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile);
    	    selectedObject = getSelectedObject();
        	fillInformationFields(gameScene, silo, harvester, tractor, gameValue);
			gameController.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController);
    	    GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);

    	    SavingController sc = new SavingController();
        	sc.createFunctionality(gameScene, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill,
					fieldTile, silo, levelOfDifficulty, courtTrade);

        	return gameScene;
    }


	/**
	 * @param gameScene
	 * @param silo
	 * @param harvester
	 * @param tractor
	 * @param gameValue
	 */
	private void fillInformationFields(GameScene gameScene, Silo silo, Harvester harvester, Tractor tractor,
									   GameValue gameValue){
		gameScene.getInformationBox().getSiloField().setText("corn in silo: " + silo.getCapacityAsString());
		gameScene.getInformationBox().getHarvesterField().setText("petrol harvester: " + harvester.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTractorField().setText("petrol tractor: " + tractor.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTimeField().setText("day: " + gameValue.getDayAsString());
		gameScene.getInformationBox().getMoneyField().setText("money: " + gameValue.getCashAsString());
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
    public GameScene reloadGame() {
    	ObjectToPojo otp = new ObjectToPojo();
    	otp.toDeserialize();
        GameScene gameScene = new GameScene();
		GameController gameController = new GameController();
		String[] deserializedGame = otp.getDeserializedGameObjects();
		System.out.println(deserializedGame[0]);
		Jsonb jb = JsonbBuilder.create();
	
		gameValue = jb.fromJson(deserializedGame[0], GameValue.class);
		farmer = jb.fromJson(deserializedGame[1], Farmer.class);
		tractor = jb.fromJson(deserializedGame[2], Tractor.class);
		harvester = jb.fromJson(deserializedGame[3], Harvester.class);
		cultivator = jb.fromJson(deserializedGame[4], Cultivator.class);
		dumpTruck = jb.fromJson(deserializedGame[5], DumpTruck.class);
		seedDrill = jb.fromJson(deserializedGame[6], SeedDrill.class);
		fieldTile = jb.fromJson(deserializedGame[7], FieldTile.class);
		silo = jb.fromJson(deserializedGame[8], Silo.class);
    	levelOfDifficulty = jb.fromJson(deserializedGame[9], LevelOfDifficulty.class);
    	courtTrade = jb.fromJson(deserializedGame[10], CourtTrade.class);

    	 //all numeric values
        
    	/**
    	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
    	 * It implements a new position (x and y value) of the harvester.
    	 */
		GameController gameController2 = new GameController();

	        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
	                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
	                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(), 1, 1,
					gameController2);
		fillInformationFields(gameScene, silo, harvester, tractor, gameValue);
	        System.out.println(getSelectedObject());
	        selectedObject = getSelectedObject();
	        MovingObjectController movingObjectController2 = new MovingObjectController(gameScene, movingObject,
					gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile);
			gameController2.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController2);
	        GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
	        return gameScene;
    }
}