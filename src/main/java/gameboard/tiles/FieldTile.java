package gameboard.tiles;

import gameboard.objects.MovingObject;
import gui.view.Matchfield;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * This class represents a tile, which is a field with its several properties
 * @author Luisaibele
 *
 */
public class FieldTile extends Tile{
	
	private Timer timer = new Timer(); //needed for the field growing on its own


	private HashMap<Integer, Integer> indexes;
	HashMap<Integer, Boolean> cultivatedTilesField1 = new HashMap<Integer, Boolean>();
	
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
	 * this constructor sets the growthState for each field tile
	 * @param growthState
	 * @param growthState2
	 * @param growthState3
	 */
	public FieldTile(int growthState, int growthState2, int growthState3 ) {
		super();
		this.growthState = growthState;
		this.growthState2 = growthState2;
		this.growthState3 = growthState3;
		createHashMapField1();
		setCultivatedTilesField1False();
	}
	
	/**
	 * this empty constructor is for starting a new game
	 */
	public FieldTile() {
		growthState = 1;
		growthState2 = 0;
		growthState3 = 0;
		createHashMapField1();
		setCultivatedTilesField1False();
	}
		
	/**
	 * this method is supposed to check whether the farmer can run over 
	 * a field tile or not
	 * @return the checked boolean value
	 */
	public boolean isSolid() {
		return true;
	}
	
	/**
	 * this method gets the growthState of the first field
	 * @return growthState
	 */
	public int getGrowthState() {
		return growthState;
	}

	/**
	 * this method sets the growthState of the first field
	 * @param growthState
	 */
	public void setGrowthState(int growthState) {
		this.growthState = growthState;
		// if else statement without timer for growing
		if(growthState == 5) {
			System.out.println("The first field is ready to harvest!");
			//timer.stop
		}else if(growthState == 6){
			System.out.println("The first field is ready to get cultivated!");
		}else if(growthState == 1){
			System.out.println("The first field is ready for sowing!");
		}else {
			System.out.println("The first field is growing now!");
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
	 * this method sets the growthState of the second field
	 * @param growthState2
	 */
	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
		if(growthState2 == 5) {
			System.out.println("The second field is ready to harvest!");
			//timer.stop
		}else if(growthState2 == 6){
			System.out.println("The second field is ready to get cultivated!");
		}else if(growthState2 == 1){
			System.out.println("The second field is ready for sowing!");
		}else {
			System.out.println("The second field is growing now!");
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
	 * this method sets the growthState of the third field
	 * @param growthState3
	 */
	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
		if(growthState3 == 5) {
			System.out.println("The third field is ready to harvest!");
			//timer.stop
		}else if(growthState3 == 6){
			System.out.println("The third field is ready to get cultivated!");
		}else if(growthState3 == 1){
			System.out.println("The third field is ready for sowing!");
		}else {
			System.out.println("The third field is growing now!");
		}
	}
	
	/**
	 * this method is there so the field is able to grow by time
	 * @param growthState
	 */
	public void growing(int growthState) {
		
	}

	/**
	 * this method is needed for serializing this class into JSONB
	 */
	@Override
	public String toString() {
		return "FieldTile [growthState=" + growthState + ", growthState2=" + growthState2 + ", growthState3="
				+ growthState3 + "]";
	}

	private void createHashMapField1(){
		indexes = new HashMap<Integer, Integer>();
		int fieldIndex = 855;
		for (int i = 440; i <= 449; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 470; i <= 479; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 500; i <= 509; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 530; i <= 539; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 560; i <= 569; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}

		for (int i = 590; i <= 599; i++) {
			indexes.put(i, fieldIndex);
			fieldIndex++;
		}
	}

	public void cultivateField1(Matchfield matchfield, int column, int row){
		int indexMovingObject = (row * 30) + column;
		boolean completelyCultivated = false;
		for(Integer indexCombo : indexes.keySet()) {
			if (indexCombo == indexMovingObject) {
				matchfield.getImageViewField1(indexes.get(indexCombo)).setImage(matchfield.getCorrectImageField(1));
			}
		}
		completelyCultivated = proofCultivateCompleteField1(column, row);
		if (completelyCultivated) {
			this.setGrowthState(1);
			System.out.println("Stage growth of field 1 is now 1: " + this.getGrowthState());
			setCultivatedTilesField1False();
		}
	}

	private boolean proofCultivateCompleteField1(int column, int row){
		boolean completelycultivated = true;
		int indexMovingObject = (row * 30) + column;

		cultivatedTilesField1.put(indexMovingObject, true);

		for(Integer indexOfTile : cultivatedTilesField1.keySet()) {
			if (cultivatedTilesField1.get(indexOfTile) == false) {
				completelycultivated = false;
			}
		}

		return completelycultivated;
	}

	private void setCultivatedTilesField1False(){
		for (int i = 440; i <= 449; i++) {
			cultivatedTilesField1.put(i, false);
		}

		for (int i = 470; i <= 479; i++) {
			cultivatedTilesField1.put(i, false);
		}

		for (int i = 500; i <= 509; i++) {
			cultivatedTilesField1.put(i, false);
		}

		for (int i = 530; i <= 539; i++) {
			cultivatedTilesField1.put(i, false);
		}

		for (int i = 560; i <= 569; i++) {
			cultivatedTilesField1.put(i, false);
		}

		for (int i = 590; i <= 599; i++) {
			cultivatedTilesField1.put(i, false);
		}
	}


}
