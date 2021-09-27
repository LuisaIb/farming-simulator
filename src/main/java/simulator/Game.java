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
import gui.view.Matchfield;

/**
 * This class offers methods to start a new game and reloading an old game status.
 * @author Isabel, Judith
 *
 */
public class Game {
	/**
	 * an object of the class MovingObject to hold the different moving objects in the game
	 */
    MovingObject movingObject;
	/**
	 * an object of the class Farmer that is initialized in the methods to start or reload a game
	 */
	private Farmer farmer;
	/**
	 * an object of the class Tractor that is initialized in the methods to start or reload a game
	 */
    private Tractor tractor;
	/**
	 * an object of the class Harvester that is initialized in the methods to start or reload a game
	 */
    private Harvester harvester;
	/**
	 * an object of the class Cultivator that is initialized in the methods to start or reload a game
	 */
    private Cultivator cultivator;
	/**
	 * an object of the class DumpTruck that is initialized in the methods to start or reload a game
	 */
    private DumpTruck dumpTruck;
	/**
	 * an object of the class SeedDrill that is initialized in the methods to start or reload a game
	 */
    private SeedDrill seedDrill;
	/**
	 * an object of the class FieldTile that is initialized in the methods to start or reload a game
	 */
    private FieldTile fieldTile;
	/**
	 * an object of the class CourtTrade that is initialized in the methods to start or reload a game
	 */
    private CourtTrade courtTrade;
	/**
	 * integer to save a value depending on the moving object that is selected
	 */
    private int selectedObject;
	/**
	 * an object of the class GameValue that is initialized in the methods to start or reload a game
	 */
    private GameValue gameValue;
	/**
	 * an object of the class LevelOfDifficulty that is initialized in the methods to start or reload a game
	 */
    private LevelOfDifficulty levelOfDifficulty;
	/**
	 * an object of the class Silo that is initialized in the methods to start or reload a game
	 */
    private Silo silo;
	/**
	 * an object of the class GameScene that is set to the specific GameScene that is implemented when starting or
	 * reloading a game
	 */
    private GameScene gameScene = new GameScene();
	/**
	 * an object of the class GameController that is initialized in the methods to start or reload a game
	 */
	GameController gameController;

	/**
	 * This method deals with starting a new game, the param Level Of Difficulty has to be transferred.
	 *
	 * @param lod
	 * This param decides how the new game objects: 
	 * levelOfDifficulty, dumpTruck, seedDrill, fieldTile, gameValue, courtTrade and silo are implemented.
	 * The other objects are implemented with an empty constructor.
	 *
	 * @return the actual gameScene
	 */
	public GameScene createNewGame(int lod){
		levelOfDifficulty = new LevelOfDifficulty(lod);
		movingObject = new MovingObject();
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
		setMovingObject();
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

	/**
	 * This method returns the x-value of the moving object.
	 *
	 * @param movingObject the MovingObject object of the actual game
	 * @return the requested x-value of the moving object
	 */
	private int getX(MovingObject movingObject){
		return movingObject.getX();
	}

	/**
	 * This method returns the y-value of the moving object.
	 *
	 * @param movingObject the MovingObject object of the actual game
	 * @return the requested y-value of the moving object
	 */
	private int getY(MovingObject movingObject){
		return movingObject.getY();
	}

	/**
	 * This method fills the text fields of the informationBox of the gameScene with the starting values of the game.
	 * As there are bindings implemented to the properties they change automatically.
	 *
	 * @param gameScene the GameScene object of the actual game
	 * @param silo the Silo object of the actual game
	 * @param harvester the Harvester object of the actual game
	 * @param tractor the Tractor object of the actual game
	 * @param gameValue the GameValue object of the actual game
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
	 * This method returns an integer that is set depending on the moving object that is selected.
	 *
	 * @return the integer of the selected moving object
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
			} else { // if there is no attachment to the tractor
				selectedObject=2;
			}
        }else if(harvester.isSelected()){
            selectedObject=3;
        }
        return selectedObject;
    }

	/**
	 * This method checks, which moving object is selected, sets it as the moving object, and sets the x- and y-values
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
     * This method represents the functionality to reload the game after saving and restarting it.
     * It's the second part of the saving process. The serialized JSON-B in the String Array is deserialized into a
	 * new dedicated object. All saved information is set to the constructor of the new dedicated object.
	 *
     * @return the actual gameScene
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
		fillMatchfieldWithFields(fieldTile, gameScene.getMatchfield());
		SavingController sc = new SavingController();
		sc.createFunctionality(gameScene, gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill,
				fieldTile, silo, levelOfDifficulty, courtTrade, movingObject);

		return gameScene;
    }

	/**
	 * This method uses the fillWithField() methods from the class Matchfield to implement the tiles of a field that
	 * have been processed before saving the game.
	 *
	 * @param fieldTile the FieldTile object of the actual game
	 * @param matchfield the Matchfield object of the actual game
	 */
	private void fillMatchfieldWithFields(FieldTile fieldTile, Matchfield matchfield) {
		matchfield.fillWithField1(fieldTile.getIndexesField1ForMatchfield(),
				fieldTile.getTilesField1CompletedForMatchfield(), fieldTile.getGrowthState());
		matchfield.fillWithField2(fieldTile.getIndexesField2ForMatchfield(),
				fieldTile.getTilesField2CompletedForMatchfield(), fieldTile.getGrowthState2());
		matchfield.fillWithField3(fieldTile.getIndexesField3ForMatchfield(),
				fieldTile.getTilesField3CompletedForMatchfield(), fieldTile.getGrowthState3());
	}
}