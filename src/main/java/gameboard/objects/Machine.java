package gameboard.objects;

import gameboard.GameValue;
import gui.view.GameScene;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * @author Luisaibele, Hanna, Judith
 *
 */
public class Machine extends MovingObject{
	/**
	 * the maximum amount of petrol that fits into the tank of a machine (tractor of harvester)
	 */
	private final int PETROL_TANK_CAPACITY = 200; // capacity of the tank
	//amount of litres in the tank:
	/**
	 * IntegerProperty for the amount of petrol that is in the machine to make a binding for automatic change possible
	 */
	private IntegerProperty petrolTankFillLevel = new SimpleIntegerProperty();

	
	/**
	 * This constructor is used for starting a new game.
	 */
	public Machine() {
		super(18, 7, false);
		petrolTankFillLevel.set(200);
	}

	/**
	 * Constructor with parameters. Sets the coordinates, whether if it is selected or not and the fill level of
	 * the petrol.
	 *
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 * @param petrolTankFillLevel the value that is set as fill level of the petrol tank
	 */
	public Machine(int x, int y, boolean selected, int petrolTankFillLevel) {
		super(x, y, selected);
		this.petrolTankFillLevel.set(petrolTankFillLevel);
	}

	/**
	 * This method is used when driving around and lowering the petrol tank. It warns the player when the petrol level
	 * is low and ends the game when the petrol tank is empty.
	 *
	 * @param tank the value that is set as the new fill level of the petrol tank
	 * @param gameScene the GameScene object of the actual game
	 */
	public void lowPetrolLevel(int tank, GameScene gameScene) {
    	this.petrolTankFillLevel.set(tank);
    	if(tank <= 50 && tank > 0) { //little reminder to fuel the machine
    		gameScene.getInformationBox().getNewsField().setText("Please go to the gasstation!");
    		} 
    	else if (tank == 0) { //tank is empty -> Game Over!
    		gameScene.setGameOver();

    	}
    }

	/**
	 * Getter for the petrolTankFillLevel.
	 * @return the requested fill level of the petrol tank
	 */
	public int getPetrolTankFillLevel() {
		return petrolTankFillLevel.get();
	}

	/**
	 * Setter for the PetrolTankFillLevel.
	 * @param petrolTankFillLevel the value that is set as the fill level of the petrol tank
	 */
	public void setPetrolTankFillLevel(int petrolTankFillLevel){ this.petrolTankFillLevel.set(petrolTankFillLevel);}

	/**
	 * Method to get the IntegerProperty petrolTankFillLevel.
	 *
	 * @return the requested IntegerProperty petrolTankFillLevel
	 */
	public IntegerProperty petrolTankFillLevel(){ return petrolTankFillLevel; }

	/**
	 * This method is needed for the text field of the informationBox as the value of the fill level is needed in a String.
	 *
	 * @return a String with the value of fill level of the petrol tank
	 */
	public String getPetrolTankFillLevelAsString(){
		return "" + petrolTankFillLevel.get();
	}

	/**
	 * This method represents the functionality to fuel a machine at the gas station.
	 *
	 * @param gameValue the GameValue object of the actual game
	 */
	public void fillTank(GameValue gameValue){
		// the amount of petrol that fits into the petrol tank of the machine
		int litresToTank = 200 - petrolTankFillLevel.get();
		// the amount of cash is enough to fuel the tank completely
		if (gameValue.getCash() >= litresToTank) {
			petrolTankFillLevel.set(PETROL_TANK_CAPACITY);
			gameValue.setCash(gameValue.getCash() - litresToTank);
		} else { // the tank can only be filled with the amount of petrol that the player can buy with his money
			petrolTankFillLevel.set(petrolTankFillLevel.get() + gameValue.getCash());
			gameValue.setCash(0);
		}
	}
}
