package gui.controller;

import gameboard.objects.Farmer;
import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.tiles.FieldTile;
import datastorage.ObjectToJsonb;
import gameboard.GameValue;
import gameboard.objects.Harvester;
import simulator.LevelOfDifficulty;
import gameboard.objects.SeedDrill;
import gameboard.tiles.Silo;
import gui.view.GameScene;
import gameboard.objects.Tractor;

public class SavingController {
	
	 public void createFunctionality(GameScene gameScene, GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile, Silo silo, LevelOfDifficulty levelOfDifficulty){
	        ObjectToJsonb otj = new ObjectToJsonb();
	        gameScene.getInformationBox().getMenuButton().setOnMouseClicked(mouseEvent -> {
	        	otj.toSerialize(gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile, silo, levelOfDifficulty);
	            
	        });
	      
	    }

}
