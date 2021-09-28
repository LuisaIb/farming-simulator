package gameboard.objects;

import gui.view.InformationBox;

/**
 * This class represents the harvester with its properties to harvest a field.
 * @author Luisaibele
 *
 */
public class Harvester extends Machine {
	/**
	 * the maximum amount of grain that fits into the tank of the harvester
	 */
	private final int GRAIN_TANK_CAPACITY = 60; //grain capacity of 1 field
	/**
	 * the amount of grain that is in the grain tank of the harvester
	 */
	private int grainTankFillLevel;
	
	/**
	 * Constructor of Harvester for starting the game.
	 */
	public Harvester() {
		super();
		grainTankFillLevel = 0;
	}

	/**
	 * Constructor of Harvester for reloading / continuing the game.
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 * @param petrolTankFillLevel the value that is set as petrol tank fill level
	 * @param grainTankFillLevel the value that is set as grain tank fill level
	 */
	public Harvester(int x, int y, boolean selected, int petrolTankFillLevel, int grainTankFillLevel){
		super(x, y, selected, petrolTankFillLevel);
		this.grainTankFillLevel = grainTankFillLevel;
	}
	
	/**
	 * this method stands for the operation of filling the tank 
	 * of the harvester with grain
	 */
	//public void fillTankWithGrain() { //if animation worked 1 time then full?
	//		grainTankFillLevel++;
	//
	//	if(grainTankFillLevel == GRAIN_TANK_CAPACITY) {
	//		System.out.println("The harvester needs to be unloaded");
	//	}
	//}

	/**
	 * this method represents the functionality of the Harvester to unload its tank
	 * to the dump truck or the silo
	 */
	//public void unload(){
	//	grainTankFillLevel = 0;
	//}

	/**
	 * Getter for the GrainTankFillLevel of the Harvester.
	 * @return the requested fill level of the grain tank
	 */
	public int getGrainTankFillLevel() {
		return grainTankFillLevel;
	}


	/**
	 * Setter for grainTankFillLevel.
	 * @param grainTankFillLevel the value that is set as fill level of the grain tank
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void setGrainTankFillLevel(int grainTankFillLevel, InformationBox informationBox) {
		this.grainTankFillLevel = grainTankFillLevel;
		if (grainTankFillLevel == GRAIN_TANK_CAPACITY) {
			informationBox.getNewsField().setText("the grain tank of the harvester is full");
		}
	}

	/**
	 * Getter for GRAIN_TANK_CAPACITY.
	 * @return the requested capacity of the grain tank
	 */
	public int getGRAIN_TANK_CAPACITY(){
		return GRAIN_TANK_CAPACITY;
	}


	/**
	 * This method represents the functionality of the harvester to unload
	 * grain to the dump truck.
	 * @param dumpTruck the DumpTruck object of the actual game
	 * @param informationBox the InformationBox object of the actual game
	 */
	public void unloadToDumpTruck(DumpTruck dumpTruck, InformationBox informationBox){
		// calculating the amount of grain that fits into the dumpTruck
		int grainToFill = dumpTruck.getGrainTankCapacity() - dumpTruck.getGrainFillLevel();
		// the grain in the tank of the harvester is less or the same as the amount that fits into the dumpTruck
		if (grainTankFillLevel <= grainToFill) {
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainTankFillLevel);
			grainTankFillLevel = 0;
			informationBox.getNewsField().setText("the grain tank of the harvester is now empty");
		} else { // the grain tank of the harvester holds more grain than grain that fits into the dumpTruck
			grainTankFillLevel = grainTankFillLevel - grainToFill;
			dumpTruck.setGrainFillLevel(dumpTruck.getGrainFillLevel() + grainToFill);
			informationBox.getNewsField().setText("the harvester could not get unloaded completely");
		}
	}

}