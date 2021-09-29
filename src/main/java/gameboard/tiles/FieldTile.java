package gameboard.tiles;

import gameboard.GameValue;
import gameboard.objects.Harvester;
import gui.view.GameScene;
import gui.view.InformationBox;
import gui.view.Matchfield;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the three fields, with its several properties and functionalities (i.e. to grow).
 * @author Luisaibele, Judith
 *
 */
public class FieldTile {
	/**
	 * the amount of money the player has to pay for buying a field
	 */
	private int sellingPrice;
	/**
	 * the amount of grain the player gets for harvesting a tile of a field depends on the level of difficulty
	 */
	private int harvest; //the amount of grain you get per part of the field
	/**
	 * boolean that saves whether field 1 is owned by the player in the actual game or now
	 */
	private boolean owningField1; //boolean variable whether you own this field or not
	/**
	 * boolean that saves whether field 2 is owned by the player in the actual game or now
	 */
	private boolean owningField2;
	/**
	 * boolean that saves whether field 3 is owned by the player in the actual game or now
	 */
	private boolean owningField3;
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values the indexes of
	 * the image view on the grid pane of the matchfield for field 1
	 */
	private HashMap<Integer, Integer> indexesField1;
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values booleans that
	 * tell if the specific tile of field 1 has already been processed by the player
	 */
	HashMap<Integer, Boolean> tilesField1Completed = new HashMap<>();
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values the indexes of
	 * the image view on the grid pane of the matchfield for field 2
	 */
	private HashMap<Integer, Integer> indexesField2;
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values booleans that
	 * tell if the specific tile of field 2 has already been processed by the player
	 */
	HashMap<Integer, Boolean> tilesField2Completed = new HashMap<>();
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values the indexes of
	 * the image view on the grid pane of the matchfield for field 3
	 */
	private HashMap<Integer, Integer> indexesField3;
	/**
	 * HashMap that has as key the indexes of the moving object (calculated: y*30 + x) and as values booleans that
	 * tell if the specific tile of field 3 has already been processed by the player
	 */
	HashMap<Integer, Boolean> tilesField3Completed = new HashMap<>();
	/**
	 * representing the state of growth of the first field
	 */
	private int growthState; //representing the state of growth of the first field
	/**
	 * representing the state of growth of the second field
	 */
	private int growthState2; //representing the state of growth of the second field
	/**
	 * representing the state of growth of the third field
	 */
	private int growthState3; //representing the state of growth of the third field
	/* 
	 * growthStates overview:
	 * growthstate = 0 - > grasslands / Wiese (noch nicht im Besitz)
	 * growthstate = 1 -> ready for sowing / zur Aussaat bereit
	 * growthstate = 2 -> growth state 1 / Wachstumsstufe 1
	 * growthstate = 3 -> growth state 2 / Wachstumsstufe 2
	 * growthstate = 4 -> growth state 3 / Wachstumsstufe 3
	 * growthstate = 5 -> ready for harvesting / erntereif
	 * growthstate = 6 -> harvested / abgeerntet
	 * 
	 */
	
	/**
	 * Empty Constructor of FieldTile for reloading the game. It initializes the HashMaps immediately.
	 */
	public FieldTile() {
		initializeHashMaps();
	}

	/**
	 * Constructor for starting a new game. The selling price to buy a field depends on the level of difficulty.
	 * @param level the level of difficulty the player has chosen
	 */
	public FieldTile(int level) {
		growthState = 1;
		growthState2 = 0;
		growthState3 = 0;
		if (level == 1) {
			sellingPrice = 500;
			harvest = 3;
		} else if (level == 2) {
			sellingPrice = 750;
			harvest = 2;
		} else if (level == 3) {
			sellingPrice = 1000;
			harvest = 1;
		}
		owningField1 = true;
		owningField2 = false;
		owningField3 = false;
		initializeHashMaps();
	}

	/**
	 * This method implements all the HashMaps, that are needed for cultivating, sowing and harvesting the fields.
	 */
	private void initializeHashMaps(){
		createHashMapField1();
		createHashMapField2();
		createHashMapField3();
		setTilesField1False();
		setTilesField2False();
		setTilesField3False();
	}
		
	/**
	 * Getter for the state of growth of the first field
	 * @return the requested growthState of field 1
	 */
	public int getGrowthState() {
		return growthState;
	}

	/**
	 * Setter of growthState for reloading the game
	 * @param growthState the value that is set as state of growth of field 1
	 */
	public void setGrowthState(int growthState) {
		this.growthState = growthState;
	}


	/**
	 * Setter of growthState for the first field.
	 *
	 * @param growthState the value that is set as state of growth of field 1
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void setGrowthState(int growthState, InformationBox informationBox) {
		this.growthState = growthState;
		if(growthState == 5) {
			informationBox.getNewsField().setText("The first field is ready to harvest!");			
		}else if(growthState == 6){
			informationBox.getNewsField().setText("The first field is ready to get cultivated!");			
		}else if(growthState == 1){
			informationBox.getNewsField().setText("The first field is ready for sowing!");			
		}else {
			informationBox.getNewsField().setText("The first field is growing now!");
		}
	}
	
	/**
	 * Getter for the state of growth of the second field
	 * @return the requested growthState2
	 */
	public int getGrowthState2() {
		return growthState2;
	}

	/**
	 * Setter of growthState2 for reloading the game
	 * @param growthState2 the value that is set as state of growth of field 2
	 */
	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
	}

	/**
	 * Setter of growthState2 for the second field
	 * @param growthState2 the value that is set as state of growth of field 2
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void setGrowthState2(int growthState2, InformationBox informationBox) {
		this.growthState2 = growthState2;
		if(growthState2 == 5) {
			informationBox.getNewsField().setText("The second field is ready to harvest!");
		}else if(growthState2 == 6){
			informationBox.getNewsField().setText("The second field is ready to get cultivated!");
		}else if(growthState2 == 1){
			informationBox.getNewsField().setText("The second field is ready for sowing!");
		}else {
			informationBox.getNewsField().setText("The second field is growing now!");
		}
	}

	/**
	 * Getter for the growthState of the third field
	 * @return the value that is set as state of growth of field 3
	 */
	public int getGrowthState3() {
		return growthState3;
	}
	
	/**
	 *  Setter of growthState3 for reloading the game
	 * @param growthState3  the value that is set as state of growth of field 3
	 */
	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
	}

	/**
	 * Setter of growthState3 for the third field
	 * @param growthState3 the value that is set as state of growth of field 3
	 */
	public void setGrowthState3(int growthState3, InformationBox informationBox) {
		this.growthState3 = growthState3;
		if(growthState3 == 5) {			
			informationBox.getNewsField().setText("The third field is ready to harvest!");
		}else if(growthState3 == 6){
			informationBox.getNewsField().setText("The third field is ready to get cultivated!");
		}else if(growthState3 == 1){
			informationBox.getNewsField().setText("The third field is ready for sowing!");
		}else {
			informationBox.getNewsField().setText("The third field is growing now!");
		}
	}


	/**
	 * This method creates the HashMap of field 1. As key, it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField1(){
		indexesField1 = new HashMap<>();
		int fieldIndex = 855;
		for (int i = 440; i <= 599; i++) {
			if (i % 30 == 0) {
				i = i + 20;
			}
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method creates the HashMap of field 2. As key, it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField2(){
		indexesField2 = new HashMap<>();
		int fieldIndex = 915;
		for (int i = 429; i <= 588; i++) {
			if (i % 30 == 19) {
				i = i + 20;
			}
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method creates the HashMap of field 3. As key, it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField3(){
		indexesField3 = new HashMap<>();
		int fieldIndex = 975;
		for (int i = 200; i <= 389; i++) {
			if (i % 30 == 0) {
				i = i + 20;
			}
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method cultivates the fields. If a field is cultivated completely it sets the growth stage of the field to 1.
	 *
	 * @param matchfield the Matchfield object of the actual game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void cultivateField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox){
		// calculating the index of the actual tile of the moving object
		int indexMovingObject = (row * 30) + column;
		boolean completelyCultivated;
		if (field == 1) {
			// iterating trough every keySet of the HashMap indexesField1
			for(Integer indexCombo : indexesField1.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as cultivating is possible
					matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is cultivated
			if (completelyCultivated) {
				this.setGrowthState(1, informationBox);
				setTilesField1False();
			}
		}
		if (field == 2) {
			// iterating trough every keySet of the HashMap indexesField2
			for(Integer indexCombo : indexesField2.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as cultivating is possible
					matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is cultivated
			if (completelyCultivated) {
				this.setGrowthState2(1);
				setTilesField2False();
			}
		}
		if (field == 3) {
			// iterating trough every keySet of the HashMap indexesField3
			for(Integer indexCombo : indexesField3.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as cultivating is possible
					matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is cultivated
			if (completelyCultivated) {
				this.setGrowthState3(1);
				setTilesField3False();
			}
		}
	}

	/**
	 * This method sows the fields. If a field is sowed completely it sets the growth stage of the field to 2.
	 *
	 * @param matchfield the Matchfield object of the actual game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void sowField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox){
		// calculating the index of the actual tile of the moving object
		int indexMovingObject = (row * 30) + column;
		boolean completelySowed;
		if (field == 1) {
			// iterating trough every keySet of the HashMap indexesField1
			for(Integer indexCombo : indexesField1.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as sowing is possible
					matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is sowed
			if (completelySowed) {
				this.setGrowthState(2, informationBox);
				setTilesField1False();
			}
		}
		if (field == 2) {
			// iterating trough every keySet of the HashMap indexesField2
			for(Integer indexCombo : indexesField2.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as sowing is possible
					matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is sowed
			if (completelySowed) {
				this.setGrowthState2(2);
				setTilesField2False();
			}
		}
		if (field == 3) {
			// iterating trough every keySet of the HashMap indexesField3
			for(Integer indexCombo : indexesField3.keySet()) {
				// proofing if the index of the HashMap is the same as the index of the moving object
				if (indexCombo == indexMovingObject) {
					// change the image view of the field tile, as sowing is possible
					matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			// the growth state of the field has to be changed if every tile of it is sowed
			if (completelySowed) {
				this.setGrowthState3(2);
				setTilesField3False();
			}
		}

	}

	/**
	 * This method harvests the fields. If the field is harvested completely it sets the growth stage of the field to 6.
	 *
	 * @param matchfield initialized matchfield from the class game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 * @param informationBox the InformationBox object of the actual game
	 * @param harvester the Harvester object of the actual game
	 */
	public void harvestField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox,
							 Harvester harvester){
		// calculating the index of the actual tile of the moving object
		int indexMovingObject = (row * 30) + column;
		boolean completelyHarvested;
		// checking if the grain tank of the harvester isn't full - if it is, harvesting isn't possible until it's
		// unloaded to the dump truck
		if (harvester.getGrainTankFillLevel() != harvester.getGRAIN_TANK_CAPACITY()) {
			if (field == 1) {
				// iterating trough every keySet of the HashMap indexesField1
				for(Integer indexCombo : indexesField1.keySet()) {
					// proofing if the index of the HashMap is the same as the index of the moving object
					if (indexCombo == indexMovingObject) {
						// checking if the tile of that index isn't already harvested
						if (!tilesField1Completed.get(indexCombo)) {
							// change the image view of the field tile, as harvesting is possible
							matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							// filling the grain tank of the harvester with the harvested grain
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				// the growth state of the field has to be changed if every tile of it is harvested
				if (completelyHarvested) {
					this.setGrowthState(6, informationBox);
					setTilesField1False();
				}
			}
			if (field == 2) {
				// iterating trough every keySet of the HashMap indexesField2
				for(Integer indexCombo : indexesField2.keySet()) {
					// proofing if the index of the HashMap is the same as the index of the moving object
					if (indexCombo == indexMovingObject) {
						// checking if the tile of that index isn't already harvested
						if (!tilesField2Completed.get(indexCombo)) {
							// change the image view of the field tile, as harvesting is possible
							matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							// filling the grain tank of the harvester with the harvested grain
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				// the growth state of the field has to be changed if every tile of it is harvested
				if (completelyHarvested) {
					this.setGrowthState2(6);
					setTilesField2False();
				}
			}
			if (field == 3) {
				// iterating trough every keySet of the HashMap indexesField3
				for(Integer indexCombo : indexesField3.keySet()) {
					// proofing if the index of the HashMap is the same as the index of the moving object
					if (indexCombo == indexMovingObject) {
						// checking if the tile of that index isn't already harvested
						if (!tilesField3Completed.get(indexCombo)) {
							// change the image view of the field tile, as harvesting is possible
							matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							// filling the grain tank of the harvester with the harvested grain
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				// the growth state of the field has to be changed if every tile of it is harvested
				if (completelyHarvested) {
					this.setGrowthState3(6);
					setTilesField3False();
				}
			}
		}
	}


	/**
	 * This method proofs, if a field is completely cultivated, sowed or harvested. It's called every time the tile of
	 * one field has been processed by the player. Therefore, it gets the index of the moving object handed over and
	 * sets the value of that index in the HashMap true. Afterwards it iterates through the complete HashMap to check
	 * if every tile of one field has been processed.
	 *
	 * @param column x-value of the moving object - is used to calculate the index of the moving object
	 * @param row y-value of the moving object - is used to calculate the index of the moving object
	 * @param field number of the field
	 * @return whether the field is completely cultivated, sowed or harvested or not
	 */
	private boolean proofCompleteField(int column, int row, int field){
		boolean fieldCompleted = true;
		int indexMovingObject = (row * 30) + column;
		if (field == 1) {
			// set the value of the index key true
			tilesField1Completed.put(indexMovingObject, true);
			// iterating through the HashMap
			for (Integer indexOfTile : tilesField1Completed.keySet()) {
				// if a value is false, the boolean has to be set to false
				if (!tilesField1Completed.get(indexOfTile)) {
					fieldCompleted = false;
				}
			}
		}
		if (field == 2) {
			// set the value of the index key true
			tilesField2Completed.put(indexMovingObject, true);
			// iterating through the HashMap
			for (Integer indexOfTile : tilesField2Completed.keySet()) {
				// if a value is false, the boolean has to be set to false
				if (!tilesField2Completed.get(indexOfTile)) {
					fieldCompleted = false;
				}
			}
		}
		if (field == 3) {
			// set the value of the index key true
			tilesField3Completed.put(indexMovingObject, true);
			// iterating through the HashMap
			for (Integer indexOfTile : tilesField3Completed.keySet()) {
				// if a value is false, the boolean has to be set to false
				if (!tilesField3Completed.get(indexOfTile)) {
					fieldCompleted = false;
				}
			}
		}
		return fieldCompleted;
	}

	/**
	 * This method puts all values of the HashMap to false.
	 */
	private void setTilesField1False(){
		for (int i = 440; i <= 599; i++) {
			if (i % 30 == 0) {
				i = i + 20;
			}
			tilesField1Completed.put(i, false);
		}
	}

	/**
	 * This method puts all values of the HashMap to false.
	 */
	private void setTilesField2False(){
		for (int i = 429; i <= 588; i++) {
			if (i % 30 == 19) {
				i = i + 20;
			}
			tilesField2Completed.put(i, false);
		}
	}

	/**
	 * This method puts all values of the HashMap to false.
	 */
	private void setTilesField3False(){
		for (int i = 200; i <= 389; i++) {
			if (i % 30 == 0) {
				i = i + 20;
			}
			tilesField3Completed.put(i, false);
		}
	}


	/**
	 * Getter for owningField1
	 * @return the requested boolean whether the player owns the first field or not
	 */
	public boolean isOwningField1() {
		return owningField1;
	}

	/**
	 * Getter for owningField2
	 * @return the requested boolean whether the player owns the second field or not
	 */
	public boolean isOwningField2() {
		return owningField2;
	}

	/**
	 * Getter for owningField3
	 * @return the requested boolean whether the player owns the third field or not
	 */
	public boolean isOwningField3() {
		return owningField3;
	}

	/**
	 * Setter for owningField1
	 * @param owningField1 value that is set to the boolean owningField1
	 */
	public void setOwningField1(boolean owningField1) {
		this.owningField1 = owningField1;
	}

	/**
	 * Setter for owningField2
	 * @param owningField2 value that is set to the boolean owningField2
	 */
	public void setOwningField2(boolean owningField2) {
		this.owningField2 = owningField2;
	}

	/**
	 * Setter for owningField3
	 * @param owningField3 value that is set to the boolean owningField3
	 */
	public void setOwningField3(boolean owningField3) {
		this.owningField3 = owningField3;
	}

	/**
	 * Getter for harvest
	 * @return returns the value of the integer harvest
	 */
	public int getHarvest() {
		return harvest;
	}

	/**
	 * Setter for harvest
	 * @param harvest value that is set to the integer harvest
	 */
	public void setHarvest(int harvest) {
		this.harvest = harvest;
	}

	/**
	 * Getter for sellingPrice
	 * @return returns the value of the integer sellingPrice
	 */
	public int getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * Setter for sellingPrice
	 * @param sellingPrice value that is set to the integer sellingPrice
	 */
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * This method represents the functionality of the farmer to buy additional fields to the first field
	 * in the course of the game.
	 * @param gameValue the GameValue object of the actual game
	 * @param gameScene the GameScene object of the actual game
	 */
	public void buyField(GameValue gameValue, GameScene gameScene){
		// if the player is not owning the second field he buys that one first
		if (!owningField2) {
			// checking if the player has enough money
			if (gameValue.getCash() >= sellingPrice) {
				owningField2 = true;
				gameValue.setCash(gameValue.getCash()-sellingPrice);
				// changing the state of growth of field 2 from grasslands to ready for sowing
				setGrowthState2(1);
				// changing all the image views of the second field
				for (int i = 915; i < 975; i++) {
					gameScene.getMatchfield().getImageViewField2(i).setImage(gameScene.getMatchfield().getCorrectImageField(1));
				}
			} else {
				gameScene.getInformationBox().getNewsField().setText("you do not have enough money to buy this field");
			}
		} else { // if the player is owning the second field already he can buy the third field
			// checking if the player has enough money
			if (gameValue.getCash() >= sellingPrice) {
				owningField3 = true;
				gameValue.setCash(gameValue.getCash()-sellingPrice);
				// changing the state of growth of field 3 from grasslands to ready for sowing
				setGrowthState3(1);
				// changing all the image views of the third field
				for (int i = 975; i < 1045; i++) {
					gameScene.getMatchfield().getImageViewField3(i).setImage(gameScene.getMatchfield().getCorrectImageField(1));
				}
			} else {
				gameScene.getInformationBox().getNewsField().setText("you do not have enough money to buy this field");
			}
		}
	}

	/**
	 * Getter for the HashMap tilesField1Completed that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap tilesField1Completed
	 */
	public HashMap<Integer, Boolean> getTilesField1CompletedForMatchfield() {
		return tilesField1Completed;
	}

	/**
	 * Getter for the HashMap indexesField1 that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap indexesField1
	 */
	public HashMap<Integer, Integer> getIndexesField1ForMatchfield() {
		return indexesField1;
	}

	/**
	 * Getter for the HashMap tilesField1Completed that is used for saving and loading. Therefore, it creates an
	 * ArrayList that is filled with the booleans of the HashMap.
	 *
	 * @return an ArrayList with all the values of the HashMap tilesField1Completed
	 */
	public List<Boolean> getTilesField1Completed() {
		ArrayList<Boolean> field1Completed = new ArrayList<>();
		for (Integer indexOfTile : tilesField1Completed.keySet()) {
			field1Completed.add(tilesField1Completed.get(indexOfTile));
		}
		return field1Completed;
	}

	/**
	 * Setter for the HashMap tilesField1Completed that is used for saving and loading.
	 *
	 * @param field1Completed an ArrayList whit which the values of the HashMap tilesField1Completed are filled
	 */
	public void setTilesField1Completed(ArrayList<Boolean> field1Completed) {
		int index = 0;
		for (Integer indexOfTile : tilesField1Completed.keySet()) {
			tilesField1Completed.put(indexOfTile, field1Completed.get(index));
			index++;
		}
	}


	/**
	 * Getter for the HashMap tilesField2Completed that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap tilesField2Completed
	 */
	public HashMap<Integer, Boolean> getTilesField2CompletedForMatchfield() {
		return tilesField2Completed;
	}

	/**
	 * Getter for the HashMap indexesField2 that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap indexesField2
	 */
	public HashMap<Integer, Integer> getIndexesField2ForMatchfield() {
		return indexesField2;
	}

	/**
	 * Getter for the HashMap tilesField2Completed that is used for saving and loading. Therefore, it creates an
	 * ArrayList that is filled with the booleans of the HashMap.
	 *
	 * @return an ArrayList with all the values of the HashMap tilesField2Completed
	 */
	public List<Boolean> getTilesField2Completed() {
		ArrayList<Boolean> field2Completed = new ArrayList<>();
		for (Integer indexOfTile : tilesField2Completed.keySet()) {
			field2Completed.add(tilesField2Completed.get(indexOfTile));
		}
		return field2Completed;
	}

	/**
	 * Setter for the HashMap tilesField2Completed that is used for saving and loading.
	 *
	 * @param field2Completed an ArrayList whit which the values of the HashMap tilesField2Completed are filled
	 */
	public void setTilesField2Completed(ArrayList<Boolean> field2Completed) {
		int index = 0;
		for (Integer indexOfTile : tilesField2Completed.keySet()) {
			tilesField2Completed.put(indexOfTile, field2Completed.get(index));
			index++;
		}
	}


	/**
	 * Getter for the HashMap tilesField3Completed that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap tilesField3Completed
	 */
	public HashMap<Integer, Boolean> getTilesField3CompletedForMatchfield() {
		return tilesField3Completed;
	}

	/**
	 * Getter for the HashMap indexesField3 that is used for filling the matchfield with the correct image view.
	 *
	 * @return the requested HashMap indexesField3
	 */
	public HashMap<Integer, Integer> getIndexesField3ForMatchfield() {
		return indexesField3;
	}

	/**
	 * Getter for the HashMap tilesField3Completed that is used for saving and loading. Therefore, it creates an
	 * ArrayList that is filled with the booleans of the HashMap.
	 *
	 * @return an ArrayList with all the values of the HashMap tilesField3Completed
	 */
	public List<Boolean> getTilesField3Completed() {
		ArrayList<Boolean> field3Completed = new ArrayList<>();
		for (Integer indexOfTile : tilesField3Completed.keySet()) {
			field3Completed.add(tilesField3Completed.get(indexOfTile));
		}
		return field3Completed;
	}

	/**
	 * Setter for the HashMap tilesField3Completed that is used for saving and loading.
	 *
	 * @param field3Completed an ArrayList whit which the values of the HashMap tilesField3Completed are filled
	 */
	public void setTilesField3Completed(ArrayList<Boolean> field3Completed) {
		int index = 0;
		for (Integer indexOfTile : tilesField3Completed.keySet()) {
			tilesField3Completed.put(indexOfTile, field3Completed.get(index));
			index++;
		}
	}

}
