package gameboard.objects;

import java.util.HashMap;

import exceptions.EmptyTankException;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * @author Luisaibele, Hanna
 *
 */
public class Machine extends MovingObject{

	private final int PETROL_TANK_CAPACITY = 150;
	private int petrolTankFillLevel; //stands for the petrol tank of the machines

	
	/**
	 * this empty constructor is there for starting a new game
	 */
	public Machine() {
		super(18, 7, false);
		petrolTankFillLevel = 100;
	}
	
	/**
	 * the constructor sets the position in the coordinate system
	 * @param id
	 */
	public Machine(int x, int y, boolean selected, int petrolTankFillLevel) {
		super(x, y, selected);
		this.petrolTankFillLevel = petrolTankFillLevel;
	}
	

	
	 /** 
     * this method minimizes the petrol level when the vehicle is moving
     * @return petrolLevel
     */
    public int consumption(int tank, int x, int y) {
    	if(x == +-1 || y == +-1) {
    		tank--;
    	} return tank;
    }
    
    /** 
     * this method warns the player when the petrol level is low
     * and ends the game when the petrol is empty
     */
    public void lowPetrolLevel(int tank) throws EmptyTankException{
    	if(tank <= 50) {
    		System.out.println("The petrol level is only " + tank + "l.");
    		System.out.println("Please go to the gasstation!");
    } 	else if (tank == 0) {
     		System.out.println("The tank is empty!");
    		System.out.println("Game Over!");		
    }
    	
//    	if(tank >= 20) {
//    		System.out.println("The petrol level is only " + tank + "l.");
//    		System.out.println("Please go to the gasstation!");
//    	} else {
//    		try {
//        		mo.move();
//        	} catch(EmptyTankException e) {
//        		System.out.println("The tank is empty!");
//        		System.out.println("Game Over!");
//        	}
//    	}
    }
	
}
