package gameboard.objects;

import exceptions.WrongMachineException;

/**
 *  this class represents the harvester with its properties to harvest a field
 * @author Luisaibele
 *
 */
public class Harvester extends Machine {
	private final int GRAIN_TANK_CAPACITY = 60; //grain capacity of 1 field
	private int grainTankFillLevel;
	
	/**
	 * Empty Constructor of Harvester for starting the game
	 */
	public Harvester() {
		super();
		grainTankFillLevel = 0;
	}

	/**
	 * Constructor of Harvester for reloading / continuing the game
	 * @param x
	 * @param y
	 * @param selected
	 * @param petrolTankFillLevel
	 * @param grainTankFillLevel
	 */
	public Harvester(int x, int y, boolean selected, int petrolTankFillLevel, int grainTankFillLevel){
		super(x, y, selected, petrolTankFillLevel);
		this.grainTankFillLevel = grainTankFillLevel;
	}
	
	/**
	 * this method stands for the operation of filling the tank 
	 * of the harvester with grain
	 */
	public void fillTankWithGrain() { //if animation worked 1 time then full?
			grainTankFillLevel++;
			
		if(grainTankFillLevel == GRAIN_TANK_CAPACITY) {
			System.out.println("The harvester needs to be unloaded");
		}
	}

	/**
	 * this method represents the functionality of the Harvester to unload its tank
	 * to the dump truck or the silo
	 */
	public void unload(){
		grainTankFillLevel = 0;
	}

	/**
	 * Getter for the GrainTankFillLevel of the Harvester
	 * @return grainTankFillLevel
	 */
	public int getGrainTankFillLevel() {
		return grainTankFillLevel;
	}

	/**
	 * this method represents the functionality to harvest a field 
	 * when it's ready to do so
	 * @param growthState
	 */
	public int harvest(int growthState) throws WrongMachineException{
		//checking if harvester is at the right place for this action
		if(growthState == 5) {
			growthState++;
		} else {
			throw new WrongMachineException("You can not use the harvester yet!");
		}
		return growthState;
	}
	
}