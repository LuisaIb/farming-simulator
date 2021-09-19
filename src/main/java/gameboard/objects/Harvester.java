package gameboard.objects;

import exceptions.WrongMachineException;
import gui.view.InformationBox;

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


	public void setGrainTankFillLevel(int grainTankFillLevel, InformationBox informationBox) {
		this.grainTankFillLevel = grainTankFillLevel;
		if (grainTankFillLevel == GRAIN_TANK_CAPACITY) {
			informationBox.getNewsField().setText("the grain tank of the harvester is full");
		}
	}

	public int getGRAIN_TANK_CAPACITY(){
		return GRAIN_TANK_CAPACITY;
	}


	public void unloadToDumpTruck(Harvester harvester, DumpTruck dumpTruck){
		int grainToFill = dumpTruck.getGrainTankCapacity() - dumpTruck.getGrainFillLevel();
		if (grainTankFillLevel <= grainToFill) {
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainTankFillLevel);
			grainTankFillLevel = 0;
			System.out.println("grain tank fill level of harvester is now: " + grainTankFillLevel);
			System.out.println("dump truck fill level of dump truck is now: " + dumpTruck.getGrainFillLevel());
		} else {
			grainTankFillLevel = grainTankFillLevel - grainToFill;
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainToFill);
		}
	}

}