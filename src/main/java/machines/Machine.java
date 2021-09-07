package machines;

import exceptions.datastorage.EmptyTankException;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * @author Luisaibele, Hanna
 *
 */
public class Machine extends MovingObject{

	private MovingObject mo = new MovingObject();
	private double x;
	private double y;
	
	private int tank; //stands for the petrol tank of the machines
	private boolean attachement; //stands for the value if a device is attached or not
	
	/**
	 * this empty constructor is there for starting a new game
	 */
	public Machine() {
	}
	
	/**
	 * the constructor sets the position in the coordinate system
	 * @param id
	 */
	public Machine(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
    /** 
     * hand over the x-Coordinate
     * @return x
     */
	public double getX() {
		return x;
	}
	
    /** 
     * Sets the x-Coordinate
     * @param x - Coordinate
     */
	public void setX(double x) {
		this.x = x;
	}
	
    /** 
     * hand over the y-Coordinate
     * @return y
     */
	public double getY() {
		return y;
	}
	
    /** 
     * Sets the y-Coordinate
     * @param y - Coordinate
     */
	public void setY(double y) {
		this.y = y;
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
    		System.out.println("Please refuel your vehicle!");
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
