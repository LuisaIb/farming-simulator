package gameboard.tiles;

import gameboard.GameValue;
import gameboard.objects.Harvester;
import gui.view.GameScene;
import gui.view.InformationBox;
import gui.view.Matchfield;
import java.util.HashMap;

/**
 * This class represents a tile, which is part of one of the three fields, with its several properties
 * and functionalities (i. e. to grow))
 * @author Luisaibele
 *
 */
public class FieldTile{
	
	private int sellingPrice; //the amount of money you get for selling the harvest
	private int harvest; //the amount of grain you get per part of the field
	private boolean owningField1; //boolean variable whether you own this field or not
	private boolean owningField2;
	private boolean owningField3;

	private HashMap<Integer, Integer> indexesField1;
	HashMap<Integer, Boolean> tilesField1Completed = new HashMap<Integer, Boolean>();
	private HashMap<Integer, Integer> indexesField2;
	HashMap<Integer, Boolean> tilesField2Completed = new HashMap<Integer, Boolean>();
	private HashMap<Integer, Integer> indexesField3;
	HashMap<Integer, Boolean> tilesField3Completed = new HashMap<Integer, Boolean>();
	
	private int growthState; //representing the state of growth of the first field
	private int growthState2; //representing the state of growth of the second field
	private int growthState3; //representing the state of growth of the third field
	/* 
	 * growthStates overview:
	 * growthstate = 0 - > Wiese (noch nicht im Besitz)
	 * growthstate = 1 -> zur Aussaat bereit
	 * growthstate = 2 -> Wachstumsstufe 1
	 * growthstate = 3 -> Wachstumsstufe 2
	 * growthstate = 4 -> Wachstumsstufe 3
	 * growthstate = 5 -> erntereif
	 * growthstate = 6 -> abgeerntet
	 * 
	 */
	
	/**
	 * Empty Constructor of FieldTile for reloading the game
	 */
	public FieldTile() {
		super();
		initializeHashMaps();
	}
	
	/**
	 * this constructor sets the growthState for each field tile
	 * @param growthState
	 * @param growthState2
	 * @param growthState3
	 */
	public FieldTile(int growthState, int growthState2, int growthState3, int sellingPrice, int harvest, boolean owningField1,
					 boolean owningField2, boolean owningField3) {
		this.growthState = growthState;
		this.growthState2 = growthState2;
		this.growthState3 = growthState3;
		this.sellingPrice = sellingPrice;
		this.harvest = harvest;
		this.owningField1 = owningField1;
		this.owningField2 = owningField2;
		this.owningField3 = owningField3;
		initializeHashMaps();
	}
	
	/**
	 * this empty constructor is for starting a new game
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
	 * This method implements the HashMaps, that are needed for cultivating, sowing and harvesting the fields.
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
	 * this method gets the growthState of the first field
	 * @return growthState
	 */
	public int getGrowthState() {
		return growthState;
	}

	/**
	 *  Empty Setter of growthState for reloading the game
	 * @param growthState
	 */
	public void setGrowthState(int growthState) {
		this.growthState = growthState;
	}


	/**
	 *  Setter of growthState for the first field
	 * @param growthState
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
	 * this method gets the growthState of the second field
	 * @return growthState2
	 */
	public int getGrowthState2() {
		return growthState2;
	}

	/**
	 * Empty Setter of growthState2 for reloading the game
	 * @param growthState2
	 */
	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
	}

	/**
	 *  Setter of growthState2 for the second field
	 * @param growthState2
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
	 * this method gets the growthState of the third field
	 * @return growthState3
	 */
	public int getGrowthState3() {
		return growthState3;
	}
	
	/**
	 *  Empty Setter of growthState3 for reloading the game
	 * @param growthState3
	 */
	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
	}

	/**
	 * Setter of growthState3 for the third field
	 * @param growthState3
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
	 * This method creates the HashMap of field 1. As key it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField1(){
		indexesField1 = new HashMap<Integer, Integer>();
		int fieldIndex = 855;
		for (int i = 440; i <= 449; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 470; i <= 479; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 500; i <= 509; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 530; i <= 539; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 560; i <= 569; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 590; i <= 599; i++) {
			indexesField1.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method creates the HashMap of field 2. As key it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField2(){
		indexesField2 = new HashMap<Integer, Integer>();
		int fieldIndex = 915;
		for (int i = 429; i <= 438; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 459; i <= 468; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 489; i <= 498; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 519; i <= 528; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 549; i <= 558; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 579; i <= 588; i++) {
			indexesField2.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method creates the HashMap of field 2. As key it has the index of the coordinates (y*30 + x) and as
	 * value the matching index of the image view on the grid pane.
	 */
	private void createHashMapField3(){
		indexesField3 = new HashMap<Integer, Integer>();
		int fieldIndex = 975;
		for (int i = 200; i <= 209; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 230; i <= 239; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 260; i <= 269; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 290; i <= 299; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 320; i <= 329; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 350; i <= 359; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 380; i <= 389; i++) {
			indexesField3.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	/**
	 * This method cultivates the field. If it's cultivated completely it sets the growth stage of the field to 1.
	 *
	 * @param matchfield initialized matchfield from the class game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 */
	public void cultivateField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox){
		int indexMovingObject = (row * 30) + column;
		boolean completelyCultivated = false;
		if (field == 1) {
			for(Integer indexCombo : indexesField1.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			if (completelyCultivated) {
				this.setGrowthState(1, informationBox);
				setTilesField1False();
			}
		}
		if (field == 2) {
			for(Integer indexCombo : indexesField2.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			if (completelyCultivated) {
				this.setGrowthState2(1);
				this.setGrowthState2(1);
				System.out.println("Stage growth of field 2 is now 1: " + this.getGrowthState2());
				setTilesField2False();
			}
		}
		if (field == 3) {
			for(Integer indexCombo : indexesField3.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
				}
			}
			completelyCultivated = proofCompleteField(column, row, field);
			if (completelyCultivated) {
				this.setGrowthState3(1);
				this.setGrowthState3(1);
				System.out.println("Stage growth of field 3 is now 1: " + this.getGrowthState3());
				setTilesField3False();
			}
		}
	}

	/**
	 * This method sowes the field. If it's sowed completely it sets the growth stage of the field to 2.
	 *
	 * @param matchfield initialized matchfield from the class game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 */
	public void sowField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox){
		int indexMovingObject = (row * 30) + column;
		boolean completelySowed = false;
		if (field == 1) {
			for(Integer indexCombo : indexesField1.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			if (completelySowed) {
				this.setGrowthState(2, informationBox);
				setTilesField1False();
			}
		}
		if (field == 2) {
			for(Integer indexCombo : indexesField2.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			if (completelySowed) {
				this.setGrowthState2(2);

				this.setGrowthState2(2);
				System.out.println("Stage growth of field 1 is now 2: " + this.getGrowthState2());

				setTilesField2False();
			}
		}
		if (field == 3) {
			for(Integer indexCombo : indexesField3.keySet()) {
				if (indexCombo == indexMovingObject) {
					matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(2));
				}
			}
			completelySowed = proofCompleteField(column, row, field);
			if (completelySowed) {

				this.setGrowthState3(2);

				this.setGrowthState3(2);
				System.out.println("Stage growth of field 1 is now 2: " + this.getGrowthState3());
				setTilesField3False();
			}
		}

	}

	/**
	 * This method harvests the field. If it's harvested completely it sets the growth stage of the field to 6.
	 *
	 * @param matchfield initialized matchfield from the class game
	 * @param column x-value of the moving object to calculate the index
	 * @param row y-value of the moving object to calculate the index.
	 * @param field number of the field
	 */
	public void harvestField(Matchfield matchfield, int column, int row, int field, InformationBox informationBox,
							 Harvester harvester){
		int indexMovingObject = (row * 30) + column;
		boolean completelyHarvested = false;

		if (harvester.getGrainTankFillLevel() != harvester.getGRAIN_TANK_CAPACITY()) {
			if (field == 1) {
				for(Integer indexCombo : indexesField1.keySet()) {
					if (indexCombo == indexMovingObject) {
						if (!tilesField1Completed.get(indexCombo)) {
							matchfield.getImageViewField1(indexesField1.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				if (completelyHarvested) {
					this.setGrowthState(6, informationBox);
					setTilesField1False();
				}
			}
			if (field == 2) {
				for(Integer indexCombo : indexesField2.keySet()) {
					if (indexCombo == indexMovingObject) {
						if (!tilesField2Completed.get(indexCombo)) {
							matchfield.getImageViewField2(indexesField2.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				if (completelyHarvested) {

					this.setGrowthState2(6);

					this.setGrowthState2(6);
					System.out.println("Stage growth of field 1 is now 6: " + this.getGrowthState2());

					setTilesField2False();
				}
			}
			if (field == 3) {
				for(Integer indexCombo : indexesField3.keySet()) {
					if (indexCombo == indexMovingObject) {
						if (!tilesField3Completed.get(indexCombo)) {
							matchfield.getImageViewField3(indexesField3.get(indexCombo)).setImage(matchfield.getCorrectImageField(6));
							harvester.setGrainTankFillLevel(harvester.getGrainTankFillLevel()+harvest, informationBox);
						}
					}
				}
				completelyHarvested = proofCompleteField(column, row, field);
				if (completelyHarvested) {

					this.setGrowthState3(6);

					this.setGrowthState3(6);
					System.out.println("Stage growth of field 1 is now 6: " + this.getGrowthState3());
					setTilesField3False();
				}
			}
		}
	}


	/**
	 * This method proofs, if a field is completely cultivated, sowed or harvested.
	 *
	 * @param column x-value of the moving object - is used to calculate the index of the moving object
	 * @param row y-value of the moving object - is used to calculate the index of the moving object
	 * @param field number of the field
	 * @return if the field is completely cultivated, sowed or harvested
	 */
	private boolean proofCompleteField(int column, int row, int field){
		boolean fieldCompleted = true;
		int indexMovingObject = (row * 30) + column;
		if (field == 1) {
			tilesField1Completed.put(indexMovingObject, true);
			for (Integer indexOfTile : tilesField1Completed.keySet()) {
				if (tilesField1Completed.get(indexOfTile) == false) {
					fieldCompleted = false;
				}
			}
		}
		if (field == 2) {
			tilesField2Completed.put(indexMovingObject, true);
			for (Integer indexOfTile : tilesField2Completed.keySet()) {
				if (tilesField2Completed.get(indexOfTile) == false) {
					fieldCompleted = false;
				}
			}
		}
		if (field == 3) {
			tilesField3Completed.put(indexMovingObject, true);
			for (Integer indexOfTile : tilesField3Completed.keySet()) {
				if (tilesField3Completed.get(indexOfTile) == false) {
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
		for (int i = 440; i <= 449; i++) {
			tilesField1Completed.put(i, false);
		}

		for (int i = 470; i <= 479; i++) {
			tilesField1Completed.put(i, false);
		}

		for (int i = 500; i <= 509; i++) {
			tilesField1Completed.put(i, false);
		}

		for (int i = 530; i <= 539; i++) {
			tilesField1Completed.put(i, false);
		}

		for (int i = 560; i <= 569; i++) {
			tilesField1Completed.put(i, false);
		}

		for (int i = 590; i <= 599; i++) {
			tilesField1Completed.put(i, false);
		}
	}

	/**
	 * This method puts all values of the HashMap to false.
	 */
	private void setTilesField2False(){
		for (int i = 429; i <= 438; i++) {
			tilesField2Completed.put(i, false);
		}

		for (int i = 459; i <= 468; i++) {
			tilesField2Completed.put(i, false);
		}

		for (int i = 489; i <= 498; i++) {
			tilesField2Completed.put(i, false);
		}

		for (int i = 519; i <= 528; i++) {
			tilesField2Completed.put(i, false);
		}

		for (int i = 549; i <= 558; i++) {
			tilesField2Completed.put(i, false);
		}

		for (int i = 579; i <= 588; i++) {
			tilesField2Completed.put(i, false);
		}
	}

	/**
	 * This method puts all values of the HashMap to false.
	 */
	private void setTilesField3False(){
		for (int i = 200; i <= 209; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 230; i <= 239; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 260; i <= 269; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 290; i <= 299; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 320; i <= 329; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 350; i <= 359; i++) {
			tilesField3Completed.put(i, false);
		}

		for (int i = 380; i <= 389; i++) {
			tilesField3Completed.put(i, false);
		}
	}


	/**
	 * Getter for owningField1
	 * @return owningField1
	 */
	public boolean isOwningField1() {
		return owningField1;
	}

	/**
	 * Getter for owningField2
	 * @return owningField2
	 */
	public boolean isOwningField2() {
		return owningField2;
	}

	/**
	 * Getter for owningField3
	 * @return owningField3
	 */
	public boolean isOwningField3() {
		return owningField3;
	}

	/**
	 * Setter for owningField1
	 * @param owningField1
	 */
	public void setOwningField1(boolean owningField1) {
		this.owningField1 = owningField1;
	}

	/**
	 * Setter for owningField2
	 * @param owningField2
	 */
	public void setOwningField2(boolean owningField2) {
		this.owningField2 = owningField2;
	}

	/**
	 * Setter for owningField3
	 * @param owningField3
	 */
	public void setOwningField3(boolean owningField3) {
		this.owningField3 = owningField3;
	}

	/**
	 * Getter for harvest
	 * @return harvest
	 */
	public int getHarvest() {
		return harvest;
	}

	/**
	 * Setter for harvest
	 * @param harvest
	 */
	public void setHarvest(int harvest) {
		this.harvest = harvest;
	}

	/**
	 * Getter for sellingPrice
	 * @return sellingPrice
	 */
	public int getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * Setter for sellingPrice
	 * @param sellingPrice
	 */
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * this method represents the functionality of the farmer to buy additional fields to the first field 
	 * in the course of the game
	 * @param gameValue
	 * @param gameScene
	 */
	public void buyField(GameValue gameValue, GameScene gameScene){
		if (!owningField2) {
			if (gameValue.getCash() >= sellingPrice) {
				owningField2 = true;
				gameValue.setCash(gameValue.getCash()-sellingPrice);
				setGrowthState2(1);
				setGrowthState2(1);
				for (int i = 914; i < 975; i++) {
					gameScene.getMatchfield().getImageViewField2(i).setImage(gameScene.getMatchfield().getCorrectImageField(1));
				}
			} else {
				gameScene.getInformationBox().getNewsField().setText("you do not have enough money to buy this field");
			}
		} else {
			if (gameValue.getCash() >= sellingPrice) {
				owningField3 = true;
				gameValue.setCash(gameValue.getCash()-sellingPrice);

				setGrowthState3(1);

				setGrowthState3(1);

				for (int i = 975; i < 1045; i++) {
					gameScene.getMatchfield().getImageViewField3(i).setImage(gameScene.getMatchfield().getCorrectImageField(1));
				}
			} else {
				gameScene.getInformationBox().getNewsField().setText("you do not have enough money to buy this field");
			}
		}
	}

}
