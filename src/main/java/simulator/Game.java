package simulator;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.tiles.CourtTrade;
import datastorage.ObjectToPojo;
import gameboard.GameValue;
import gameboard.LevelOfDifficulty;
import gameboard.tiles.Silo;
import gui.controller.GameController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.controller.MovingObjectController;
import gui.controller.SavingController;
import gui.model.GameInformation;
import gui.view.GameScene;

/**
 * this class deals with staring a new game and reloading an old game status. 
 * @author Isabel, Judith
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
	GameController gameController;

	/**
	 * This method deals with starting a new game, the param Level Of Difficulty has to be transferred.
	 * @param lod
	 * This param decides how the new game objects: 
	 * levelofdifficulty, dumptruck, seeddrill, fieldtile, gamevalue, courttrade and silo are implemented.
	 * the other objects are implemented with an empty constructor.
	 * @return the gameScene
	 */
	public GameScene createNewGame(int lod){
		levelOfDifficulty = new LevelOfDifficulty(lod);
    	farmer = new Farmer();
    	tractor = new Tractor();
        harvester = new Harvester();
        cultivator = new Cultivator();
        dumpTruck = new DumpTruck(lod);
        seedDrill = new SeedDrill();
        fieldTile = new FieldTile(lod);
        gameValue = new GameValue(lod);
        courtTrade = new CourtTrade(lod);
        silo = new Silo(lod);

        	movingObject = farmer;
        	gameController = new GameController();
	        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
					cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
					fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), 1, farmer.getX(), farmer.getY(),
					gameController);
			MovingObjectController movingObjectController = new MovingObjectController(gameScene, movingObject,
					gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile,
					silo, courtTrade);
    	    selectedObject = getSelectedObject();
        	fillInformationFields(gameScene, silo, harvester, tractor, gameValue);
			gameController.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController);
    	    GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
    	    SavingController sc = new SavingController();
        	sc.createFunctionality(gameScene, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill,
					fieldTile, silo, levelOfDifficulty, courtTrade, movingObject);

        	return gameScene;
    }


//    private void getSelectedObject(Farmer farmer, Tractor tractor, Harvester harvester, Cultivator cultivator,
//								   DumpTruck dumpTruck, SeedDrill seedDrill){
//		if (farmer.isSelected()){
//			selectedObject = 1;
//		} else if (tractor.isSelected()) {
//			if (cultivator.isSelected()) {
//				selectedObject = 4;
//			} else if (dumpTruck.isSelected()){
//				if (dumpTruck.getGrainFillLevel() == 0) {
//					selectedObject = 5;
//				} else {
//					selectedObject = 6;
//				}
//			} else if (seedDrill.isSelected()) {
//				selectedObject = 7;
//			} else {
//				selectedObject = 2;
//			}
//		} else if (harvester.isSelected()) {
//			selectedObject = 3;
//		}
//	}

	/**
	 * this method is there to get the X-Coordinate of the selected Moving Object
	 * @param movingObject
	 * @return
	 */
	private int getX(MovingObject movingObject){
		return movingObject.getX();
	}

	/**
	 * this method is there to get the Y-Coordinate of the selected Moving Object
	 * @param movingObject
	 * @return
	 */
	private int getY(MovingObject movingObject){
		return movingObject.getY();
	}


	/**
	 * this method is there to fill the information fields in the game scene
	 * with the belonging properties
	 * @param gameScene
	 * @param silo
	 * @param harvester
	 * @param tractor
	 * @param gameValue
	 */
	private void fillInformationFields(GameScene gameScene, Silo silo, Harvester harvester, Tractor tractor,
									   GameValue gameValue){
		gameScene.getInformationBox().getSiloField().setText("corn in silo: " + silo.getFillLevelAsString());
		gameScene.getInformationBox().getHarvesterField().setText("petrol harvester: " + harvester.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTractorField().setText("petrol tractor: " + tractor.getPetrolTankFillLevelAsString());
		gameScene.getInformationBox().getTimeField().setText("day: " + gameValue.getDayAsString());
		gameScene.getInformationBox().getMoneyField().setText("money: " + gameValue.getCashAsString());
	}


	/**
	 * this method is there to determine the currently selected object 
	 * when reloading the game
	 * @return
	 */
	public int getSelectedObject(){
        if(farmer.isSelected()){
            selectedObject=1;
        }else if(tractor.isSelected()){
        	if (cultivator.isSelected()) {
        		selectedObject = 4;
			} else if (dumpTruck.isSelected()){
        		if (dumpTruck.getGrainFillLevel() == 0) {
					selectedObject = 5;
				} else {
        			selectedObject =6;
				}
			} else if (seedDrill.isSelected()) {
        		selectedObject = 7;
			} else {
				selectedObject=2;
			}
        }else if(harvester.isSelected()){
            selectedObject=3;
        }
        return selectedObject;
    }

	/**
	 * This method proofs, which moving object is selected, sets it as the moving object, and sets the x- and y-values
	 * to the ones of the moving object. This method is used for reloading the game.
	 */
	private void setMovingObject(){
		if(farmer.isSelected()){
			farmer.setX(movingObject.getX());
			farmer.setY(movingObject.getY());
			movingObject = farmer;
		}else if(tractor.isSelected()){
			if (tractor.isSelected()) {
				tractor.setX(movingObject.getX());
				tractor.setY(movingObject.getY());
				movingObject = tractor;
			}
		}else if(harvester.isSelected()){
			harvester.setX(movingObject.getX());
			harvester.setY(movingObject.getY());
			movingObject = harvester;
		}
	}


    /**
     * this method represents the functionality to reload the game after having saved it
     * It's the other part of the saving process. The serialized JSON-B in the String Array, is deserialized into a new dedicated object.
     * All saved information are set in the constructor of the new dedicated object.
     * @return new gameScene
     */
    public GameScene reloadGame() {
    	ObjectToPojo otp = new ObjectToPojo();
    	otp.toDeserialize();
        GameScene gameScene = new GameScene();
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
    	movingObject = jb.fromJson(deserializedGame[11], MovingObject.class);

		setMovingObject();

		gameController = new GameController();
		gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
				cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
				fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(), getX(movingObject), getY(movingObject),
				gameController);
		MovingObjectController movingObjectController = new MovingObjectController(gameScene, movingObject,
				gameController, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile,
				silo, courtTrade);
		selectedObject = getSelectedObject();
		fillInformationFields(gameScene, silo, harvester, tractor, gameValue);
		gameController.initGameLoop(gameScene, fieldTile, gameValue, movingObjectController);
		GameInformation gameInformation = new GameInformation(gameScene.getInformationBox(), gameValue, tractor, harvester, silo);
		gameScene.getMatchfield().fillWithField1(fieldTile.getIndexesField1ForMatchfield(),
				fieldTile.getTilesField1CompletedForMatchfield(), fieldTile.getGrowthState());
		SavingController sc = new SavingController();
		sc.createFunctionality(gameScene, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill,
				fieldTile, silo, levelOfDifficulty, courtTrade, movingObject);

		return gameScene;
    }
}