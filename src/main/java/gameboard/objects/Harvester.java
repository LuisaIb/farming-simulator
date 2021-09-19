package gameboard.objects;

import gui.view.InformationBox;

/**
 *  this class represents the harvester with its properties to harvest a field
 * @author Luisaibele
 *
 */
public class Harvester extends Machine {
	private final int GRAIN_TANK_CAPACITY = 60; 
	private int grainTankFillLevel; //how much grain is in the harvester?
	
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
	 * Getter for the GrainTankFillLevel of the Harvester
	 * @return grainTankFillLevel
	 */
	public int getGrainTankFillLevel() {
		return grainTankFillLevel;
	}


	/**
	 * this method sets the grainTankFillLevel and gives back the information 
	 * to the user if the tank is full
	 * @param grainTankFillLevel
	 * @param informationBox
	 */
	public void setGrainTankFillLevel(int grainTankFillLevel, InformationBox informationBox) {
		this.grainTankFillLevel = grainTankFillLevel;
		if (grainTankFillLevel == GRAIN_TANK_CAPACITY) {
			informationBox.getNewsField().setText("the grain tank of the harvester is full");
		}
	}

	/**
	 * Getter for the final variable GRAIN_TANK_CAPACITY
	 * @return GRAIN_TANK_CAPACITY
	 */
	public int getGRAIN_TANK_CAPACITY(){
		return GRAIN_TANK_CAPACITY;
	}


	/**
	 * this method represents the functionality of the harvester to unload 
	 * grain to the dumpTruck 
	 * @param dumpTruck
	 */
	public void unloadToDumpTruck(DumpTruck dumpTruck){
		int grainToFill = dumpTruck.getGrainTankCapacity() - dumpTruck.getGrainFillLevel();
		System.out.println(grainToFill);
		if (grainTankFillLevel <= grainToFill) {
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainTankFillLevel);
			grainTankFillLevel = 0;
			System.out.println("grain tank fill level of harvester is now: " + grainTankFillLevel);
			System.out.println("dump truck fill level of dump truck is now: " + dumpTruck.getGrainFillLevel());
		} else {
			System.out.println(grainTankFillLevel);
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainToFill);
			grainTankFillLevel = grainTankFillLevel - grainToFill;
		}
	}

}