package gameboard.objects;

import gameboard.GameValue;
import gui.view.GameScene;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * @author Luisaibele, Hanna
 *
 */
public class Machine extends MovingObject{

	private final int PETROL_TANK_CAPACITY = 200; // capacity of the tank
	//amount of litres in the tank:
	private IntegerProperty petrolTankFillLevel = new SimpleIntegerProperty();

	
	/**
	 * this empty constructor is there for starting a new game
	 */
	public Machine() {
		super(18, 7, false);
		petrolTankFillLevel.set(200);
	}
	
	/**
	 * the constructor sets the position in the coordinate system
	 * @param
	 */
	public Machine(int x, int y, boolean selected, int petrolTankFillLevel) {
		super(x, y, selected);
		this.petrolTankFillLevel.set(petrolTankFillLevel);
	}
    
    /** 
     * this method warns the player when the petrol level is low
     * and ends the game when the petrol is empty
     */
    public void lowPetrolLevel(int tank, GameScene gameScene) {
    	this.petrolTankFillLevel.set(tank);
    	if(tank <= 50 && tank > 0) { //little reminder to fuel the machine
    		gameScene.getInformationBox().getNewsField().setText("Please go to the gasstation!");
    		System.out.println("There are only " + tank + "l left in the tank.");
    		System.out.println("Please go to the gasstation!");
    		} 
    	else if (tank == 0) { //tank is empty -> Game Over!
    		gameScene.setGameOver();

    }
    	
    }

	/**
	 * Getter for the petrolTankFillLevel
	 * @return the petrolTankFillLevel
	 */
	public int getPetrolTankFillLevel() {
		return petrolTankFillLevel.get();
	}

	/**
	 * Setter for the variable PetrolTankFillLevel
	 * @param petrolTankFillLevel
	 */
	public void setPetrolTankFillLevel(int petrolTankFillLevel){ this.petrolTankFillLevel.set(petrolTankFillLevel);}

	/**
	 * Getter for the IntegerProperty pertrolTankFillLevel
	 * @return
	 */
	public IntegerProperty petrolTankFillLevel(){ return petrolTankFillLevel; }

	/**
	 * method for serializing the petrolTankFillLevel to give it back as
	 * an information to the user 
	 * @return
	 */
	public String getPetrolTankFillLevelAsString(){
		return "" + petrolTankFillLevel.get();
	}

	/**
	 * this method represents the functionality to fuel a machine
	 * @param gameValue
	 */
	public void fillTank(GameValue gameValue){
		int litresToTank = 200 - petrolTankFillLevel.get();
		if (gameValue.getCash() >= litresToTank) {
			petrolTankFillLevel.set(PETROL_TANK_CAPACITY);
			gameValue.setCash(gameValue.getCash() - litresToTank);
		} else {
			petrolTankFillLevel.set(petrolTankFillLevel.get() + gameValue.getCash());
			gameValue.setCash(0);
		}
	}
	
}
