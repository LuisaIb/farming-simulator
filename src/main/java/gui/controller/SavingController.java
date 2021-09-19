package gui.controller;

import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import datastorage.ObjectToJsonb;
import gameboard.GameValue;
import gui.view.ViewManager;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.stage.Stage;
import simulator.LevelOfDifficulty;
import gameboard.tiles.Silo;
import gui.view.GameScene;

import java.util.concurrent.TimeUnit;

public class SavingController {

	 /**
	 * @param gameScene
	 * @param gameValue
	 * @param farmer
	 * @param tractor
	 * @param harvester
	 * @param cultivator
	 * @param dumpTruck
	 * @param seedDrill
	 * @param fieldTile
	 * @param silo
	 * @param levelOfDifficulty
	 * @param courtTrade
	 */
	public void createFunctionality(GameScene gameScene, GameValue gameValue, Farmer farmer, Tractor tractor,
									Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck,
									SeedDrill seedDrill, FieldTile fieldTile, Silo silo,
									LevelOfDifficulty levelOfDifficulty, CourtTrade courtTrade, MovingObject movingObject){
	        ObjectToJsonb otj = new ObjectToJsonb();

	        gameScene.getInformationBox().getMenuButton().setOnMouseClicked(mouseEvent -> {
	        	otj.toSerialize(gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile, silo, levelOfDifficulty, courtTrade, movingObject);
				gameScene.getInformationBox().getNewsField().setText("game saved");
			try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				close();
	        });
	    }
	    private void close(){
			Platform.exit();
			System.exit(0);
		}

}
