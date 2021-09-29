package gui.controller;

import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import datastorage.ObjectToJsonb;
import gameboard.GameValue;
import gameboard.LevelOfDifficulty;
import javafx.application.Platform;
import gameboard.tiles.Silo;
import gui.view.GameScene;
import java.util.concurrent.TimeUnit;

/**
 * This class implements the functionality of the save & end button of the informationBox of the gameScene. It saves the
 * game to a text file with an object of the class ObjectToJsonb and the method toSerialize(). After saving it waits for
 * two seconds and then ends the game.
 *
 * @author Isabel
 * @author Judith
 */
public class SavingController {

	/**
	 * This method implements the functionality of the save & end button. It sets the game to sleep for two seconds
	 * before closing it.
	 *
	 * @param gameScene the gameScene object of the actual game
	 * @param gameValue the gameValue object of the actual game
	 * @param farmer the farmer object of the actual game
	 * @param tractor the tractor object of the actual game
	 * @param harvester the harvester object of the actual game
	 * @param cultivator the cultivator object of the actual game
	 * @param dumpTruck the dumpTruck object of the actual game
	 * @param seedDrill the seedDrill object of the actual game
	 * @param fieldTile the fieldTile object of the actual game
	 * @param silo the silo object of the actual game
	 * @param levelOfDifficulty the levelOfDifficulty object of the actual game
	 * @param courtTrade the courtTrade object of the actual game
	 * @param movingObject the movingObject object of the actual game
	 */
	public void createFunctionality(GameScene gameScene, GameValue gameValue, Farmer farmer, Tractor tractor,
									Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck,
									SeedDrill seedDrill, FieldTile fieldTile, Silo silo,
									LevelOfDifficulty levelOfDifficulty, CourtTrade courtTrade, MovingObject movingObject){
		ObjectToJsonb otj = new ObjectToJsonb();
        gameScene.getInformationBox().getSaveButton().setOnMouseClicked(mouseEvent -> {
      	otj.toSerialize(gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile, silo,
				levelOfDifficulty, courtTrade, movingObject);
      	// sleep for two seconds so the game doesn't close immediately after clicking on the button end & save
      	try {
      		TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			close();
	    });
	}

	/**
	 * This method closes the program.
	 */
	private void close(){
		Platform.exit();
		System.exit(0);
	}
}
